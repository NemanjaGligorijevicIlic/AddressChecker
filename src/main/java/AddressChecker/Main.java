package AddressChecker;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String screenshotDirectory = "/Users/Nemanj Gligorijevic Ilic/Desktop/screenshots";

        try {
            driver.get("https://www.ratsit.se/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            try {
                WebElement acceptCookiesButton = wait.until(
                        ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"))
                );
                acceptCookiesButton.click();
            } catch (Exception e) {
                System.out.println("No cookies consent button found.");
            }

            WebElement searchBox = driver.findElement(By.id("vem-start"));
            searchBox.sendKeys("Aleksandar Samardzic");
            searchBox.submit();
            Thread.sleep(5000);

            String address = "Kronetorpsgatan 40 C";
            if (!driver.getPageSource().contains(address)) {
                LocalDateTime dt = LocalDateTime.now();
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destination = new File(screenshotDirectory + "/screenshot_" + dt + ".png");
                Files.copy(screenshot.toPath(), destination.toPath());
                System.out.println("Text not found, screenshot saved as 'screenshot.png'");
            } else {
                System.out.println("Text found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }
}

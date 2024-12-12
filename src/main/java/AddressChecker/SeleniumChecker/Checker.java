package AddressChecker.SeleniumChecker;

import AddressChecker.Model.Person;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static AddressChecker.Helper.AddressCheckerHelper.formatAddress;

public class Checker {
    private static final String screenshotDirectory = "/Users/Nemanj Gligorijevic Ilic/Desktop/screenshots";
    private static final String ratsitAddress = "https://www.ratsit.se/";
    public static void checkAddresses(List<Person> people){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get(ratsitAddress);
            acceptCookies(driver);

            for(int i = 0; i < people.size(); i++){
                Person person = people.get(i);
                WebElement searchBox;

                if(i == 0) {
                    searchBox = driver.findElement(By.id("vem-start"));
                } else {
                    searchBox = driver.findElement(By.id("vem-sok"));
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].value = '';", searchBox);
                }

                WebElement searchButton = driver.findElement(By.cssSelector("button[aria-label='Sök person eller företag']"));
                searchBox.sendKeys(person.getName());
                searchButton.click();
                Thread.sleep(5000);

                String address = person.getAddress();
                String formattedAddress = formatAddress(address);
                if (!driver.getPageSource().contains(formattedAddress)) {
                    LocalDateTime dt = LocalDateTime.now();
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    File destination = new File(screenshotDirectory + "/screenshot_" + dt + ".png");
                    Files.copy(screenshot.toPath(), destination.toPath());
                    System.out.println("Text not found, screenshot saved as 'screenshot.png'");
                } else {
                    System.out.println("Text found!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }

    private static void acceptCookies(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement acceptCookiesButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"))
            );
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("No cookies consent button found.");
        }
    }
}

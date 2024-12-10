package AddressChecker.ExcelReader;

import AddressChecker.Model.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private static final String excelFilePath = "/Users/Nemanj Gligorijevic Ilic/Desktop/AddressChecker/DB.xlsx";
    private static final List<Person> people = new ArrayList<>();

    public static List<Person> readFromExcel(){
        try(FileInputStream fis = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fis)){

            Sheet sheet = workbook.getSheetAt(0);
            for(int i = 1; i <= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i);
                if(row != null){
                    Cell nameCell = row.getCell(0);
                    Cell addressCell = row.getCell(1);

                    String name = nameCell.getStringCellValue();
                    String address = addressCell.getStringCellValue();

                    people.add(new Person(name, address));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return people;
    }
}

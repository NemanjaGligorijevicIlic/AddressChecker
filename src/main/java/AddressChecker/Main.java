package AddressChecker;

import AddressChecker.ExcelReader.ExcelReader;
import AddressChecker.Model.Person;

import java.util.ArrayList;
import java.util.List;

import static AddressChecker.Helper.AddressCheckerHelper.*;
import static AddressChecker.SeleniumChecker.Checker.checkAddresses;

public class Main {
    private static List<Person> people = new ArrayList<>();
    public static void main(String[] args) {
        people = ExcelReader.readFromExcel();
        people.forEach(a -> System.out.println(a.getName() + " " + a.getAddress()));
        System.out.println(people.size());
        //checkAddresses(people);
    }
}

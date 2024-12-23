package AddressChecker.DuplicateChecker;

import AddressChecker.ExcelReader.ExcelReader;
import AddressChecker.Model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateChecker {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        people = ExcelReader.readFromExcel();
        //people.forEach(a -> System.out.println(a.getName()));

        for(Person person : people){
            if(!map.containsKey(person.getName())){
                map.put(person.getName(), 1);
            } else {
                int i = map.get(person.getName());
                map.replace(person.getName(), ++i);
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1)
                System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

package test;

import com.morik.db.bean.Person;
import com.morik.service.PhoneBookService;

/**
 * Created by Morik on 08.03.2015.
 */
public class Test {
    public static void main(String[] args) {
        PhoneBookService phoneBookService = PhoneBookService.getInstance();

//        Person person = new Person("Jesica222", "Alb222a");
//        person.setId(8);
//        phoneBookService.savePerson(person);
//        System.out.println();

        Person jA = phoneBookService.getPerson(61);
        jA.setlName("NATASHKA");

        phoneBookService.savePerson(jA);
    }
}

package utils;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill.witt on 11/7/2016.
 */
public class GenerateUserData {

    @Test
    public static List<String> generateData() {
        // Generates a test user with randomly generated first and last names, and email
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        String firstName = person.firstName();
        String lastName = person.lastName();
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@email.com";

        List<String> userData = new ArrayList<>();
        userData.add(firstName);
        userData.add(lastName);
        userData.add(email);

        return userData;
    }
}

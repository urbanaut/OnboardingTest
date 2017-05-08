package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestBase;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginTest extends TestBase {

    private static String username = "droach282+test@gmail.com";
    private static String password = "stgRocks!";

    @Test
    public static void loginToOnboarding() {
        LoginPage.logIn(username, password);
    }
}

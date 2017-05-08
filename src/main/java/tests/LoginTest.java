package tests;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestBase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginTest extends TestBase {

    private static String username = "droach282+test@gmail.com";
    private static String password = "stgRocks!";


    @Test
    public static void login_to_onboarding() throws InterruptedException {
        LoginPage.logIn(username, password);

        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to the Dev Center')]"));
        assertThat(assertionText.isDisplayed(), is(true));
    }

}

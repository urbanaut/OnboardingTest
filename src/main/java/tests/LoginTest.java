package tests;

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

    public static String adminUsername = "droach282+test@gmail.com";
    public static String adminPassword = "stgRocks!";
    public static String contractorUsername = "billtest0515c@example.com";
    public static String contractorPassword = "stgRocks!";


    @Test
    public static void log_in_as_admin() throws InterruptedException {
        LoginPage.logIn(adminUsername, adminPassword);

        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to the Dev Center')]"));
        assertThat(assertionText.isDisplayed(), is(true));
    }

    public static void log_in_as_contractor() throws InterruptedException {
        LoginPage.logIn(contractorUsername, contractorPassword);

        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to the Dev Center')]"));
        assertThat(assertionText.isDisplayed(), is(true));
    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.LandingPage;
import pages.LoginPage;
import utils.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginTests extends TestBase {

    public static String adminUsername = "droach282+test@gmail.com";
    public static String adminPassword = "stgRocks!";
    public static String contractorUsername = "billtest0515c@example.com";
    public static String contractorPassword = "stgRocks!";

    @Test
    public void log_in_as_admin() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.logIn(adminUsername, adminPassword);
        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to the Dev Center')]"));
        assertThat(assertionText.isDisplayed(), is(true));
        System.out.println("Admin login successful.");
    }

    @Test
    public void log_in_as_contractor() throws InterruptedException {
        LoginPage login = new LoginPage();
        login.logIn(contractorUsername, contractorPassword);
        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to the Dev Center')]"));
        assertThat(assertionText.isDisplayed(), is(true));
        System.out.println("Contractor login successful.");
    }

    @AfterMethod
    public void logout_of_app() throws InterruptedException {
        LandingPage landing = new LandingPage();
        landing.clickLogoutButton();
        waitInSeconds(1);
    }
}
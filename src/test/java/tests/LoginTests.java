package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;
import utils.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginTests extends TestBase {

    public static String adminUsername = "droach282+test@gmail.com";
    public static String adminPassword = "stgRocks!";
    public static String contractorUsername = "billtest0515c@example.com";
    public static String contractorPassword = "stgRocks!";
    private LoginPage login;
    private WebDriver driver;

    @BeforeClass
    public void classSetup() {
        driver = getDriver();
    }

    @BeforeMethod
    public void setup() {
        login = new LoginPage(driver);
    }

    @Test
    public void logInAsAdmin() throws InterruptedException {
        login.logIn(adminUsername, adminPassword);
        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]"));
        assertThat(assertionText.isDisplayed(), is(true));
        System.out.println("Admin login successful.");
    }

    @Test
    public void logInAsContractor() throws InterruptedException {
        login.logIn(contractorUsername, contractorPassword);
        WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]"));
        assertThat(assertionText.isDisplayed(), is(true));
        System.out.println("Contractor login successful.");
    }

    @AfterMethod
    public void logoutOfApp() throws InterruptedException {
        LandingPage landing = new LandingPage();
        landing.clickLogoutButton();
    }
}

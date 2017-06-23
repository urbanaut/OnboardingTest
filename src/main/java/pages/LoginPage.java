package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginPage extends TestBase {

    protected WebDriver driver;
    private By usernameFieldElem = By.id("username");
    private By passwordFieldElem = By.id("password");
    private By loginBtn = By.xpath("//button[contains(text(),'Login')]");
    private By homeBtn = By.xpath("//a[@class='navbar-brand']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String username, String password) {
        try {
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();
            waitInSeconds(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void enterUsername(String username) {
        try{
            WebElement usernameField = driver.findElement(usernameFieldElem);
            if(usernameField.isDisplayed())
                usernameField.sendKeys(username);
            else
                System.out.println("Username field not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void enterPassword(String password) {
        try{
            WebElement passwordField = driver.findElement(passwordFieldElem);
            if(passwordField.isDisplayed())
                passwordField.sendKeys(password);
            else
                System.out.println("Password field not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void clickLoginButton() {
        try{
            WebElement login = driver.findElement(loginBtn);
            if(login.isDisplayed())
                login.click();
            else
                System.out.println("Login button not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

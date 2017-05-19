package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginPage extends TestBase {

    public WebElement usernameFieldElem = driver.findElement(By.id("username"));
    public WebElement passwordFieldElem = driver.findElement(By.id("password"));
    public WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
    public WebElement homeBtn = driver.findElement(By.xpath("//a[@class='navbar-brand']"));

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
            if(usernameFieldElem.isDisplayed())
                usernameFieldElem.sendKeys(username);
            else
                System.out.println("Username field not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void enterPassword(String password) {
        try{
            if(passwordFieldElem.isDisplayed())
                passwordFieldElem.sendKeys(password);
            else
                System.out.println("Password field not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void clickLoginButton() {
        try{
            if(loginBtn.isDisplayed())
                loginBtn.click();
            else
                System.out.println("Login button not found.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

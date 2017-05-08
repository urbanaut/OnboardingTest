package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class LoginPage extends TestBase {

    private static WebElement usernameFieldElem = driver.findElement(By.id("username"));
    private static WebElement passwordFieldElem = driver.findElement(By.id("password"));
    private static WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));


    public static void logIn(String username, String password) {
        try {
            enterUsername(username);
            enterPassword(password);
            clickLoginButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void enterUsername(String username) {
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

    private static void enterPassword(String password) {
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

    private static void clickLoginButton() {
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

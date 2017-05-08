package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class AdminHomePage extends TestBase {

    public static WebElement homeMenuBtn = driver.findElement(By.linkText("Home"));
    public static WebElement tasksMenuBtn = driver.findElement(By.linkText("Tasks"));
    public static WebElement usersMenuBtn = driver.findElement(By.linkText("Users"));
    public static WebElement templatesMenuBtn = driver.findElement(By.linkText("Templates"));
    public static WebElement reportMenuBtn = driver.findElement(By.linkText("Report"));
    public static WebElement addUserBtn = driver.findElement(By.xpath("//a[contains(text(),'Add User')]"));
    public static WebElement LogoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

    public static void clickHomeButton() {
        if(homeMenuBtn.isDisplayed())
        homeMenuBtn.click();
        else
            System.out.println("Home button not found");
    }

    public static void clickTasksButton() {
        if(tasksMenuBtn.isDisplayed())
            tasksMenuBtn.click();
        else
            System.out.println("Tasks button not found");
    }

    public static void clickUsersButton() {
        if(usersMenuBtn.isDisplayed())
            usersMenuBtn.click();
        else
            System.out.println("Users button not found");
    }

    public static void clickTemplatesButton() {
        if(templatesMenuBtn.isDisplayed())
            templatesMenuBtn.click();
        else
            System.out.println("Templates button not found");
    }

    public static void clickReportButton() {
        if(reportMenuBtn.isDisplayed())
            reportMenuBtn.click();
        else
            System.out.println("Report button not found");
    }

    public static void clickAddUserButton() {
        if(addUserBtn.isDisplayed())
            addUserBtn.click();
        else
            System.out.println("Add User button not found");
    }

    public static void clickLogoutButton() {
        if(LogoutBtn.isDisplayed())
            LogoutBtn.click();
        else
            System.out.println("Logout button not found");
    }

}

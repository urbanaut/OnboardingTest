package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class UserTasksPage extends TestBase {

    public static WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
    public static WebElement titleLink = driver.findElement(By.linkText("Title"));
    public static WebElement descriptionLink = driver.findElement(By.linkText("Description"));
    public static WebElement startDateLink = driver.findElement(By.linkText("Start Date"));
    public static WebElement durationLink = driver.findElement(By.linkText("Duration"));
    public static WebElement remainingLink = driver.findElement(By.linkText("Remaining"));
    public static WebElement requiredLink = driver.findElement(By.linkText("Required"));
    public static WebElement completeLink = driver.findElement(By.linkText("Complete"));

    public static void clickLogoutButton() {
        if(logoutBtn.isDisplayed())
            logoutBtn.click();
        else
            System.out.println("Logout button not found");
    }

    public static void clickTitleLink() {
        if(titleLink.isDisplayed())
            titleLink.click();
        else
            System.out.println("'Title' link is not found.");
    }

    public static void clickDescriptionLink() {
        if(descriptionLink.isDisplayed())
            descriptionLink.click();
        else
            System.out.println("'Description' link is not found.");
    }

    public static void clickStartDateLink() {
        if(startDateLink.isDisplayed())
            startDateLink.click();
        else
            System.out.println("'Start Date' link is not found.");
    }

    public static void clickDurationLink() {
        if(durationLink.isDisplayed())
            durationLink.click();
        else
            System.out.println("'Duration' link is not found.");
    }

    public static void clickRemainingLink() {
        if(remainingLink.isDisplayed())
            remainingLink.click();
        else
            System.out.println("'Remaining' link is not found.");
    }

    public static void clickRequiredLink() {
        if(requiredLink.isDisplayed())
            requiredLink.click();
        else
            System.out.println("'Required' link is not found.");
    }

    public static void clickCompleteLink() {
        if(completeLink.isDisplayed())
            completeLink.click();
        else
            System.out.println("'Complete' link is not found.");
    }




}

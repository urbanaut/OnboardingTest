package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.LoginPage;
import utils.GenerateDate;
import utils.TestBase;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class TempTester extends TestBase {

    private String date = GenerateDate.todaysDate();

    @Test
    public void run() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.randomizeInputFields();
    }

    @Test public void test1() throws InterruptedException {
        LoginPage.logIn("droach282+test@gmail.com","stgRocks!");
        WebElement home = driver.findElement(By.linkText("Home"));
        home.click();

        Thread.sleep(4000);

        WebElement addUserBtn = driver.findElement(By.xpath("//a[contains(text(),'Add User')]"));
        addUserBtn.click();
        WebElement dateFieldElem = driver.findElement(By.xpath("//input[@placeholder='Enter date']"));
        dateFieldElem.sendKeys(date);
    }
}

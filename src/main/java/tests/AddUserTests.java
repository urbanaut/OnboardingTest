package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddUserPage;
import utils.*;

import java.util.List;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class AddUserTests extends TestBase {

    // Input values
    private String firstName = GenerateUserData.generateData().get(0);
    private String lastName = GenerateUserData.generateData().get(1);
    private String practice = GeneratePractice.randomPractice();
    private String email = GenerateUserData.generateData().get(2);
    private String date = GenerateDate.todaysDate();


    @Test
    public void adding_user_with_no_input_failure() {
        AddUserPage addUserPage = new AddUserPage();
        addUserPage.clickAddUserButton();
        WebElement error = driver.findElement(By.xpath("//input[contains(@class,'empty error')]"));

        Assert.assertTrue(error.isDisplayed(),"No page error on null submit.");
    }

    @Test
    public void adding_user_with_partial_input_failure() {
        AddUserPage addUserPage = new AddUserPage();
        List<WebElement> inputFields = addUserPage.randomizeInputFields();
        for (int i = 0; i < inputFields.size(); i++) {
            if (inputFields.get(i).getAttribute("id").equals("firstname"))
                inputFields.get(i).sendKeys();
            else if (inputFields.get(i).getAttribute("id").equals("lastname"))
                inputFields.get(i).sendKeys(lastName);
            else if (inputFields.get(i).getAttribute("id").equals("inputEmail3"))
                inputFields.get(i).sendKeys(email);
            else if (inputFields.get(i).getAttribute("id").equals("date"))
                inputFields.get(i).sendKeys(date);

            addUserPage.clickAddUserButton();
            WebElement error = driver.findElement(By.xpath("//input[contains(@class,'empty')]"));

            Assert.assertTrue(error.isDisplayed(),"No page error on null submit.");
        }
    }

    @Test
    public void adding_user_with_all_input_successful() throws Exception {
        AddUserPage addUserPage = new AddUserPage();

        addUserPage.firstNameFieldElem.sendKeys(firstName);
        addUserPage.lastNameFieldElem.sendKeys(lastName);
        addUserPage.positionChoiceElem.click();
        addUserPage.positionOption.click();
        addUserPage.practiceChoiceElem.click();
        addUserPage.getPracticeOption(practice).click();
        addUserPage.emailFieldElem.sendKeys(email);
        addUserPage.dateFieldElem.sendKeys(date);
        addUserPage.addUserBtnElem.click();

        try {
            waitInSeconds(2);
            WebElement success = driver.findElement(By.xpath("//div[text()='Success!']"));
            Assert.assertTrue(success.isDisplayed(), "Unsuccessful addition of new user.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("\nAssert failed: 'Success!' alert not shown.");
        }
    }

    @Test
    public void new_user_saved_to_db() throws Exception {
        AddUserPage addUserPage = new AddUserPage();
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();

        List<String> newUserData = addUserPage.createRandomizedNewUser();
        String email = newUserData.get(2);
        List<String> dbUserData = connectToDatabase.verifyDbData(email);

        Assert.assertTrue(newUserData.equals(dbUserData), "New user data not found in database.");
        System.out.println("New user data matches new user in database.");
    }

    @Test
    public void same_user_cannot_be_added_again() {

    }


}

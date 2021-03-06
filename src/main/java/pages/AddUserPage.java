package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.GenerateDate;
import utils.GeneratePractice;
import utils.GenerateUserData;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class AddUserPage extends TestBase {

    // Input values
    public static WebElement firstNameFieldElem = driver.findElement(By.id("firstname"));
    public static WebElement lastNameFieldElem = driver.findElement(By.id("lastname"));
    public static WebElement positionChoiceElem = driver.findElement(By.id("inputPosition"));
    public static WebElement positionOption = driver.findElement(By.xpath("//option[@value='Contractor']"));
    public static WebElement practiceChoiceElem = driver.findElement(By.id("inputPractice"));
    public static WebElement emailFieldElem = driver.findElement(By.id("inputEmail3"));
    public static WebElement dateFieldElem = driver.findElement(By.xpath("//input[@placeholder='Enter date']"));
    public static WebElement addUserBtnElem = driver.findElement(By.id("submitbutton"));

    public void clickAddUserButton() {
        addUserBtnElem.click();
    }

    public List<WebElement> randomizeInputFields() {
        List<WebElement> randomElements = new ArrayList<>();
        List<WebElement> elements = new ArrayList<>();
        elements.add(firstNameFieldElem);
        elements.add(lastNameFieldElem);
        elements.add(emailFieldElem);
        elements.add(dateFieldElem);

        Random random = new Random();
        for(int i = 0; i <3; i++) {
            int randomInt = random.nextInt(4);
            if (!randomElements.contains(elements.get(randomInt))) {
                randomElements.add(elements.get(randomInt));
            }
        }
        return randomElements;
    }

    public WebElement getPracticeOption(String option) {
        return driver.findElement(By.xpath("//option[@value='" + option + "']"));
    }

    public List<String> createRandomizedNewUser() {
        /* TODO: Put all user data form elements into the userData array */
        // List userData contains randomly generated first and last names, and email address
        List<String> userData = GenerateUserData.generateData();
        String firstName = userData.get(0);
        String lastName = userData.get(1);
        String practice = GeneratePractice.randomPractice();
        String email = userData.get(2);

        firstNameFieldElem.sendKeys(firstName);
        lastNameFieldElem.sendKeys(lastName);
        positionChoiceElem.click();
        positionOption.click();
        practiceChoiceElem.click();
        getPracticeOption(practice).click();
        emailFieldElem.sendKeys(email);
        dateFieldElem.sendKeys(GenerateDate.todaysDate());
        addUserBtnElem.click();

        return userData;
    }
}

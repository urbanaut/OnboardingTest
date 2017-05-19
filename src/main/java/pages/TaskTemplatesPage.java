package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/10/2017.
 */
public class TaskTemplatesPage extends TestBase {

    public static WebElement categoryDropdown = driver.findElement(By.id("selectCategory"));

    public void selectCategory (String option) {
        
    }
}

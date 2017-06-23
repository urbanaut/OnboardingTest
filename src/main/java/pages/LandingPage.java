package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

/**
 * Created by bill.witt on 5/19/2017.
 */
public class LandingPage extends TestBase {

    private static By logoutButton = By.xpath("//a[contains(text(),'Logout')]");
    //private static WebElement assertionText = driver.findElement(By.xpath("//h2[contains(text(),'Welcome')]"));

    public void clickLogoutButton() {
        WebElement logout = driver.findElement(logoutButton);
        logout.click();
    }
}

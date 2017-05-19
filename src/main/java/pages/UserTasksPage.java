package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bill.witt on 5/8/2017.
 */
public class UserTasksPage extends TestBase {

    private static WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));

    public static List<String> columnHeaders() {
        List<String> headers = new ArrayList<>();
        headers.add("Title");
        headers.add("Description");
        headers.add("Start Date");
        headers.add("Duration");
        headers.add("Remaining");
        headers.add("Required");
        headers.add("Complete");
        return headers;
    }

    public static WebElement sortArrow(String header) {
        return driver.findElement(By.xpath("//th[@class='sort-false']/a[text()='" + header + "']")); //or ("//th[@ng-class=\"vm.selectedCls(vm.tasks,'task')\" and @class='sort-false']");
    }

    public static List<WebElement> taskRows() {
        return driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
    }

    public static String fieldText(int rowNum, int columnNum) {
        return driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + rowNum + "]/td[" + columnNum + "]")).getAttribute("innerHTML");
    }

    public static Character firstChar(int rowNum, int columnNum) {
        return fieldText(rowNum, columnNum).charAt(0);
    }

    public static String day(int rowNum, int columnNum) {
        String rowText = fieldText(rowNum, columnNum);
        return rowText.substring(rowText.length() - 2);
    }

    public static void clickHeaderNamed(String headerName) {
        WebElement headerLink = driver.findElement(By.linkText("" + headerName + ""));
        if(headerLink.isDisplayed())
            headerLink.click();
        else
            System.out.println("'" + headerName + "' link is not found.");
    }

    public static void clickLogoutButton() {
        if(logoutBtn.isDisplayed())
            logoutBtn.click();
        else
            System.out.println("Logout button not found");
    }

}

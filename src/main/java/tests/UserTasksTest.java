package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserTasksPage;
import utils.TestBase;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;

/**
 * Created by bill.witt on 5/10/2017.
 */
public class UserTasksTest extends TestBase {

    //private static String header = "Title";
    private static List<String> headers = new ArrayList<>();

    private void addHeaders() {
        headers.add("Title");
        headers.add("Description");
        headers.add("Start Date");
        headers.add("Duration");
        headers.add("Remaining");
        headers.add("Required");
        headers.add("Complete");
    }

    @Test
    public void sort_task_list_by_column_header() throws InterruptedException {
        LoginPage.logIn(LoginTest.contractorUsername, LoginTest.contractorPassword);
        addHeaders();

        for (String header : headers) {
            UserTasksPage.clickHeaderNamed(header);
            waitInSeconds(1);

            WebElement assertionText = driver.findElement(By.xpath("//th[@class='sort-false']/a[text()='" + header + "']")); //or ("//th[@ng-class=\"vm.selectedCls(vm.tasks,'task')\" and @class='sort-false']");
            assertThat(assertionText.isDisplayed(), is(true));
            if (assertionText.isDisplayed())
                System.out.println(header + " column sorted successfully.");
        }

    }

    @Test
    public void verify_alphabetical_column_sort() throws InterruptedException {
        LoginPage.logIn(LoginTest.contractorUsername, LoginTest.contractorPassword);
        addHeaders();

        int rowNum = 2;
        int columnNum = 1;
        ArrayList<String> firstLettersString = new ArrayList<>();
        Character firstLetter;
        boolean ordered = true;

        for (String header : headers) {
            UserTasksPage.clickHeaderNamed(header);
            waitInSeconds(1);

            List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));

            for (WebElement row : rows) {
                if (columnNum != 3) {
                    firstLetter = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + rowNum + "]/td[" + columnNum + "]")).getAttribute("innerHTML").charAt(0);
                    String letter = firstLetter.toString().toLowerCase();
                    firstLettersString.add(letter);
                    rowNum = rowNum + 1;

                    if (rowNum == rows.size() + 1) {
                        rowNum = 2;
                        break;
                    }

                    for (int i = 0; i < firstLettersString.size() - 1; i++) {
                        if ((int) firstLettersString.get(i).charAt(0) > (int) firstLettersString.get(i + 1).charAt(0)) {
                            System.out.println("Rows not sorted in alphabetical order.");
                            ordered = false;
                            break;
                        } else
                            ordered = true;
                    }
                }
                else {
                    String rowText = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + rowNum + "]/td[" + columnNum + "]")).getAttribute("innerHTML");
                    String day = rowText.substring(rowText.length() - 2);
                    firstLettersString.add(day);
                    rowNum = rowNum + 1;

                    if (rowNum == rows.size() + 1) {
                        rowNum = 2;
                        break;
                    }

                    for (int i = 0; i < firstLettersString.size() - 1; i++) {
                        if (Integer.parseInt(firstLettersString.get(i)) > Integer.parseInt(firstLettersString.get(i + 1))) {
                            System.out.println("Rows in '" + header + "' column are not sorted in alphabetical order.");
                            ordered = false;
                            break;
                        } else
                            ordered = true;
                    }
                }
            }

            if (ordered)
                System.out.println("All rows in '" + header + "' column are in alphabetical order.");

            firstLettersString.clear();
            columnNum = columnNum + 1;
        }
    }
}

package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
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

    private List<String> headers = new ArrayList<>();

    @BeforeMethod
    public void setup() {
        LoginPage.logIn(LoginTest.contractorUsername, LoginTest.contractorPassword);
        headers = UserTasksPage.columnHeaders();
    }

    @Test
    public void verify_presence_of_column_sort_arrow() throws InterruptedException {
        for (String header : headers) {
            UserTasksPage.clickHeaderNamed(header);
            waitInSeconds(1);
            WebElement sortArrow = UserTasksPage.sortArrow(header);

            if (sortArrow.isDisplayed()) {
                assertThat(sortArrow.isDisplayed(), is(true));
                System.out.println(header + " column sorted successfully.");
            }
        }
    }

    @Test
    public void verify_alphabetical_column_sort() throws InterruptedException {
        int rowNum = 2;
        int columnNum = 1;
        ArrayList<String> firstLettersString = new ArrayList<>();
        boolean ordered = true;

        for (String header : headers) {
            UserTasksPage.clickHeaderNamed(header);
            waitInSeconds(1);

            List<WebElement> rows = UserTasksPage.taskRows();
            Character firstLetter = UserTasksPage.firstChar(rowNum, columnNum);

            for (WebElement row : rows) {
                while (rowNum != rows.size() + 1) {
                    if (columnNum != 3) {
                        String letter = firstLetter.toString().toLowerCase();
                        firstLettersString.add(letter);

                        for (int i = 0; i < firstLettersString.size() - 1; i++) {
                            if ((int) firstLettersString.get(i).charAt(0) > (int) firstLettersString.get(i + 1).charAt(0)) {
                                System.out.println("Rows not sorted in alphabetical order.");
                                ordered = false;
                                break;
                            }
                        }
                    } else {
                        String day = UserTasksPage.day(rowNum, columnNum);
                        firstLettersString.add(day);

                        for (int i = 0; i < firstLettersString.size() - 1; i++) {
                            if (Integer.parseInt(firstLettersString.get(i)) > Integer.parseInt(firstLettersString.get(i + 1))) {
                                System.out.println("Rows in '" + header + "' column are not sorted in alphabetical order.");
                                ordered = false;
                                break;
                            }
                        }
                    }
                    rowNum++;
                }
                rowNum = 2;
            }
            if (ordered)
                System.out.println("All rows in '" + header + "' column are in alphabetical order.");

            firstLettersString.clear();
            columnNum = columnNum + 1;
        }
    }
}

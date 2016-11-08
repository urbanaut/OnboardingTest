package tests;

import org.testng.annotations.Test;
import pages.NewUserPage;
import utils.TestBase;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class Tester extends TestBase {

    @Test
    public void run() {
        NewUserPage newUserPage = new NewUserPage();
        newUserPage.randomizeInputFields();
    }
}

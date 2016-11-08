package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class TestBase {

        protected static WebDriver driver;
        protected static WebDriverWait wait;
        protected static JavascriptExecutor jsEx;
        protected static Actions action;
        private static String driverPath;
        private static String startingUrl;

        protected TestBase() {
            driverPath = "src\\main\\resources\\drivers\\chromedriver.exe";
            startingUrl = "http://onboarding.stgconsulting.com/new-user#/"; // Talent Rover
        }

        @BeforeClass
        public void initialize() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("chrome.switches","--disable-extensions"); //Removes popup for disabling extensions
            System.setProperty("webdriver.chrome.driver",driverPath);
            driver = new ChromeDriver(options);

            wait = new WebDriverWait(driver, 20);
            jsEx = (JavascriptExecutor) driver;
            action = new Actions(driver);

            driver.navigate().to(startingUrl);
            //driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        //@AfterClass
        public void tearDown() {
            driver.close();
        }

        protected void waitInSeconds(int seconds) throws InterruptedException {
            int milliseconds = seconds * 1000;
            Thread.sleep(milliseconds);
        }
}

package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class TestBase {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor jsEx;
    protected static Actions action;
    public static String driverPathJenkins = "src/main/resources/drivers/chromedriver.exe";
    public static String driverPathDev = "src\\main\\resources\\drivers\\chromedriver.exe";
    public static String startingUrlProd = "http://onboarding.stgconsulting.com/new-user#/";
    public static String startingUrlDev = "http://10.117.3.200:8111";
    public static String startingUrlDevPub = "http://216.21.162.13:8111";

    public static String driverPath = driverPathJenkins;
    public static String startingUrl = startingUrlDev;

    @BeforeSuite
    public void initialize() {
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver(initializeNewDriver());

        wait = new WebDriverWait(driver, 20);
        jsEx = (JavascriptExecutor) driver;
        action = new Actions(driver);

        driver.navigate().to(startingUrl);
//            //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public static ChromeOptions initializeNewDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches","--disable-extensions"); //Removes popup for disabling extensions
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public static void waitInSeconds(int seconds) throws InterruptedException {
        int milliseconds = seconds * 1000;
        Thread.sleep(milliseconds);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}

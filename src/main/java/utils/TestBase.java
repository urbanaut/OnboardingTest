package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by bill.witt on 11/1/2016.
 */
public class TestBase {

    protected static WebDriver driver;
    public static String chromeDriverPathJenkins = "/usr/local/share/chromedriver";
    public static String chromeDriverPathDev = "src\\main\\resources\\drivers\\chromedriver.exe";
    public static String geckoDriverPathJenkins = "/usr/bin/geckodriver";
    public static String geckoDriverPathDev = "src\\main\\resources\\drivers\\geckodriver.exe";
    public static String startingUrlProd = "http://onboarding.stgconsulting.com/new-user#/";
    public static String startingUrlDev = "http://10.117.3.200:8111";
    public static String startingUrlDevPub = "http://216.21.162.13:8111";

    public static String startingUrl = startingUrlDev;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", chromeDriverPathJenkins);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("chrome.switches","--disable-extensions"); //Removes popup for disabling extensions
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        System.setProperty("webdriver.gecko.driver", geckoDriverPathJenkins);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    @Parameters({ "browserType", "appURL" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            setDriver(browserType, appURL);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    //@AfterClass
    public void tearDown() {
        driver.close();
    }

    public static void waitInSeconds(int seconds) throws InterruptedException {
        int milliseconds = seconds * 1000;
        Thread.sleep(milliseconds);
    }

}

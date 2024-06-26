package Base;
import com.fasterxml.jackson.core.JsonFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
//import utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

public class BaseClass {
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BaseClass.class.getName());
    public SoftAssert softAssert = new SoftAssert();
    public String baseDirectory = System.getProperty("user.dir");

    private void setDriver(String browserType, String baseURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(baseURL);
                break;
            case "ie":
                driver = initIEDriver(baseURL);
                break;
            default:
                driver = initFirefoxDriver(baseURL);
        }
    }
    public WebDriver initChromeDriver(String baseURL) {
        logger.info("Launching google chrome browser..");
        logger.info("Opening Machnetinc.com");


        WebDriverManager.chromedriver().clearDriverCache().setup();
      // WebDriverManager.chromedriver().clearResolutionCache().setup();
       // WebDriverManager.chromedriver().setup();
     // WebDriverManager.chromedriver().driverVersion("126.0.6478.57").setup();
        ChromeOptions options = new ChromeOptions();


        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");


     driver = new ChromeDriver(options);
        if (driver == null) {
            System.out.println("Driver is null after ChromeDriver instantiation.");
        } else {
            System.out.println("Driver instantiated successfully.");
        }



//        driver.manage().window().maximize();
//        driver.manage().window().setSize(new Dimension(1814, 974));
       driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if (driver == null) {
            System.out.println("Driver is null before returning from initChromeDriver.");
        } else {
            System.out.println("Driver initialized and ready to use.");
        }
        return driver;
    }

    private WebDriver initFirefoxDriver(String baseURL) {
        logger.info("Launching Firefox browser..");
        logger.info("Opening Machnetinc.com");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initIEDriver(String baseURL) {
        logger.info("Launching Internet Explorer browser..");
        logger.info("Opening Machnetinc.com");
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseURL);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }
    @Parameters({ "browser", "baseURL" })
    @BeforeClass(alwaysRun = true)
    public void initializeBaseTest(String browser, String baseURL) {
        try {
            String log4jConfPath = baseDirectory + "/src/main/resources/config/log4j.properties";

            PropertyConfigurator.configure(log4jConfPath);
            logger.info("Initiate browser..");
            setDriver(browser, baseURL);

        } catch (Exception e) {
            System.out.println("Error:" + e.getStackTrace());
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
     //  logger.info("Clean up activity: Closed all browser instances..");
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}

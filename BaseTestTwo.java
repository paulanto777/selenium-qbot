package test.java.com.quill.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.ConfigUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestTwo extends TestPageHandler {


    public WebDriver driver;
    @BeforeSuite
    public void startReport() {

    }

    @BeforeClass(alwaysRun = true)
    public void launchBrowser() throws Exception {
        String Executiontype = ConfigUtil.getpropertyvalue("EXECUTION").toLowerCase();
        System.out.println(Executiontype);
        String browser = ConfigUtil.getpropertyvalue("BROWSER").toLowerCase();
        System.out.println(browser);

        if(Executiontype.equalsIgnoreCase("local"))
        {
            if(browser.equalsIgnoreCase("chrome"))
            {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
//                options.addExtensions(new File("latest.zip"));
                options.addArguments("--use-fake-ui-for-media-stream");
                options.addArguments("--deny-permission-prompts");
                driver = new ChromeDriver(options);
            }
            else if(browser.equalsIgnoreCase("edge"))
            {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            else if(browser.equalsIgnoreCase("firefox"))
            {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            else
            {
                System.out.println("Something went wrong can't able to initiate the browser");
            }
        }
        else if(Executiontype.equalsIgnoreCase("gitlab"))
        {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--window-size=1366,784");
            options.addArguments("--user-agent="+System.getProperty("useragent"));
            options.addArguments("--use-fake-ui-for-media-stream");
            options.addArguments("--log-level=3");
            driver = new ChromeDriver(options);
        }
        else if(Executiontype.equalsIgnoreCase("gcp"))
        {
            setUpSelenoid(browser);
        }

        driver.get(ConfigUtil.getpropertyvalue("qaURL"));
        driver.manage().window().maximize();
        System.out.println("Launched the App::" + driver.getCurrentUrl());
        System.out.println("Current loaded page title is ::"+driver.getTitle());
//        Thread.sleep(3000);
    }

    public void setUpSelenoid(String browser) throws Exception {

        String remoteURL = ConfigUtil.getpropertyvalue("remoteURL");

        System.out.println("Selenoid hub URL is ::"+ remoteURL);

        DesiredCapabilities dc = new DesiredCapabilities();
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            dc.setCapability("browserName", "chrome");
            dc.setCapability("visual", true); // To enable step by step screenshot
            dc.setCapability("enableVNC",true);
            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserVersion", "102.0");
            System.out.println(System.getProperty("user.dir"));
            options.addArguments("load-extension=latest.zip");
            dc.setCapability(ChromeOptions.CAPABILITY, options);

        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            dc.setCapability("browserName", "edge");
        }
        else
        {
            System.out.println("Something went wrong can't able to initiate the browser");
        }
        try {
            driver = new RemoteWebDriver(new URL(remoteURL), dc);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

    @AfterSuite
    public void CloseReport() {

    }

    public WebDriver getDriver() {
        return driver;
    }

}

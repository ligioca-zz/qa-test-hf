package com.hellofresh.challenge.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public static WebDriverWait wait;


    private static String setSystemPathForDrivers() {
        String os;
        String osFullName = System.getProperty("os.name");

        if (osFullName.toLowerCase().contains("mac")) {
            os = "mac";
        } else if (osFullName.toLowerCase().contains("linux")) {
            os = "linux";
        } else if (osFullName.toLowerCase().contains("windows")) {
            os = "windows";
        } else {
            throw new IllegalStateException("OS not supported");
        }
        return os;

    }

    private void setDriver() {
        String os = setSystemPathForDrivers();
        String browser = System.getProperty("browser");

        if (browser.equals("chrome")){
            if (os.equals("windows")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/" + os + "/chromedriver.exe");
            } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/" + os + "/chromedriver");
            }
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/" + os + "/geckodriver");
            driver = new FirefoxDriver();
        }

    }
    @Before
    public void setUp() {
        setDriver();
        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

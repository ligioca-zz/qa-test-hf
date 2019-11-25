package com.hellofresh.challenge.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public WebDriver driver;

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

    protected WebDriver setDriver() {
        String os = setSystemPathForDrivers();
        String browser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");

        if (browser.equals("chrome")) {
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
        return driver;
    }
}

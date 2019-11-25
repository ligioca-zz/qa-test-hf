package com.hellofresh.challenge.base;

import com.hellofresh.challenge.helpers.BrowserFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.Properties;

public class Base extends BrowserFactory {

    public WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void setUp() {
        driver = setDriver();
        wait = new WebDriverWait(driver, 10, 50);
        String url = System.getProperty("url") == null ? "http://automationpractice.com/index.php":System.getProperty("url");
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

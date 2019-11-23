package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.base.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignInButton(){
        logger.info("Clicking on SignIn button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
    }

}

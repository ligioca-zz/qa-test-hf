package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.helpers.PropertiesHelper;
import com.hellofresh.challenge.pages.authentication.AccountCreationPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class MyAccountPage {

    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    static public String email;
    final static Logger logger = Logger.getLogger(MyAccountPage.class);

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleCorret(){
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        logger.info("Title: " + heading.getText() + " must be the same as \"MY ACCOUNT\"");
        return heading.getText().equals("MY ACCOUNT");
    }

    public boolean isUserNameOnTheHeaderForNewUserCorrect(){
        WebElement nameOnTheHeader = driver.findElement(By.className("account"));
        String firstName = PropertiesHelper.prop.getProperty("newUserfirstName");
        String surname = PropertiesHelper.prop.getProperty("newUserSurname");
        logger.info("Name on the header: " + nameOnTheHeader.getText() + " must be the same as " + firstName + " " + surname);

        return nameOnTheHeader.getText().equals(firstName + " " + surname);
    }

    //This method is the same as the above one, should be improved to avoid repeat code
    public boolean isUserNameOnTheHeaderForRegisteredUserCorrect(){
        WebElement nameOnTheHeader = driver.findElement(By.className("account"));
        String name = PropertiesHelper.prop.getProperty("existingUserName");
        logger.info("Name on the header: " + nameOnTheHeader.getText() + " must be the same as " + name);

        return nameOnTheHeader.getText().equals(name);
    }

    public boolean infoAccountContainsWelcomeText(){
        logger.info("Account information should contain \"Welcome to your account\" message");
        return driver.findElement(By.className("info-account")).getText().contains("Welcome to your account.");
    }

    public boolean isLogoutDisplayed(){
        logger.info("Logout button should be displayed");
        return driver.findElement(By.className("logout")).isDisplayed();
    }

    public boolean isUrlCorret(){
        logger.info("URL should contain \"controller=my-account\"");
        return driver.getCurrentUrl().contains("controller=my-account");
    }

    public void clickOnWomenSession(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
    }

}

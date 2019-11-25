package com.hellofresh.challenge.pages.authentication;

import com.hellofresh.challenge.helpers.PropertiesHelper;
import com.hellofresh.challenge.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class AuthenticationPage {

    private WebDriver driver;
    WebDriverWait wait;
    final static Logger logger = Logger.getLogger(AuthenticationPage.class);

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    private String createRandomEmail(){
        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        logger.info("Created new email String: " + email);
        return email;
    }

    public void fillRandomEmailAddressInCreateAnAccountForm(){
        logger.info("Filling email in create an account form");
        driver.findElement(By.id("email_create")).sendKeys(createRandomEmail());
    }

    public void clickOnCreateAnAccount(){
        logger.info("Clicking on Create and account");
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void fillEmailInAlreadyRegistered(){
        logger.info("Filling email in already registered form");
        String email = PropertiesHelper.prop.getProperty("existingUserEmail");
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void fillPasswordInAlreadyRegistered(){
        logger.info("Filling password in already registered form");
        String password = PropertiesHelper.prop.getProperty("existingUserPassword");
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void clickOnSignIn(){
        logger.info("Clicking sign in");
        driver.findElement(By.id("SubmitLogin")).click();
    }
}

package com.hellofresh.challenge.pages.authentication;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.helpers.PropertiesHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class AccountCreationPage {

    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    final static Logger logger = Logger.getLogger(AccountCreationPage.class);

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTitleInPersonalInformation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
    }

    public void fillFirstNameInPersonalInformation(){
        String firstName = PropertiesHelper.prop.getProperty("newUserfirstName");
        logger.info("Filling first name: " + firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
    }

    public void fillLastNameInPersonalInformation(){
        String surname = PropertiesHelper.prop.getProperty("newUserSurname");
        logger.info("Filling last name: " + surname);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
    }

    public void fillPasswordInPersonalInformation(){
        String password = PropertiesHelper.prop.getProperty("newUserPassword");
        logger.info("Filling password: " + password);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void selectDateOfBirthInPersonalInformation(){
        logger.info("Selecting date of birth");
        Select select = new Select(driver.findElement(By.id("days")));
        String dayOfBirth = PropertiesHelper.prop.getProperty("newUserDayOfBirth");
        select.selectByValue(dayOfBirth);
        select = new Select(driver.findElement(By.id("months")));
        String monthOfBirth = PropertiesHelper.prop.getProperty("newUserMonthOfBirth");
        select.selectByValue(monthOfBirth);
        select = new Select(driver.findElement(By.id("years")));
        String yearOfBirth = PropertiesHelper.prop.getProperty("newUserYearOfBirth");
        select.selectByValue(yearOfBirth);
    }

    public void fillCompanyInYourAddress(){
        logger.info("Filling company");
        String company = PropertiesHelper.prop.getProperty("newUserCompany");
        driver.findElement(By.id("company")).sendKeys(company);
    }

    public void fillAddressInYourAddress(){
        logger.info("Filling Address");
        String userAddress1 = PropertiesHelper.prop.getProperty("newUserAddress1");
        driver.findElement(By.id("address1")).sendKeys(userAddress1);
        String userAddress2 = PropertiesHelper.prop.getProperty("newUserAddress2");
        driver.findElement(By.id("address2")).sendKeys(userAddress2);
    }

    public void fillCityInYourAddress(){
        logger.info("Filling city");
        String city = PropertiesHelper.prop.getProperty("newUserCity");
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void selectStateInYourAddress(){
        logger.info("Selecting state");
        Select select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("Colorado");
    }

    public void fillZipCodeInYourAddress(){
        logger.info("Filling zip code");
        String zipCode = PropertiesHelper.prop.getProperty("newUserZipCode");
        driver.findElement(By.id("postcode")).sendKeys(zipCode);
    }

    public void fillAdditionalInfoInYourAddress(){
        logger.info("Filling additional information");
        String additionalInfo = PropertiesHelper.prop.getProperty("newUserAdditionalInfo");
        driver.findElement(By.id("other")).sendKeys(additionalInfo);
    }

    public void fillHomePhoneInYourAddress(){
        logger.info("Filling home phone");
        String homePhone = PropertiesHelper.prop.getProperty("newUserHomePhone");
        driver.findElement(By.id("phone")).sendKeys(homePhone);
    }

    public void fillMobilePhoneInYourAddress(){
        logger.info("Filling mobile phone");
        String mobilePhone = PropertiesHelper.prop.getProperty("newUserMobilePhone");
        driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
    }

    public void fillEmailAliasInYourAddress(){
        logger.info("Filling email alias");
        String emailAlias = PropertiesHelper.prop.getProperty("newUserEmailAlias");
        driver.findElement(By.id("alias")).sendKeys(emailAlias);
    }

    public void clickOnRegister(){
        logger.info("Clicking on register");
        driver.findElement(By.id("submitAccount")).click();
    }

}

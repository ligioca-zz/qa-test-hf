package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.helpers.PropertiesHelper;
import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.MyAccountPage;
import com.hellofresh.challenge.pages.authentication.AccountCreationPage;
import com.hellofresh.challenge.pages.authentication.AuthenticationPage;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class WebTest extends Base{

    HomePage homePage;
    AuthenticationPage authenticationPage;
    AccountCreationPage accountCreationPage;
    MyAccountPage myAccountPage;

    @Test
    public void signInTest() {
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickOnSignInButton();
        authenticationPage.fillRandomEmailAddressInCreateAnAccountForm();
        authenticationPage.clickOnCreateAnAccount();
        accountCreationPage.fillFirstNameInPersonalInformation();
        accountCreationPage.fillLastNameInPersonalInformation();
        accountCreationPage.fillPasswordInPersonalInformation();
        accountCreationPage.selectDateOfBirthInPersonalInformation();
        accountCreationPage.fillCompanyInYourAddress();
        accountCreationPage.fillAddressInYourAddress();
        accountCreationPage.fillCityInYourAddress();
        accountCreationPage.selectStateInYourAddress();
        accountCreationPage.fillZipCodeInYourAddress();
        accountCreationPage.fillAdditionalInfoInYourAddress();
        accountCreationPage.fillHomePhoneInYourAddress();
        accountCreationPage.fillMobilePhoneInYourAddress();
        accountCreationPage.fillEmailAliasInYourAddress();
        accountCreationPage.clickOnRegister();

        assertTrue(myAccountPage.isTitleCorret());
        assertTrue(myAccountPage.isUserNameOnTheHeaderForNewUserCorrect());
        assertTrue(myAccountPage.infoAccountContainsWelcomeText());
        assertTrue(myAccountPage.isLogoutDisplayed());
        assertTrue(myAccountPage.isUrlCorret());
    }

    @Test
    public void logInTest() {
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        homePage.clickOnSignInButton();
        authenticationPage.fillEmailInAlreadyRegistered();
        authenticationPage.fillPasswordInAlreadyRegistered();
        authenticationPage.clickOnSignIn();

        assertTrue(myAccountPage.isTitleCorret());
        assertTrue(myAccountPage.isUserNameOnTheHeaderForRegisteredUserCorrect());
        assertTrue(myAccountPage.infoAccountContainsWelcomeText());
        assertTrue(myAccountPage.isLogoutDisplayed());
        assertTrue(myAccountPage.isUrlCorret());
    }
////
//    @Test
//    public void checkoutTest() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
//        driver.findElement(By.id("email")).sendKeys(existingUserEmail);
//        driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
//        driver.findElement(By.id("SubmitLogin")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
//        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
//        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
//        driver.findElement(By.name("processCarrier")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
//        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
//
//        assertEquals("ORDER CONFIRMATION", heading.getText());
//        assertTrue(driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed());
//        assertTrue(driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed());
//        assertTrue(driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete."));
//        assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
//    }
}
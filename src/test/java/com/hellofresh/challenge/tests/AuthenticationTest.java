package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.*;
import com.hellofresh.challenge.pages.authentication.AccountCreationPage;
import com.hellofresh.challenge.pages.authentication.AuthenticationPage;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AuthenticationTest extends Base {

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
}

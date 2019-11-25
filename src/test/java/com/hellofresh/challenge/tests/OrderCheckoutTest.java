package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.*;
import com.hellofresh.challenge.pages.authentication.AccountCreationPage;
import com.hellofresh.challenge.pages.authentication.AuthenticationPage;
import com.hellofresh.challenge.pages.order.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class OrderCheckoutTest extends Base {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    AccountCreationPage accountCreationPage;
    MyAccountPage myAccountPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    OrderPage orderPage;
    OrderAddressProcessPage orderAddressProcessPage;
    OrderShippingPage orderShippingPage;
    OrderPaymentPage orderPaymentPage;
    BankWirePaymentPage bankWirePaymentPage;
    OrderConfirmationPage orderConfirmationPage;

    @Test
    public void checkoutTest() {
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
        orderPage = new OrderPage(driver);
        orderAddressProcessPage = new OrderAddressProcessPage(driver);
        orderShippingPage = new OrderShippingPage(driver);
        orderPaymentPage = new OrderPaymentPage(driver);
        bankWirePaymentPage = new BankWirePaymentPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);

        homePage.clickOnSignInButton();
        authenticationPage.fillEmailInAlreadyRegistered();
        authenticationPage.fillPasswordInAlreadyRegistered();
        authenticationPage.clickOnSignIn();

        myAccountPage.clickOnWomenSession();
        categoryPage.clickOnProductWithNameFadedShortSleeveTshirts();

        productPage.clickOnAddToCart();
        productPage.clickOnProceedToCheckOut();
        orderPage.clickOnProceedToCheckOut();
        orderAddressProcessPage.clickOnProceedToCheckOut();
        orderShippingPage.checkTermsOfService();
        orderShippingPage.clickOnProceedToCheckOut();
        orderPaymentPage.selectPaymentMethodPayByBankWire();
        bankWirePaymentPage.clickOnConfirmMyOrder();

        assertTrue(orderConfirmationPage.isTitleCorret());
        assertTrue(orderConfirmationPage.isTheConfirmationLastStep());
        assertTrue(orderConfirmationPage.isOrderComplete());
        assertTrue(orderConfirmationPage.isUrlCorret());
    }
}

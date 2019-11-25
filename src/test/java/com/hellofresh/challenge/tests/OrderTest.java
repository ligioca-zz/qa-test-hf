package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.*;
import com.hellofresh.challenge.pages.authentication.AccountCreationPage;
import com.hellofresh.challenge.pages.authentication.AuthenticationPage;
import com.hellofresh.challenge.pages.order.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderTest extends Base {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    AccountCreationPage accountCreationPage;
    MyAccountPage myAccountPage;
    Category category;
    Product product;
    Order order;
    OrderAddressProcess orderAddressProcess;
    OrderShipping orderShipping;
    OrderPayment orderPayment;
    BakWirePaymentPage bakWirePaymentPage;
    OrderConfirmation orderConfirmation;

    @Test
    public void checkoutTest() {
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        category = new Category(driver);
        product = new Product(driver);
        order = new Order(driver);
        orderAddressProcess = new OrderAddressProcess(driver);
        orderShipping = new OrderShipping(driver);
        orderPayment = new OrderPayment(driver);
        bakWirePaymentPage = new BakWirePaymentPage(driver);
        orderConfirmation = new OrderConfirmation(driver);

        homePage.clickOnSignInButton();
        authenticationPage.fillEmailInAlreadyRegistered();
        authenticationPage.fillPasswordInAlreadyRegistered();
        authenticationPage.clickOnSignIn();

        myAccountPage.clickOnWomenSession();
        category.clickOnProductWithNameFadedShortSleeveTshirts();

        product.clickOnAddToCart();
        product.clickOnProceedToCheckOut();
        order.clickOnProceedToCheckOut();
        orderAddressProcess.clickOnProceedToCheckOut();
        orderShipping.checkTermsOfService();
        orderShipping.clickOnProceedToCheckOut();
        orderPayment.selectPaymentMethodPayByBankWire();
        bakWirePaymentPage.clickOnConfirmMyOrder();

        assertTrue(orderConfirmation.isTitleCorret());
        assertTrue(orderConfirmation.isTheConfirmationLastStep());
        assertTrue(orderConfirmation.isOrderComplete());
        assertTrue(orderConfirmation.isUrlCorret());
    }
}

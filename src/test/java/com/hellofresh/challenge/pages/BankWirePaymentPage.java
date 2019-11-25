package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.base.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankWirePaymentPage {
    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    static public String email;
    final static Logger logger = Logger.getLogger(BankWirePaymentPage.class);

    public BankWirePaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnConfirmMyOrder(){
        logger.info("Clicking on confirm my order");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
    }

}

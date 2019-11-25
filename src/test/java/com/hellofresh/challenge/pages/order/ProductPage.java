package com.hellofresh.challenge.pages.order;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.MyAccountPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    static public String email;
    final static Logger logger = Logger.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCart(){
        logger.info("Click on Add to Cart");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
    }

    public void clickOnProceedToCheckOut(){
        logger.info("Click on Proceed to checkout");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
    }
}

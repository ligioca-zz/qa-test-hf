package com.hellofresh.challenge.pages.order;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.MyAccountPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmation {
    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    static public String email;
    final static Logger logger = Logger.getLogger(MyAccountPage.class);

    public OrderConfirmation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTitleCorret(){
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        logger.info("Title: " + heading.getText() + " must be the same as \"ORDER CONFIRMATION\"");
        return heading.getText().equals("ORDER CONFIRMATION");
    }

    public boolean isUrlCorret(){
        logger.info("URL should contain \"controller=order-confirmation\"");
        return driver.getCurrentUrl().contains("controller=order-confirmation");
    }

    public boolean isOrderComplete(){
        logger.info("Order confirmation message should be displayed");
        return driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText().contains("Your order on My Store is complete.");
    }

    public boolean isTheConfirmationLastStep(){
        logger.info("Order confirmation message should be displayed");
        return driver.findElement(By.xpath("//li[@class='step_done step_done_last four']")).isDisplayed() &&
                driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed();    }

}

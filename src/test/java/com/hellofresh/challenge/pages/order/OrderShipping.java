package com.hellofresh.challenge.pages.order;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.MyAccountPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderShipping {

    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    static public String email;
    final static Logger logger = Logger.getLogger(MyAccountPage.class);

    public OrderShipping(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProceedToCheckOut(){
        driver.findElement(By.name("processCarrier")).click();
    }

    public void checkTermsOfService(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
    }
}

package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.base.Base;
import com.hellofresh.challenge.pages.MyAccountPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
    private WebDriver driver;
    private WebDriverWait wait = Base.wait;
    final static Logger logger = Logger.getLogger(CategoryPage.class);

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProductWithNameFadedShortSleeveTshirts(){
        logger.info("Selecting product with name Faded Short Sleeve");
        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();    }
}

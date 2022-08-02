package com.amit.assignment.pageObjects;

import com.amit.assignment.steps.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Header_Bar extends BaseDriver {
    Actions actions = new Actions(driver);
    By navCartBtn = By.xpath("//div[@id='primary-menu']/ul/li/a[contains(text(),'Cart')]");

    public void clickOnCartBtn() {
        actions.scrollToElement(driver.findElement(navCartBtn)).build().perform();
        driver.findElement(navCartBtn).click();
    }
}

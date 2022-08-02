package com.amit.assignment.steps;

import com.amit.assignment.pageObjects.Header_Bar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Shop_Steps extends BaseDriver {
    Actions actions = new Actions(driver);
    Header_Bar headerPage = new Header_Bar();

    @Given("I add {string} random items to my cart")
    public void i_add_random_items_to_my_cart(String addCount) {
        int i = 1;
        int count = Integer.parseInt(addCount);

        while (i <= count) {
            String products = "//ul[@class='products columns-3']/li[" + i + "]";
            String addBtn = "//ul[@class='products columns-3']/li[" + i + "]/div/following::a[starts-with(@href,'?add')]";
            actions.scrollToElement(driver.findElement(By.xpath(products))).build().perform();
            actions.moveToElement(driver.findElement(By.xpath(products))).build().perform();
            driver.findElement(By.xpath(addBtn)).click();
            i++;

        }


    }

    @When("I view my cart")
    public void i_view_my_cart() throws InterruptedException {
        headerPage.clickOnCartBtn();
    }
}

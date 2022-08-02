package com.amit.assignment.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.TreeMap;

public class Cart_Steps extends BaseDriver {
    int lowestProductRow = 0;
    Actions actions = new Actions(driver);

    @Then("I find total {string} listed in my cart")
    public void i_find_total_listed_in_my_cart(String totalItems) {


        int count = driver.findElements(By.xpath("//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr/td[5]/div/input")).size();
        int row = 1;
        int actualCount = 0;
        while (row <= count) {

            String quantityCol = "//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr[" + row + "]/td[5]/div/input";
            WebElement quantityValue = driver.findElement(By.xpath(quantityCol));
            actualCount = actualCount + Integer.parseInt(quantityValue.getAttribute("value"));
            row++;
        }

        int expectedCount = Integer.parseInt(totalItems);
        Assert.assertEquals("expected: " + expectedCount + " actual: " + actualCount, expectedCount, actualCount);
    }

    @When("I search for lowest price item")
    public void i_search_for_lowest_price_item() throws ParseException {
        int totalProductsinCart = driver.findElements(By.xpath("//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr/td[4]")).size();
        System.out.println("totalProducts in Cart: " + totalProductsinCart);
        int count = 1;
        TreeMap<Double, Integer> map = new TreeMap<>();

        while (count <= totalProductsinCart) {
            String prodcutRows = "//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr[" + count + "]/td[4]/span";
            actions.scrollToElement(driver.findElement(By.xpath(prodcutRows)));
            String myMoney = driver.findElement(By.xpath(prodcutRows)).getText();
            String s = DecimalFormat.getCurrencyInstance(Locale.US).parse(myMoney).toString();

            double d = Double.parseDouble(s);
            map.put(d, count);
            count++;
        }
        lowestProductRow = map.get(map.firstKey());
    }

    @When("I am able to remove the lowest price item from my cart")
    public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() {
        String removeLowestProduct = "//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr[" + lowestProductRow + "]/td/a[contains(@href,'remove')]";
        actions.scrollToElement(driver.findElement(By.xpath(removeLowestProduct)));
        driver.findElement(By.xpath(removeLowestProduct)).click();
    }

    @Then("I am able to verify {string} items in my cart")
    public void i_am_able_to_verify_items_in_my_cart(String expedCountInCart) throws InterruptedException {
        Thread.sleep(2000);
        int expectedCount = Integer.parseInt(expedCountInCart);
        int count = driver.findElements(By.xpath("//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr/td[5]/div/input")).size();
        System.out.println("total products after removing lowest price product:" + count);
        int row = 1;
        int actualCount = 0;
        while (row <= count) {
            String quantityCol = "//table[contains(@class,'woocommerce-cart-form__contents')]/tbody/tr[" + row + "]/td[5]/div/input";
            WebElement quantityValue = driver.findElement(By.xpath(quantityCol));
            actions.scrollToElement(quantityValue);
            actualCount = actualCount + Integer.parseInt(quantityValue.getAttribute("value"));
            row++;
        }
        Assert.assertEquals("expected: " + expectedCount + " actual: " + actualCount, expectedCount, actualCount);
    }
}

package com.amit.assignment.steps;

import com.amit.assignment.utils.Utils;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class Base_Steps extends BaseDriver {

    @Given("I launch {string}")
    public void i_launch(String baseUrl) throws InterruptedException, IOException {
        String url = Utils.getConfigValueFor(baseUrl);
        driver.get(url);

    }
}

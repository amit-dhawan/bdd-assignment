package com.amit.assignment.steps;

import com.amit.assignment.steps.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends BaseDriver {

    @Before
    public void beforeScenario() {
        try {
            initializeBrowser();
        } catch (IOException e) {
            System.out.println("##### Browser setup failed #######");
            throw new RuntimeException(e);
        }
    }

    @After
    public void afterScenario() throws IOException {
        tearDown();
    }
}

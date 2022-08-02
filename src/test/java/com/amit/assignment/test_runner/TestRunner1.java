package com.amit.assignment.test_runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles"},
        glue = {"com.amit.assignment.steps"},
        plugin = {"pretty",
                "html:target/cucumber-html/cucumber.html",
                "json:target/cucumber-json/cucumber.json"}
        //     , tags = "@run1")
)

public class TestRunner1 {
}

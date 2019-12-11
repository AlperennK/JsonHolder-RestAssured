package com.jsonplaceholder;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        tags = {"~@wip", "~@ignored"},
        plugin = {
                "json:target/cucumber-reports/cucumber.json"
        }

)
public class RunCukeTest {
}
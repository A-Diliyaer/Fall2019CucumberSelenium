package com.vytrack.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features/fleet",
        dryRun = false,
        strict = false,
        tags = "@create_car",
        plugin = {
                "html:target/default-report",
                "json:target/cucumber2.json"
        }
)
public class CreateCarRunner extends AbstractTestNGCucumberTests {

}

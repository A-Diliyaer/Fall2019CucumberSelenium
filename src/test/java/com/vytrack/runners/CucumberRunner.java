package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        strict = true,
        tags = "@create_calendar_Event_2", //"@sales_manager or @driver"----runs both tests, "and" runs test that have both tags
        plugin = {
                "html:target/cucumber-html-report",
                "json:target/cucumber1.json"
        }

)
public class CucumberRunner {


}

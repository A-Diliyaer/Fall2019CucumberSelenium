package com.vytrack.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@smoke_test", //"@sales_manager or @driver"----runs both tests, "and" runs test that have both tags
        plugin = {
                "html:target/smoke_test_default-report",
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }

)
public class SmokeTestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider
        public Object[][] scenarios(){
                if (testNGCucumberRunner )
        }
}

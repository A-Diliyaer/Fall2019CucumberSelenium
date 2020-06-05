package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order =2)
    public void setup(){
        System.out.println("test setup");
        Driver.getDriver().manage().window().maximize();
    }

    @Before(value = "@driver", order =1)
    public void specialSetup(){
        System.out.println("setup for driver");
    }

    @After("@driver")
    public void specialTeardown(){
        System.out.println("tear down for driver only");
    }

    @After
    public void teardown(Scenario scenario){
        if (scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("test clean up");
        Driver.closeDriver();
    }
}

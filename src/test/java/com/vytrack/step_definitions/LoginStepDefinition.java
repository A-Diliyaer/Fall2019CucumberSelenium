package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("open login page");
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        System.out.println("login as sales manager");
        loginPage.login("salesmanager110","UserUser123");
    }
    @Then("user should verify that title is Dashboard")
    public void user_should_verify_that_title_is_Dashboard() {
        System.out.println("verify that title is dashboard");
        Assert.assertEquals("Dashboard",Driver.getDriver().getTitle());
        Driver.closeDriver();
    }
}

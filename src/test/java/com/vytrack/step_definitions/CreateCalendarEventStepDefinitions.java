package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinitions {

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user clicks on create calendar event button")
    public void userClicksOnCreateCalendarEventButton() {
        System.out.println("User click on create calendar event button");
        calendarEventsPage.clickToCreateCalendarEvent();
    }

    @And("user enters {string} as title")
    public void userEntersAsTitle(String title) {
        System.out.println("User enters title: "+title);
        calendarEventsPage.enterCalendarEventTitle(title);
    }

    @And("user enters {string} as description")
    public void userEntersAsDescription(String description) {
        System.out.println("User enters: "+description);
        calendarEventsPage.enterCalendarEventDescription(description);
    }

    @Then("user clicks on save and close button")
    public void userClicksOnSaveAndCloseButton() {
        System.out.println("User clicks on save and close button");
        calendarEventsPage.clickOnSaveAndClose();
    }

    @And("user verifies that description of new calendar event is {string}")
    public void userVerifiesThatDescriptionOfNewCalendarEventIs(String description) {
        Assert.assertEquals(description,calendarEventsPage.getGeneralInfoDescriptionText());
    }

    @And("user verifies that title of new calendar event is {string}")
    public void userVerifiesThatTitleOfNewCalendarEventIs(String title) {
        Assert.assertEquals(title,calendarEventsPage.getGeneralInfoTitleText());
    }

    @Then("user enters new calendar event information:")
    public void userEntersNewCalendarEventInformation(Map<String,String> dataTable) {
        calendarEventsPage.enterCalendarEventTitle(dataTable.get("title"));
        calendarEventsPage.enterCalendarEventDescription(dataTable.get("description"));

    }

    @Then("user verifies new calendar event")
    public void userVerifiesNewCalendarEvent(Map<String,String> dataTable) {
        Assert.assertEquals(dataTable.get("title"),calendarEventsPage.getGeneralInfoTitleText());
        Assert.assertEquals(dataTable.get("description"),calendarEventsPage.getGeneralInfoDescriptionText());

    }
}

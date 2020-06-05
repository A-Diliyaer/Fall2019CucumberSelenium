package com.vytrack.step_definitions;

import com.vytrack.pages.CalendarEventsPage;
import io.cucumber.java.en.Then;

public class CreateCalendarEventStepDefinitions {

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user clicks on create calendar event button")
    public void userClicksOnCreateCalendarEventButton() {
        System.out.println("User click on create calendar event button");
        calendarEventsPage.clickToCreateCalendarEvent();
    }
}

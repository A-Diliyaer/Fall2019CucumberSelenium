package com.vytrack.pages;

import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase{

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    @FindBy(xpath = "//thead//tr//th")
    private List<WebElement> columnNames;

    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;

    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(id = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right']>button")
    private WebElement saveAndClose;

    @FindBy(xpath ="(//div[@class='control-label'])[1]" )
    private WebElement generalInfoTitle;

    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//p[1]")
    private WebElement generalInfoDescription;

    public void enterCalendarEventTitle(String titleValue){
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterCalendarEventDescription(String description){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();
    }

    public void clickOnSaveAndClose(){
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }

    public String getGeneralInfoTitleText(){
        BrowserUtils.waitForLoad();
        return generalInfoTitle.getText();
    }

    public String getGeneralInfoDescriptionText(){
       BrowserUtils.waitForLoad();
        return generalInfoDescription.getText();
    }

    public String getOwnerName(){
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }


    public void clickToCreateCalendarEvent(){

        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Create Calendar event']")));
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }

    public String getStartDate(){
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtils.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }
    public String getEndTime(){
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");

    }

    public List<String> getColumnNames(){
        BrowserUtils.waitForLoad();
        return BrowserUtils.getTextFromWebElements(columnNames);
    }

}

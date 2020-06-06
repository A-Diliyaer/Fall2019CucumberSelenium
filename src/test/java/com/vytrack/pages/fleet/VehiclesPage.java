package com.vytrack.pages.fleet;

import com.vytrack.pages.AbstractPageBase;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    @FindBy(xpath = "(//div[@class='loader-frame'])[3]")
    private WebElement loader;

    @FindBy(css = "input[name='custom_entity_type[LicensePlate]']")
    private WebElement licencePlateInput;

    @FindBy(css = "input[name='custom_entity_type[Driver]']")
    private WebElement driverInput;

    @FindBy(css = "input[name='custom_entity_type[Location]']")
    private WebElement locationInput;

    @FindBy(css = "input[name='custom_entity_type[ModelYear]']")
    private WebElement modelYear;

    @FindBy(css = "input[name='custom_entity_type[Color]']")
    private WebElement color;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement submit;

    public void setLicensePlateInput(String licensePlate){
        BrowserUtils.waitForLoad();
        licencePlateInput.sendKeys(licensePlate);
    }

    public void setDriverInput(String driver){
        driverInput.sendKeys(driver);
    }

    public void setLocationInput(String location){
        locationInput.sendKeys(location);
    }

    public void setModelYear(String modelYear){
        this.modelYear.sendKeys(modelYear);
    }

    public void setColor(String color){
        this.color.sendKeys(color);
    }

    public void submit(){
        submit.click();
    }

    public void clickToCreateCar(){
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }

    public String getCarGeneralInfo(String parameter){
        String xpath = "//label[text()='"+parameter+"']/following-sibling::div/div";
        BrowserUtils.waitForLoad();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

}

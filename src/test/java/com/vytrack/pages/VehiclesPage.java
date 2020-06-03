package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    @FindBy(xpath = "(//div[@class='loader-frame'])[3]")
    private WebElement loader;

    public void clickToCreateCar(){
        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
    }

}

package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class will be extended by page classes
 * any common webelements/locators can be stored here
 * since navigation menu doesnt belong to particular page
 * we cannot really create a dedicated page
 */
public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,10);

    @FindBy(css = "[id='user-menu']>a")
    protected WebElement currentUser;

    @FindBy(css = "[class='btn-group pull-right']>button")
    protected WebElement saveAndClose;


    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    /**
     * get current user name
     * @return currentUser
     */
    public String getCurrentUserName(){
       BrowserUtils.waitForLoad();
       wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }


    /**
     * method for vytrack navigation, provide tab name and module name to navigate
     * @param tabName, like dashboards, fleet, customers
     * @param moduleName, like vehicles, vehicles odometer, vehicles costs
     */
    public void navigateTo(String tabName, String moduleName){
        String tabNameXpath ="//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='"+moduleName+"']";
        BrowserUtils.waitForLoad();

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);
        BrowserUtils.waitForLoad();
        actions.moveToElement(tabElement).
                pause(1000).
                click(moduleElement).
                build().perform();

        BrowserUtils.waitForLoad();

    }

    public void clickOnSaveAndClose(){
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }


}

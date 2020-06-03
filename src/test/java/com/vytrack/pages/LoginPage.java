package com.vytrack.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase {

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMsg;


    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    /**
     * method to login version 1
     * login as a specific user
     * @param username
     * @param password
     */
    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password, Keys.ENTER);
        if (username.equals(ConfigurationReader.getProperty("store_manager")) &&
            password.equals(ConfigurationReader.getProperty("password"))){
            BrowserUtils.waitForLoad();
        }

    }


    /**
     * method to login version 2
     * login as a default user
     * credentials will be retrieved from configuration.properties file
     */
    public void login(){
       username.sendKeys(ConfigurationReader.getProperty("store_manager"));
       password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
       BrowserUtils.waitForLoad();
    }

    /**
     * return warning msg if credentials are not correct
     * @return
     */
    public String getWarningMsg(){
        return warningMsg.getText();
    }

}

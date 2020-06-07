package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

//    private static WebDriver driver;
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private Driver(){

    }

    public synchronized static WebDriver getDriver(){
        if (driverPool.get()==null){
            String browser = com.vytrack.utilities.ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("---start-maximized");
//                    driver = new ChromeDriver(chromeOptions);
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "chromeheadless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
//                    driver = new ChromeDriver(options);
                    driverPool.set(new ChromeDriver(options));

                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
//                    driver=new FirefoxDriver();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }

        return driverPool.get();
    }


    public static void closeDriver(){
        if (driverPool!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

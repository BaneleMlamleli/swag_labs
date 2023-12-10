package com.swag_labs.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Class: BaseClass
 * This class will contain the definition calls of the different browsers and 
 * launch the default website page
 */
public class BaseClass {

    public static WebDriver webDriver = null;
    static final String DRIVER_PATH = "C:/Users/ciphe/Documents/Programming_local/webdrivers/";
    static final String BASE_URL = "https://www.saucedemo.com/";
    final static String BROWSER = "chrome"; //chrome, firefox, edge
    
    public static void launchBrowserWithWebsiteHomePage() {
        switch (BROWSER) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to(BASE_URL);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
                webDriver = new FirefoxDriver(options);
                webDriver.manage().window().maximize();
                webDriver.navigate().to(BASE_URL);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", DRIVER_PATH + "msedgedriver.exe");
                webDriver = new EdgeDriver();
                webDriver.manage().window().maximize();
                webDriver.navigate().to(BASE_URL);
                break;
            default:
                System.out.println("Selected browser is not available. You can use Chrome, Firefox, or Edge");
                break;
        }
    }
    
    public void closeBrowser() {
        webDriver.close();
        webDriver.quit();
    }
}
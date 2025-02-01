package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            setupDriver();
        }
        return driver;
    }

    private static void setupDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "e1d6ccd2");
        capabilities.setCapability("appPackage", "com.akakce.akakce");
        capabilities.setCapability("appActivity", "com.akakce.akakce.ui.activity.MainActivity");
        capabilities.setCapability("noReset", false);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
} 
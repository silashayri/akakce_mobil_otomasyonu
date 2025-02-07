package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    
    @AndroidFindBy(id = "com.akakce.akakce:id/announcementTextView")
    private WebElement continueWithoutLoginButton;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private WebElement allowNotificationButton;

    @AndroidFindBy(id = "com.akakce.akakce:id/searchTextView")
    private WebElement searchButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@resource-id=\"com.akakce.akakce:id/searchTextView\"])[2]")
    private WebElement searchBox;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickContinueWithoutLogin() {
        waitAndClick(allowNotificationButton);
        waitAndClick(continueWithoutLoginButton);
    }

    public void searchProduct(String productName) throws InterruptedException {
        waitAndClick(searchButton);
        waitAndSendKeys(searchBox, productName);

        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));


    }
} 
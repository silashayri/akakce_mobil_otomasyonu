package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    
    @AndroidFindBy(id = "com.akakce.akakce:id/continueWithoutLogin")
    private WebElement continueWithoutLoginButton;

    @AndroidFindBy(id = "com.akakce.akakce:id/searchBox")
    private WebElement searchBox;

    @AndroidFindBy(id = "com.akakce.akakce:id/searchButton")
    private WebElement searchButton;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickContinueWithoutLogin() {
        waitAndClick(continueWithoutLoginButton);
    }

    public void searchProduct(String productName) {
        waitAndSendKeys(searchBox, productName);
        waitAndClick(searchButton);
    }
} 
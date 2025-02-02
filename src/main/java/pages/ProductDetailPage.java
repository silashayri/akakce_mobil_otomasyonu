package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {

    @AndroidFindBy(id = "com.akakce.akakce:id/goToProductButton")
    private WebElement goToProductButton;

    @AndroidFindBy(id = "com.akakce.akakce:id/goToSellerButton")
    private WebElement goToSellerButton;

    public ProductDetailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickGoToProduct() {
        waitAndClick(goToProductButton);
    }

    public boolean isGoToSellerButtonDisplayed() {
        return isElementDisplayed(goToSellerButton);
    }
} 
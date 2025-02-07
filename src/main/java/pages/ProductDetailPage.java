package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends BasePage {

    @AndroidFindBy(id = "com.akakce.akakce:id/detailBtnLayout")
    private WebElement goToProductButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Satıcıya Git\"]/android.view.View")
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
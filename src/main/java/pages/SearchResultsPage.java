package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {

    @AndroidFindBy(id = "com.akakce.akakce:id/filterButton")
    private WebElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bilgisayar,Donanım']")
    private WebElement computerHardwareCategory;

    @AndroidFindBy(id = "com.akakce.akakce:id/showProductsButton")
    private WebElement showProductsButton;

    @AndroidFindBy(id = "com.akakce.akakce:id/sortButton")
    private WebElement sortButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='En Yüksek Fiyat']")
    private WebElement highestPriceOption;

    public SearchResultsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickFilterButton() {
        waitAndClick(filterButton);
    }

    public void selectComputerHardwareCategory() {
        waitAndClick(computerHardwareCategory);
    }

    public void clickShowProductsButton() {
        waitAndClick(showProductsButton);
    }

    public void sortByHighestPrice() {
        waitAndClick(sortButton);
        waitAndClick(highestPriceOption);
    }

    public void selectProductByIndex(int index) {
        WebElement product = driver.findElement(By.xpath(
            "(//android.widget.LinearLayout[@resource-id='com.akakce.akakce:id/productItem'])[" + index + "]"));
        waitAndClick(product);
    }
} 
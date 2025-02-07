package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @AndroidFindBy(id = "com.akakce.akakce:id/filterArea")
    private WebElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bilgisayar, Donanım']")
    private WebElement computerHardwareCategory;

    @AndroidFindBy(id = "com.akakce.akakce:id/applyFilterBtn")
    private WebElement showProductsButton;

    @AndroidFindBy(id = "com.akakce.akakce:id/sortArea")
    private WebElement sortButton;

    @AndroidFindBy(xpath = "(//android.widget.LinearLayout[@resource-id='com.akakce.akakce:id/sort_cell_bg'])[3]")
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

        int totalProducts = 0;
        while (totalProducts < 11) {

            List<WebElement> productList = driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id=\"com.akakce.akakce:id/card\"]"));
            totalProducts += productList.size();
            swipeUp(driver);

            if (totalProducts >= index) {
                productList.get(9 - (totalProducts - productList.size()));
                WebElement product = driver.findElement(By.xpath(
                        "//android.widget.TextView[@resource-id=\"com.akakce.akakce:id/price\" and @text=\"125.501,03 TL\"]"));
                System.out.println("Total products: "+totalProducts);
                waitAndClick(product);
                break;
            }


        }



    }
} 
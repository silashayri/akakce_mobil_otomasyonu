package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import static org.testng.Assert.assertTrue;
import java.time.Duration;

public class AkakceSteps {
    private AppiumDriver driver = DriverManager.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("Kullanıcı Akakçe uygulamasını açar")
    public void kullaniciAkakceUygulamasiniAcar() {
    }

    @When("Üye olmadan devam et seçeneğine tıklar")
    public void uyeOlmadanDevamEt() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.akakce.akakce:id/continueWithoutLogin")));
        continueButton.click();
    }

    @When("Arama kutusuna {string} yazar ve aratır")
    public void aramaYap(String searchText) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.akakce.akakce:id/searchBox")));
        searchBox.sendKeys(searchText);
        
        WebElement searchButton = driver.findElement(By.id("com.akakce.akakce:id/searchButton"));
        searchButton.click();
    }

    @When("Filtrele butonuna tıklar")
    public void filtreleButonunaTiklar() {
        WebElement filterButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.akakce.akakce:id/filterButton")));
        filterButton.click();
    }

    @When("Alt kategori olarak Bilgisayar,Donanım seçer")
    public void altKategoriSec() {
        WebElement categoryButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//android.widget.TextView[@text='Bilgisayar,Donanım']")));
        categoryButton.click();
    }

    @When("Ürünleri Gör butonuna tıklar")
    public void urunleriGorButonunaTiklar() {
        WebElement showProductsButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.akakce.akakce:id/showProductsButton")));
        showProductsButton.click();
    }

    @When("Sıralama için En Yüksek Fiyat seçeneğini seçer")
    public void enYuksekFiyatSec() {
        WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.akakce.akakce:id/sortButton")));
        sortButton.click();

        WebElement highestPriceOption = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//android.widget.TextView[@text='En Yüksek Fiyat']")));
        highestPriceOption.click();
    }

    @When("Sonuç listesinden {int}. ürüne tıklar")
    public void urunSec(int index) {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//android.widget.LinearLayout[@resource-id='com.akakce.akakce:id/productItem'])[" + index + "]")));
        product.click();
    }

    @When("Ürüne Git butonuna tıklar")
    public void uruneGitButonunaTiklar() {
        WebElement goToProductButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.id("com.akakce.akakce:id/goToProductButton")));
        goToProductButton.click();
    }

    @Then("Satıcıya Git butonu görüntülenmelidir")
    public void saticiyaGitButonuKontrol() {
        WebElement goToSellerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("com.akakce.akakce:id/goToSellerButton")));
        assertTrue(goToSellerButton.isDisplayed());
    }
} 
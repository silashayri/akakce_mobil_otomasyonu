package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ProductDetailPage;
import static org.testng.Assert.assertTrue;

public class AkakceSteps {
    private HomePage homePage = new HomePage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private ProductDetailPage productDetailPage = new ProductDetailPage();

    @Given("Kullanıcı Akakçe uygulamasını açar")
    public void kullaniciAkakceUygulamasiniAcar() {
    }

    @When("Üye olmadan devam et seçeneğine tıklar")
    public void uyeOlmadanDevamEt() {
        homePage.clickContinueWithoutLogin();
    }

    @When("Arama kutusuna {string} yazar ve aratır")
    public void aramaYap(String searchText) throws InterruptedException {
        homePage.searchProduct(searchText);
    }

    @When("Filtrele butonuna tıklar")
    public void filtreleButonunaTiklar() {
        searchResultsPage.clickFilterButton();
    }

    @When("Alt kategori olarak Bilgisayar,Donanım seçer")
    public void altKategoriSec() {
        searchResultsPage.selectComputerHardwareCategory();
    }

    @When("Ürünleri Gör butonuna tıklar")
    public void urunleriGorButonunaTiklar() {
        searchResultsPage.clickShowProductsButton();
    }

    @When("Sıralama için En Yüksek Fiyat seçeneğini seçer")
    public void enYuksekFiyatSec() {
        searchResultsPage.sortByHighestPrice();
    }

    @When("Sonuç listesinden {int}. ürüne tıklar")
    public void urunSec(int index) {
        searchResultsPage.selectProductByIndex(index);
    }

    @When("Ürüne Git butonuna tıklar")
    public void uruneGitButonunaTiklar() {
        productDetailPage.clickGoToProduct();
    }

    @Then("Satıcıya Git butonu görüntülenmelidir")
    public void saticiyaGitButonuKontrol() {
        assertTrue(productDetailPage.isGoToSellerButtonDisplayed());
    }
} 
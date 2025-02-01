Feature: Akakçe Ürün Arama ve Filtreleme

  Scenario: Laptop arama ve filtreleme
    Given Kullanıcı Akakçe uygulamasını açar
    When Üye olmadan devam et seçeneğine tıklar
    And Arama kutusuna "Laptop" yazar ve aratır
    And Filtrele butonuna tıklar
    And Alt kategori olarak Bilgisayar,Donanım seçer
    And Ürünleri Gör butonuna tıklar
    And Sıralama için En Yüksek Fiyat seçeneğini seçer
    And Sonuç listesinden 10. ürüne tıklar
    And Ürüne Git butonuna tıklar
    Then Satıcıya Git butonu görüntülenmelidir 
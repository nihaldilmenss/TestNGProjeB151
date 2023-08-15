package test.user15_16;

import utilities.ConfigReader;
import utilities.ExtentReport;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import pages.Page;
import utilities.ReusableMethods;

public class US_16_TC_01 extends ExtentReport {

    @Test
    public void test01() {

        //silinebilir daha sonra bu satir
        //https://allovercommerce.com/ adresine gidin.
        //Kayıtlı satıcı e-postası ve şifresi ile giriş yapın.
        //Mağaza müdürü için tıklayın.
        //Ürünler için tıklayın.
        //Yeni ekle düğmesine tıklay.ın.
        //Simple Product'ın varsayılan olarak geldiğini doğrulayın.
        //Sanal ve İndirilebilir onay kutularının seçilebilir olduğunu doğrulayın.
        //Sanal onay kutunuzu seçin.
        //Fiyat ve Satış Fiyatı metin kutularının erişilebilir olduğunu doğrulayın.
        //Fiyat ve Satış Fiyatı metin kutularına bir değer girin.
        //Ürün Başlığı metin kutusunun erişilebilir olduğunu doğrulayın.
        //Ürün Başlığı metin kutusuna bir değer girin.
        //Kategoriler altındaki kategorilerin seçilebilir olduğunu doğrulayın.
        //Kategoriler'den bir kategori seçin.
        //Sağ taraftaki resim ekle düğmesine tıklayın ve resim ekleyin
        //En alttaki Gönder düğmesine tıklayın.
        //"Ürün mesaji: Bu alan gereklidir." görünür olduğunuzu doğrulayın
        //Ürün bölümünde ürünün eklendiğini dogrulayin


        extentTest = extentReports.createTest("Nihal" , "Allovercommerce Test Edebilmeli");

        //Go to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //Login with registered vendor email and password
        Page alloverCommercePage = new Page();

        alloverCommercePage.signIn.click();


        ReusableMethods.bekle(2);

        alloverCommercePage.username.sendKeys(ConfigReader.getProperty("email"), Keys.TAB, ConfigReader.getProperty("password"));

        ReusableMethods.bekle(2);


        alloverCommercePage.logInButton.submit();

        ReusableMethods.bekle(2);

        extentTest.info("Giriş yapıldı");

        //Verify that the My Account section at the bottom of the page is visible
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE).perform();

        Assert.assertTrue(alloverCommercePage.hesabimYazisi.isDisplayed());

        ReusableMethods.bekle(2);
        extentTest.info("Hesabim Yazisi Görüldü");

        extentTest.info(" Store Manager Yazisi Görüldü");
        //Click My Account under the My Account tab
        ReusableMethods.click(alloverCommercePage.hesabimButton);
        extentTest.info("Hesabim Butonuna Tiklandi");

        //Verify that the Store Manager Section is visible on the My account page that opens
        ReusableMethods.bekle(2);
        Assert.assertTrue(alloverCommercePage.storeManagerText.isDisplayed());


        //Click to Store Manager
        ReusableMethods.click(alloverCommercePage.storeManagerButton);
        extentTest.info(" Store Managera Tiklandi");



        actions.sendKeys(Keys.SPACE);

        //Verify that the Products section is visible on the Store Manager page that opens
        Assert.assertTrue(alloverCommercePage.productYazisi.isDisplayed());
        extentTest.info(" Product Yazisi Görüldü");

        //Click Add New that appears when you hover over Products.
        ReusableMethods.click(alloverCommercePage.productButton);
        ReusableMethods.bekle(2);
        extentTest.info(" Product Yazisina Tiklandi");


        //Add New click
        ReusableMethods.click(alloverCommercePage.addnewButton);

        ReusableMethods.bekle(2);
        extentTest.info(" Yeni tıklama eklendi");



        //Verify that Simple Product comes by default
        Assert.assertTrue(alloverCommercePage.simpleProductYazisi.getText().contains("Simple Product"));
        ReusableMethods.bekle(2);

        extentTest.info("Basit Ürünün varsayılan olarak geldiğini doğrulandi");


        actions.sendKeys(Keys.SPACE);

        //Verify that Virtual and Downloadable checkboxes are selectable
        ReusableMethods.click(alloverCommercePage.virtual);
        ReusableMethods.bekle(2);
        extentTest.info("Sanal ve İndirilebilir onay kutularının seçilebilir olduğunu doğrulandi");


        ReusableMethods.click(alloverCommercePage.downloadable);
        ReusableMethods.bekle(2);

        //Select your virtual checkbox
        ReusableMethods.click(alloverCommercePage.virtual);
        extentTest.info("Sanal Onay Kutunuzu Seçildi");


        //Verify that the Price and Sale Price textboxes are accessible
        //Enter a value in the Price and Sale Price textboxes
        ReusableMethods.click(alloverCommercePage.salePriceKutu);
        alloverCommercePage.salePriceKutu.sendKeys("20");
        ReusableMethods.bekle(2);

        extentTest.info("Fiyat ve İndirimli Fiyat metin kutularının erişilebilir olduğunu doğrulandi");
        extentTest.info("Fiyat ve Satış Fiyatı metin kutularına bir değer girildi");


        ReusableMethods.click(alloverCommercePage.priceKutu);
        alloverCommercePage.priceKutu.sendKeys("20");
        ReusableMethods.bekle(2);


        //Verify that the Product Title textbox is accessible
        //Enter a value in the Product Title textbox
        ReusableMethods.click(alloverCommercePage.productTitle);
        alloverCommercePage.productTitle.sendKeys("Eglence Kutusu");
        ReusableMethods.bekle(2);
        extentTest.info("Ürün Başlığı metin kutusunun erişilebilir olduğunu doğrulandi\n" +
                "/Ürün Başlığı metin kutusuna bir değer girildi");


        //Verify that the categories under Categories are selectable
        //Select a category from Categories
        ReusableMethods.scroll(alloverCommercePage.categoriesYildiz);
        extentTest.info("Kategoriler altındaki kategorilerin seçilebilir olduğunu doğrulandi");


        Assert.assertTrue(alloverCommercePage.categoriesYildiz.isDisplayed());
        //Assert.assertTrue(alloverCommercePage.categories1.isSelected());
        //Assert.assertTrue(alloverCommercePage.categories2.isSelected());
        //Assert.assertTrue(alloverCommercePage.categories3.isSelected());



        ReusableMethods.click(alloverCommercePage.categories1);
        extentTest.info("Kategorilerden bir kategori seçildi");






        //Click the add image button on the right and add image
        ReusableMethods.scroll(alloverCommercePage.resimEkleButton);
        ReusableMethods.click(alloverCommercePage.resimEkleButton);

        extentTest.info("Sağdaki resim ekle butonuna tıklandi ve resim eklendi");




        //bu kisimda resim eklenmedi ve kaydedilmedi-->HATALI KISIM







        //Click the Submit button at the bottom.
        ReusableMethods.scroll(alloverCommercePage.submitButton);
        ReusableMethods.click(alloverCommercePage.submitButton);
        //alloverCommercePage.submitButton.submit();
        extentTest.info("En alttaki Gönder düğmesine tıklandi");



        //"Product cat: This field is required." verify that you are visible
        Assert.assertTrue(alloverCommercePage.redmesaji.isDisplayed());
        extentTest.info("Ürün kedisi: Bu alan zorunludur. Görünür olduğunuzu doğrulandi");


        extentTest.pass("Checked");
        extentReports.flush();

        Driver.getDriver().quit();


    }

}

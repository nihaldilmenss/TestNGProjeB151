package test.user9_10;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US10_TestCase01 extends ExtentReport {
    @Test
    public void US10TestCase01() {
        extentTest = extentReports.createTest("Gülsün", "Parola Dereceleri: Test Kontrolü");
        Page alloverPage = new Page();

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("VendorUrl"));
        extentTest.info("Anasayfaya gidildi");
        ReusableMethods.bekle(2);

        assert alloverPage.anaSayfa.isDisplayed();
        extentTest.pass("Anasayfaya giriş dogrulandı");
        ReusableMethods.bekle(2);

        //Register butonuna tikla
        alloverPage.register.click();
        extentTest.info("Register Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.becomeVendor.isDisplayed());
        extentTest.pass("Become a Vendor Yazısı Dogrulandı");
        ReusableMethods.bekle(4);

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        alloverPage.becomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");
        ReusableMethods.bekle(4);

        //Vendor Registration sayfasının görünürlügünü doğrula.
        Assert.assertTrue(alloverPage.vendorRegistirationBaslik.isDisplayed());
        extentTest.pass("Vendor Registration sayfası dogrulandı");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterden az bir password  gir.
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKarakAzKod"));
        extentTest.info("Altı Karakterden Az Bir Password Girildi");
        ReusableMethods.bekle(2);

        //"Too short" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.tooShort.isDisplayed());
        extentTest.info("Too short Mesajı Görüldü");
        ReusableMethods.bekle(2);

        ReusableMethods.webElementResmi(alloverPage.tooShort);
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanı Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli sadece rakam içeren bir password gir
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKarakteriRakam"));
        extentTest.info("Password Alanına Altı Karakterli Rakamdan Olusan Password Girildi");
        ReusableMethods.bekle(2);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        ReusableMethods.webElementResmi(alloverPage.weak);
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Password Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli sadece küçük harf içeren bir password gir	Password--> abcdef
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKarkterkucukHarf"));
        extentTest.info("Password Alanına Altı Karakterli Küçük Harften Olusan Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli sadece büyük harf içeren bir password gir	Password--> ABCDEF
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKarktrBuyukHarf"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harften Oluşan Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli sadece special karakter içeren bir password gir(*,?,&,%,!,#,$,^,',',_ karakterleri hariç)	Password-->+++...
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKarktrSpecialKrkt"));
        extentTest.info("Password Alanına Altı Karakterli Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli rakam, kücük harf ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç) içeren bir password giriniz	Password--> 12ab..
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiRakmKHrfSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakterli Rakam, Küçük Harf, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli rakam, büyük harf ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç) içeren bir password giriniz	Password--> 12AB..
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiRakmBHrfSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakter Rakam, Büyük Harf, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli küçük harf, büyük harf ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç) içeren bir password giriniz	Password-->aaSS..
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKHrfBHrfSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakter Küçük Harf, Büyük Harf, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli küçük harf, rakam ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç) içeren bir password giriniz	Password-->11aa..
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKHrfRakamSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakter Küçük Harf, Rakam, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);


        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli büyük harf, rakam ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç) içeren bir password giriniz	Password-->22AA..
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfRkamSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harf, Rakam, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli küçük harf ve rakam  içeren bir password giriniz	Password-->asd123
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKHarfRakam"));
        extentTest.info("Password Alanına Altı Karakterli Küçük Harf, Rakam İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli büyük harf ve rakam  içeren bir password giriniz	Password-->ASD123
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfRakam"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harf,Rakam İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli büyük harf ve küçük harf  içeren bir password giriniz	Password-->ASDghj
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfKHarf"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harf, Küçük Harf İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli küçük  harf ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç)  içeren bir password giriniz	Password-->asd…
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKHarfSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakterli Küçük Harf, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password  alanina 6 karakterli büyük  harf ve special karakter (*,?,&,%,!,#,$,^,',',_ karakterleri hariç)  içeren bir password giriniz	Password-->ASD…
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfSpecKrkt"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harf, Special Karakter İçeren Password Girildi ");
        ReusableMethods.bekle(3);

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.weak.isDisplayed());
        extentTest.pass("Week Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password 6 karakterli en az bir büyük harf, küçük harf, rakam  ve special karakter(*,?,&,%,!,#,$,^,',',_ karakterleri hariç) içeren  bir password gir.	"Password-->Tech1+Password-->Tech1."
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfKHarfRakamSpecKrk"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harf, Küçük Harf İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.good.isDisplayed());
        extentTest.pass("Good Yazısı Görüldü");
        ReusableMethods.bekle(2);

        ReusableMethods.webElementResmi(alloverPage.good);
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password 6 karakterli en az bir büyük harf, küçük harf, rakam içeren  bir password gir.	Password-->Tech12
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfKHarfRakam"));
        extentTest.info("Pasword Alanına Altı Karakterli Büyük Harf, Küçük Harf, Rakam İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.good.isDisplayed());
        extentTest.pass("Good Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password 8 karakterli en az bir büyük harf ve küçük harf içeren bir password giriniz
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("sekizBHarfKHarf"));
        extentTest.info("Password Alanına Sekiz Karakterli Büyük Harf, Küçük Harf İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.good.isDisplayed());
        extentTest.pass("Good Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Password 8 karakterli en az bir büyük harf ve rakam içeren bir password giriniz
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("sekizBHarfRakam"));
        extentTest.info("Password Alanına Sekiz Karakterli Büyük Harf, Rakam İçeren Password Girildi.");
        ReusableMethods.bekle(2);

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.good.isDisplayed());
        extentTest.pass("Good Yazısı Görüldü");
        ReusableMethods.bekle(3);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Password 8 karakterli en az bir küçük harf ve rakam içeren bir password giriniz
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("sekizKHarfRakam"));
        extentTest.info("Password Alanına Sekiz Karakterli Küçük Harf, Rakam İçeren Password Girildi");
        ReusableMethods.bekle(2);

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.good.isDisplayed());
        extentTest.pass("Good Yazısı Görüldü");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Password 6 karakterli en az bir büyük harf ,küçük harf, rakam içeren ve (*,?,&,%,!,#,$,^,',',_) karakterlerinden en az birini içeren bir password gir.	"Password-->Tech1?
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiBHarfKHarfRakamOzelKrkt"));
        extentTest.info("Password Alanına Altı Karakterli Büyük Harf, Küçük Harf, Rakam İçeren Password Girildi");
        ReusableMethods.bekle(3);

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.strong.isDisplayed());
        extentTest.pass("Strong Yazısı Dogrulandı");
        ReusableMethods.bekle(2);

        ReusableMethods.webElementResmi(alloverPage.strong);
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password 8 karakterli en az bir büyük harf ,küçük harf ve rakam  içeren  bir password gir. Password-->Tech1234
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("sekizBHarfKHarfRakam"));
        extentTest.info("Password Alanına Sekiz Karakterli Büyük Harf, Küçük Harf, Rakam İçeren Password Giriniz");
        ReusableMethods.bekle(3);

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.strong.isDisplayed());
        extentTest.pass("Strong Yazısı Dogrulandı");
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(2);

        //Password 8 karakterli en az bir büyük harf ,küçük harf rakam ve special karakter(*,?,&,%,!,#,$,^,',',_) içeren  bir password gir. "Password-->Tech123?
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("sekizBHarfKHarfOzelKrk"));
        extentTest.info("Password Alanına Sekiz Karakterli Büyük Harf, Küçük Harf, Rakam, Special Karakter İçeren Password Girildi");
        ReusableMethods.bekle(2);

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.strong.isDisplayed());
        extentTest.pass("Strong Yazısı Dogrulandı");
        ReusableMethods.bekle(2);

        Driver.closeDriver();

    }
}

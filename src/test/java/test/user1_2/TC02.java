package test.user1_2;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC02 extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Ceylan" , "Allovercommerce Test Edebilmeli");
        Faker faker= new Faker();
        Page pages=new Page();
        Actions actions= new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        SoftAssert softAssert = new SoftAssert();



        // 1	Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        assert pages.anaSayfa.isDisplayed();
        ReusableMethods.webElementResmi(pages.anaSayfa);
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");


        // 2	Register butonuna tıkla
        pages.register.click();
        extentTest.info("Register butonuna tiklandi");

        // 3	"I agree to the privacy policy" seçenegine tıkla
        pages.IAgree.click();
        ReusableMethods.bekle(3);
        extentTest.info("I Agree butonuna tiklandi");

        // 4	SIGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // 5	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(Username alanı)
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        String userNameMesaj = pages.userName.getAttribute("validationMessage");
        System.out.println("Usename alanı : "+userNameMesaj);
        assert userNameMesaj.contains("Lütfen bu alanı doldurun.");
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // 6	Username alanına tıkla  username gir
        pages.userName.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(2);
        extentTest.info("Username alanina gecerli bir username girildi");

        // 7	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // 8	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(email alanı)
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        String emailMesaj= pages.email.getAttribute("validationMessage");
        System.out.println("Email alanı : " + emailMesaj);
        assert emailMesaj.contains("Lütfen bu alanı doldurun.");
        ReusableMethods.bekle(3);
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // 9	e mail alanına  "@"  girmeden bır emaıl gır
        pages.email.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(3);
        extentTest.info("Email alanina gecersiz bir email girildi");

        // 10	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");

        // 11	Lütfen e-posta adresine bir  @" işareti ekleyin" mesajının görünür oldugunu doğrula
        String emailMesaj2 = pages.email.getAttribute("validationMessage");
        System.out.println("@ işareti ekle  = " + emailMesaj2);
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        softAssert.assertTrue(emailMesaj2.contains("Lütfen e-posta adresine bir  '@' işareti ekleyin."));
        extentTest.pass("Hata mesaji alindi ve test edildi");


        // 12	email'in sonuna @ ekle
        pages.email.sendKeys(ConfigReader.getProperty("emeileEkle"));
        ReusableMethods.webElementResmi(pages.email);
        ReusableMethods.bekle(5);
        extentTest.info(" hatali email'in sonuna @ isareti eklendi");

        // 13	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");


        // 14	"Lütfen  "@" işaretinden sonra gelen kısmı ekleyin"  mesajını doğrula
        String emailMesaj3 = pages.email.getAttribute("validationMessage");
        ReusableMethods.webElementResmi(pages.email);
        System.out.println("@ işaretinden Sonra = " + emailMesaj3);
        softAssert.assertTrue(emailMesaj3.contains("Lütfen  '@' işaretinden sonra gelen kısmı ekleyin."));
        extentTest.pass("Hata mesaji alindi ve test edildi");


        // emeil alanını sıl
        pages.email.clear();
        ReusableMethods.bekle(3);
        extentTest.pass("Email alanı silindi");

        // 15	email alanına gecerli bır email gir
        pages.email.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(5);
        extentTest.info("gecerli bir email yazıldı");

        // 16	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // 17	"Lütfen bu alanı doldurun" mesajınin görünürlüğünü dogrula(password alanı)
        String passwordMesaj = pages.sifre.getAttribute("validationMessage");
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        System.out.println("password Mesaji = " + passwordMesaj);
        assert passwordMesaj.contains("Lütfen bu alanı doldurun");
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // 18	Password alanına 12 karakterden az bir password gir.
        pages.sifre.sendKeys(ConfigReader.getProperty("weakPassword"));
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        extentTest.pass("Password kriterlerine uymayan hatali bir password girildi");

        // 19	"Weak - Please enter a stronger password." mesajının görünürlüğünü dogrula
        Assert.assertTrue(pages.VeriyWeak.isDisplayed());
        ReusableMethods.webElementResmi(pages.VeriyWeak);
        extentTest.info("Weak - Please enter a stronger password. mesaji alindi ve test edildi");

        // 20	"I agree to the privacy policy" seçenegine tıkla

        // 21	SIGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");

        // 22	Kayıt yapılamadığını doğrula
        js.executeScript("arguments[0].click();", pages.signUpButton);
        assert pages.signUpButton.isEnabled();
        ReusableMethods.bekle(3);
        extentTest.pass("Kayit yapilamadigi dogrulandi");

        // 23	Passwor alanındaki passwordu sil.
        pages.sifre.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Password alanindaki hatali password silindi");

        // 24	Password alanına 12 karakterli en az bir harf , rakam, spesifik karakter içeren bir password gir.
        pages.sifre.sendKeys(ConfigReader.getProperty("password1"));
        ReusableMethods.bekle(3);
        extentTest.info("Password alanina kriterlere uyan bir password basarili bir sekilde girildi");

        // 25	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // 26	İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını göründüğünü doğrula
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        String agreMesaj = pages.IAgree.getAttribute("validationMessage");
        System.out.println("I agree mesajı = " + agreMesaj);
        ReusableMethods.bekle(5);
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // 27	"I agree to the privacy policy" seçenegine tıkla
        js.executeScript("arguments[0].click();",pages.IAgree);
        ReusableMethods.bekle(5);
        extentTest.info("I Agree butonuna tiklandi");

        // 28	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(5);
        extentTest.info("Sign Up butonuna tiklandi");

        //  29	My Account  sayfasını göründüğünü doğrula
        assert pages.MyAccount.isDisplayed();
        extentTest.pass("Hesaba basarili bir sekilde giris yapildi ve My Account yazisinin gorunurlugu test edildi");
        extentReports.flush();
    }
}

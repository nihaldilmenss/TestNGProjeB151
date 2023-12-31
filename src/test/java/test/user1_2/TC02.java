package test.user1_2;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
        System.out.println("Username alanı : "+userNameMesaj);
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
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Email mesaj1");

        // 11	Lütfen e-posta adresine bir  @" işareti ekleyin" mesajının görünür oldugunu doğrula
        String emailMesaj2 = pages.email.getAttribute("validationMessage");
        System.out.println("@ işareti ekle  = " + emailMesaj2);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(emailMesaj2.contains("Lütfen e-posta adresine bir  '@' işareti ekleyin."));
        extentTest.pass("Hata mesaji alindi ve test edildi");


        // 12	email'in sonuna @ ekle
        pages.email.sendKeys(ConfigReader.getProperty("emeileEkle"));
        ReusableMethods.tumSayfaResmi("email mesajı2");
        ReusableMethods.bekle(3);
        extentTest.info(" hatali email'in sonuna @ isareti eklendi");

        // 13	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");

        // 14	"Lütfen  "@" işaretinden sonra gelen kısmı ekleyin"  mesajını doğrula
        ReusableMethods.tumSayfaResmi("Email mesajı3");
        String emailMesaj3 = pages.email.getAttribute("validationMessage");
        System.out.println("@ işaretinden Sonra = " + emailMesaj3);
        softAssert.assertTrue(emailMesaj3.contains("Lütfen  '@' işaretinden sonra gelen kısmı ekleyin."));
        extentTest.pass("Hata mesaji alindi ve test edildi");
        ReusableMethods.bekle(2);


        // 15 emeil alanını sıl
        pages.email.clear();
        ReusableMethods.bekle(3);
        extentTest.pass("Email alanı silindi");

        // 16	email alanına gecerli bır email gir
        pages.email.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(5);
        extentTest.info("gecerli bir email yazıldı");

        // 17	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // 18	"Lütfen bu alanı doldurun" mesajınin görünürlüğünü dogrula(password alanı)
        String passwordMesaj = pages.sifre.getAttribute("validationMessage");
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        System.out.println("password Mesaji = " + passwordMesaj);
        assert passwordMesaj.contains("Lütfen bu alanı doldurun");
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // 19	Password alanına 12 karakterden az bir password gir.
        pages.sifre.sendKeys(ConfigReader.getProperty("weakPassword"));
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        extentTest.pass("Password kriterlerine uymayan hatali bir password girildi");

        // 20	"Weak - Please enter a stronger password." mesajının görünürlüğünü dogrula
        Assert.assertEquals(pages.VeriyWeak.getText(),"Weak - Please enter a stronger password.");
        ReusableMethods.webElementResmi(pages.VeriyWeak);
        extentTest.fail("Weak - Please enter a stronger password. mesaji alindi ve test edildi");

        // 21	Passwor alanındaki passwordu sil.
        pages.sifre.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Password alanindaki hatali password silindi");

        //22 Password alanına 9 karakterli  harf , rakam, spesifik karakter içeren bir password gir.
        pages.sifre.sendKeys(ConfigReader.getProperty("password2"));
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        extentTest.info("kriterlere uygun password girildi");

        //23 "Hint: The password should be at least twelve characters long. To make it stronger, use upper and lower
        // case letters, numbers, and symbols like ! "" ? $ % ^ & ). Mesajın gorundugunu dogrula"
        Assert.assertEquals(pages.yanlisPasswordMesaji.getText(),"Hint: The password should be at least twelve characters long." +
                " To make it stronger, use upper and lower case letters, numbers, and symbols like ! \" ? $ % ^ & ).");
        ReusableMethods.webElementResmi(pages.yanlisPasswordMesaji);
        extentTest.pass("Mesajın gorunurlugu dogrulandı");


        //24 SIGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");


        //25	Kayıt yapılamadığını doğrula
        js.executeScript("arguments[0].click();", pages.signUpButton);
        assert pages.signUpButton.isEnabled();
        ReusableMethods.bekle(3);
        extentTest.pass("Kayit yapilamadigi dogrulandi");

        //26 Passwor alanındaki passwordu sil.
        pages.sifre.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Password alanindaki hatali password silindi");

        // 27	Password alanına 12 karakterli en az bir harf , rakam, spesifik karakter içeren bir password gir.
        pages.sifre.sendKeys(ConfigReader.getProperty("password1"));
        ReusableMethods.bekle(3);
        extentTest.info("Password alanina kriterlere uyan bir password basarili bir sekilde girildi");

        // 28	"I agree to the privacy policy" seçenegine tıkla
        js.executeScript("arguments[0].click();",pages.IAgree);
        ReusableMethods.bekle(5);
        extentTest.info("I Agree butonuna tiklandi");

        // 29	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // 30	İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını göründüğünü doğrula
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        String agreMesaj = pages.IAgree.getAttribute("validationMessage");
        System.out.println("I agree mesajı = " + agreMesaj);
        ReusableMethods.bekle(5);
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // 31	"I agree to the privacy policy" seçenegine tıkla
        js.executeScript("arguments[0].click();",pages.IAgree);
        ReusableMethods.bekle(5);
        extentTest.info("I Agree butonuna tiklandi");

        // 32	SİGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(5);
        extentTest.info("Sign Up butonuna tiklandi");

        //33 "Sign Out" yazısının görünürlüğünü dogrula
        Assert.assertEquals(pages.signOut.getText(),"Sign Out");
        ReusableMethods.webElementResmi(pages.signOut);
        extentTest.pass("Sayfaya giriş yapıldiği doğrulandı");
    }
}

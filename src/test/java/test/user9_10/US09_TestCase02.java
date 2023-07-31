package test.user9_10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.time.Duration;

public class US09_TestCase02 extends ExtentReport {
    @Test
    public void US09TestCase1() {
        extentTest = extentReports.createTest("Gülsün", "Satıcı Olarak Siteye Kayıt Yapabilmeli");
        Page alloverPage = new Page();

        //Anasayfaya git 	https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("VendorUrl"));
        extentTest.info("Anasayfaya gidildi");
        ReusableMethods.bekle(2);

        assert alloverPage.anaSayfa.isDisplayed();
        extentTest.pass("Anasayfaya giriş dogrulandı");
        ReusableMethods.bekle(2);

        //Sign In butonuna tıkla.
        alloverPage.signInButonu.click();
        extentTest.info("Sign In Butonuna Tıklandı");
        ReusableMethods.bekle(2);

        //SIGN UP butonuna tıkla.
        alloverPage.signUpButonu.click();
        extentTest.info("Sign Up Butonuna Tıklandı");
        ReusableMethods.bekle(2);

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        alloverPage.becomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");
        ReusableMethods.bekle(4);

        //Vendor Registration sayfasının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.vendorRegistirationBaslik.isDisplayed());
        extentTest.pass("Vendor Registration sayfası dogrulandı");
        ReusableMethods.bekle(2);

        ReusableMethods.tumSayfaResmi("Vendor Registration");//

        //Registration alanındaki REGISTER butonuna tikla
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.registrationRegister);
        ReusableMethods.bekle(3);

        alloverPage.registrationRegister.click();
        extentTest.info("REGİSTER Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        ReusableMethods.tumSayfaResmi("Hiçbir veri girmeden giris yapamazsın");

        //"Email: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(alloverPage.emailError.getText().contains("Email: This field is required."));
        extentTest.pass("Email: This field is required. mesajın göründü");
        ReusableMethods.bekle(2);

        //"Email Verification Code: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(alloverPage.emailError.getText().contains("Email Verification Code: This field is required."));
        extentTest.pass("Email Verification Code: This field is required.");
        ReusableMethods.bekle(2);

        //"Password: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(alloverPage.emailError.getText().contains("Password: This field is required."));
        extentTest.pass("Password: This field is required. mesajı göründü");
        ReusableMethods.bekle(2);

        //"Confirm Password: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(alloverPage.emailError.getText().contains("Confirm Password: This field is required."));
        extentTest.pass("Confirm Password: This field is required. mesajı göründü");
        ReusableMethods.bekle(2);

        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.vendorRegistirationBaslik);
        ReusableMethods.bekle(3);

        //Email alanina geçersiz email gir.	lemarcus.eliceofixedfor.com
        alloverPage.vendorEmailKutusu.sendKeys(ConfigReader.getProperty("gecersizzEmail"));
        extentTest.info("Email Alanına Geçersiz Email Girildi");
        ReusableMethods.bekle(3);

        //Email alanı dışında boşluğa tıkla. Password alanına tıkladım
        alloverPage.passwordKutusu.click();
        extentTest.info("Password Alanına Tıklandı");
        ReusableMethods.bekle(2);

        //"Please provide a valid email address." mesajın göründüğünü doğrula.
        Assert.assertEquals("Please provide a valid email address.", alloverPage.gecerliAdresGirKMesaji.getText());
        extentTest.pass("Please provide a valid email address. mesajın göründü");
        ReusableMethods.bekle(3);

        ReusableMethods.webElementResmi(alloverPage.gecerliAdresGirKMesaji);
        ReusableMethods.bekle(2);

        //Email alanindaki emaili sil.
        alloverPage.vendorEmailKutusu.clear();
        extentTest.info("Email Alanındaki Email Silindi");
        ReusableMethods.bekle(3);

        //Email alanina kayıtlı bir e-mail adresi gir. 	tyrik.venicio@fixedfor.com
        alloverPage.vendorEmailKutusu.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        extentTest.info("Email Alanına Kayıtlı Bir Email Girildi");
        ReusableMethods.bekle(3);

        //Email alanı dışında boşluğa tıkla. Password alanına tıkladım
        alloverPage.passwordKutusu.click();
        extentTest.info("Password Alanına Tıklandı");
        ReusableMethods.bekle(2);

        //Mesajın "Verification code sent to your email: " içerdiğini doğrula.
        Assert.assertTrue(alloverPage.emailDogrulamaKoduKMesaji.getText().contains("Verification code sent to your email:"));
        extentTest.pass("Mesajın Verification code sent to your email:  içerdiği doğrulandı");
        ReusableMethods.bekle(3);

        ReusableMethods.webElementResmi(alloverPage.emailDogrulamaKoduKMesaji);
        ReusableMethods.bekle(2);

        // Verification Code text kutusuna 58235 sayısını gir.
        alloverPage.verificationKodKutusu.sendKeys(ConfigReader.getProperty("dogrulamaKodu"));
        extentTest.info("Verification Code Text Kutusuna İstenile Sayı Girildi");
        ReusableMethods.bekle(2);

        //Password  alanina geçerli password  gir.
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("gecerliPasword"));
        extentTest.info("Password Alanına Geçerli Bir Password Girildi");
        ReusableMethods.bekle(3);

        //Confirm Password alanina aynı password  gir.
        alloverPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPasword"));
        extentTest.info("Confirm Password Alanına Password Alanına Girilen Sifre Girildi");

        //Register butonuna tikla
        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.registrationRegister);
        ReusableMethods.bekle(3);

        alloverPage.registrationRegister.click();
        extentTest.info("Register Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.vendorRegistirationBaslik);//asaidsn gert
        ReusableMethods.bekle(3);

        //"This Email already exists. Please login to the site and apply as vendor." mesajını aldığını doğrula.
        Assert.assertEquals("This Email already exists. Please login to the site and apply as vendor.", alloverPage.ePostaZatenVarMesaji.getText());
        extentTest.pass("This Email already exists. Please login to the site and apply as vendor. mesajı dogrulandı");
        ReusableMethods.bekle(1);

        ReusableMethods.webElementResmi(alloverPage.ePostaZatenVarMesaji);//
        ReusableMethods.bekle(2);

        //Email alanindaki emaili sil.
        alloverPage.vendorEmailKutusu.clear();
        extentTest.info("Email Alanındaki Email Silindi");
        ReusableMethods.bekle(2);

        //Email alanina geçerli email gir.
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        ReusableMethods.bekle(4);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());

        Driver.getDriver().get(ConfigReader.getProperty("fakerUrl"));
        ReusableMethods.bekle(5);

        WebElement fakeEMaillll = alloverPage.fakeMailKutusu;
        String fakeEPosta = fakeEMaillll.getText();

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());

        alloverPage.vendorEmailKutusu.sendKeys(fakeEPosta);
        extentTest.info("Email Alanına Geçerli Email Girildi");
        ReusableMethods.bekle(2);

        //Register butonuna tikla
        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.registrationRegister);
        ReusableMethods.bekle(3);

        alloverPage.registrationRegister.click();
        extentTest.info("Register Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        //"Email verification code invalid." yazının göründüğünü doğrula.
        Assert.assertEquals("Email verification code invalid.",alloverPage.ePostaGecersizKod.getText());
        extentTest.pass("Email Verification Code İnvalid. Yazısı Göründü");
        ReusableMethods.bekle(2);

        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.vendorRegistirationBaslik);
        ReusableMethods.bekle(3);

        //Verification Code text kutusundaki verileri sil
        alloverPage.verificationKodKutusu.clear();
        extentTest.info("Verification Code Text Kutusundaki Veri Silindi");
        ReusableMethods.bekle(3);

        //Emaile gelen doğrulama kodunu Verification Code text kutusuna  gir.(doğru giriş)
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        ReusableMethods.bekle(3);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(alloverPage.fakeMektup));

        alloverPage.fakeMektup.click();
        ReusableMethods.bekle(4);

        Driver.getDriver().switchTo().frame(alloverPage.iframeDogrulamaKodu);
        ReusableMethods.bekle(3);

        WebElement dogruKod = alloverPage.dogrulamaKodu;
        String fakeMektupDogruKod = dogruKod.getText();

        ReusableMethods.bekle(5);

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(5);

        alloverPage.verificationKodKutusu.sendKeys(fakeMektupDogruKod);
        extentTest.info("Emaile Gelen Doğrulama Kodu Verification Code Text Kutusuna Girildi");
        ReusableMethods.bekle(5);

        //Password alanındaki verileri sil
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Password  alanina 6 karakterden az password  gir.
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("altiKarakAzKod"));  //Sa12.
        extentTest.info("Password Alanına 6 Karakterden Az Password Girildi");
        ReusableMethods.bekle(3);

        //Confirm alanındaki verileri sil
        alloverPage.confirmPasswordKutusu.clear();
        extentTest.info("Confirm Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Confirm Password alanina aynı password  gir.
        alloverPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("altiKarakAzKod"));
        extentTest.info("Confirm Password Alanına Password Alanı ile Aynı Password Girildi");
        ReusableMethods.bekle(3);

        //Register butonuna tikla
        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.registrationRegister);
        ReusableMethods.bekle(3);

        alloverPage.registrationRegister.click();
        extentTest.info("Register Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.vendorRegistirationBaslik);
        ReusableMethods.bekle(3);

        //"Password strength should be atleast "Good". "Yazısın çıktığını doğrula
        Assert.assertEquals("Password strength should be atleast \"Good\".", alloverPage.sifreGucuIyiOlmaliMesaji.getText());
        extentTest.pass("Password strength should be atleast Good. Yazısı Dogrulandı");

        ReusableMethods.webElementResmi(alloverPage.sifreGucuIyiOlmaliMesaji);
        ReusableMethods.bekle(2);

        //Passwordu alanındaki passwordu sil.
        alloverPage.passwordKutusu.clear();
        extentTest.info("Password Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Password  alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password  gir.
        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("gecerliPasword"));
        extentTest.info("Password Alanına Geçerli Bir Password Girildi");
        ReusableMethods.bekle(3);

        //Register butonuna tikla
        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.registrationRegister);
        extentTest.info("Register Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        alloverPage.registrationRegister.click();
        ReusableMethods.bekle(3);

        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.vendorRegistirationBaslik);
        ReusableMethods.bekle(3);

        //Password and Confirm-password are not same."Yazısının çıktığını doğrula
        Assert.assertEquals("Password and Confirm-password are not same.", alloverPage.sifreVeOnaySifreAyniOlmaliMesaji.getText());
        extentTest.pass("Password and Confirm-password are not same.Yazısı Dogrulandı");
        ReusableMethods.bekle(3);

        ReusableMethods.webElementResmi(alloverPage.sifreVeOnaySifreAyniOlmaliMesaji);
        ReusableMethods.bekle(2);

        //Confirm alanındaki verileri sil
        alloverPage.confirmPasswordKutusu.clear();
        extentTest.info("Confirm Alanındaki Veriler Silindi");
        ReusableMethods.bekle(3);

        //Password  alanina girilen passwordu Confirm Password alanina  gir.
        alloverPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPasword"));
        extentTest.info("Password Alanına Girilen Sifre Confirm Password Alanına Girildi");
        ReusableMethods.bekle(3);

        //Register butonuna tikla.
        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.registrationRegister);
        extentTest.info("Register Butonuna Tıklandı");
        ReusableMethods.bekle(3);

        alloverPage.registrationRegister.click();
        ReusableMethods.bekle(3);

        js.executeScript("arguments[0].scrollIntoView(true);", alloverPage.vendorRegistirationBaslik);
        ReusableMethods.bekle(3);

        //"Registration Successfully Completed. "Yazısın çıktığını doğrula.
        Assert.assertEquals("Registration Successfully Completed.", alloverPage.registerSuccessfullyCompleted.getText());
        extentTest.pass("Registration Successfully Completed. Yazısı Dogrulandı");
        ReusableMethods.bekle(3);

        //Yeni açılan sayfada "Welcome to Allover Commerce!" yazısını görüdüğünü doğrula.
        Assert.assertEquals("Welcome to Allover Commerce!",alloverPage.welcomeToAlloverCommerce.getText());
        extentTest.pass("Welcome to Allover Commerce! yazısı Dogrulandı");
        ReusableMethods.bekle(2);

        Driver.closeDriver();
    }
}

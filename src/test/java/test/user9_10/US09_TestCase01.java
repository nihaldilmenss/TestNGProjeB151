package test.user9_10;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
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

public class US09_TestCase01 extends ExtentReport {
    @Test
    public void US09TestCase01() {
        extentTest = extentReports.createTest("Gülsün", "Satıcı Olarak Siteye Kayıt Yapabilmeli");
        Page alloverPage = new Page();

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("VendorUrl"));
        extentTest.info("Anasayfaya gidildi");
        ReusableMethods.bekle(2);

        assert alloverPage.anaSayfa.isDisplayed();
        ReusableMethods.tumSayfaResmi("Anasayfa");
        extentTest.pass("Anasayfaya giriş dogrulandı");
        ReusableMethods.bekle(2);

        //Register butonuna tikla
        alloverPage.register.click();
        extentTest.info("Register Butonuna Klik Yapıldı.");
        ReusableMethods.bekle(3);

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        Assert.assertTrue(alloverPage.becomeVendor.isDisplayed());
        extentTest.pass("Become a Vendor yazısının göründüğü dogrulandı");

        ReusableMethods.bekle(4);
        ReusableMethods.tumSayfaResmi("Become a Vendor");
        ReusableMethods.bekle(2);

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        alloverPage.becomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");
        ReusableMethods.bekle(4);

        //Vendor Registration sayfasını doğrula.
        Assert.assertTrue(alloverPage.vendorRegistirationBaslik.isDisplayed());
        extentTest.pass("Vendor Registration sayfası dogrulandı");
        ReusableMethods.bekle(2);

        ReusableMethods.tumSayfaResmi("Vendor Registration");
        ReusableMethods.bekle(2);

        //Email alanina email gir.
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        ReusableMethods.bekle(4);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());

        Driver.getDriver().get(ConfigReader.getProperty("fakerUrl"));
        ReusableMethods.bekle(5);

        alloverPage.fakeMailCopy.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());

        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(alloverPage.vendorEmailKutusu, Keys.CONTROL).sendKeys("v").release().perform();

        extentTest.info("Email Alanına Email Girildi");
        ReusableMethods.bekle(4);

        //Email alanı dışında boşluğa tıkla.
        alloverPage.bosluk.click();

        extentTest.info("Boşlua Tıklandı");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(alloverPage.verificationCodeMesaji));

        //mesajın "Verification code sent to your email: " içerdiğini doğrula.
        Assert.assertTrue(alloverPage.verificationCodeMesaji.getText().contains("Verification code sent to your email"));
        ReusableMethods.bekle(5);

        extentTest.pass("Mesajın Verification code sent to your email: İçerdigi Dogrulandı");

        ReusableMethods.webElementResmi(alloverPage.verificationCodeMesaji);
        ReusableMethods.bekle(2);

        //Emaile gelen doğrulma kodunu Verification Code text kutusuna gir.
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());

        wait.until(ExpectedConditions.visibilityOf(alloverPage.fakeMektup));

        alloverPage.fakeMektup.click();
        ReusableMethods.bekle(5);

        Driver.getDriver().switchTo().frame(alloverPage.iframeDogrulamaKodu);
        actions.doubleClick(alloverPage.dogrulamaKodu).perform();
        ReusableMethods.bekle(7);

        actions.keyDown(Keys.CONTROL).sendKeys("C").release().perform();
        ReusableMethods.bekle(5);

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(5);

        alloverPage.verificationKodKutusu.click();


        actions.keyDown(Keys.CONTROL).sendKeys("v").release().perform();
        extentTest.info("Dogrulama Kodu Verification Code Text Kutusuna Girildi");
        ReusableMethods.bekle(5);

        //Password  alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password  gir.

        alloverPage.verificationKodKutusu.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN);

        alloverPage.passwordKutusu.sendKeys(ConfigReader.getProperty("gecerliPasword"));
        extentTest.info("Password Alanına Geçerli Bir Password Girildi");
        ReusableMethods.bekle(3);

        //Confirm Password alanina aynı password  gir.
        alloverPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("gecerliPasword"));
        extentTest.info("Confirm Password Alanına Password Alanı ile Aynı Password Girildi");
        ReusableMethods.bekle(1);

        ReusableMethods.tumSayfaResmi("Tüm İşlemler");
        ReusableMethods.bekle(3);

        //Register butonuna tikla
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",alloverPage.registrationRegister);
        ReusableMethods.bekle(3);
        alloverPage.registrationRegister.click();

        extentTest.info("Register Butonuna Tıklandı");


        js.executeScript("arguments[0].scrollIntoView(true);",alloverPage.vendorRegistirationBaslik);

        wait.until(ExpectedConditions.visibilityOf(alloverPage.registerSuccessfullyCompleted));

        //"Registration Successfully Completed. "Yazısının çıktığını doğrula
        Assert.assertEquals("Registration Successfully Completed.", alloverPage.registerSuccessfullyCompleted.getText());
        extentTest.pass("Registration Successfully Completed Yazısı Dogrulandı");

        ReusableMethods.tumSayfaResmi("Registration Successfully Completed ");
        ReusableMethods.bekle(5);

        //Yeni açılan sayfada "Welcome to Allover Commerce!" yazısını görüdüğünü doğrula
        Assert.assertTrue(alloverPage.welcomeToAlloverCommerce.isDisplayed());
        extentTest.pass("Welcome to Allover Commerce! Yazısı Dogrulandı");

        ReusableMethods.tumSayfaResmi("Açılan Yeni Pencere");
    }
}

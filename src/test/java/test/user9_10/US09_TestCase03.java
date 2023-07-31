package test.user9_10;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US09_TestCase03 extends ExtentReport {
    @Test
    public void US09TestCase01() {
        extentTest = extentReports.createTest("Gülsün", "Allover test raporu");
        Page page = new Page();

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Anasayfaya gidildi.");
        ReusableMethods.tumSayfaResmi("AnaSayfa");
        extentTest.info("Tum sayfa resmi alındı");

        //Register butonuna tikla
        page.register.click();
        ReusableMethods.bekle(2);
        extentTest.info("Register butonuna tiklandı");

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.becomeVendor.isDisplayed());

        extentTest.pass("Çıkan ekranda 'Become a Vendor' yazısının göründüğü doğrulandı.");

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.becomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");

        //Vendor Registration sayfasını doğrula.
        softAssert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.vendorRegistirationBaslik.getText());
        extentTest.pass("Vendor Registration Sayfasının Göründüğü Doğrulandı");

        //Email alanina email gir.
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        ReusableMethods.window(1);
        Driver.getDriver().get(ConfigReader.getProperty("fakerUrl"));
        ReusableMethods.bekle(2);
        page.fakeMailCopy.click();
        ReusableMethods.window(0);
        ReusableMethods.bekle(2);
        page.vendorEmailKutusu.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("v").release().perform();
        ReusableMethods.bekle(2);
        extentTest.info("Email Alanina Email Girildi.");

        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();
        extentTest.info("Email Alanı Dışında Boşluğa Tıklandı.");


        //mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.visibleWait(page.verificationCodeMesaji, 10);
        System.out.println(page.verificationCodeMesaji.getText());
        softAssert.assertTrue(page.verificationCodeMesaji.getText().contains(ConfigReader.getProperty("sentToYourEmail")));
        extentTest.pass("Mesajın Verification code sent to your email: İçerdiği Doğrulandı.");

        //Emaile gelen doğrulma kodunu Verification Code text kutusuna gir.
        ReusableMethods.bekle(10);
        ReusableMethods.window(1);
        ReusableMethods.bekle(5);
        page.fakeMektup.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().frame("iframeMail");
        actions.doubleClick().doubleClick(page.dogrulamaKodu).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").release().perform();
        ReusableMethods.bekle(5);
        ReusableMethods.window(0);

        page.verificationKodKutusu.click();
        actions.keyDown(Keys.CONTROL).sendKeys("v").perform();
        extentTest.info("Emaile gelen doğrulma kodunu Verification Code text kutusuna girildi.");

        //Gecersiz sifre ile "Password strength should be atleast "Good"" message'ını doğrula
        page.verificationKodKutusu.sendKeys(Keys.PAGE_DOWN);
        page.verificationKodKutusu.sendKeys(Keys.TAB, Keys.TAB,
                ConfigReader.getProperty("gecersizPassword"),
                Keys.TAB,
                ConfigReader.getProperty("gecersizPassword"), Keys.ENTER);

        ReusableMethods.bekle(2);
        softAssert.assertEquals(ConfigReader.getProperty("goodMessage"), page.sifreGucuIyiOlmaliMesaji.getText(), "Password strength should be atleast Good message'ı görülmedi");
        extentTest.fail("Gecersiz password ile giriş yapılamamalı");
        extentTest.info("Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içermeyen password girildi.");
        extentTest.info("Confirm Password alanina aynı password girildi.");
        extentTest.info("Password strength should be atleast Good message'ı doğrulandı");
        ReusableMethods.webElementResmi(page.sifreGucuIyiOlmaliMesaji);
        extentTest.info("Webelement resmi alındı.");
        softAssert.assertAll();

    }
}

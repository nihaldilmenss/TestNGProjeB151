package test.user1_2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US02TC01 extends ExtentReport {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));

        extentTest = extentReports.createTest("Ceylan" , "Allovercommerce Test Edebilmeli");
        Page pages=new Page();
        Actions actions=new Actions(Driver.getDriver());


        // Anasayfaya git
        ReusableMethods.bekle(3);
        assert pages.anaSayfa.isDisplayed();
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");

        // Register butonuna tıkla
        pages.register.click();
        extentTest.info("Register butonuna tiklandi");
        ReusableMethods.bekle(3);

        //SİGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");
        ReusableMethods.bekle(3);

        //"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(username)
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        String userNameMesaj = pages.userName.getAttribute("validationMessage");
        System.out.println("Username alanı : "+userNameMesaj);
        assert userNameMesaj.contains("Lütfen bu alanı doldurun.");
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // Username alanına tıkla ve kayıtlı username gir
        pages.userName.sendKeys(ConfigReader.getProperty("username"));
        ReusableMethods.bekle(2);
        extentTest.info("Username alanina gecerli bir username girildi");

        //SİGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");
        ReusableMethods.bekle(3);

        //"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(email alanı)
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        String emailMesaj= pages.email.getAttribute("validationMessage");
        System.out.println("Email alanı : " + emailMesaj);
        assert emailMesaj.contains("Lütfen bu alanı doldurun.");
        ReusableMethods.bekle(3);
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // Email alanına tıkla  ve kayıtlı email gir
        pages.email.sendKeys(ConfigReader.getProperty("email"));
        extentTest.info("gecerli bir email yazıldı");

        //SİGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");
        ReusableMethods.bekle(3);

        //"Lütfen bu alanı doldurun" mesajınin görünürlüğünü dogrula(password alanı)
        String passwordMesaj = pages.sifre.getAttribute("validationMessage");
        ReusableMethods.webElementResmi(pages.RegisterEkrani);
        System.out.println("password Mesaji = " + passwordMesaj);
        assert passwordMesaj.contains("Lütfen bu alanı doldurun");
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // Password alanına tıkla geçerli password gir
        pages.sifre.sendKeys(ConfigReader.getProperty("password1"));
        extentTest.info("Password alanına gecerlı bır password girildi");

        // "I agree to the privacy policy" seçenegine tıkla
        pages.IAgree.click();
        extentTest.info("I Agree butonuna tiklandi");
        ReusableMethods.bekle(3);

        // SIGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");
        ReusableMethods.bekle(3);

        // An account is already registered with your email address mesajının göründüğünü doğrula.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertEquals("An account is already registered with your email address. Please log in.",pages.kayitliMesaj.getText());
        ReusableMethods.bekle(3);
        ReusableMethods.webElementResmi(pages.kayitliMesaj);
        extentTest.pass("An account is already registered with your email address mesajının göründüğü doğrulandı");

        // Email alanına tıkla  ve kayıtlı olmayan email gir
        pages.email.clear();
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        pages.fakeMailCopy.click();
        ReusableMethods.bekle(3);
        extentTest.info("Fake mail adresine gidildi ve gecerli bir mail kopyalandı");

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        pages.email.sendKeys(Keys.CONTROL,"v");
        extentTest.info("Email alanina tiklandi ve kopyalanan  email girildi");

        // SIGN UP butonuna tıkla
        pages.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");
        ReusableMethods.bekle(3);

        // "An account is already registered with that username. Please choose another." mesajının göründüğünü doğrula.
        Assert.assertEquals("An account is already registered with that username. Please choose another.",pages.kayitliMesaj.getText());
        Assert.assertTrue(pages.kayitliMesaj.isDisplayed());
        ReusableMethods.webElementResmi(pages.kayitliMesaj);
        extentTest.pass("An account is already registered with that username. Please choose another. mesjının göründğü doğrulandı");

    }


}

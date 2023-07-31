package test.user1_2;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01 extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Ceylan", "Allovercommerce Test Edebilmeli");
        Faker faker = new Faker();
        Page pages = new Page();

        // Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        ReusableMethods.bekle(3);
        assert pages.anaSayfa.isDisplayed();
        ReusableMethods.webElementResmi(pages.anaSayfa);
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");

        // Register butonuna tıkla
        pages.register.click();
        extentTest.info("Register butonuna tiklandi");
        ReusableMethods.bekle(3);

        // Username alanına tıkla  username gir

        pages.userName.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(3);
        extentTest.info("Usename alanına username girildi");

        // Email alanına tıkla  email gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        pages.fakeMailCopy.click();
        extentTest.info("Fake mail adresine gidildi ve gecerli bir mail kopyalandı");

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(3);
        pages.email.sendKeys(Keys.CONTROL, "v");
        extentTest.info("Email alanina tiklandi ve kopyalanan  email girildi");
        ReusableMethods.bekle(3);


        // Password en az 12 karakterli harf ve rakam içeren bir password gir
        pages.sifre.sendKeys(ConfigReader.getProperty("password1"));
        extentTest.info("Password alanina kriterlere uyan bir password basarili bir sekilde girildi");

        ReusableMethods.bekle(3);
        // "I agree to the privacy policy" seçenegine tıkla
        pages.IAgree.click();
        ReusableMethods.bekle(3);
        extentTest.info("I Agree butonuna tiklandi");

        // SIGN UP butonuna tıkla
        pages.signUpButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        // "Sign Out" yazısının görünürlüğünü dogrula
        Assert.assertEquals("Sign Out",pages.signOut.getText());
        ReusableMethods.webElementResmi(pages.signOut);
        extentTest.pass("Sayfaya giriş yapıldiği doğrulandı");

    }
}



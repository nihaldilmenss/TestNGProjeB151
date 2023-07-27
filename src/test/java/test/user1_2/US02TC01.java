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
        extentTest = extentReports.createTest("Ceylan" , "Allovercommerce Test Edebilmeli");
        Page pages=new Page();
        Actions actions=new Actions(Driver.getDriver());

        // Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        ReusableMethods.bekle(3);
        assert pages.anaSayfa.isDisplayed();
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");

        // Register butonuna tıkla
        pages.register.click();
        extentTest.info("Register butonuna tiklandi");
        ReusableMethods.bekle(3);

        // Username alanına tıkla ve kayıtlı username gir
        // Email alanına tıkla  ve kayıtlı email gir
        // Password alanına tıkla geçerli password gir
        pages.userName.sendKeys(ConfigReader.getProperty("username"), Keys.TAB,
                ConfigReader.getProperty("email"),Keys.TAB,ConfigReader.getProperty("password1"));
        extentTest.info("Username,Email alanı ve password alanına gecerli bilgiler girildi ");
        ReusableMethods.bekle(3);


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
        Assert.assertTrue(pages.kayitliMesaj.isDisplayed());
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
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(pages.kayitliMesaj.isDisplayed());
        ReusableMethods.webElementResmi(pages.kayitliMesaj);
        extentTest.pass("An account is already registered with that username. Please choose another. mesjının göründğü doğrulandı");
        extentReports.flush();
    }

}

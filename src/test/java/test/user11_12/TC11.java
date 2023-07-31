package test.user11_12;

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

public class TC11 extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Saadet", "Allovercommerce Test Edebilmeli");
        Faker faker = new Faker();
        Page pages = new Page();


        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("allovercommerceUrl"));
        ReusableMethods.bekle(3);
        assert pages.anasayfas.isDisplayed();
        ReusableMethods.webElementResmi(pages.anasayfas);
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");

       /* //Sign in butonuna tıkla
        pages.signInButton.click();
        extentTest.info("Sıgn In butonuna tiklandi");
        ReusableMethods.bekle(3);




        //username ya da email adresi alanına username gir
        pages.userNames.sendKeys("saadetceee");
        ReusableMethods.bekle(3);
        Assert.assertTrue(pages.userNames.getText().contains("saadetceee"));
        extentTest.info("Usename alanına username girildi");

        //şifre gir
        pages.passwords.sendKeys("admins.");
        ReusableMethods.bekle(3);
        Assert.assertTrue(pages.passwords.getText().contains("admins12."));
        extentTest.info("password alanına username girildi");


        //Sign in butonuna tıkla
        //My account yazısının görünürlüğünü doğrula
        //Dashboard'un altında Orders'ın görünürlüğünü doğrula
        //Downloads'ın görünürlüğünü doğrula
        //Addresses'in görünürlüğünü doğrula
        //Account details'in görünürlüğünü doğrula
        //Wishlist'in görünürlüğünü doğrula
        //Chat box'ın görünürlüğünü doğrula
        //Support Tickets'in görünürlüğünü doğrula
        //Sayfayı aşağı doğru kaydır
        //Followings'in görünürlüğünü doğrula
        //Logout'un görünürlüğünü doğrula

        */




    }
}

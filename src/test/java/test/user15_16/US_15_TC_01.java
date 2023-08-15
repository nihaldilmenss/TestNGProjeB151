package test.user15_16;

import utilities.ConfigReader;
import utilities.ExtentReport;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import pages.Page;
import utilities.ReusableMethods;

public class US_15_TC_01 extends ExtentReport {

    @Test
    public void test01() {

        //https://allovercommerce.com/ 'e gidin.
        //Kayıtlı satıcı e-postası ve şifresi ile giriş yapın.
        //username = nihalicin20@gmail.com, eposta şifresi = nihalsanlidilmen, vendor sifresi = nihalicin20@gmail.com.
        //Sayfanın altındaki Hesabım bölümünün görünür olduğunu doğrulayın.
        //Hesabım sekmesi altındaki Hesabım'ı tıklayın.
        //Mağaza Yöneticisi Bölümünün açılan Hesabım sayfasında görünür olduğunu doğrulayın.
        //Mağaza Yöneticisine tıklayın.
        //Ürünler bölümünün açılan Mağaza Yöneticisi sayfasında görünür olduğunu doğrulayın.
        //Ürünler üzerine geldiğinizde görünen Yeni Ekle'yi tıklayın.
        //Sayfanın altındaki Envanter menüsünün görünürlüğünü doğrulayın
        //Sayfanın altındaki Gönderim menüsünün görünürlüğünü doğrulayın
        //Sayfanın altındaki Bağlantılı menünün görünürlüğünü doğrulayın
        //Sayfanın altındaki Seo menüsünün görünürlüğünü doğrulayın
        //Sayfanın altındaki Gelişmiş menünün görünürlüğünü doğrulayın

        extentTest = extentReports.createTest("Nihal" , "Allovercommerce Test Edebilmeli");


        //Go to https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //Login with registered vendor email and password
        Page alloverCommercePage = new Page();


        alloverCommercePage.signIn.click();

        ReusableMethods.bekle(2);

        alloverCommercePage.username.sendKeys(ConfigReader.getProperty("email"), Keys.TAB, ConfigReader.getProperty("password"));

        ReusableMethods.bekle(2);


        alloverCommercePage.logInButton.submit();

        ReusableMethods.bekle(2);

        extentTest.info("Giriş yapıldı");



        //Verify that the My Account section at the bottom of the page is visible
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE).perform();//page up down //js.r
        Assert.assertTrue(alloverCommercePage.hesabimYazisi.isDisplayed());

        ReusableMethods.bekle(2);
        extentTest.info("Hesabim Yazisi Görüldü");


        //Click My Account under the My Account tab
        ReusableMethods.click(alloverCommercePage.hesabimButton);
        extentTest.info("Hesabim Butonuna Tiklandi");

        //Verify that the Store Manager Section is visible on the My account page that opens
        ReusableMethods.bekle(2);
        Assert.assertTrue(alloverCommercePage.storeManagerText.isDisplayed());
        extentTest.info(" Store Manager Yazisi Görüldü");

        //Click to Store Manager
        ReusableMethods.click(alloverCommercePage.storeManagerButton);
        extentTest.info(" Store Managera Tiklandi");


        actions.sendKeys(Keys.SPACE);

        //Verify that the Products section is visible on the Store Manager page that opens
        Assert.assertTrue(alloverCommercePage.productYazisi.isDisplayed());
        extentTest.info(" Product Yazisi Görüldü");

        //Click Add New that appears when you hover over Products.
        ReusableMethods.click(alloverCommercePage.productButton);
        ReusableMethods.bekle(2);

        extentTest.info(" Product Yazisina Tiklandi");

        //Add New click
        ReusableMethods.click(alloverCommercePage.addnewButton);

        ReusableMethods.bekle(2);
        extentTest.info(" Yeni tıklama eklendi");





        actions.sendKeys(Keys.SPACE, Keys.SPACE);


        //Verify visibility of Inventory menu at the bottom of the page
        Assert.assertTrue(alloverCommercePage.inventoryYazisi.isDisplayed());

        extentTest.info("Sayfanın altındaki Envanter menüsünün görünürlüğünü doğrulandi");


        ReusableMethods.bekle(2);

        actions.sendKeys(Keys.SPACE);

        //Verify visibility of Shipping menu at the bottom of the page
        Assert.assertTrue(alloverCommercePage.shippingYazisi.isDisplayed());
        extentTest.info("Sayfanın altındaki Gönderi menüsünün görünürlüğünü doğrulandi");


        //Verify visibility of Linked menu at the bottom of the page
        Assert.assertTrue(alloverCommercePage.linkedYazisi.isDisplayed());
        extentTest.info("Sayfanın altındaki Bağlantılı menünün görünürlüğünü doğrulandi");



        //Verify visibility of Seo menu at the bottom of the page
        Assert.assertTrue(alloverCommercePage.seoYazisi.isDisplayed());
        extentTest.info("Sayfanın altındaki Seo menüsünün görünürlüğünü doğrulandi");


        //Verify visibility of Advanced menu at the bottom of the page
        Assert.assertTrue(alloverCommercePage.advancedYazisi.isDisplayed());
        extentTest.info("Sayfanın altındaki Gelişmiş menünün görünürlüğünü doğrulandi");

        extentTest.pass("Checked");
        extentReports.flush();

        Driver.getDriver().quit();




    }




}

package test.user5_14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC extends ExtentReports {


    @Test
    public void test01() {


        /*
        1   Web Sitesine git
        2   Sign in butonuna tıkla
        3   Username or email addresskısmını doldur
        4   Password kısmını doldur
        5   Sign in butonuna tıkla
        6   My Account'a tıkla
        7   Account Details' tıkla
        */
        // 1-Web Sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("homePage"));


        // 2-Sign in butonuna tıkla
        Page page = new Page();
        page.signInButton.click();
        ReusableMethods.bekle(2);

        // 3-Username or email addresskısmını doldur
        page.usernameOrEmailAdress.sendKeys(ConfigReader.getProperty("userName1"));

        // 4-Password kısmını doldur
        page.password.sendKeys(ConfigReader.getProperty("password1"));

        // 5-Sign in butonuna tıkla
        page.signInButton2.click();
        ReusableMethods.bekle(4);

        // 6-My Account'a tıkla
        page.myAccountButton.click();

        // 7-Account Details' tıkla
        page.accountDetailsButton.click();
        Assert.assertTrue(page.accountDetailText.isDisplayed());


    }

    @Test
    public void test02() {
           /*
        1   Web Sitesine git
        2   Sign in butonuna tıkla
        3   Username or email addresskısmını doldur
        4   Password kısmını doldur
        5   Sign in butonuna tıkla
        6   My Account'a tıkla
        7   Account Details' tıkla
     -- 8	First name'i doldur
        9	Last name'i doldur.
        10	Display name'i doldur.
        11	E-mail'i doldur.
        12	save changes'e bas
        */

        // 1-Web Sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("homePage"));

        // 2-Sign in butonuna tıkla
        Page page = new Page();
        page.signInButton.click();
        ReusableMethods.bekle(2);

        // 3-Username or email addresskısmını doldur
        page.usernameOrEmailAdress.sendKeys(ConfigReader.getProperty("userName1"));

        // 4-Password kısmını doldur
        page.password.sendKeys(ConfigReader.getProperty("password1"));

        // 5-Sign in butonuna tıkla
        page.signInButton2.click();
        ReusableMethods.bekle(4);

        // 6-My Account'a tıkla
        page.myAccountButton.click();

        // 7-Account Details' tıkla
        page.accountDetailsButton.click();
        Assert.assertTrue(page.accountDetailText.isDisplayed());

        // 8 First name'i doldur
        page.firstName.clear();
        ReusableMethods.bekle(2);
        page.firstName.sendKeys(ConfigReader.getProperty("firstName"));
        // 9 Last name'i doldur.
        page.lastName.clear();
        ReusableMethods.bekle(2);
        page.lastName.sendKeys(ConfigReader.getProperty("lastName"));

        // 10 Display name'i doldur.
        page.displayName.clear();
        page.displayName.sendKeys(ConfigReader.getProperty("displayName"));
        // 11 E-mail'i doldur.
        page.emailAddress.clear();
        ReusableMethods.bekle(2);
        page.emailAddress.sendKeys(ConfigReader.getProperty("newEmail"));
        // 12 save changes'e bas
        page.saveChanges.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(page.accountDetailsChanged.isDisplayed());

    }

    @Test
    public void test03() {
       /*
        1	Web Sitesine git
        2	Sign in butonuna tıkla
        3	Username or email address kısmını doldur
        4	Password kısmını doldur
        5	Sign in butonuna tıkla
        6	My Account'a tıkla
        7	Account Details' tıkla
        8	Biography kısmını doldur
        9	save changes'e bas


        */

        // 1-Web Sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("homePage"));

        // 2-Sign in butonuna tıkla
        Page page = new Page();
        page.signInButton.click();
        ReusableMethods.bekle(2);

        // 3-Username or email addresskısmını doldur
        page.usernameOrEmailAdress.sendKeys(ConfigReader.getProperty("userName3"));

        // 4-Password kısmını doldur
        page.password.sendKeys(ConfigReader.getProperty("password3"));

        // 5-Sign in butonuna tıkla
        page.signInButton2.click();
        ReusableMethods.bekle(4);

        // 6-My Account'a tıkla
        page.myAccountButton.click();

        // 7-Account Details' tıkla
        page.accountDetailsButton.click();
        Assert.assertTrue(page.accountDetailText.isDisplayed());

        // 8-Biography kısmını doldur
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Driver.getDriver().switchTo().frame(0);

        page.biography.click();
        page.biography.sendKeys(ConfigReader.getProperty("bio"));
        Driver.getDriver().switchTo().defaultContent();

        // 9-save changes'e bas
        page.saveChanges.click();


    }

    @Test
    public void test04() {

    }

    @Test
    public void test05() {

        //Web Sitesine git
        Driver.getDriver().get(ConfigReader.getProperty("homePage"));

        //   2	Sign in butonuna tıkla
        Page page = new Page();
        page.signInButton.click();

        //   3	Username or email address kısmını doldur
        page.usernameOrEmailAdress.sendKeys("denemeprojedenemeproje@gmail.com");
        //  4	Password kısmını doldur
        page.password.sendKeys("Be123456");

        //  5	Sign in butonuna tıkla
        page.signInButton2.click();
        ReusableMethods.bekle(2);
        //  6	My Account'a tıkla
        page.myAccountButton.click();

        // 7-  Store Manager'a tıkla
        page.storeManager.click();
        ReusableMethods.bekle(1);

        // 8-	Mouse ile products add new elementine tıkla


        // 9-	Simple Product seçeneğine tıkla
        // 10-	Simple Product görünürlüğünü kontrol et
        // 11-	Variable Product görünürlüğünü kontrol et
        // 12-	Grouped Product görünürlüğünü kontrol et
        // 13-	External - Affiliate Product görünürlüğünü kontrol et

    }
}
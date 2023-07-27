package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page {
    public Page(){
        PageFactory.initElements(Driver.getDriver(),this);}

        //Ceylan Bitimli
        @FindBy(xpath = "(//p)[1]")
        public WebElement anaSayfa;
        @FindBy(xpath = "//*[@class='register inline-type']")
        public WebElement register;
        @FindBy(xpath = "//*[@id='reg_username']")
        public WebElement userName;
        @FindBy(xpath = "(//*[@id='reg_email'])[1]")
        public WebElement email;
        @FindBy(xpath =  "//*[@autocomplete='new-password']")
        public WebElement sifre;
        @FindBy(xpath = "(//*[@type='checkbox'])[2]")
        public WebElement IAgree;
        @FindBy(xpath = "(//button)[2]")
        public WebElement signUpButton;
        @FindBy(xpath = "//*[@class='color cetc']")
        public WebElement fakeMailCopy;
        @FindBy(xpath = "//*[text()='Sign Out']")
        public WebElement signOut;

        @FindBy(xpath = "(//h2)[1]")
        public  WebElement MyAccount;
        @FindBy(xpath = "//*[@class='nav-link']")
        public  WebElement signUp;
        @FindBy(xpath = "//*[@class='woocommerce-password-strength short']")
        public  WebElement VeriyWeak;

        @FindBy(xpath = "//*[@class='tab-pane active in']")
        public  WebElement RegisterEkrani;

        @FindBy(xpath = "(//*[@class='submit-status'])[2]")
        public  WebElement  kayitliMesaj;

























































































        //Ahmet Bora


















































        //Alper Küçük



































































































        //Erdem Üzüm



































































































        //Gülsün Demir





















































































































































        //Saadet Göker



































































































        //Gökay Terzi

















































        //Nihal Dilmen



































































































        //Mustafa Erbil



































































































        //Üsame Aydoğdu

















































































}

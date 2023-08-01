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
        @FindBy(xpath = "//*[@class='woocommerce-password-hint']")
        public  WebElement yanlisPasswordMesaji;


























































































        //Ahmet Bora

















































        //Alper Küçük



































































































        //Erdem Üzüm




































































































    //Gülsün Demir
    //Become locate
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/vendor-register/'])[2]")
    public WebElement becomeVendor;

    //Vendor Registration Basligi locate
    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement vendorRegistirationBaslik;

    //Email Kutusu locate
    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement vendorEmailKutusu;

    //email alanı bosluk locate
    @FindBy(xpath = "//h2[@class='wcfm_registration_form_heading']")
    public WebElement bosluk;

    //Verification code sent to your email  Mesaj locate
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement verificationCodeMesaji;

    //AlloverConvarce Dogrulama Kodu Sayfasına giriş locate   Mesaj Kutusu locators u
    @FindBy(xpath = "//tr[@data-href='2']")  // olmazsa index 1 ekle
    public WebElement fakeMektup;

    //Dogrulama Kodunu Kapsayan Iframe locater
    @FindBy(xpath = "//iframe[@class='col-xs-12 noPadding']")    //iframe[@id='iframeMail']
    public WebElement iframeDogrulamaKodu;

    //Dogrulama Kodu locate
    @FindBy(xpath = "//b")
    public WebElement dogrulamaKodu;

    //Verification Code kutusu locateri
    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement verificationKodKutusu;

    //Password Alanı Locatori
    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement passwordKutusu;

    //Confirm Password Locatori
    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordKutusu;

    // "Registration Successfully Completed. "Yazısı locator
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
    public WebElement registerSuccessfullyCompleted;

    //"Welcome to Allover Commerce!" yazısı locater
    @FindBy(xpath = "//h1[text()='Welcome to Allover Commerce!']")
    public WebElement welcomeToAlloverCommerce;

    //SignIn butonu locator
    @FindBy(xpath = "//*[@class='w-icon-account']")
    public WebElement signInButonu;

    //SignUp butonu locator
    @FindBy(xpath = "(//a[@data-toggle='tab'])[2]")
    public WebElement signUpButonu;

    //Registration Alanındaki Register Butonu Locatori
    @FindBy(xpath = "//*[@value='Register']")
    public WebElement registrationRegister;

    //"Email: This field is required." mesajı locator
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement emailError;

    //"Please provide a valid email address." mesajı locator
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement gecerliAdresGirKMesaji;

    //"Verification code sent to your email: " mesajı locator
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement emailDogrulamaKoduKMesaji;

    //"This Email already exists. Please login to the site and apply as vendor." mesajı locator
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement ePostaZatenVarMesaji;

    //fake Mail kutusu
    @FindBy(xpath = "//span[@id='email']")
    public WebElement fakeMailKutusu;

    //"Email verification code invalid." yazısı locator
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement ePostaGecersizKod;

    //"Password strength should be atleast "Good". "Yazısı locatoru
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement sifreGucuIyiOlmaliMesaji;

    //"Password and Confirm-password are not same." yazısı locator
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public  WebElement sifreVeOnaySifreAyniOlmaliMesaji;

    //too short yazısı locator
    @FindBy(xpath = "//div[text()='Too short']")
    public WebElement tooShort;

    //Weak mesajı locator
    @FindBy(xpath = "//div[text()='Weak']")
    public WebElement weak;

    //Good mesajı locator
    @FindBy(xpath = "//div[text()='Good']")
    public WebElement good;

    //Strong mesajı locator
    @FindBy(xpath = "//div[text()='Strong']")
    public WebElement strong;


























































































































        //Saadet Göker
    @FindBy (xpath = "(//p)[3]")
    public WebElement anasayfas;
    @FindBy (xpath = "(//Sign In)[0]")
    public WebElement signInButton1;

    @FindBy (xpath = "(//*[@name='username'])[1]")
    public WebElement userNames;

    @FindBy(xpath = "(//*[@name='password'])[1]")
    public WebElement passwords;
































    //Saadet Göker




































































































        //Gökay Terzi
   @FindBy(xpath = "(//*[.='Sign In'])[1]")
       public WebElement signInButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernameOrEmailAdress;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement signInButton2;
    @FindBy(xpath = "(//*[.='My Account'])[3]")
    public WebElement myAccountButton;
    @FindBy(xpath = "(//*[@class='text-uppercase text-center mb-0'])[4]")
    public WebElement accountDetailsButton;
    @FindBy(xpath = "//*[@class='icon-box-title text-normal']")
    public WebElement accountDetailText;
    @FindBy(xpath = "//*[@autocomplete='given-name']")
    public WebElement firstName;
    @FindBy(xpath = "//*[@id='account_last_name']")
    public WebElement lastName;
    @FindBy(xpath = "//*[@id='account_display_name']")
    public WebElement displayName;
    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emailAddress;
    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement saveChanges;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement accountDetailsChanged;
    @FindBy(xpath = "//*[@data-id='user_description']")
    public WebElement biography;
    ///********
    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAVendor;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;


 // evet yoksa dün kızarırdı. normaldi hatta herşey
   //sıfırdan mı yapssak yine














































        //Nihal Dilmen



































































































        //Üsame Aydoğdu



        //deneme































































































}

package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
    private WebDriver driver;
    @FindBy(id = "email_create")
    WebElement emailCreate;
    @FindBy(id = "SubmitCreate")
    WebElement submitCreateAccount;
    @FindBy(id = "uniform-id_gender1")
    WebElement mrRadiobtn;
    @FindBy(id = "uniform-id_gender2")
    WebElement mrsRadiobtn;
    @FindBy(id = "customer_firstname")
    WebElement firstname;
    @FindBy(id = "customer_lastname")
    WebElement lastname;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "days")
    WebElement days;
    @FindBy(id = "months")
    WebElement month;
    @FindBy(id = "years")
    WebElement years;
    @FindBy(id = "company")
    WebElement companyname;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement cityname;
    @FindBy(id = "id_state")
    WebElement statename;
    @FindBy(id = "postcode")
    WebElement postcode;
    @FindBy(id = "other")
    WebElement other;
    @FindBy(id = "phone")
    WebElement homePhone;
    @FindBy(id = "phone_mobile")
    WebElement mobile;
    @FindBy(id = "submitAccount")
    WebElement registerbtn;
    @FindBy(xpath = "//h1[normalize-space()='Create an account']")
    WebElement pageHeader;
    @FindBy(id = "uniform-days")
    WebElement daysClick;
    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement accountPageHeader;
    @FindBy(xpath = "//p[@class='info-account']")
    WebElement welcome;



    public CreateAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void enterEmail(){
        String randomemail= RandomStringUtils.randomAlphabetic(4);
       String email= randomemail+"@gmail.com";
        emailCreate.sendKeys(email);
    }
    public void clickOncreateAccount(){
        submitCreateAccount.click();
    }
    public String verifyPageHeading(){
        return pageHeader.getText();
    }
    public void selectTitile(){
        mrRadiobtn.click();
    }
    public void setTitle(){
        mrsRadiobtn.click();
    }
    public void fillForm(String Fname,String Lname,String passWord){
        firstname.sendKeys(Fname);
        lastname.sendKeys(Lname);
        password.sendKeys(passWord);
    }
    public void fillDate(String day) {
        new Select(days).selectByValue(day);}
    public void fillMonth(String Months) throws InterruptedException {

//          month.click();
        Thread.sleep(2000);
        new Select(month).selectByVisibleText(Months);}
    public void fillYear(String Year) throws InterruptedException {
        Thread.sleep(2000);
        new Select(years).selectByValue(Year);}
    public void company(String company) {
        companyname.sendKeys(company);
    }
    public void setAddress1(String address1,String city){
        address.sendKeys(address1);
        cityname.sendKeys(city);}
     public void setState(String stat){
        new Select(statename).selectByVisibleText(stat);

    }
    public void setPostcode(String zipcod){
        postcode.sendKeys(zipcod);
    }
    public void setHomePhone(String phone){
        homePhone.sendKeys(phone);
    }
    public void setMobile(String mobileno){
        mobile.sendKeys(mobileno);
    }
    public void clickRegisterBtn(){
        registerbtn.click();
    }
    public String verifyUrl(){
       return driver.getCurrentUrl();
    }
    public String verifyAccountPageHeading(){
        return accountPageHeader.getText();
    }
    public String verifyPageTitle(){
       return driver.getTitle();
    }
    public String verifyWelcome(){
        return welcome.getText();
    }










}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AngelContactPage {
    private WebDriver driver;
@FindBy(id = "menu-item-11811")
    WebElement contactLink;
@FindBy(xpath = "//img[@alt='Angel Solutions Logo']")
WebElement logo;
@FindBy(id="nf-field-21")
WebElement selectSub;
@FindBy(id = "nf-field-22")
WebElement name;
@FindBy(id = "nf-field-23")
WebElement email;
@FindBy(id = "nf-field-24")
WebElement phone;
@FindBy(id = "nf-field-25")
WebElement productQuery;
@FindBy(id = "nf-field-26")
WebElement job;
@FindBy(id = "nf-field-27")
WebElement message;
@FindBy(id = "nf-field-28")
WebElement submitBtn;
@FindBy(xpath = "//div[@class='nf-response-msg']/h3")
WebElement thxMsg;






    public AngelContactPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnContact(){
        contactLink.click();
    }
    public boolean logoDisplayed(){
       return logo.isDisplayed();
    }
    public String getUrl(){
       return driver.getCurrentUrl();
    }
    public String getTitle(){
       return driver.getTitle();
    }
    public void selectSubject(String subject){
        Select select=new Select(selectSub);
        select.selectByVisibleText(subject);
    }
    public void fillForm(String Name,String Email){
        name.sendKeys(Name);
        email.sendKeys(Email);
    }
    public void enterPhone(String Phone){
        phone.sendKeys(Phone);
    }
    public void SelectProductQuery(String prodQuery){
        Select select= new Select(productQuery);
        select.selectByVisibleText(prodQuery);
    }
    public void setJobTitle(String jobTitle){
        job.sendKeys(jobTitle);
    }
    public void enterMessage(String msg){
        message.sendKeys(msg);
    }
    public void submitForm(){
        submitBtn.click();
    }
    public String getThankYouMsg(){
        return thxMsg.getText();
    }
}

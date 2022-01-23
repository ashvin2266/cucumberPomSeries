package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
    private WebDriver driver;
    @FindBy(xpath = "//div[@id='contact-link']")
    WebElement contactUsLink;
    @FindBy(id = "id_contact")
    WebElement subHeading;
    @FindBy(id = "email")
    WebElement Email;
    @FindBy(id = "id_order")
    WebElement orderref;
    @FindBy(id= "message")
    WebElement Message;
    @FindBy(id = "submitMessage")
    WebElement sendBtn;
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successMsg;





    public ContactUsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnContactUs(){
        contactUsLink.click();
    }
    public String verifyContactUsPageTitle(){
        return driver.getTitle();
    }
    public String verifyContactUsUrl(){
      return  driver.getCurrentUrl();
    }
    public void fillContactFormFromExcell(String subheading,String email,String orderRef,String message){
        Select sc=new Select(subHeading);
        sc.selectByVisibleText(subheading);
        Email.sendKeys(email);
        orderref.sendKeys(orderRef);
        Message.sendKeys(message);

    }
    public void clickOnSendBtn(){
        sendBtn.click();
    }
    public String verifySuccessMsg(){
        String actualSuccessmsg=successMsg.getText();
        return actualSuccessmsg;
        
    }

}

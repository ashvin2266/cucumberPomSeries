package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

@FindBy(id = "email")
    WebElement emailId;
    @FindBy(id = "passwd")
    WebElement password;
    @FindBy(id = "SubmitLogin")
    WebElement signInBtn;
    @FindBy(linkText = "Forgot your password?")
    WebElement forgetPassword;






    public LoginPage(WebDriver driver){
        this.driver=driver;
               PageFactory.initElements(driver,this);

    }
    public String getLoginPageTitle(){

        return  driver.getTitle();
    }
    public boolean isForgetPasswordLinkExist(){
        return forgetPassword.isDisplayed();
    }
    public void enterEmail(String username){
        emailId.sendKeys(username);

    }
    public void enterPassword(String passwd){
        password.sendKeys(passwd);
    }
    public void clickSignIn(){
        signInBtn.click();
    }
}

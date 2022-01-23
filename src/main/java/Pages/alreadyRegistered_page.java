package Pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class alreadyRegistered_page {
    private WebDriver driver;
    @FindBy(linkText = "Sign in")
    WebElement signInBtn;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passwd")
    WebElement passwd;
    @FindBy(name = "SubmitLogin")
    WebElement signin;
    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    WebElement errorMsg;


    public alreadyRegistered_page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void clickSignIn()  {
        signInBtn.click();

            }
    public void seeUrl(){

        String Actual_URL=driver.getCurrentUrl();
    }
    public void enteraEmail(String Email){
        email.sendKeys(Email);
    }
    public void clickSignInButton(){
        signin.click();
    }
    public void Password(String password){
            passwd.sendKeys(password);}

    public String message()  {

      String actual_message;
      actual_message = errorMsg.getText();
      return actual_message;
//            Assert.assertEquals(message,actual_message);
//            log.info("Actual error msg is "+actual_message);
    }
    public void enterData(DataTable table){
//        first method
    /*   email.sendKeys(table.getGherkinRows().get(1).getCells().get(0));
        log.info(table.getGherkinRows().get(1).getCells().get(0));
        log.info(table.getGherkinRows().get(1).getCells().get(1));
        passwd.sendKeys(table.getGherkinRows().get(1).getCells().get(1));*/
//        second method
        List<Map<String,String>> namelist=table.asMaps(String.class,String.class);
        System.out.println(namelist);
        System.out.println(namelist.get(0).get("email"));
        email.sendKeys(namelist.get(0).get("email"));
        passwd.sendKeys(namelist.get(0).get("password"));
//        email.sendKeys(namelist.get(1).get("email"));
//        passwd.sendKeys(namelist.get(1).get("password"));*/
    }
    public String getPageTitle(){
        return driver.getTitle();
    }


}

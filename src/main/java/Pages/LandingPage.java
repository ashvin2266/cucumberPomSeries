package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {
   private WebDriver driver;
   @FindBy(xpath = "//img[@class='logo img-responsive']")
    WebElement logo;
   @FindBy(xpath = "//div[@class='header_user_info']")
   WebElement signInLink;
   @FindBy(xpath = "//a[normalize-space()='Sign in']")
   WebElement signInBtn;

    public LandingPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public boolean logoIsDisplayed(){
       return logo.isDisplayed();
    }
    public String getTitleOfLandingPage(){
       return  driver.getTitle();
    }
    public String getUrl(){
       return driver.getCurrentUrl();
    }
    public boolean signInLinkIsDisplayed(){
        return signInLink.isEnabled();
    }
    public void findTotalLink(){
       List<WebElement> linkElement= driver.findElements(By.tagName("a"));
       int totalLink=linkElement.size();
        System.out.println(totalLink);

    }
    public void printAllLink() {
        List<WebElement> linkElement = driver.findElements(By.tagName("a"));
        int totalLink = linkElement.size();
        System.out.println(totalLink);
        for (int i = 0; i < totalLink; i++) {
            System.out.println(linkElement.get(i).getText());
        }
    }
        public void clickSignIn(){
        signInBtn.click();

        }



}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TriSoftHomePage {
    private WebDriver driver;







    public TriSoftHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public int getTotalLink(){
      List<WebElement> totalLink= driver.findElements(By.tagName("a"));
      int actualTotalLink=totalLink.size();
        System.out.println("Total link present on Home Page is---->"+actualTotalLink);
      return actualTotalLink;
    }
    public String getTitleOfPage(){
        return driver.getTitle();
    }

}

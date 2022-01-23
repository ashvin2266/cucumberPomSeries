package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.CommonMethod;

import java.util.List;

public class OptimaCareerPage {
    private WebDriver driver;
    @FindBy(linkText = "Careers")
    WebElement careersLink;
    @FindBy(id = "logo")
    WebElement logo;
    @FindBy(name = "category")
    WebElement categoriesField;
    @FindBy(name = "type")
    WebElement jobtype;
    @FindBy(name = "location")
    WebElement location;
    @FindBy(xpath = "//div[@class='col-md-3']/button")
    WebElement filterBtn;
    @FindBy(xpath = "//div[@class='panel-heading']")
    WebElement jobTitle;









    public OptimaCareerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void clickOnCareerLink(){
        CommonMethod.clickOnElement(careersLink);
    }
    public boolean logoIsDisplayed(){
        return logo.isDisplayed();
    }
    public void selectCategories(String text){
        CommonMethod.selectByVisibleTextFromDropDown(categoriesField,text);

    }
    public void selectJobType(String type){
        CommonMethod.selectByVisibleTextFromDropDown(jobtype,type);
    }
    public void selectLocation(String city){
        CommonMethod.selectByVisibleTextFromDropDown(location,city);
    }
    public void clickOnFilterBtn(){
        filterBtn.click();
    }
    public String getTitleOfPage(){
        return driver.getTitle();
    }
    public int totalJobAvailable(){
      List<WebElement>totalJobElement= driver.findElements(By.xpath("//div[@class='panel-heading']"));
      return totalJobElement.size();
    }
    public void listOfJob(){
        List<WebElement>totalJobElement= driver.findElements(By.xpath("//div[@class='panel-heading']"));
        for (WebElement jobTitle:totalJobElement){
            System.out.println(jobTitle.getText());
        }
    }










}

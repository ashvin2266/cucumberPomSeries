package util;

import DriverFactory.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonMethod {
    private WebDriver driver;
    public static void clickOnElement(WebElement element){
        element.click();
    }
    public static String verifyUrl(){

        return DriverClass.getDriver().getCurrentUrl();
    }

    /*
     * This method wiLL SELECT an element from a DROPDOWN menu by INDEX
     */
    public static void selectByIndexFromDropDown(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /*
     * This method wiLL SELECT an element from a DROPDOWN menu by VISIBLE TEXT
     */
    public static void selectByVisibleTextFromDropDown(WebElement element, String string) {
        Select select = new Select(element);
        select.selectByVisibleText(string);
    }

    /*
     * This method wiLL SELECT an element from a DROPDOWN menu by VALUE
     */
    public void selectByValueFromDropDown(WebElement element, String string) {
        Select select = new Select(element);
        select.selectByValue(string);
    }
    /*
    This method will select an element from dropdown having select tagname
    but without select method
     */
    public static void selectOptionFromDropdown(WebElement element,String value){
        Select select=new Select(element);
        List<WebElement> optionList=select.getOptions();
        for (WebElement option:optionList){
            if (option.getText().equals(value)){
                option.click();
            }
        }
    }
    /*
    this method is used for jquery dropdown for select one or multiple choice or all choice
    from dropdown
     */
    public static void selectChoiceOfOption(WebDriver driver,String... value) {
        List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
        System.out.println("total choice list =" + choiceList.size());
        if (!value[0].equalsIgnoreCase("all")) {
            for (WebElement choice : choiceList) {
                String text = choice.getText();
                for (String val : value) {
                    if (text.equalsIgnoreCase(val)) {
                        choice.click();
                        break;
                    }
                }
            }

        } else {
            try {
                for (WebElement choice : choiceList) {
                    choice.click();
                }
            } catch (Exception e) {

            }
        }

    }
    /*
    This method used for wait until element to be clickable
     */
    public void waitUntilElementToBeClickable(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//     Above syntex used when you use selenium 4 dependency
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}

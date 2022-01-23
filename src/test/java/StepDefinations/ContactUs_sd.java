package StepDefinations;

import DriverFactory.DriverClass;
import Pages.ContactUsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.ExcelReader;
import util.Xls_Reader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUs_sd {
    private WebDriver driver;
    private ContactUsPage contactpage=new ContactUsPage(DriverClass.getDriver());
    @When("user click on contact us link")
    public void userClickOnContactUsLink() {
        contactpage.clickOnContactUs();

    }

    @Then("user are on the contact us page")
    public void userAreOnTheContactUsPage() {
        Assert.assertTrue(contactpage.verifyContactUsUrl().contains("contact"));
        System.out.println("Contact us Url is verified "+contactpage.verifyContactUsUrl());

    }

    @And("user verify user are on contact us page title as {string}")
    public void userVerifyUserAreOnContactUsPageTitleAs(String pageTitle) {
        Assert.assertEquals(pageTitle,contactpage.verifyContactUsPageTitle());
        System.out.println("Contact Us page title is verified");
    }
    @When("user fill the contact us form with valid detail from excell sheetname {string} and rownumber {int}")
    public void user_fill_the_contact_us_form_with_valid_detail_from_excell_sheetname_and_rownumber(String sheetname, Integer rownumber) throws IOException, InvalidFormatException {
        ExcelReader reader=new ExcelReader();
      List<Map<String,String>> data=  reader.getData("src/main/java/TestData/ContactUs.xlsx",sheetname);
     String subheading= data.get(rownumber).get("SubjectHeading");
        String email= data.get(rownumber).get("EmailAddress");
        String order= data.get(rownumber).get("Order Reference");
        String message= data.get(rownumber).get("Message");
        contactpage.fillContactFormFromExcell(subheading,email,order,message);

    }


    @And("user click on send button")
    public void userClickOnSendButton() {
        contactpage.clickOnSendBtn();
    }

    @Then("it shows a successful message {string}")
    public void itShowsASuccessfulMessage(String successMsg) {
        Assert.assertEquals(successMsg,contactpage.verifySuccessMsg());
        System.out.println("Successful Message is verified---->"+successMsg);

    }


}

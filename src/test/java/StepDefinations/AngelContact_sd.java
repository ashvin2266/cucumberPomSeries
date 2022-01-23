package StepDefinations;

import DriverFactory.DriverClass;
import Pages.AngelContactPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;

public class AngelContact_sd {
    private WebDriver driver;
    private ConfigReader configreader=new ConfigReader();
    private AngelContactPage angelContactPage=new AngelContactPage(DriverClass.getDriver());
    @Given("user are on HomePage")
    public void userAreOnHomePage() throws IOException {
        DriverClass.getDriver().get(configreader.init_prop().getProperty("url1"));
    }
    @When("User click on contact link")
    public void userClickOnContactLink() {
        angelContactPage.clickOnContact();
    }
    @Then("User verify the url of contact pageas as {string}")
    public void userVerifyTheUrlOfContactPageasAs(String expUrl) {
        String actualUrl=angelContactPage.getUrl();
        Assert.assertEquals(expUrl,actualUrl);
        System.out.println("Url of contact page is verified "+ actualUrl);
    }

    @And("User verify the companey logo is displayed on contact page")
    public void userVerifyTheCompaneyLogoIsDisplayedOnContactPage() {
        Assert.assertTrue(angelContactPage.logoDisplayed());
        System.out.println("Logo is displayed on page is verified");
    }

    @And("User verify the title of the contact page is {string}")
    public void useeVerifyTheTitleOfTheContactPageIs(String expTitle) {
        Assert.assertEquals(expTitle,angelContactPage.getTitle());
        System.out.println("Contact page title is verified ---->"+  expTitle);
    }

    @When("User select a subject is a {string}")
    public void userSelectASubjectIsA(String Sub) {
        angelContactPage.selectSubject(Sub);
    }

    @Given("User enter the name as {string}and email address as {string}")
    public void userEnterTheNameAsAndEmailAddressAs(String name, String email) {
        angelContactPage.fillForm(name,email);
    }

    @And("User select the product query is as {string}")
    public void userSelectTheProductQueryIsAs(String product) {
        angelContactPage.SelectProductQuery(product);
    }

    @And("User enter his job title as {string}")
    public void userEnterHisJobTitleAs(String jobTitle) {
        angelContactPage.setJobTitle(jobTitle);
    }

    @And("user enter the message as {string}")
    public void userEnterTheMessageAs(String message) {
        angelContactPage.enterMessage(message);
    }

    @When("User click on submit button")
    public void userClickOnSubmitButton() {
        angelContactPage.submitForm();
    }

    @Then("User see the thank you message as {string}")
    public void userSeeTheThankYouMessageAs(String expThxMsg) {
        Assert.assertEquals(expThxMsg,angelContactPage.getThankYouMsg());
        System.out.println("Thank you message is verified "+ expThxMsg);

    }

    @And("User enter phone as {string}")
    public void userEnterPhoneAs(String phone) {
        angelContactPage.enterPhone(phone);
    }
}

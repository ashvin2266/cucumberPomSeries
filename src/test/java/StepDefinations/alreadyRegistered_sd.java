package StepDefinations;

import DriverFactory.DriverClass;
import Pages.LoginPage;
import Pages.alreadyRegistered_page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class alreadyRegistered_sd {
    private WebDriver driver;
    private alreadyRegistered_page d_page=new alreadyRegistered_page(DriverClass.getDriver());

    //    public alreadyRegistered_page d_page = PageFactory.initElements(driver,alreadyRegistered_page.class);
    private Object DataTable;
//    public CommonMethod cm=new CommonMethod();
    @Given("^I go to Home Page$")
    public void iGoToHomePage() throws IOException {
        DriverClass.getDriver().get("http://automationpractice.com/index.php?");

//        cm.verifyUrl(getProperty("url"));
    }
    @When("^I click on a sign in button on home page$")
    public void iClickOnASignInButtonOnHomePage()
    {

        d_page.clickSignIn();
    }
    @Then("^I should see Already Registered in authentication page title as\"([^\"]*)\"$")
    public void iShouldSeeAlreadyRegisteredInAuthenticationPageTitleAs(String title)
    {
       Assert.assertEquals(title, d_page.getPageTitle());
    }
    @Given("^I enter a valid email as \"([^\"]*)\"$")
    public void iEnterAValidEmailAs(String email)  {

        d_page.enteraEmail(email);
    }
    @When("^I click on sign in button$")
    public void iClickOnSignInButton() {

        d_page.clickSignInButton();
    }
    @Given("^I enter a valid password is  as \"([^\"]*)\"$")
    public void iEnterAValidPasswordIsAs(String password)  {

        d_page.Password(password);
    }
     @Given("^I enter below details;$")
    public void iEnterBelowDetails(io.cucumber.datatable.DataTable table) {
       d_page.enterData(table);
         }

    @Then("^I should see error message as \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageAs(String message){
        Assert.assertEquals(message,d_page.message());
    }

    @Then("^I should see my account page Url as\"([^\"]*)\"$")
    public void iShouldSeeMyAccountPageUrlAs(String accountUrl) throws IOException {
//            cm.verifyUrl(accountUrl);
    }
    @And("^verify the page title of account page is \"([^\"]*)\"$")
    public void verifyThePageTitleOfAccountPageIs(String expTitle)
    {
        Assert.assertEquals(expTitle, d_page.getPageTitle());

    }


}

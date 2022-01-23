package StepDefinations;

import DriverFactory.DriverClass;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPage_sd {
    private  static String title;
    private WebDriver driver;
    private LoginPage loginpage=new LoginPage(DriverClass.getDriver());

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        DriverClass.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
       title= loginpage.getLoginPageTitle();

              System.out.println("page title is "+title);

    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expTitle) {
        Assert.assertEquals(expTitle,title);
    }

    @Then("forgot your password link should be displayed")
    public void forgotYourPasswordLinkShouldBeDisplayed() {
       Assert.assertTrue( loginpage.isForgetPasswordLinkExist());
    }

    @When("user enters username {string}")
    public void userEntersUsername(String email) {
        loginpage.enterEmail(email);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        loginpage.enterPassword(password);
    }

    @And("user clicks on Login button")
    public void userClicksOnLoginButton() {
        loginpage.clickSignIn();
    }
}

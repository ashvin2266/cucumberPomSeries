package StepDefinations;

import DriverFactory.DriverClass;
import Pages.TriSoftHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;

public class TriSoft_sd {
    private WebDriver driver;
    private TriSoftHomePage trsoft=new TriSoftHomePage(DriverClass.getDriver());
    private ConfigReader configReader=new ConfigReader();
    @Given("User are on Home Page")
    public void userAreOnHomePage() throws IOException {
        DriverClass.getDriver().get(configReader.init_prop().getProperty("url3"));
    }

    @When("User find the all link present on Home Page")
    public void userFindTheAllLinkPresentOnHomePage() {
        trsoft.getTotalLink();
    }

    @Then("User verify the title of the Home Page is {string}")
    public void userVerifyTheTitleOfTheHomePageIs(String expTitle) {
        String actualTitle=trsoft.getTitleOfPage();
        Assert.assertEquals(expTitle,actualTitle);
        System.out.println("Page title of Home Page is verifies---->"+actualTitle);
    }
    @And("User verify the total link present on Home Page is {int}")
    public void userVerifyTheTotalLinkPresentOnHomePageIs(int expTotalLink) {
        int actualTotalLink=trsoft.getTotalLink();
        Assert.assertEquals(expTotalLink,actualTotalLink);
    }
}

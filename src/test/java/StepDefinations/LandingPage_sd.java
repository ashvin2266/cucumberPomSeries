package StepDefinations;

import DriverFactory.DriverClass;
import Pages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class LandingPage_sd {
    private WebDriver driver;
    private ConfigReader config=new ConfigReader();
    private LandingPage landingpage=new LandingPage(DriverClass.getDriver());
    @Given("user are on landing page")
    public void userAreOnLandingPage() throws IOException {
        DriverClass.getDriver().get(config.init_prop().getProperty("url"));
    }
    @And("user verify the title of the page is as {string}")
    public void userVerifyTheTitleOfThePageIsAs(String landingPageTitle) {
      String actualPageTitle=  landingpage.getTitleOfLandingPage();
        Assert.assertEquals(landingPageTitle,actualPageTitle);
        System.out.println("Page title of landing page is verified "+actualPageTitle);
    }
    @Then("user are on landing page contains url as {string}")
    public void userAreOnLandingPageContainsUrlAs(String url) {
        Assert.assertEquals(url,landingpage.getUrl());
        System.out.println("Url of landing page is verified ");
    }


    @And("user verify the logo of the company is displayed")
    public void userVerifyTheLogoOfTheCompanyIsDisplayed() {
       Assert.assertTrue( landingpage.logoIsDisplayed());
        System.out.println("Logo is diaplayed on page");
    }


    @Then("user verify the signIn button is Enabled")
    public void userVerifyTheSignInButtonIsEnabled() {
        Assert.assertTrue(landingpage.signInLinkIsDisplayed());
        System.out.println("SignIn button enabled on page");
    }

    @Then("user identified total link present on page")
    public void userIdentifiedTotalLinkPresentOnPage() {
        landingpage.findTotalLink();

    }

    @And("user print all link on console page")
    public void userPrintAllLinkOnConsolePage() {
        landingpage.printAllLink();
    }
}

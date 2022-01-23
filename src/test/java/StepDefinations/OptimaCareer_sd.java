package StepDefinations;

import DriverFactory.DriverClass;
import Pages.OptimaCareerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.CommonMethod;
import util.ConfigReader;

import java.io.IOException;

public class OptimaCareer_sd {
    private WebDriver driver;
    private ConfigReader configreader=new ConfigReader();
    private OptimaCareerPage careerPage=new OptimaCareerPage(DriverClass.getDriver());
    @Given("User are on HomePage")
    public void userAreOnHomePage() throws IOException {
        DriverClass.getDriver().get(configreader.init_prop().getProperty("url2"));
    }
    @When("user click on careers link")
    public void userClickOnCareersLink() {
        careerPage.clickOnCareerLink();
    }
    @Then("user are on careers page contains url as {string}")
    public void userAreOnCareersPageContainsUrlAs(String careerPageUrl) {
        String ActualUrl= CommonMethod.verifyUrl();
        Assert.assertEquals(careerPageUrl,ActualUrl);
        System.out.println("CareerPage url is verified --->"+ActualUrl);
    }

    @And("user verify the company logo is displayed on career page")
    public void userVerifyTheCompanyLogoIsDisplayedOnCareerPage() {
        Assert.assertTrue(careerPage.logoIsDisplayed());
        System.out.println("Logo is displayed on Career page ");
    }
    @Given("user select a job categories from dropdown as {string} in search bar")
    public void userSelectAJobCategoriesFromDropdownAsInSearchBar(String jobCategories) {
        careerPage.selectCategories(jobCategories);
    }

    @And("user select a type of job is {string}")
    public void userSelectATypeOfJobIs(String jobType) {
        careerPage.selectJobType(jobType);
    }

    @And("user select a location is {string}")
    public void userSelectALocationIs(String locationCity) {
        careerPage.selectLocation(locationCity);
    }

    @When("user click on filter button")
    public void userClickOnFilterButton() {
        careerPage.clickOnFilterBtn();
    }

    @Then("user should see the job available in london is displayed in page")
    public void userShouldSeeTheJobAvailableInLondonIsDisplayedInPage() {
        Assert.assertEquals("Careers - Optima Health",careerPage.getTitleOfPage());
    }

    @And("user verify the total available job is {int}")
    public void userVerifyTheTotalAvailableJobIs(int totalJob) {
        Assert.assertEquals(totalJob,careerPage.totalJobAvailable());
        System.out.println("Total clinical clinical job available is ---->"+totalJob);
    }

    @And("user print the all job title")
    public void userPrintTheAllJobTitle() {
        careerPage.listOfJob();
    }
}

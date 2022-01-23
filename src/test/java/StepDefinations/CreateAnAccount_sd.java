package StepDefinations;

import DriverFactory.DriverClass;
import Pages.CreateAccountPage;
import Pages.LandingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateAnAccount_sd {
    private WebDriver driver;
    private CreateAccountPage createAccount=new CreateAccountPage(DriverClass.getDriver());
    private ExcelReader reader=new ExcelReader();
    @When("user click on sign In button")
    public void userClickOnSignInButton() {
        new LandingPage(DriverClass.getDriver()).clickSignIn();
    }

    @And("user enter a valid email on create an account page")
    public void userEnterAValidEmailOnCreateAnAccountPage() throws IOException, InvalidFormatException {
        createAccount.enterEmail();
    }

    @And("user click on create an account")
    public void userClickOnCreateAnAccount() {
        createAccount.clickOncreateAccount();
    }

    @Then("user see the create an account page heading  as {string}")
    public void userSeeTheCreateAnAccountPageHeadingAs(String pageHeading) {
        Assert.assertEquals(pageHeading,createAccount.verifyPageHeading());
    }


    @When("user fill up all personal information from excel sheetname as {string} and row number as {int}")
    public void userFillUpAllPersonalInformationFromExcelSheetnameAsAndRowNumberAs(String sheetName, int rawnumber) throws IOException, InvalidFormatException, InterruptedException {
        List<Map<String, String>> data= reader.getData("src/main/java/TestData/ContactUs.xlsx","createAccount");
      String title=data.get(rawnumber).get("title");
      if (title.equalsIgnoreCase("Mr."))
      {
        createAccount.selectTitile();}
      else {
          createAccount.setTitle();
      }
        String name=data.get(rawnumber).get("FirstName");
        String lastname=data.get(rawnumber).get("LastName");
        String passwd=data.get(rawnumber).get("password");
        createAccount.fillForm(name,lastname,passwd);
        String days=data.get(rawnumber).get("date");
        System.out.println(days);
        createAccount.fillDate(days);
        String Month=data.get(rawnumber).get("month");
        createAccount.fillMonth(Month);
        System.out.println(Month);
        String year=data.get(rawnumber).get("year");
        System.out.println(year);
        createAccount.fillYear(year);
        String Coname=data.get(rawnumber).get("company");
        createAccount.company(Coname);
         String Address=data.get(rawnumber).get("address");
         String City=data.get(rawnumber).get("city");
         createAccount.setAddress1(Address,City);
         String state=data.get(rawnumber).get("state");
         createAccount.setState(state);
        String postalcode=data.get(rawnumber).get("zipcode");
        createAccount.setPostcode(postalcode);
        String homephoneno=data.get(rawnumber).get("homephone");
        createAccount.setHomePhone(homephoneno);
        String mobileNo=data.get(rawnumber).get("mobilePhone");
        createAccount.setMobile(mobileNo);


    }

    @And("user click on register  button")
    public void userClickOnRegisterButton() {
        createAccount.clickRegisterBtn();
    }

    @Then("user should be on his account Page")
    public void userShouldBeOnHisAccountPage() {
        String expUrl="http://automationpractice.com/index.php?controller=my-account";
        String actualurl=createAccount.verifyUrl();
        Assert.assertEquals(expUrl,actualurl);
    }

    @And("user verify account page by heading as {string} present on page")
    public void userVerifyAccountPageByHeadingAsPresentOnPage(String accountpageHeading) {
        String actual= createAccount.verifyAccountPageHeading();
        Assert.assertEquals(accountpageHeading,actual);
    }

    @And("user verify the account page title as {string}")
    public void userVerifyTheAccountPageTitleAs(String pagetitle) {
        Assert.assertEquals(pagetitle,createAccount.verifyPageTitle());

    }

    @And("user verify the welcome text contains{string}")
    public void userVerifyTheWelcomeTextContains(String welcome) {
        Assert.assertTrue(createAccount.verifyWelcome().contains(welcome));
    }


}

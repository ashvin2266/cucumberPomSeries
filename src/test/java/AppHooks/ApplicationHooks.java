package AppHooks;

import DriverFactory.DriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {
    private ConfigReader configreader;
    private DriverClass driverclass;
    Properties prop;
    private WebDriver driver;
/*if you want to skip some scenario use below @Before hook
    @Before(value = "@skip",order=0)
    public void skipScenario(Scenario scenario){
        System.out.println("Skipped scenario is -->"+ scenario.getName());
        Assume.assumeTrue(false);
    }*/

@Before(order=0)
    public void getProperty() throws IOException {
    configreader=new ConfigReader();
    prop= configreader.init_prop();}
@Before(order=1)
        public void launchBrowser(){
    String browserName=prop.getProperty("browser");
    driverclass =new DriverClass();
    driver=driverclass.init_driver(browserName);

    }
    @After(order=0)
    public void quitBrowser(){
    driver.quit();
    }
    @After(order  =1)
    public void tearDown(Scenario scenario){
    if (scenario.isFailed()) {
//        take a screenshot
        String screenshotName = scenario.getName().toString().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcePath, "image/png" ,screenshotName);
    }
    }

}



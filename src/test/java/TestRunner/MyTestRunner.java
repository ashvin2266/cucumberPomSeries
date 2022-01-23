package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
/*        tags = "not @skip",if you want to skip this scenario use this tags
        tags = "@login and not @skip",*/
        tags = "@already",
        glue = {"StepDefinations","AppHooks"},
        monochrome = true,
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        }
)

public class MyTestRunner {
}

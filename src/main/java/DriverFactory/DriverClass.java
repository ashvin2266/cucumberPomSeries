package DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverClass {
    public WebDriver driver;
    public static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<>();
    public WebDriver init_driver(String browser){
        System.out.println("Browser value is "+browser);
        if (browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        /*when we need to headless browser use this chromeoptions class
            chromeOptions.addArguments("--headless");
        tlDriver.set(new ChromeDriver(chromeOptions));*/
        tlDriver.set(new ChromeDriver());
            System.out.println("Chrome browser is open");        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
            System.out.println("firefox browser is open");
        }
        else if (browser.equalsIgnoreCase("safari")){
            tlDriver.set(new SafariDriver());
            System.out.println("Safari Browser is open");
        }
        else {
            System.out.println("Please pass the correct browser value"+browser);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return getDriver();

    }
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}

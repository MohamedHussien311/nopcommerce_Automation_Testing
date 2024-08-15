package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    Faker fakeData = new Faker();
   @BeforeSuite
    public void startDriver(){
        driver = new ChromeDriver();
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }
    // Take screenshot when the testcase fails
    @AfterMethod
    public void takeScreenShotAtFailure(ITestResult result){
       if(result.getStatus() == ITestResult.FAILURE){
           System.out.println("Failed");
           System.out.println("Taking screenshot...");
           Helper.captureScreeShot(driver,result.getName());
       }
    }

}

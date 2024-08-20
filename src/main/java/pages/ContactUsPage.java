package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    WebElement fullNameTxt = driver.findElement(By.id("FullName"));
    WebElement emailTxt = driver.findElement(By.id("Email"));
    WebElement enquiryTxt = driver.findElement(By.id("Enquiry"));
    WebElement submit = driver.findElement(By.name("send-email"));
    public WebElement successMessage = driver.findElement(By.cssSelector("div.result"));
    public void contactUs(String fname,String email,String enquiry){
        setValueToElement(fullNameTxt,fname);
        setValueToElement(emailTxt,email);
        setValueToElement(enquiryTxt,enquiry);
        clickButton(submit);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    WebElement registerLink = driver.findElement(By.linkText("Register"));
    WebElement loginLink = driver.findElement(By.linkText("Log in"));
    WebElement myAccountLink = driver.findElement(By.linkText("My account"));
    WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
    WebElement currencyList = driver.findElement(By.id("customerCurrency"));
    WebElement computersMenu = driver.findElement(By.linkText("Computers"));
    WebElement softwareCategory = driver.findElement(By.linkText("Software"));
    public WebElement selectedCategory = driver.findElement(By.cssSelector("strong.current-item"));
    public void openReigisterationPage(){
        clickButton(registerLink);
    }
    public void openLoginPage(){
        clickButton(loginLink);
    }
    public void openMyAccountPage(){
        clickButton(myAccountLink);
    }
    public void openContactUsPage(){
        scrollToBottom();
        clickButton(contactUsLink);
    }
    public void changeCurrency(){
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }
    public void selectSoftwareCategory(){
        action.moveToElement(computersMenu).moveToElement(softwareCategory).click().build().perform();
    }
}

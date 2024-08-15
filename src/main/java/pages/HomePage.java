package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }
    @FindBy(linkText = "Register")
    WebElement registerLink;
    @FindBy(linkText = "Log in")
    WebElement loginLink;
    @FindBy(linkText = "My account")
    WebElement myAccountLink;
    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(id = "customerCurrency")
    WebElement currencyList;
    @FindBy(linkText = "Computers")
    WebElement computersMenu;
    @FindBy(linkText = "Software")
    WebElement softwareCategory;
    @FindBy(css = "strong.current-item")
    public WebElement selectedCategory;
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

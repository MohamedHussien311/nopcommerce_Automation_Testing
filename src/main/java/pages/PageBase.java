package pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
    JavascriptExecutor jse;
    Select select;
    Actions action;
    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    protected static void clickButton(WebElement button){
        button.click();
    }
    protected static void setValueToElement(WebElement element, String value){
        element.sendKeys(value);
    }
    public void scrollToBottom(){
        jse.executeScript("scrollBy(0,2500)");
    }
    public void clearElementTextBox(WebElement element){
        element.clear();
    }
}

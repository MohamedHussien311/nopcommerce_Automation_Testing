package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    WebElement searchTextBox = driver.findElement(By.id("small-searchterms"));
    List<WebElement> productList = driver.findElements(By.id("ui-ui-id-1-3"));
    WebElement searchBtn = driver.findElement(By.cssSelector("button.button-1.search-box-button"));
    WebElement productTitle = driver.findElement(By.linkText("Apple MacBook Pro 13-inch"));
    public void searchForProduct(String productName){
        setValueToElement(searchTextBox,productName);
        clickButton(searchBtn);
    }
    public void openProductDetailsPage(){
        clickButton(productTitle);
    }
    public void searchUsingAutoSuggest(String searchTxt) {
        setValueToElement(searchTextBox,searchTxt);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productList.get(0).click();
    }
}

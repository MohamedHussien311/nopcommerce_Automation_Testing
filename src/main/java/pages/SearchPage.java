package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "small-searchterms")
    WebElement searchTextBox;
    @FindBy(id = "ui-ui-id-1-3")
    List<WebElement> productList;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;
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

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareProductsPage extends PageBase{
    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.clear-list")
    WebElement clearListBtn;
    @FindBy(tagName = "tr")
    List<WebElement> allRows;
    @FindBy(css = "div.no-data")
    public WebElement emptyCompareList;
    public void clearCompareList(){
        clickButton(clearListBtn);
    }
    public void compareProducts(){
        for (WebElement row : allRows)
            System.out.println(row.getText());
    }
}

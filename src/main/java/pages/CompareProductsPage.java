package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CompareProductsPage extends PageBase{
    public CompareProductsPage(WebDriver driver) {
        super(driver);
    }
    WebElement clearListBtn = driver.findElement(By.cssSelector("a.clear-list"));
    List<WebElement> allRows = driver.findElements(By.tagName("tr"));
    public WebElement emptyCompareList = driver.findElement(By.cssSelector("div.no-data"));
    public void clearCompareList(){
        clickButton(clearListBtn);
    }
    public void compareProducts(){
        for (WebElement row : allRows)
            System.out.println(row.getText());
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    WebElement printBtn = driver.findElement(By.linkText("Print"));
    WebElement downloadPDFDetailsBtn = driver.findElement(By.linkText("PDF Invoice"));
    public void printOrderDetails(){
        clickButton(printBtn);
    }
    public void downloadOrderDetailsPDF(){
        clickButton(downloadPDFDetailsBtn);
    }
}

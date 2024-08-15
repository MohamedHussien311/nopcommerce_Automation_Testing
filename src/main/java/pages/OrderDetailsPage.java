package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Print")
    WebElement printBtn;
    @FindBy(linkText = "PDF Invoice")
    WebElement downloadPDFDetailsBtn;
    public void printOrderDetails(){
        clickButton(printBtn);
    }
    public void downloadOrderDetailsPDF(){
        clickButton(downloadPDFDetailsBtn);
    }
}

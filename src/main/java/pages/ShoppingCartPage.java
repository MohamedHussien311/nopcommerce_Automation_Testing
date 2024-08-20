package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public WebElement productNameCell = driver.findElement(By.cssSelector("a.product-name"));
    WebElement removeProductCell = driver.findElement(By.cssSelector("td.remove-from-cart"));
    public WebElement emptyCart = driver.findElement(By.cssSelector("div.page-body"));
    WebElement confirmTermsOfService = driver.findElement(By.id("termsofservice"));
    WebElement checkOutLink = driver.findElement(By.id("checkout"));
    public void removeProductFromCart(){
        clickButton(removeProductCell);
    }
    public void openCheckoutPage(){
        clickButton(confirmTermsOfService);
        clickButton(checkOutLink);
    }
}

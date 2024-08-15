package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "a.product-name")
    public WebElement productNameCell;
    @FindBy(css = "td.remove-from-cart")
    WebElement removeProductCell;
    @FindBy(css = "div.page-body")
    public WebElement emptyCart;
    @FindBy(id = "termsofservice")
    WebElement confirmTermsOfService;
    @FindBy(id = "checkout")
    WebElement checkOutLink;
    public void removeProductFromCart(){
        clickButton(removeProductCell);
    }
    public void openCheckoutPage(){
        clickButton(confirmTermsOfService);
        clickButton(checkOutLink);
    }
}

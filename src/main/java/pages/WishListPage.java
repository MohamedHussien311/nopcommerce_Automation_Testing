package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "td.product")
    public WebElement productCell;
    @FindBy(css = "h1")
    public WebElement wishListHeader;
    @FindBy(css = "td.remove-from-cart")
    WebElement removeProductBtn;
    @FindBy(css = "div.no-data")
    public WebElement emptyWishList;
    public void removeProductFromList(){
        clickButton(removeProductBtn);
    }

}

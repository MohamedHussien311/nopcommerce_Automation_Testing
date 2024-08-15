package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "strong.current-item")
    public WebElement productNameBreadCrumb;
    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement emailFriendLink;
    @FindBy(id = "price-value-4")
    public WebElement productPrice;
    @FindBy(linkText = "Add your review")
    WebElement addReviewLink;
    @FindBy(css = "button.button-2.add-to-wishlist-button")
    WebElement addToWishListBtn;
    @FindBy(linkText = "wishlist")
    public WebElement openWishListLink;
    @FindBy(css = "button.button-1.add-to-cart-button")
    WebElement addToCartBtn;
    @FindBy(linkText = "shopping cart")
    public WebElement openCartLink;
    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement addToCompareLink;
    @FindBy(linkText = "product comparison")
    public WebElement openCompareLink;
    public void openEmailFriendPAge(){
        clickButton(emailFriendLink);
    }
    public void openAddProductReviewPage(){
        clickButton(addReviewLink);
    }
    public void addProductToWishList(){
        clickButton(addToWishListBtn);
    }
    public void addProductToCart(){
        clickButton(addToCartBtn);
    }
    public void addProductToCompareList(){
        clickButton(addToCompareLink);
    }
}

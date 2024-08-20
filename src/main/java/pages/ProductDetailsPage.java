package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement productNameBreadCrumb = driver.findElement(By.cssSelector("strong.current-item"));
    WebElement emailFriendLink = driver.findElement(By.cssSelector("button.button-2.email-a-friend-button"));
    public WebElement productPrice = driver.findElement(By.id("price-value-4"));
    WebElement addReviewLink = driver.findElement(By.linkText("Add your review"));
    WebElement addToWishListBtn = driver.findElement(By.cssSelector("button.button-2.add-to-wishlist-button"));
    public WebElement openWishListLink = driver.findElement(By.linkText("wishlist"));
    WebElement addToCartBtn = driver.findElement(By.cssSelector("button.button-1.add-to-cart-button"));
    public WebElement openCartLink = driver.findElement(By.linkText("shopping cart"));
    WebElement addToCompareLink = driver.findElement(By.cssSelector("button.button-2.add-to-compare-list-button"));
    public WebElement openCompareLink = driver.findElement(By.linkText("product comparison"));
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

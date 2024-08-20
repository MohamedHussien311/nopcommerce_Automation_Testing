package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToCartTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject = new SearchPage(driver);
    ProductDetailsPage productDetailsObject = new ProductDetailsPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    @Test(priority = 1)
    public void userCanSearchForProduct(){
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 2)
    public void UserCanAddProductToCart(){
        productDetailsObject.addProductToCart();
        productDetailsObject.openCartLink.click();
        Assert.assertEquals(shoppingCartPage.productNameCell.getText(),productName);
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromCart(){
        shoppingCartPage.removeProductFromCart();
       Assert.assertEquals(shoppingCartPage.emptyCart.getText(),"Your Shopping Cart is empty!");
    }
}

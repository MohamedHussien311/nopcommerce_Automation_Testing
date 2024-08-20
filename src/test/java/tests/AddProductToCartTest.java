package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToCartTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject ;
    ProductDetailsPage productDetailsObject;
    ShoppingCartPage shoppingCartPage;
    @Test(priority = 1)
    public void userCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 2)
    public void UserCanAddProductToCart(){
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addProductToCart();
        productDetailsObject.openCartLink.click();
        shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(shoppingCartPage.productNameCell.getText(),productName);
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromCart(){
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeProductFromCart();
       Assert.assertEquals(shoppingCartPage.emptyCart.getText(),"Your Shopping Cart is empty!");
    }
}

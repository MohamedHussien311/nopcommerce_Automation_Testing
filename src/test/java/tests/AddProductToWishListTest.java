package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    WishListPage wishListPage;
    @Test(priority = 1)
    public void userCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 2)
    public void UserCanAddProductToWishListTest(){
        productDetailsObject = new ProductDetailsPage(driver);
        productDetailsObject.addProductToWishList();
        productDetailsObject.openWishListLink.click();
        wishListPage = new WishListPage(driver);
        Assert.assertEquals(wishListPage.wishListHeader.getText(),"Wishlist");
        Assert.assertEquals(wishListPage.productCell.getText(),productName);
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromWishList(){
        wishListPage = new WishListPage(driver);
        wishListPage.removeProductFromList();
        Assert.assertTrue(wishListPage.emptyWishList.getText().contains("empty"));
    }
}

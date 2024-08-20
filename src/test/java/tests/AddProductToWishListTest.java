package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject = new SearchPage(driver);
    ProductDetailsPage productDetailsObject = new ProductDetailsPage(driver);
    WishListPage wishListPage = new WishListPage(driver);
    @Test(priority = 1)
    public void userCanSearchForProduct(){
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 2)
    public void UserCanAddProductToWishListTest(){
        productDetailsObject.addProductToWishList();
        productDetailsObject.openWishListLink.click();
        Assert.assertEquals(wishListPage.wishListHeader.getText(),"Wishlist");
        Assert.assertEquals(wishListPage.productCell.getText(),productName);
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromWishList(){
        wishListPage.removeProductFromList();
        Assert.assertTrue(wishListPage.emptyWishList.getText().contains("empty"));
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ProductSearchTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject = new SearchPage(driver);
    ProductDetailsPage productDetailsObject = new ProductDetailsPage(driver);
    @Test
    public void userCanSearchForProduct(){
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
}

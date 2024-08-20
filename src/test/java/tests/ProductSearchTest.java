package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ProductSearchTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    @Test
    public void userCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
}

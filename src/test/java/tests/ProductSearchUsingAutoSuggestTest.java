package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ProductSearchUsingAutoSuggestTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject = new SearchPage(driver);
    ProductDetailsPage productDetailsObject;
    @Test
    public void UserCanSearchUsingAutoSuggest() {
        searchObject.searchUsingAutoSuggest("MacBook");
        productDetailsObject = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
}

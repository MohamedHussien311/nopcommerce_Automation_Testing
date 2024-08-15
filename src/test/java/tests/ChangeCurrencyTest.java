package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage productDetailsObject;
    HomePage homePage;
    @Test(priority = 1)
    public void UserCanChangeCurrency(){
        homePage = new HomePage(driver);
        homePage.changeCurrency();
    }
    @Test(priority = 2)
    public void userCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
        Assert.assertTrue(productDetailsObject.productPrice.getText().contains("€"));
        System.out.println(productDetailsObject.productPrice.getText());
    }

}

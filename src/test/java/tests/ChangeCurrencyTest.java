package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
    String productName = "Apple MacBook Pro 13-inch";
    SearchPage searchObject = new SearchPage(driver);
    ProductDetailsPage productDetailsObject = new ProductDetailsPage(driver);
    HomePage homePage = new HomePage(driver);
    @Test(priority = 1)
    public void UserCanChangeCurrency(){
        homePage.changeCurrency();
    }
    @Test(priority = 2)
    public void userCanSearchForProduct(){
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
        Assert.assertTrue(productDetailsObject.productPrice.getText().contains("€"));
        System.out.println(productDetailsObject.productPrice.getText());
    }

}

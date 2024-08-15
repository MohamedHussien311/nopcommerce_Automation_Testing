package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CompareProductsTest extends TestBase{
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    CompareProductsPage compareProductsPage;
    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop";
    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        compareProductsPage = new CompareProductsPage(driver);
        searchPage.searchForProduct(firstProductName);
        productDetailsPage.addProductToCompareList();

        searchPage.searchForProduct(secondProductName);
        productDetailsPage.addProductToCompareList();
        Thread.sleep(2000);

        productDetailsPage.openCompareLink.click();
        compareProductsPage.compareProducts();
    }
    @Test(priority = 2)
    public void UserCanClearCompareList(){
        compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.clearCompareList();
        Assert.assertEquals(compareProductsPage.emptyCompareList.getText(),"You have no items to compare.");
    }
}

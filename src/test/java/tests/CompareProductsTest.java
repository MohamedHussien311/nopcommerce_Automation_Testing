package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

import java.time.Duration;

public class CompareProductsTest extends TestBase{
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    CompareProductsPage compareProductsPage;
    String firstProductName = "Apple MacBook Pro 13-inch";
    String secondProductName = "Asus N551JK-XO076H Laptop";
    @Test(priority = 1)
    public void UserCanCompareProducts(){
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct(firstProductName);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addProductToCompareList();

        searchPage.searchForProduct(secondProductName);
        productDetailsPage.addProductToCompareList();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        productDetailsPage.openCompareLink.click();
        compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.compareProducts();
    }
    @Test(priority = 2)
    public void UserCanClearCompareList(){
        compareProductsPage = new CompareProductsPage(driver);
        compareProductsPage.clearCompareList();
        Assert.assertEquals(compareProductsPage.emptyCompareList.getText(),"You have no items to compare.");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddProductReviewTest extends TestBase{
    ProductDetailsPage productDetailsObject = new ProductDetailsPage(driver);
    HomePage homePage = new HomePage(driver);
    UserRegisterationPage userRegisterationPage = new UserRegisterationPage(driver);
    SearchPage searchObject = new SearchPage(driver);
    AddProductReviewPage addProductReviewPage = new AddProductReviewPage(driver);
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String productName = "Apple MacBook Pro 13-inch";
    String reviewTitle = "New Review";
    String reviewText = "This is a good product.";
    @Test(priority = 1)
    public void UserCanRegisterSuccessfully(){
        homePage.openReigisterationPage();
        userRegisterationPage.userRegisteration(firstName,lastName,
                email,password);
        Assert.assertEquals(userRegisterationPage.registeredSuccessMessage.getText()
                ,"Your registration completed");
    }
    @Test(priority = 2)
    public void userCanSearchForProduct(){
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 3)
    public void RegisteredUserCanAddProductReview(){
        productDetailsObject.openAddProductReviewPage();
        addProductReviewPage.addProductReview(reviewTitle,reviewText);
        Assert.assertEquals(addProductReviewPage.reviewAddedMessage.getText(),
                "Product review is successfully added.");
    }
    @Test(priority = 4)
    public void RegisteredUserCanLogoutSuccessfully(){
        addProductReviewPage.submitReview.click();    //To make the logout button visible
        userRegisterationPage.userLogout();
    }
}

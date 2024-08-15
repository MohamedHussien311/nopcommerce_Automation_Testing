package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase{
    EmailFriendPage emailFriendPage;
    ProductDetailsPage productDetailsObject;
    HomePage homePage;
    UserRegisterationPage userRegisterationPage;
    SearchPage searchObject;
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String productName = "Apple MacBook Pro 13-inch";
    String friendEmail = fakeData.internet().emailAddress();
    String message = "Hello my Friend, Check out this product.";
    @Test(priority = 1)
    public void UserCanRegisterSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openReigisterationPage();
        userRegisterationPage = new UserRegisterationPage(driver);
        userRegisterationPage.userRegisteration(firstName,lastName,
                email,password);
        Assert.assertEquals(userRegisterationPage.registeredSuccessMessage.getText()
                ,"Your registration completed");
    }
    @Test(priority = 2)
    public void userCanSearchForProduct(){
        searchObject = new SearchPage(driver);
        productDetailsObject = new ProductDetailsPage(driver);
        searchObject.searchForProduct(productName);
        searchObject.openProductDetailsPage();
        Assert.assertEquals(productDetailsObject.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 3)
    public void RegisteredUserCanSendEmailToFriend(){
        emailFriendPage = new EmailFriendPage(driver);
        productDetailsObject.openEmailFriendPAge();
        emailFriendPage.sendEmailToFriend(friendEmail,message);
        Assert.assertEquals(emailFriendPage.successSentMessage.getText(),"Your message has been sent.");
    }
}

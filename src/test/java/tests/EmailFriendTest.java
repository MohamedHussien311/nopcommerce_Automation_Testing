package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EmailFriendTest extends TestBase{
    EmailFriendPage emailFriendPage = new EmailFriendPage(driver);
    ProductDetailsPage productDetailsObject = new ProductDetailsPage(driver);
    HomePage homePage = new HomePage(driver);
    UserRegisterationPage userRegisterationPage = new UserRegisterationPage(driver);
    SearchPage searchObject = new SearchPage(driver);
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String productName = "Apple MacBook Pro 13-inch";
    String friendEmail = fakeData.internet().emailAddress();
    String message = "Hello my Friend, Check out this product.";
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
    public void RegisteredUserCanSendEmailToFriend(){
        productDetailsObject.openEmailFriendPAge();
        emailFriendPage.sendEmailToFriend(friendEmail,message);
        Assert.assertEquals(emailFriendPage.successSentMessage.getText(),"Your message has been sent.");
    }
}

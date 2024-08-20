package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{
    HomePage homePage;
    UserRegisterationPage userRegisterationPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    String newPassword = fakeData.number().digits(8).toString();
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
    public void RegisteredUserCanChangePassword(){
        homePage = new HomePage(driver);
        homePage.openMyAccountPage();
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.openChangePasswordPage();
        myAccountPage.changePassword(password,newPassword);
        Assert.assertEquals(myAccountPage.passwordUpdatedMessage.getText(),"Password was changed");
    }
    @Test(priority = 3)
    public void RegisteredUserCanLogoutSuccessfully(){
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.openChangePasswordPage();
        userRegisterationPage = new UserRegisterationPage(driver);
        userRegisterationPage.userLogout();
    }
    @Test(priority = 4)
    public void RegisteredUserCanLoginSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email,newPassword);
        userRegisterationPage = new UserRegisterationPage(driver);
        Assert.assertEquals(userRegisterationPage.logoutLink.getText(),"Log out");
    }
}

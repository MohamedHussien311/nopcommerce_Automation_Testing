package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase{
    HomePage homePage;
    UserRegisterationPage userRegisterationPage;
    LoginPage loginPage;
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
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
    @Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void RegisteredUserCanLogoutSuccessfully(){
        userRegisterationPage.userLogout();
    }
    @Test(dependsOnMethods = {"RegisteredUserCanLogoutSuccessfully"})
    public void RegisteredUserCanLoginSuccessfully(){
        homePage = new HomePage(driver);
        homePage.openLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.userLogin(email,password);
        userRegisterationPage = new UserRegisterationPage(driver);
        Assert.assertEquals(userRegisterationPage.logoutLink.getText(),"Log out");
    }
}

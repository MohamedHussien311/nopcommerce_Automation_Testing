package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase{
    HomePage homePage = new HomePage(driver);
    UserRegisterationPage userRegisterationPage = new UserRegisterationPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();
    @Test(priority = 1)
    public void UserCanRegisterSuccessfully(){
        homePage.openReigisterationPage();
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
        homePage.openLoginPage();
        loginPage.userLogin(email,password);
        Assert.assertEquals(userRegisterationPage.logoutLink.getText(),"Log out");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
    String fullName = fakeData.name().fullName();
    String email = fakeData.internet().emailAddress();
    String enquiry = "Hi admin, This is for test";
    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    @Test
    public void UserCanContactUs(){
        homePage.openContactUsPage();
        contactUsPage.contactUs(fullName,email,enquiry);
        Assert.assertEquals(contactUsPage.successMessage.getText(),
                "Your enquiry has been successfully sent to the store owner.");
    }
}

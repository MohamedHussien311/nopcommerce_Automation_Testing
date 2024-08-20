package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverMenuTest extends TestBase{
    HomePage homePage;
    @Test
    public void UserCanSelectFromHoverMenu(){
        homePage = new HomePage(driver);
        homePage.selectSoftwareCategory();
        Assert.assertEquals(homePage.selectedCategory.getText(),"Software");
    }
}

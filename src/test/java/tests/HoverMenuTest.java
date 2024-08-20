package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HoverMenuTest extends TestBase{
    HomePage homePage = new HomePage(driver);
    @Test
    public void UserCanSelectFromHoverMenu(){
        homePage.selectSoftwareCategory();
        Assert.assertEquals(homePage.selectedCategory.getText(),"Software");
    }
}

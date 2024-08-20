package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPage extends PageBase{
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    public WebElement productCell = driver.findElement(By.cssSelector("td.product"));
    public WebElement wishListHeader = driver.findElement(By.cssSelector("h1"));
    WebElement removeProductBtn = driver.findElement(By.cssSelector("td.remove-from-cart"));
    public WebElement emptyWishList = driver.findElement(By.cssSelector("div.no-data"));
    public void removeProductFromList(){
        clickButton(removeProductBtn);
    }

}

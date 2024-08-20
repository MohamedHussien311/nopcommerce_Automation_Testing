package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductReviewPage extends PageBase{
    public AddProductReviewPage(WebDriver driver) {
        super(driver);
    }
    WebElement reviewTitleTxt = driver.findElement(By.id("AddProductReview_Title"));
    WebElement reviewTextBox = driver.findElement(By.id("AddProductReview_ReviewText"));
    WebElement goodRating = driver.findElement(By.id("addproductrating_4"));
    public WebElement submitReview = driver.findElement(By.id("review"));
    public WebElement reviewAddedMessage = driver.findElement(By.cssSelector("p.content"));
    public void addProductReview(String reviewTitle,String reviewText){
        setValueToElement(reviewTitleTxt,reviewTitle);
        setValueToElement(reviewTextBox,reviewText);
        clickButton(goodRating);
        clickButton(submitReview);
    }

}

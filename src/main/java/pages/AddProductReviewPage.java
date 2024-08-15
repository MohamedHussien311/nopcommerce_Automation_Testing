package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase{
    public AddProductReviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitleTxt;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewTextBox;
    @FindBy(id = "addproductrating_4")
    WebElement goodRating;
    @FindBy(id = "add-review")
    public WebElement submitReview;
    @FindBy(css = "p.content")
    public WebElement reviewAddedMessage;
    public void addProductReview(String reviewTitle,String reviewText){
        setValueToElement(reviewTitleTxt,reviewTitle);
        setValueToElement(reviewTextBox,reviewText);
        clickButton(goodRating);
        clickButton(submitReview);
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailFriendPage extends PageBase{
    public EmailFriendPage(WebDriver driver) {
        super(driver);
    }
    WebElement friendEmailTxt = driver.findElement(By.id("FriendEmail"));
    WebElement personalMessageTxt = driver.findElement(By.id("PersonalMessage"));
    WebElement sendEmailBtn = driver.findElement(By.name("send-email"));
    public WebElement successSentMessage = driver.findElement(By.cssSelector("div.result"));
    public void sendEmailToFriend(String fEmail, String message){
        setValueToElement(friendEmailTxt,fEmail);
        setValueToElement(personalMessageTxt,message);
        clickButton(sendEmailBtn);
    }
}

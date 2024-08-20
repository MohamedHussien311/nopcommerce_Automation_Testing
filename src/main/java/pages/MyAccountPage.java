package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    WebElement changePasswordLink = driver.findElement(By.linkText("Change password"));
    WebElement oldPasswordTxt = driver.findElement(By.id("OldPassword"));
    WebElement newPasswordTxt = driver.findElement(By.id("NewPassword"));
    WebElement confirmPasswordTxt = driver.findElement(By.id("ConfirmNewPassword"));
    WebElement changePasswordBtn = driver.findElement(By.cssSelector("button.button-1.change-password-button"));
    public WebElement passwordUpdatedMessage = driver.findElement(By.cssSelector("p.content"));
    public void openChangePasswordPage(){
        clickButton(changePasswordLink);
    }
    public void changePassword(String oldPassword, String newPassword){
        setValueToElement(oldPasswordTxt,oldPassword);
        setValueToElement(newPasswordTxt,newPassword);
        setValueToElement(confirmPasswordTxt,newPassword);
        clickButton(changePasswordBtn);
    }
}

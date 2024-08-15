package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;
    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;
    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;
    @FindBy(id = "ConfirmNewPassword")
    WebElement confirmPasswordTxt;
    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;
    @FindBy(css = "p.content")
    public WebElement passwordUpdatedMessage;
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

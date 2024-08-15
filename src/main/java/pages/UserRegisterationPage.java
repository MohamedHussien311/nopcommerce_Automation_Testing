package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase{
    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "gender-male")
    WebElement gender;
    @FindBy(id = "FirstName")
    WebElement fNameTxt;
    @FindBy(id = "LastName")
    WebElement lNameTxt;
    @FindBy(id = "Email")
    WebElement emailTxt;
    @FindBy(id = "Password")
    WebElement passwordTxt;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id = "register-button")
    WebElement registerbtn;
    @FindBy(className = "result")
    public WebElement registeredSuccessMessage;
    @FindBy(linkText = "Log out")
    public WebElement logoutLink;
    public void userRegisteration(String fName, String lName, String email, String password){
        clickButton(gender);
        setValueToElement(fNameTxt,fName);
        setValueToElement(lNameTxt,lName);
        setValueToElement(emailTxt,email);
        setValueToElement(passwordTxt,password);
        setValueToElement(confirmPassword,password);
        clickButton(registerbtn);
    }
    public void userLogout(){
        clickButton(logoutLink);
    }
}

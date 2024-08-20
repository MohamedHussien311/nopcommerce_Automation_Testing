package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegisterationPage extends PageBase{
    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }
    WebElement gender = driver.findElement(By.id("gender-male"));
    WebElement fNameTxt = driver.findElement(By.id("FirstName"));
    WebElement lNameTxt = driver.findElement(By.id("LastName"));
    WebElement emailTxt = driver.findElement(By.id("Email"));
    WebElement passwordTxt = driver.findElement(By.id("Password"));
    WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
    WebElement registerbtn = driver.findElement(By.id("register-button"));
    public WebElement registeredSuccessMessage = driver.findElement(By.className("result"));
    public WebElement logoutLink = driver.findElement(By.linkText("Log out"));
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

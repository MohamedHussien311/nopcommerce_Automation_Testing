package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    WebElement emailTxt = driver.findElement(By.id("Email"));
    WebElement passwordTxt = driver.findElement(By.id("Password"));
    WebElement loginBtn = driver.findElement(By.cssSelector("button.button-1.login-button"));
    public void userLogin(String email, String password){
        setValueToElement(emailTxt,email);
        setValueToElement(passwordTxt,password);
        clickButton(loginBtn);
    }
}

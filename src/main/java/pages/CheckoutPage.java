package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    WebElement countryList = driver.findElement(By.id("BillingNewAddress_CountryId"));
    WebElement cityNameTxt = driver.findElement(By.id("BillingNewAddress_City"));
    WebElement addressTxt = driver.findElement(By.id("BillingNewAddress_Address1"));
    WebElement zipCodeTxt = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    WebElement phoneNumberTxt = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    WebElement continueBtn = driver.findElement(By.name("save"));
    WebElement landShippingBtn = driver.findElement(By.id("shippingoption_0"));
    WebElement continueShippingBtn = driver.findElement(By.cssSelector("button.button-1.shipping-method-next-step-button"));
    WebElement payByCreditCardBtn = driver.findElement(By.id("paymentmethod_1"));
    WebElement continuePaymentBtn = driver.findElement(By.cssSelector("button.button-1.payment-method-next-step-button"));
    WebElement cardHolderNameTxt = driver.findElement(By.id("CardholderName"));
    WebElement cardNumberTxt = driver.findElement(By.id("CardNumber"));
    WebElement cardCodeTxt = driver.findElement(By.id("CardCode"));
    WebElement expireMonthList = driver.findElement(By.id("ExpireMonth"));
    WebElement expireYearList = driver.findElement(By.id("ExpireYear"));
    WebElement paymentNextBtn = driver.findElement(By.cssSelector("button.button-1.payment-info-next-step-button"));
    WebElement confirmBtn = driver.findElement(By.cssSelector("button.button-1.confirm-order-next-step-button"));
    public WebElement successCheckoutMessage = driver.findElement(By.cssSelector("div.title"));
    WebElement orderDetailsLink = driver.findElement(By.linkText("Click here for order details."));
    public void billingAddress(String countryName,String cityName,String address,String zipCode,String phoneNumber){
        select = new Select(countryList);
        select.selectByVisibleText(countryName);
        setValueToElement(cityNameTxt,cityName);
        setValueToElement(addressTxt,address);
        setValueToElement(zipCodeTxt,zipCode);
        setValueToElement(phoneNumberTxt,phoneNumber);
        clickButton(continueBtn);
    }
    public void shippingAddress(){
        clickButton(landShippingBtn);
        clickButton(continueShippingBtn);
    }
    public void paymentMethod(){
        clickButton(payByCreditCardBtn);
        clickButton(continuePaymentBtn);
    }
    public void paymentInformation(String cardHolderName,String cardNumber,
                                   String expireMonth,String expireYear,String cardCode)
    {
        setValueToElement(cardHolderNameTxt,cardHolderName);
        setValueToElement(cardNumberTxt,cardNumber);
        select = new Select(expireMonthList);
        select.selectByVisibleText(expireMonth);
        select = new Select(expireYearList);
        select.selectByVisibleText(expireYear);
        setValueToElement(cardCodeTxt,cardCode);
        clickButton(paymentNextBtn);
    }
    public void confirmOrder(){
        clickButton(confirmBtn);
    }
    public void openOrderDetailsPage(){
        clickButton(orderDetailsLink);
    }
}

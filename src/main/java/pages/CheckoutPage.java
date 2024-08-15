package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryList;
    @FindBy(id = "BillingNewAddress_City")
    WebElement cityNameTxt;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement addressTxt;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zipCodeTxt;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberTxt;
    @FindBy(name = "save")
    WebElement continueBtn;
    @FindBy(id = "shippingoption_0")
    WebElement landShippingBtn;
    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement continueShippingBtn;
    @FindBy(id = "paymentmethod_1")
    WebElement payByCreditCardBtn;
    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement continuePaymentBtn;
    @FindBy(id = "CardholderName")
    WebElement cardHolderNameTxt;
    @FindBy(id = "CardNumber")
    WebElement cardNumberTxt;
    @FindBy(id = "CardCode")
    WebElement cardCodeTxt;
    @FindBy(id = "ExpireMonth")
    WebElement expireMonthList;
    @FindBy(id = "ExpireYear")
    WebElement expireYearList;
    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement paymentNextBtn;
    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement confirmBtn;
    @FindBy(css = "div.title")
    public WebElement successCheckoutMessage;
    @FindBy(linkText = "Click here for order details.")
    WebElement orderDetailsLink;
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

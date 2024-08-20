package tests;

import com.github.javafaker.CreditCardType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class OrderCheckoutTest extends TestBase{
    HomePage homePage = new HomePage(driver);
    UserRegisterationPage userRegisterationPage = new UserRegisterationPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password =String.valueOf( fakeData.number().digits(8));
    String productName = "Apple MacBook Pro 13-inch";
    String countryName = fakeData.country().name();
    String cityName = fakeData.address().cityName();
    String address = fakeData.address().fullAddress();
    String zipCode =String.valueOf( fakeData.number().digits(8));
    String pNumber = String.valueOf(fakeData.number().digits(11));
    String cardHolderName = fakeData.name().fullName();
    String cardNumber = fakeData.finance().creditCard(CreditCardType.VISA);
    String expireMonth = "02";
    String expireYear = String.valueOf(fakeData.number().numberBetween(2025,2038));
    String cardCode = String.valueOf(fakeData.number().digits(3));
    @Test(priority = 1)
    public void UserCanRegisterSuccessfully(){
        homePage.openReigisterationPage();
        userRegisterationPage.userRegisteration(firstName,lastName,
                email,password);
        Assert.assertEquals(userRegisterationPage.registeredSuccessMessage.getText()
                ,"Your registration completed");
    }
    @Test(priority = 2)
    public void userCanSearchForProduct(){
        searchPage.searchForProduct(productName);
        searchPage.openProductDetailsPage();
        Assert.assertEquals(productDetailsPage.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 3)
    public void UserCanAddProductToCart(){
        productDetailsPage.addProductToCart();
        productDetailsPage.openCartLink.click();
        Assert.assertEquals(shoppingCartPage.productNameCell.getText(),productName);
    }
    @Test(priority = 4)
    public void RegisteredUserCanCheckoutOrder(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        shoppingCartPage.openCheckoutPage();
        checkoutPage.billingAddress(countryName,cityName,address,zipCode,pNumber);
        checkoutPage.shippingAddress();
        checkoutPage.paymentMethod();
        checkoutPage.paymentInformation(cardHolderName,cardNumber,expireMonth,expireYear,cardCode);
        checkoutPage.confirmOrder();
        Assert.assertEquals(checkoutPage.successCheckoutMessage.getText(),
                "Your order has been successfully processed!");
        checkoutPage.openOrderDetailsPage();
        orderDetailsPage.printOrderDetails();
        orderDetailsPage.downloadOrderDetailsPDF();
    }
}

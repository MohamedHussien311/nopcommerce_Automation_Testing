package tests;

import com.github.javafaker.CreditCardType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class OrderCheckoutTest extends TestBase{
    HomePage homePage ;
    UserRegisterationPage userRegisterationPage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;
    OrderDetailsPage orderDetailsPage;
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
        homePage = new HomePage(driver);
        homePage.openReigisterationPage();
        userRegisterationPage = new UserRegisterationPage(driver);
        userRegisterationPage.userRegisteration(firstName,lastName,
                email,password);
        Assert.assertEquals(userRegisterationPage.registeredSuccessMessage.getText()
                ,"Your registration completed");
    }
    @Test(priority = 2)
    public void userCanSearchForProduct(){
        searchPage = new SearchPage(driver);
        searchPage.searchForProduct(productName);
        searchPage.openProductDetailsPage();
        productDetailsPage = new ProductDetailsPage(driver);
        Assert.assertEquals(productDetailsPage.productNameBreadCrumb.getText(),productName);
    }
    @Test(priority = 3)
    public void UserCanAddProductToCart(){
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addProductToCart();
        productDetailsPage.openCartLink.click();
        shoppingCartPage = new ShoppingCartPage(driver);
        Assert.assertEquals(shoppingCartPage.productNameCell.getText(),productName);
    }
    @Test(priority = 4)
    public void RegisteredUserCanCheckoutOrder(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openCheckoutPage();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.billingAddress(countryName,cityName,address,zipCode,pNumber);
        checkoutPage.shippingAddress();
        checkoutPage.paymentMethod();
        checkoutPage.paymentInformation(cardHolderName,cardNumber,expireMonth,expireYear,cardCode);
        checkoutPage.confirmOrder();
        Assert.assertEquals(checkoutPage.successCheckoutMessage.getText(),
                "Your order has been successfully processed!");
        checkoutPage.openOrderDetailsPage();
        orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.printOrderDetails();
        orderDetailsPage.downloadOrderDetailsPDF();
    }
}

package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class CartTests extends BaseTest {

    @Test
    public void checkItemsInCart() {
        System.out.println("CartTest is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login(withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage.addToCartClick("Sauce Labs Fleece Jacket");
        productsPage.addToCartClick("Sauce Labs Backpack");
        productsPage.switchToCart();
        assertEquals(cartPage.getProductsNames().size(), 2);
    }
}

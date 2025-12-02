package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTests extends Setup {

    @Test
    public void checkItemsInCart() {
        System.out.println("CartTest is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageLoaded("Products");
        productsPage.addToCartClick("Sauce Labs Fleece Jacket");
        productsPage.addToCartClick("Sauce Labs Backpack");
        productsPage.switchToCart();
        assertEquals(cartPage.getProductsNames().size(), 2);
    }
}

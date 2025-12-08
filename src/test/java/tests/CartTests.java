package tests;

import enums.Titles;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class CartTests extends BaseTest {

    @Test
    public void checkItemsInCart() {
        loginPage.openPage();
        loginPage.login(withAdminPermission());

        productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName());
        productsPage.addToCartClick("Sauce Labs Fleece Jacket");
        productsPage.addToCartClick("Sauce Labs Backpack");
        productsPage.switchToCart();

        assertEquals(cartPage.getProductsNames().size(), 2);
    }
}

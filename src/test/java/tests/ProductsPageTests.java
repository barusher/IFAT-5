package tests;

import enums.Titles;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsPageTests extends BaseTest {

    @Test
    public void checkItemPage() {
        loginPage.openPage();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName()), "Page didn`t open");

        productsPage.showProductItem(By.xpath("//div[text()='Sauce Labs Backpack']"));
        assertTrue(productsPage.isBackToProductButtonAppear(), "Back to products button isn`t appear");
    }

    @Test
    public void checkAddItems() {
        loginPage.openPage();
        loginPage.login(withAdminPermission());

        productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName());
        productsPage.addToCartClick("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCartClick("Sauce Labs Bolt T-Shirt");
        productsPage.addToCartClick(3);
        assertEquals(productsPage.checkCartCounter(), 3);
    }
}

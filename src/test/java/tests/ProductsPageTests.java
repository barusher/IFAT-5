package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsPageTests extends Setup {

    @Test
    public void checkItemPage() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded("Products"), "Page didn`t open");
        productsPage.showProductItem(By.xpath("//div[text()='Sauce Labs Backpack']"));

        assertTrue(productsPage.isBackToProductButtonAppear(), "Back to products button isn`t appear");
    }

    @Test
    public void checkAddItems() {
        System.out.println("ProductTest is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageLoaded("Products");
        productsPage.addToCartClick("Test.allTheThings() T-Shirt (Red)");
        productsPage.addToCartClick("Sauce Labs Bolt T-Shirt");
        productsPage.addToCartClick(3);
        assertEquals(productsPage.checkCartCounter(), 3);
    }
}

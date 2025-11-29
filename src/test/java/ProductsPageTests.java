import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProductsPageTests extends ChromeSetup {
    @Test
    public void checkItemPage() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isPageLoaded(), "Page didn`t open");
        productsPage.showProductItem(By.xpath("//div[text()='Sauce Labs Backpack']"));

        assertTrue(productsPage.isBackToProductButtonAppear(), "Back to products button isn`t appear");
    }
}

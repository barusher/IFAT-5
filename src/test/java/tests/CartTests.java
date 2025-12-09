package tests;

import enums.Titles;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

@Epic("Корзина покупок")
@Feature("Управление корзиной")
@Owner("Baranov Alex, tg=@brnvvv")
public class CartTests extends BaseTest {

    @Epic("Корзина покупок")
    @Feature("Содержимое корзины")
    @Story("Проверка добавленных товаров в корзине")
    @TmsLink("IFAT-9")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Baranov Alex, tg=@brnvvv")
    @Test(description = "Проверка количества добавленных товаров в корзине")
    public void checkItemsInCart() {
        Allure.step("Открытие страницы логина");
        loginPage.openPage();

        Allure.step("Авторизация с административными правами");
        loginPage.login(withAdminPermission());

        Allure.step("Проверка загрузки страницы продуктов");
        productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName());

        Allure.step("Добавление товара 'Sauce Labs Fleece Jacket' в корзину");
        productsPage.addToCartClick("Sauce Labs Fleece Jacket");

        Allure.step("Добавление товара 'Sauce Labs Backpack' в корзину");
        productsPage.addToCartClick("Sauce Labs Backpack");

        Allure.step("Переход в корзину");
        productsPage.switchToCart();

        Allure.step("Проверка количества товаров в корзине (должно быть 2)");
        assertEquals(cartPage.getProductsNames().size(), 2,
                "Неверное количество товаров в корзине");
    }
}
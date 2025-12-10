package tests;

import enums.Titles;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Epic("Каталог товаров")
@Feature("Страница продуктов")
@Owner("Baranov Alex, tg=@brnvvv")
@Tag("products")
public class ProductsPageTests extends BaseTest {

    @Epic("Каталог товаров")
    @Feature("Навигация по товарам")
    @Story("Просмотр детальной страницы товара")
    @TmsLink("IFAT-5")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Baranov Alexandr, tg=@brnvvv")
    @Test(description = "Проверка перехода на страницу товара и возврата назад")
    public void checkItemPage() {
        Allure.step("Открытие страницы логина и авторизация");
        loginPage
                .openPage()
                .login(withAdminPermission());

        Allure.step("Проверка загрузки страницы продуктов");
        assertTrue(productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName()),
                "Страница продуктов не загрузилась");

        Allure.step("Открытие детальной страницы товара 'Sauce Labs Backpack'");
        productsPage.showProductItem(By.xpath("//div[text()='Sauce Labs Backpack']"));

        Allure.step("Проверка отображения кнопки 'Назад к товарам'");
        assertTrue(productsPage.isBackToProductButtonAppear(),
                "Кнопка 'Назад к товарам' не отображается");
    }

    @Epic("Каталог товаров")
    @Feature("Корзина покупок")
    @Story("Добавление товаров в корзину")
    @TmsLink("IFAT-5")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Baranov Alexandr, tg=@brnvvv")
    @Test(description = "Проверка добавления нескольких товаров в корзину и счетчика корзины")
    public void checkAddItems() {
        Allure.step("Открытие страницы логина и авторизация");
        loginPage
                .openPage()
                .login(withAdminPermission());

        Allure.step("Проверка загрузки страницы продуктов");
        productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName());

        Allure.step("Добавление товара 'Test.allTheThings() T-Shirt (Red)' в корзину");
        productsPage.addToCartClick("Test.allTheThings() T-Shirt (Red)");

        Allure.step("Добавление товара 'Sauce Labs Bolt T-Shirt' в корзину");
        productsPage.addToCartClick("Sauce Labs Bolt T-Shirt");

        Allure.step("Добавление третьего товара по индексу в корзину");
        productsPage.addToCartClick(3);

        Allure.step("Проверка счетчика корзины (должно быть 3 товара)");
        assertEquals(productsPage.checkCartCounter(), 3,
                "Неверное количество товаров в корзине");
    }
}
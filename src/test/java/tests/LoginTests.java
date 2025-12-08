package tests;

import enums.Titles;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTests extends BaseTest {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withEmptyEmailPermission(), "Epic sadface: Username is required"},
                {UserFactory.withEmptyPasswordPermission(), "Epic sadface: Password is required"},
                {UserFactory.withIncorrectEmailPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Авторизация")
    @Feature("Негативные сценарии")
    @Story("Логин с различными некорректными данными")
    @TmsLink("IFAT-5")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Baranov Alex, tg=@brnvvv")
    @Test(dataProvider = "loginData")
    public void incorrectLoginTest(User user, String error) {
        loginPage.openPage();
        loginPage.login(user);
        assertTrue(loginPage.isErrorMessageAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), error);
    }

    @Epic("Авторизация")
    @Feature("Позитивные сценарии")
    @Story("Успешный логин с валидными данными")
    @TmsLink("IFAT-5")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Baranov Alexandr, tg=@brnvvv")
    @Test
    public void correctLoginTest() {
        loginPage.openPage();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isPageLoaded(Titles.PRODUCTS.getDisplayName()), "Page didn`t open");
    }
}

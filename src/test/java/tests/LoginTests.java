package tests;

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

    @Test(dataProvider = "loginData")
    public void incorrectLoginTest(User user, String error) {
        System.out.println("LoginTest incorrect is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login(user);
        assertTrue(loginPage.isErrorMessageAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), error);
    }

    @Test
    public void correctLoginTest() {
        System.out.println("LoginTest correct is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.isPageLoaded("Products"), "Page didn`t open");
    }
}

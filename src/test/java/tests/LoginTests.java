package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standart_user", "", "Epic sadface: Password is required"},
                {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData")
    public void incorrectLoginTest(String user, String password, String error) {
        System.out.println("LoginTest incorrect is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMessageAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), error);
    }

    @Test
    public void correctLoginTest() {
        System.out.println("LoginTest correct is running is thread : " + Thread.currentThread().getId());
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded("Products"), "Page didn`t open");
    }
}

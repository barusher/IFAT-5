import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends ChromeSetup {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standart_user", "", "Epic sadface: Password is required"},
                {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "loginData", description = "Проверка захода на сайт под невалидным логином, но с правильным паролем")
    public void incorrectLoginTest(String user, String password, String error) {
        loginPage.openPage();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMessageAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), error);
    }

    @Test(description = "Проверка захода на сайт под валидным логином и паролем")
    public void correctLoginTest() throws InterruptedException {
        loginPage.openPage();
        Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
        assertTrue(productsPage.isPageLoaded("Products"), "Page didn`t open");
    }


}

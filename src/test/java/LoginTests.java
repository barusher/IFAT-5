import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends ChromeSetup {

    @Test
    public void correctLoginTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageLoaded(), "Page didn`t open");
    }

    @Test
    public void incorrectLoginTest() {
        loginPage.openPage();
        loginPage.login("locked_out_user", "secret_sauce");
        assertTrue(loginPage.isErrorMessageAppear(), "Error message does not appear");
        assertEquals(loginPage.errorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}

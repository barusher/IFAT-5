import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends ChromeSetup {

    @Test
    public void correctLoginTest() throws InterruptedException {
        loginPage.openPage();
        Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(5000);
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

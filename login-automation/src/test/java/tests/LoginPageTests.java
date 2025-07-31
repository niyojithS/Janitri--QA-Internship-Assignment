package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginPageTests extends BaseTest {

    @Test(priority = 1)
    public void handleNotificationReloadPage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement reloadBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Reload')]")));
            reloadBtn.click();
            System.out.println("Test 1: handleNotificationReloadPage - Passed (Reload button clicked)");
        } catch (Exception e) {
            System.out.println("Test 1: handleNotificationReloadPage - Skipped (Reload button not present)");
        }
    }
    @Test(priority = 2)
    public void testLoginButtonEnabledWhenFieldsAreEmpty() {
        LoginPage login = new LoginPage(driver);
        boolean isEnabled = login.isLoginButtonEnabled();

        if (isEnabled) {
            System.out.println("Test 2: testLoginButtonEnabledWhenFieldsAreEmpty - Passed (Login button is enabled)");
            Assert.assertTrue(true);
        } else {
            System.out.println("Test 2 FAILED: Login button is disabled when it should be enabled.");
            Assert.fail("Login button should be enabled even when fields are empty.");
        }
    }


    @Test(priority = 3)
    public void testPasswordMaskedButton() {
        LoginPage login = new LoginPage(driver);
        login.enterPassword("123456");

        Assert.assertEquals(login.getPasswordFieldType(), "password", "Password should be masked by default");
        login.clickPasswordToggle();
        Assert.assertEquals(login.getPasswordFieldType(), "text", "Password should be visible after clicking eye icon");

        System.out.println("Test 3: testPasswordMaskedButton - Passed");
    }

    @Test(priority = 4)
    public void testInvalidLoginShowsErrorMsg() {
        LoginPage login = new LoginPage(driver);
        login.enterUsername("invaliduser");
        login.enterPassword("invalidpass");
        login.clickLogin();

        try {
            Thread.sleep(2000);
            String error = login.getErrorMessage();
            System.out.println("Login failed: " + error);
            Assert.assertTrue(error != null && !error.trim().isEmpty(), "Error message should be displayed for invalid login");
            System.out.println("Test 4: testInvalidLoginShowsErrorMsg - Passed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Test 4: testInvalidLoginShowsErrorMsg - Failed");
            Assert.fail("Failed to capture error message for invalid login.");
        }
    }

    @Test(priority = 5)
    public void testPageElementsPresence() {
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isElementDisplayed(By.id("formEmail")), "Username field is not visible");
        Assert.assertTrue(loginPage.isElementDisplayed(By.id("formPassword")), "Password field is not visible");
        Assert.assertTrue(loginPage.isElementDisplayed(By.xpath("//button[@class='login-button']")), "Login button is not visible");
        Assert.assertTrue(loginPage.isElementDisplayed(By.xpath("//img[@class='passowrd-visible']")), "Eye icon is not visible");

        System.out.println("All page elements are visible as expected.");
    }


}



package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setup() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://login.salesforce.com/?locale=in");
            loginPage = new LoginPage(driver);
        } catch (Exception e) {
             throw new RuntimeException("Failed to initialize driver: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidLogin() {
        try {
            loginPage.doLogin("invalid_user@test.com", "wrong_password");
            
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login");
            String errorText = loginPage.getErrorMessageText();
            Assert.assertTrue(errorText.contains("Please check your username and password"), "Error message text does not match expected");
            
        } catch (Exception e) {
             Assert.fail("Exception during invalid login test: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

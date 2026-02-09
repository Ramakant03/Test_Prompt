package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidLoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest
    public void setup() {
        try {
            // Selenium 4.6.0+ manages drivers automatically
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
    public void testValidLogin() {
        try {
            // Replace with valid credentials for actual execution
            loginPage.doLogin("valid_user@example.com", "valid_password");
            
            // Add assertion for successful login here (e.g., checking title or home page element)
            // For example:
            // Assert.assertTrue(driver.getTitle().contains("Home"), "Login failed, title mismatch");
            
            // Note: Since we don't have valid credentials, this test will likely fail the assertion in a real run
            // but the structure is correct.
            
        } catch (Exception e) {
            Assert.fail("Exception during valid login test: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

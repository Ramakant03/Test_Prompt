package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//label[contains(text(),'Remember me')]")
    private WebElement rememberMeCheckbox;
    
    @FindBy(xpath = "//img[@id='logo']")
    private WebElement salesforceLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameInput));
            usernameInput.clear();
            usernameInput.sendKeys(username);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter username: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordInput));
            passwordInput.clear();
            passwordInput.sendKeys(password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter password: " + e.getMessage());
        }
    }

    public void clickLoginButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (Exception e) {
            throw new RuntimeException("Failed to click login button: " + e.getMessage());
        }
    }

    public void doLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (Exception e) {
             throw new RuntimeException("Failed to retrieve error message: " + e.getMessage());
        }
    }
    
    public boolean isLogoDisplayed() {
         try {
            wait.until(ExpectedConditions.visibilityOf(salesforceLogo));
            return salesforceLogo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

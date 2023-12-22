package main.java.com.quill.pages.cowriter;

import com.aventstack.extentreports.ExtentReports;
import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class CwGuestUserPage extends CwEditorPage {
    WebDriver driver;
    public static ExtentReports extent = new ExtentReports();

    //Co-Writer login page Web Elements
    @FindBy(xpath = "//a[contains(text(),'Co-Writer')]")
    WebElement cwBottomBarLink;

    @FindBy(linkText = "Don't have an account?")
    WebElement doNotHaveAccountButton;

    @FindBy(xpath = "//input[@id='username']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[text()='Skip']")
    WebElement skipButton;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement popupContinueButton;

    @FindBy(xpath = "//p[text()='Learn the Basics']")
    WebElement learnTheBasics;

    public CwGuestUserPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getLearnTheBasics() {
        return learnTheBasics;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100000);
    }

    public void enterEmail() {
        enterText(emailField, "auto" + generateRandomNumber() + "@qb.com");
    }

    public void enterUserDetails() {
        try {
            clickElement(passwordField);
            passwordField.sendKeys("test@123");
            clickElement(nameField);
            nameField.sendKeys("Test User");
            clickElement(continueButton);
            WaitsTwo.waitForElementToBeVisible(driver, skipButton);
            clickElement(skipButton);
            WaitsTwo.waitForElementToBeVisible(driver, popupContinueButton);
            clickElement(popupContinueButton);
        } catch (Exception e) {
            driver.navigate().refresh();
        }
    }

    public void cowBottomLink() {
        WaitsTwo.waitForElementToBeVisible(driver, cwBottomBarLink);
        clickElement(cwBottomBarLink);
    }

    public void clickDoNotHaveAccount() {
        WaitsTwo.waitForElementToBeVisible(driver, doNotHaveAccountButton);
        clickElement(doNotHaveAccountButton);
    }
}

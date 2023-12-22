package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CwEditorWritingAreaPage extends CwEditorPage {
    WebDriver driver;
    //Co-Writer writing area Web Elements
    @FindBy(css = "div[id=\"editor-placeholder\"]")
    @CacheLookup
    WebElement editorPlaceholder;

    @FindBy(xpath = "//button[text() = 'Paste Text']")
    @CacheLookup
    WebElement pasteTextButton;

    @FindBy(xpath = "//button[text() = 'Upload Doc']")
    @CacheLookup
    WebElement uploadDocButton;

    @FindBy(xpath = "//button[text() = 'Suggest Outline']")
    @CacheLookup
    WebElement suggestOutlineButton;

    @FindBy(xpath = "//input[@placeholder= 'Enter your topic with a brief description (Ex: Benefits of doing yoga in the morning)']")
    @CacheLookup
    WebElement outlinePlaceholder;

    @FindBy(xpath = "//p[text() = 'Generate']")
    @CacheLookup
    WebElement outlineGenerateButton;

    @FindBy(xpath = "//p[text() = 'Insert to Editor']")
    @CacheLookup
    WebElement outlinesInsertButton;

    @FindBy(id = "fileUpload")
    @CacheLookup
    WebElement uploadFile;

    @FindBy(id = "RESEARCH_EDITOR")
    WebElement writingArea;

    @FindBy(xpath = "//span[text()='Research']")
    @CacheLookup
    WebElement editorResearchButton;

    @FindBy(css = "[data-testid=\"SearchIcon\"]")
    @CacheLookup
    WebElement searchIcon;

    public CwEditorWritingAreaPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEditorPlaceholder() {
        return editorPlaceholder;
    }

    public WebElement getPasteTextButton() {
        return pasteTextButton;
    }

    public WebElement getUploadDocButton() {
        return uploadDocButton;
    }

    public WebElement getOutlinesInsertButton() {
        return outlinesInsertButton;
    }

    public WebElement getWritingArea() {
        return writingArea;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    //Co-Writer writing editor methods
    public String enterTextInEditor(String text) {
        return ConfigUtil.getDataFile("cowriter.json", text);
    }

    public void writingEditor(String text) {
        clickWritingArea();
        writingArea.sendKeys(text);
        WaitsTwo.waitForElementToBeVisible(driver, savedJustNowIcon);
    }

    public void clickWritingArea() {
        clickElement(writingArea);
    }

    public void uploadDoc() {
        clickElement(uploadDocButton);
        String filepath = System.getProperty("user.dir") + "/src/test/resources/testdata/sample.pdf";
        uploadFile.sendKeys(filepath);
        WaitsTwo.waitForElementToBeVisible(driver, projectTitleField);
    }

    public void suggestOutline() {
        WaitsTwo.waitForElementToBeVisible(driver, suggestOutlineButton);
        clickElement(suggestOutlineButton);
        WaitsTwo.waitForElementToBeVisible(driver, outlineGenerateButton);
    }

    public void generateOutline() throws InterruptedException {
        outlinePlaceholder.sendKeys(ConfigUtil.getDataFile("cowriter.json", "suggestOutlineSearchText"));
        clickElement(outlineGenerateButton);
        Thread.sleep(3000);
        WaitsTwo.waitForElementToBeVisible(driver, outlinesInsertButton);
    }

    public void insertOutline() {
        clickElement(outlinesInsertButton);
        WaitsTwo.waitForElementToBeInvisible(driver, outlinesInsertButton);
    }

    public void researchButton() {
        WaitsTwo.waitForElementToBeVisible(driver, editorResearchButton);
        clickElement(editorResearchButton);
        WaitsTwo.waitForElementToBeVisible(driver, searchIcon);
    }

    public void selectEditorText() {
        WaitsTwo.waitForElementToBeVisible(driver, writingArea);
        if (writingArea.isDisplayed() && writingArea.isEnabled()) {
            Actions a = new Actions(driver);
            if (device.equalsIgnoreCase("windows")) {
                a.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL);
            } else {
                a.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND);
            }
            a.moveToElement(writingArea);
            a.build().perform();
        } else {
            Assert.fail("User is not able to select the editor text");
        }
    }

    public void addCitationHotKeys() throws InterruptedException {
        if (writingArea.isDisplayed() && writingArea.isEnabled()) {
            Actions a = new Actions(driver);
            if (device.equalsIgnoreCase("windows")) {
                a.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("C").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT);
            } else {
                a.keyDown(Keys.COMMAND).keyDown(Keys.SHIFT).sendKeys("C").keyUp(Keys.COMMAND).keyUp(Keys.SHIFT);
            }
            a.click().build().perform();
            Thread.sleep(3000);
        }
    }
}

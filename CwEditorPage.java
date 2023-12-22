package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.com.quill.tests.BaseTestTwo;

import java.util.List;

public class CwEditorPage extends BaseTestTwo {
    WebDriver driver;
    public String device = ConfigUtil.getpropertyvalue("DEVICE").toLowerCase();

    //Co-Writer Editor page Web Elements
    @FindBy(xpath = "//h6[text() = 'Loading...']")
    WebElement pageLoader;

    @FindBy(css = "[aria-label=\"Unsaved\"]")
    WebElement unsavedIcon;

    @FindBy(css = "[aria-label=\"Saved just now\"]")
    WebElement savedJustNowIcon;

    @FindBy(css = "span[aria-label=\"Co-Writer Home\"]")
    @CacheLookup
    WebElement coWriterHomeIcon;

    @FindBy(css = "input[data-testid=\"page_header/title\"]")
    WebElement projectTitleField;

    @FindBy(xpath = "//div[text()='Preparing your file for download. Please wait.']")
    WebElement projectExportMessage;

    //Co-Writer Editor Research/Notes/Citations Web Elements
    @FindBy(css = "[data-testid=\"globe-search-icon\"]")
    @CacheLookup
    List<WebElement> researchTabIcon;

    @FindBy(xpath = "//div[text() = 'Research']")
    @CacheLookup
    WebElement researchOption;

    @FindBy(css = "[data-testid=\"notes-icon\"]")
    @CacheLookup
    List<WebElement> notesTabIcon;

    @FindBy(xpath = "//div[text() = 'Notes']")
    @CacheLookup
    WebElement notesOption;

    @FindBy(css = "[data-testid=\"quote-icon\"]")
    @CacheLookup
    List<WebElement> citationsTabIcon;

    @FindBy(xpath = "//div[text() = 'Citations']")
    @CacheLookup
    WebElement citationsOption;

    @FindBy(xpath = "//div[text() = 'Feedback']")
    @CacheLookup
    WebElement editorFeedBack;

    @FindBy(css = "[data-testid=\"page_editor/bib_page\"]")
    WebElement bibPage;

    //Co-Writer Editor Menu bar Web Elements
    @FindBy(xpath = "//div[@role=\"menubar\"]//span[text() ='File']")
    @CacheLookup
    WebElement menuBarFile;

    @FindBy(xpath = "//div[@role=\"menubar\"]//span[text() ='Edit']")
    @CacheLookup
    WebElement menuBarEdit;

    @FindBy(xpath = "//div[@role=\"menubar\"]//span[text() ='Insert']")
    @CacheLookup
    WebElement menuBarInsert;

    @FindBy(xpath = "//div[@role=\"menubar\"]//span[text() ='Format']")
    @CacheLookup
    WebElement menuBarFormat;

    @FindBy(xpath = "//div[@role=\"menubar\"]//span[text() ='Help']")
    @CacheLookup
    WebElement menuBarHelp;

    @FindBy(css = "div[title=\"Copy\"]")
    @CacheLookup
    WebElement editMenuCopy;

    @FindBy(xpath = "//div[text()='Delete']")
    @CacheLookup
    WebElement menuBarDelete;

    @FindBy(xpath = "//p[text()='Cancel']")
    @CacheLookup
    WebElement deleteCancel;

    @FindBy(xpath = "//p[text()='Move to trash']")
    @CacheLookup
    WebElement moveToTrash;

    public CwEditorPage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getProjectTitleField() {
        return projectTitleField;
    }

    public WebElement getProjectExportMessage() {
        return projectExportMessage;
    }

    public List<WebElement> getResearchTabIcon() {
        return researchTabIcon;
    }

    public WebElement getResearchOption() {
        return researchOption;
    }

    public List<WebElement> getNotesTabIcon() {
        return notesTabIcon;
    }

    public WebElement getNotesOption() {
        return notesOption;
    }

    public List<WebElement> getCitationsTabIcon() {
        return citationsTabIcon;
    }

    public WebElement getCitationsOption() {
        return citationsOption;
    }

    public WebElement getEditorFeedBack() {
        return editorFeedBack;
    }

    public WebElement getBibPage() {
        return bibPage;
    }

    public WebElement getMenuBarFile() {
        return menuBarFile;
    }

    public WebElement getMenuBarEdit() {
        return menuBarEdit;
    }

    public WebElement getMenuBarInsert() {
        return menuBarInsert;
    }

    public WebElement getMenuBarFormat() {
        return menuBarFormat;
    }

    public WebElement getMenuBarHelp() {
        return menuBarHelp;
    }

    public WebElement getSavedJustNowIcon() {
        return savedJustNowIcon;
    }

    public CwEditorPage clickElement(final WebElement element) {
        WaitsTwo.waitForElementToBeVisible(driver, element);
        if (element.isEnabled()) {
            element.click();
        } else {
            Assert.fail("User is not able to click " + element);
        }
        return this;
    }

    public void enterText(final WebElement element, String text) {
        WaitsTwo.waitForElementToBeVisible(driver, element);
        if (element.isEnabled()) {
            element.sendKeys(text);
        } else {
            Assert.fail("User is not able to enter text in the " + element);
        }
    }

    public void clickEditMenu() {
        clickElement(menuBarEdit);
    }

    public void clickEditMenuCopy() {
        clickElement(editMenuCopy);
    }

    public void menuBarDelete() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, menuBarFile);
        clickElement(menuBarFile);
        WaitsTwo.waitForElementToBeVisible(driver, menuBarDelete);
        clickElement(menuBarDelete);
        Thread.sleep(3000);
    }

    public void deleteCancelButton() {
        WaitsTwo.waitForElementToBeVisible(driver, deleteCancel);
        clickElement(deleteCancel);
    }

    public void moveToTrashButton() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, moveToTrash);
        clickElement(moveToTrash);
        Thread.sleep(5000);
    }
}

package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CwEditorToolBarPage extends CwEditorPage {
    WebDriver driver;
    //Co-Writer Editor Toolbar Web Elements
    @FindBy(css = "button[aria-label=\"Undo\"]")
    @CacheLookup
    WebElement toolbarUndoIcon;

    @FindBy(css = "button[aria-label=\"Redo\"]")
    @CacheLookup
    WebElement toolbarRedoIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Formats\"]")
    @CacheLookup
    WebElement toolbarFormatDropdown;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Fonts\"]")
    @CacheLookup
    WebElement toolbarFontsDropdown;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Bold\"]")
    @CacheLookup
    WebElement toolbarBoldIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Italic\"]")
    @CacheLookup
    WebElement toolbarItalicIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Underline\"]")
    @CacheLookup
    WebElement toolbarUnderlineIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Text color\"]")
    @CacheLookup
    WebElement toolbarTextColorIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Background color\"]")
    @CacheLookup
    WebElement toolbarBackgroundColorIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Align left\"]")
    @CacheLookup
    WebElement toolbarAlignLeftIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Align center\"]")
    @CacheLookup
    WebElement toolbarAlignCenterIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Align right\"]")
    @CacheLookup
    WebElement toolbarAlignRightIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Justify\"]")
    @CacheLookup
    WebElement toolbarJustifyIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Line height\"]")
    @CacheLookup
    WebElement toolbarLineHeightIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Bullet list\"]")
    @CacheLookup
    WebElement toolbarBulletListIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Numbered list\"]")
    @CacheLookup
    WebElement toolbarNumberedListIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Decrease indent\"]")
    @CacheLookup
    WebElement toolbarDecreaseIndentIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Increase indent\"]")
    @CacheLookup
    WebElement toolbarIncreaseIndentIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Clear formatting\"]")
    @CacheLookup
    WebElement toolbarClearFormattingIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Print\"]")
    @CacheLookup
    WebElement toolbarPrintIcon;

    @FindBy(css = "div[role=\"toolbar\"] [aria-label=\"Export\"]")
    @CacheLookup
    WebElement toolbarExportIcon;

    @FindBy(css = "[id=\"menu-tool-bar-container\"] + div>div button")
    WebElement accountIcon;

    public CwEditorToolBarPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getToolbarUndoIcon() {
        return toolbarUndoIcon;
    }

    public WebElement getToolbarRedoIcon() {
        return toolbarRedoIcon;
    }

    public WebElement getToolbarFormatDropdown() {
        return toolbarFormatDropdown;
    }

    public WebElement getToolbarFontsDropdown() {
        return toolbarFontsDropdown;
    }

    public WebElement getToolbarBoldIcon() {
        return toolbarBoldIcon;
    }

    public WebElement getToolbarItalicIcon() {
        return toolbarItalicIcon;
    }

    public WebElement getToolbarUnderlineIcon() {
        return toolbarUnderlineIcon;
    }

    public WebElement getToolbarTextColorIcon() {
        return toolbarTextColorIcon;
    }

    public WebElement getToolbarBackgroundColorIcon() {
        return toolbarBackgroundColorIcon;
    }

    public WebElement getToolbarAlignLeftIcon() {
        return toolbarAlignLeftIcon;
    }

    public WebElement getToolbarAlignCenterIcon() {
        return toolbarAlignCenterIcon;
    }

    public WebElement getToolbarAlignRightIcon() {
        return toolbarAlignRightIcon;
    }

    public WebElement getToolbarJustifyIcon() {
        return toolbarJustifyIcon;
    }

    public WebElement getToolbarLineHeightIcon() {
        return toolbarLineHeightIcon;
    }

    public WebElement getToolbarBulletListIcon() {
        return toolbarBulletListIcon;
    }

    public WebElement getToolbarNumberedListIcon() {
        return toolbarNumberedListIcon;
    }

    public WebElement getToolbarDecreaseIndentIcon() {
        return toolbarDecreaseIndentIcon;
    }

    public WebElement getToolbarIncreaseIndentIcon() {
        return toolbarIncreaseIndentIcon;
    }

    public WebElement getToolbarClearFormattingIcon() {
        return toolbarClearFormattingIcon;
    }

    public WebElement getToolbarPrintIcon() {
        return toolbarPrintIcon;
    }

    public WebElement getToolbarExportIcon() {
        return toolbarExportIcon;
    }

    public WebElement getAccountIcon() {
        return accountIcon;
    }

    public void clickToolBarExportIcon() {
        clickElement(toolbarExportIcon);
        WaitsTwo.waitForElementToBeVisible(driver, projectExportMessage);
    }

    public void undoRedoToolbar() {
        WaitsTwo.waitForElementToBeVisible(driver, toolbarUndoIcon);
        clickElement(toolbarUndoIcon);
        WaitsTwo.waitForElementToBeVisible(driver, toolbarRedoIcon);
        clickElement(toolbarRedoIcon);
    }

    public void clickAccountIcon() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        clickElement(getAccountIcon());
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorParaphraserPage.getLocatorText("Account Details").get(0));
    }

    public void clickAccountDetails() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        clickElement(cwEditorParaphraserPage.getLocatorText("Account Details").get(0));
        Thread.sleep(3000);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorParaphraserPage.getLocatorText("Profile").get(0));
    }
}

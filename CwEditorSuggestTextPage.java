package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.WaitsTwo;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CwEditorSuggestTextPage extends CwEditorPage {
    WebDriver driver;

    @FindBy(css = "[data-testid='page_editor/suggestion_root']")
    @CacheLookup
    WebElement suggestContent;

    @FindBy(css = "[data-testid='page_editor/suggestion_root']>li")
    @CacheLookup
    WebElement suggestContentList;

    @FindBy(css = "#context-menu>div>li")
    @CacheLookup
    List<WebElement> contextMenu;

    public CwEditorSuggestTextPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSuggestContentList() {
        return suggestContentList;
    }

    public List<WebElement> getContextMenu() {
        return contextMenu;
    }

    public void selectSuggestion() {
        WaitsTwo.waitForElementToBeClickable(driver, suggestContentList);
        if (suggestContentList.isDisplayed() && suggestContentList.isEnabled()) {
            Actions a = new Actions(driver);
            a.moveToElement(suggestContentList);
            a.click(suggestContentList).build().perform();
            WaitsTwo.waitForElementToBeVisible(driver, savedJustNowIcon);
        } else {
            Assert.fail("User is not able to select the suggest content");
        }
    }

    public String suggestContent() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorWritingAreaPage.writingArea);
        String suggestContentText = null;
        if (cwEditorWritingAreaPage.writingArea.isDisplayed() && cwEditorWritingAreaPage.writingArea.isEnabled()) {
            if (device.equalsIgnoreCase("windows")) {
                cwEditorWritingAreaPage.writingArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SPACE));
            } else {
                cwEditorWritingAreaPage.writingArea.sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.SPACE));
            }
            WaitsTwo.waitForElementToBeVisible(driver, suggestContent);
            WaitsTwo.waitForElementToBeClickable(driver, suggestContentList);
            suggestContentText = suggestContentList.getText();
        } else {
            Assert.fail("Suggest content is not displayed after using Ctrl + Shift + Space");
        }
        return suggestContentText;
    }

    public void rightClickEditorText() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorWritingAreaPage.writingArea);
        if (cwEditorWritingAreaPage.writingArea.isDisplayed() && cwEditorWritingAreaPage.writingArea.isEnabled()) {
            Actions a = new Actions(driver);
            if (device.equalsIgnoreCase("windows")) {
                a.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL);
            } else {
                a.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND);
            }
            a.moveToElement(cwEditorWritingAreaPage.writingArea);
            a.contextClick(cwEditorWritingAreaPage.writingArea).build().perform();
            WaitsTwo.waitForElementToBeVisible(driver, contextMenu.get(0));
        } else {
            Assert.fail("User is not able to select the text and perform right click");
        }
    }

    public void clickContextMenuOption(int index) throws InterruptedException {
        clickElement(contextMenu.get(index));
        Thread.sleep(2000);
    }
}

package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.Switch;
import main.java.com.quill.utilities.SwitchTwo;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CwEditorParaphraserPage extends CwEditorPage {
    WebDriver driver;
    //Co-writer Paraphrase section
    @FindBy(css = "div[id=\"outputBottomQuillControls-default\"] span")
    WebElement progressBarVisibility;

    @FindBy(css = "[aria-label='Replace selected text']")
    @CacheLookup
    WebElement insertButton;

    @FindBy(css = "[aria-label='Rephrase entire text']")
    @CacheLookup
    WebElement rephraseButton;

    @FindBy(css = "span[id=\"editable-content-within-article\"]")
    @CacheLookup
    WebElement paraphrasedText;

    @FindBy(css = "div[id=\"inputText\"]")
    @CacheLookup
    WebElement paraphraserInputBox;

    @FindBy(css = "[data-testid=\"ExpandMoreIcon\"]")
    @CacheLookup
    WebElement expandMoreIcon;

    @FindBy(css = "[data-testid=\"KeyboardArrowDownIcon\"]")
    @CacheLookup
    WebElement nextParagraphArrow;

    @FindBy(css = "[data-testid=\"KeyboardArrowUpIcon\"]")
    @CacheLookup
    WebElement previousParagraphArrow;

    @FindBy(xpath = "//div[text()='Word limit of 125 exceeded, extra words trimmed']")
    @CacheLookup
    WebElement pphrLimitToaster;

    @FindBy(css = "[stroke-linejoin=\"round\"]")
    List<WebElement> diamondIcon;

    @FindBy(xpath = "//span[text()='UNLOCK WITH PREMIUM']")
    @CacheLookup
    WebElement unlockWithPremiumBtn;

    @FindBy(xpath = "//p[text()='QuillBot Premium']")
    WebElement qbPremiumPage;

    @FindBy(xpath = "//span[text()= 'Paste Text']")
    @CacheLookup
    WebElement pasteTextBtn;

    @FindBy(css = "[id=\"outputText\"]")
    @CacheLookup
    WebElement paraphraserOutputBox;

    @FindBy(css = "[id=\"demo-simple-select\"] span")
    @CacheLookup
    WebElement pphrSelectedMode;

    @FindBy(css = "[data-testid=\"ArrowDropDownIcon\"]")
    WebElement arrowDropDownIcon;

    @FindBy(css = "[role=\"listbox\"] li")
    @CacheLookup
    List<WebElement> pphrModes;

    @FindBy(css = "[aria-label=\"Synonyms\"]")
    @CacheLookup
    List<WebElement> pphrSynonymsSlider;

    @FindBy(css = "[style=\"z-index: 1; width: 67%;\"]")
    @CacheLookup
    List<WebElement> pphrSynonymsRailEnabled;

    @FindBy(css = "[style=\"display: flex; width: 33%;\"]")
    @CacheLookup
    List<WebElement> pphrSynonymsRailDisabled;

    @FindBy(xpath = "//div[text()='Synonyms slider is disabled for Simple mode']")
    @CacheLookup
    WebElement pphrSynonymsToolTip;

    @FindBy(css = "[id=\"GRAMMAR_EDITOR\"]")
    @CacheLookup
    WebElement gcEditor;

    public CwEditorParaphraserPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getParaphrasedText() {
        return paraphrasedText;
    }

    public WebElement getPphrLimitToaster() {
        return pphrLimitToaster;
    }

    public WebElement getPasteTextBtn() {
        return pasteTextBtn;
    }

    public WebElement getParaphraserInputBox() {
        return paraphraserInputBox;
    }

    public WebElement getParaphraserOutputBox() {
        return paraphraserOutputBox;
    }

    public WebElement getPphrSelectedMode() {
        return pphrSelectedMode;
    }

    public List<WebElement> getPphrModes() {
        return pphrModes;
    }

    public List<WebElement> getPphrSynonymsSlider() {
        return pphrSynonymsSlider;
    }

    public List<WebElement> getPphrSynonymsRailEnabled() {
        return pphrSynonymsRailEnabled;
    }

    public List<WebElement> getPphrSynonymsRailDisabled() {
        return pphrSynonymsRailDisabled;
    }

    public List<WebElement> getDiamondIcon() {
        return diamondIcon;
    }

    public WebElement getInsertButton() {
        return insertButton;
    }

    public WebElement getRephraseButton() {
        return rephraseButton;
    }

    public WebElement getNextParagraphArrow() {
        return nextParagraphArrow;
    }

    public WebElement getPreviousParagraphArrow() {
        return previousParagraphArrow;
    }

    public WebElement getExpandMoreIcon() {
        return expandMoreIcon;
    }

    public WebElement getQbPremiumPage() {
        return qbPremiumPage;
    }

    public WebElement getGcEditor() {
        return gcEditor;
    }

    public List<WebElement> getLocatorText(String text) {
        return driver.findElements(By.xpath("//p[text()='" + text + "']"));
    }

    public WebElement getPphrModeText(String text) {
        return driver.findElement(By.cssSelector("[id=\"modes-" + text + "\"] button"));
    }

    public void clickParaphraserInsert() {
        WaitsTwo.waitForElementAttributeContainsString(driver,
                progressBarVisibility, "style",
                "width: 100%; visibility: hidden;", 15);
        clickElement(insertButton);
        WaitsTwo.waitForElementToBeInvisible(driver, unsavedIcon);
        WaitsTwo.waitForElementToBeVisible(driver, savedJustNowIcon);
    }

    public void clickRephraseButton() throws InterruptedException {
        clickElement(rephraseButton);
        Thread.sleep(2000);
    }

    public String pphrInputBoxText() {
        return paraphraserInputBox.getText();
    }

    public void clickExpandMoreIcon() {
        clickElement(expandMoreIcon);
        WaitsTwo.waitForElementToBeVisible(driver, paraphraserInputBox);
    }

    public void clickNextParagraph() {
        WaitsTwo.waitForElementAttributeContainsString(driver,
                progressBarVisibility, "style",
                "width: 100%; visibility: hidden;", 30);
        WaitsTwo.waitForElementToBeVisible(driver, nextParagraphArrow);
        clickElement(nextParagraphArrow);
    }

    public void mouseOverDiamondIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(diamondIcon.get(1)).perform();
        WaitsTwo.waitForElementToBeVisible(driver, unlockWithPremiumBtn);
    }

    public void clickUnlockWithPremiumBtn() {
        clickElement(unlockWithPremiumBtn);
        SwitchTwo.SwitchToLastWindow(driver);
    }

    public void clickModesDropdown() {
        WaitsTwo.waitForElementToBeVisible(driver, arrowDropDownIcon);
        Actions action = new Actions(driver);
        action.moveToElement(arrowDropDownIcon);
        action.click(arrowDropDownIcon).build().perform();
        WaitsTwo.waitForElementToBeVisible(driver, pphrModes.get(0));
    }

    public void clickPphrMode(int index) {
        WaitsTwo.waitForElementToBeVisible(driver, pphrModes.get(index));
        clickElement(pphrModes.get(3));
    }

    public void mouseOverSynonymsSlider() {
        WaitsTwo.waitForElementToBeVisible(driver, getPphrSynonymsSlider().get(1));
        Actions action = new Actions(driver);
        action.moveToElement(getPphrSynonymsSlider().get(1)).perform();
        WaitsTwo.waitForElementToBeVisible(driver, pphrSynonymsToolTip);
    }
}
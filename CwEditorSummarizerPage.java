package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CwEditorSummarizerPage extends CwEditorPage {
    WebDriver driver;

    //Co-writer Summarizer section
    @FindBy(css = "span[role=\"progressbar\"]")
    WebElement progressBar;

    @FindBy(css = "button[value=\"ext\"]")
    List<WebElement> keySentencesButton;

    @FindBy(css = "button[value=\"abs\"]")
    List<WebElement> summarizerParagraphButton;

    @FindBy(css = "div[role=\"textbox\"]")
    @CacheLookup
    WebElement summarizedInputBox;

    @FindBy(css = "div[id=\"outputBoxSummarizer\"]")
    WebElement summarizedOutputBox;

    @FindBy(css = "div[class=\"Pane horizontal Pane1  \"]")
    @CacheLookup
    WebElement cwSummarizerInputBox;

    @FindBy(css = "[aria-label=\"summary length gauge\"]")
    @CacheLookup
    List<WebElement> smzrSummaryLengthSlider;

    public CwEditorSummarizerPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getKeySentencesButton() {
        return keySentencesButton;
    }

    public List<WebElement> getSummarizerParagraphButton() {
        return summarizerParagraphButton;
    }

    public WebElement getSummarizedOutputBox() {
        return summarizedOutputBox;
    }

    public WebElement getCwSummarizerInputBox() {
        return cwSummarizerInputBox;
    }

    public List<WebElement> getSmzrSummaryLengthSlider() {
        return smzrSummaryLengthSlider;
    }

    public WebElement getSummarizedInputBox() {
        return summarizedInputBox;
    }

    public WebElement getSmzrLimitToaster(String words) {
        return driver.findElement(By.xpath("//div[text()='Word limit of " + words + " exceeded, extra words trimmed.']"));
    }

    public void clickSummarizerInsert() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        WaitsTwo.waitForElementAttributeContainsString(driver, progressBar, "style",
                "visibility: hidden;", 15);
        clickElement(cwEditorParaphraserPage.insertButton);
        WaitsTwo.waitForElementToBeInvisible(driver, unsavedIcon);
        WaitsTwo.waitForElementToBeVisible(driver, savedJustNowIcon);
    }

    public void clickExpandMoreIcon() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        clickElement(cwEditorParaphraserPage.expandMoreIcon);
        WaitsTwo.waitForElementToBeVisible(driver, cwSummarizerInputBox);
    }

    public void closeTab() throws Exception {
        CwTabResearchPage cwTabResearchPage = new CwTabResearchPage(driver);
        clickElement(cwTabResearchPage.getCloseTab());
    }
}


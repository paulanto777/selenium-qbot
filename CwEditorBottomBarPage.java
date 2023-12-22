package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CwEditorBottomBarPage extends CwEditorPage {
    WebDriver driver;

    //Co-Writer Editor bottom bar Web Elements
    @FindBy(css = "button[data-testid=\"bottom_bar/paraphrase_button\"]")
    @CacheLookup
    WebElement bottomBarParaphraseButton;

    @FindBy(css = "[data-testid=\"paraphrase-icon\"]")
    @CacheLookup
    List<WebElement> paraphraseIcon;

    @FindBy(css = "button[data-testid=\"bottom_bar/summarize_button\"]")
    @CacheLookup
    WebElement bottomBarSummarizeButton;

    @FindBy(css = "[data-testid=\"summarizer-icon\"]")
    @CacheLookup
    List<WebElement> summarizeIcon;

    @FindBy(css = "button[data-testid=\"bottom_bar/suggest_text_button\"]")
    @CacheLookup
    WebElement bottomBarSuggestTextButton;

    @FindBy(css = "[data-testid=\"ai-writer-icon\"]")
    @CacheLookup
    List<WebElement> bottomBarSuggestTextIcon;

    @FindBy(css = "button[aria-label=\"View Statistics\"]")
    WebElement bottomBarViewStatistics;

    @FindBy(xpath = "//strong[text()='Statistics']")
    @CacheLookup
    WebElement statisticsHeading;

    @FindBy(xpath = "//p[text()='Characters']//following::div")
    @CacheLookup
    WebElement statisticsCharactersCount;

    @FindBy(xpath = "//p[text()='Words']//following::div")
    @CacheLookup
    WebElement statisticsWordsCount;

    @FindBy(xpath = "//p[text()='Sentences']//following::div")
    @CacheLookup
    WebElement statisticsSentencesCount;

    @FindBy(xpath = "//p[text()='Paragraphs']//following::div")
    @CacheLookup
    WebElement statisticsParagraphsCount;

    @FindBy(xpath = "//p[text()='Reading Time']")
    @CacheLookup
    WebElement statisticsReadingTime;

    @FindBy(css = "div[aria-label=\"Grammar Errors\"]")
    WebElement bottomBarGrammarErrors;

    @FindBy(css = "button[aria-label=\"Fix all grammar errors\"]")
    WebElement fixAllGCErrors;

    @FindBy(xpath = "//p[text()='Show Errors']")
    @CacheLookup
    WebElement showErrorsLabel;

    @FindBy(css = "[aria-label=\"Hide Grammar Errors\"]")
    WebElement hideGrammarErrors;

    @FindBy(css = "[aria-label=\"Show Grammar Errors\"]")
    WebElement showGrammarErrors;

    @FindBy(css = "div[style=\"z-index: -1\"]")
    WebElement textNotRedHighlighted;

    @FindBy(css = "[style=\"z-index: 1\"]")
    WebElement textRedHighlighted;

    public CwEditorBottomBarPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getBottomBarParaphraseButton() {
        return bottomBarParaphraseButton;
    }

    public List<WebElement> getParaphraseIcon() {
        return paraphraseIcon;
    }

    public WebElement getBottomBarSummarizeButton() {
        return bottomBarSummarizeButton;
    }

    public List<WebElement> getSummarizeIcon() {
        return summarizeIcon;
    }

    public WebElement getBottomBarSuggestTextButton() {
        return bottomBarSuggestTextButton;
    }

    public WebElement getBottomBarSuggestTextIcon(int index) {
        return bottomBarSuggestTextIcon.get(index);
    }

    public WebElement getBottomBarViewStatistics() {
        return bottomBarViewStatistics;
    }

    public WebElement getStatisticsHeading() {
        return statisticsHeading;
    }

    public WebElement getStatisticsCharactersCount() {
        return statisticsCharactersCount;
    }

    public WebElement getStatisticsWordsCount() {
        return statisticsWordsCount;
    }

    public WebElement getStatisticsSentencesCount() {
        return statisticsSentencesCount;
    }

    public WebElement getStatisticsParagraphsCount() {
        return statisticsParagraphsCount;
    }

    public WebElement getStatisticsReadingTime() {
        return statisticsReadingTime;
    }

    public WebElement getBottomBarGrammarErrors() {
        return bottomBarGrammarErrors;
    }

    public WebElement getFixAllGCErrors() {
        return fixAllGCErrors;
    }

    public WebElement getTextNotRedHighlighted() {
        return textNotRedHighlighted;
    }

    public WebElement getTextRedHighlighted() {
        return textRedHighlighted;
    }

    public void clickBottomBarGrammarErrors() {
        clickElement(bottomBarGrammarErrors);
        WaitsTwo.waitForElementToBeVisible(driver, showErrorsLabel);
    }

    public void clickHideGrammarErrors() {
        clickElement(hideGrammarErrors);
    }

    public void clickShowGrammarErrors() {
        clickElement(showGrammarErrors);
    }

    public void clickGCCard() {
        clickElement(showErrorsLabel);
    }

    public void clickViewStatistics() {
        Actions act = new Actions(driver);
        act.click(bottomBarViewStatistics).perform();
        WaitsTwo.waitForElementToBeVisible(driver, statisticsHeading);
    }

    public void clickBottomBarParaphrase() {
        clickElement(bottomBarParaphraseButton);
    }

    public void clickBottomBarSummarize() {
        clickElement(bottomBarSummarizeButton);
    }

    public void clickBottomBarSuggestContent() throws Exception {
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        clickElement(bottomBarSuggestTextButton);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorSuggestTextPage.suggestContentList);
    }
}

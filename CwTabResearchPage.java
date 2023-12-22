package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CwTabResearchPage extends CwEditorPage {
    WebDriver driver;
    //Co-Writer Notes Tab page elements
    @FindBy(css = "[aria-placeholder=\"Enter notes, rough ideas, and other bits of inspiration!\"]")
    @CacheLookup
    WebElement notesEditor;

    @FindBy(xpath = "//button[text() = 'Notes']")
    @CacheLookup
    WebElement notesTabOpened;

    //Co-Writer Research Tab page elements
    @FindBy(css = "[data-testid=\"SearchIcon\"]")
    @CacheLookup
    WebElement searchIcon;

    @FindBy(css = "input[id=\"research-search-box\"]")
    WebElement searchInputField;

    @FindBy(xpath = "//button[text() = 'Search the Web']")
    @CacheLookup
    WebElement searchTheWebButton;

    @FindBy(css = "[data-testid=\"close-icon\"]")
    @CacheLookup
    WebElement closeTab;

    @FindBy(css = "div[aria-label=\"Open Bookmarks\"]")
    @CacheLookup
    WebElement openBookmarks;

    @FindBy(css = "div[aria-label=\"Close Bookmarks\"]")
    @CacheLookup
    List<WebElement> closeBookmarks;

    @FindBy(css = "[data-testid=\"BookmarkBorderOutlinedIcon\"]")
    @CacheLookup
    WebElement bookmarksIcon;

    @FindBy(css = "[data-testid=\"chevron-down-icon\"]")
    @CacheLookup
    List<WebElement> bookmarksCloseIcon;

    @FindBy(xpath = "//button[text()='Get Content']")
    WebElement getContentButton;

    @FindBy(css = "[data-testid=\"more-vert-icon\"]")
    @CacheLookup
    List<WebElement> researchCardMoreIcon;

    @FindBy(css = "button[aria-label=\"Add Bookmark\"]")
    @CacheLookup
    List<WebElement> addBookmarkButton;

    @FindBy(css = "button[aria-label=\"Remove Bookmark\"]")
    @CacheLookup
    List<WebElement> removeBookmarkButton;

    @FindBy(xpath = "//button[text()='Open']")
    List<WebElement> researchCardOpenButton;

    @FindBy(xpath = "//button[text()='Open']")
    WebElement directUrlOpenButton;

    @FindBy(xpath = "//span[text() = 'Full Article']")
    @CacheLookup
    WebElement fullArticleHeading;

    @FindBy(xpath = "//span[text() = 'Highlights']")
    @CacheLookup
    WebElement highlightsHeading;

    @FindBy(xpath = "//span[text() = 'Topics/Keywords']")
    @CacheLookup
    WebElement topicsHeading;

    @FindBy(xpath = "//button[text() = 'View All Highlights']")
    @CacheLookup
    WebElement viewAllHighlightsButton;

    @FindBy(css = "[data-testid=\"bookmark_tab/result_card\"]")
    List<WebElement> bookmarkResultCard;

    @FindBy(xpath = "//button[text() = 'Back']")
    WebElement researchBackButton;

    @FindBy(css = "[data-testid=\"bookmark_tab/result_card/bookmark_button\"] [data-testid=\"trash-icon\"]")
    @CacheLookup
    WebElement deleteBookmark;

    @FindBy(xpath = "//p[text()='No saved bookmarks were found. Bookmarks can be created from search results.']")
    @CacheLookup
    WebElement noBookmarkText;

    @FindBy(xpath = "//p[text()='Open Link']")
    @CacheLookup
    WebElement openLink;

    @FindBy(xpath = "//p[text()='Report']")
    @CacheLookup
    WebElement report;

    @FindBy(css = "[data-testid=\"research_tab/result_card_info_view/accordion_outline\"]")
    @CacheLookup
    List<WebElement> getHighlightedText;

    @FindBy(css = "[data-testid=\"DocumentScannerOutlinedIcon\"]")
    @CacheLookup
    WebElement highlightsIcon;

    @FindBy(xpath = "//p[text()=\"This result doesn't have any content to show\"]")
    WebElement noContentMessage;

    @FindBy(css = "[data-testid=\"research_tab/result_card_info_view/topic-chip\"]")
    @CacheLookup
    List<WebElement> chooseTopic;

    @FindBy(css = "[data-testid=\"InsertChartOutlinedIcon\"]")
    @CacheLookup
    WebElement topicsIcon;

    @FindBy(css = "[data-testid='active-portal'] [data-testid='Full Article'] p")
    WebElement fullArticleText;

    @FindBy(xpath = "//div[text()='Insert with citation']")
    WebElement contextInsertWithCitation;

    @FindBy(xpath = "//div[text()='Paraphrase']")
    WebElement researchContextParaphrase;

    @FindBy(xpath = "//div[text()='Summarize']")
    WebElement researchContextSummarize;

    @FindBy(xpath = "//span[text() ='Insert']")
    List<WebElement> ribbonInsertButton;

    @FindBy(xpath = "//span[text() ='Paraphrase']")
    WebElement ribbonParaphraseButton;

    @FindBy(xpath = "//span[text() ='Summarize']")
    WebElement ribbonSummarizeButton;

    @FindBy(css = "[id=\"academic-toggle-icon\"] span")
    @CacheLookup
    WebElement academicToggle;

    @FindBy(xpath = "//button[text() = 'Explore']")
    List<WebElement> exploreButton;

    @FindBy(xpath = "//button[text() = 'Cite']")
    List<WebElement> citeButton;

    @FindBy(xpath = "//p[text() ='The idea of India']")
    List<WebElement> academicPdfTitle;


    public CwTabResearchPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNotesEditor() {
        return notesEditor;
    }

    public WebElement getNotesTabOpened() {
        return notesTabOpened;
    }

    public WebElement getSearchIcon() {
        return searchIcon;
    }

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public WebElement getSearchTheWebButton() {
        return searchTheWebButton;
    }

    public WebElement getCloseTab() {
        return closeTab;
    }

    public WebElement getOpenBookmarks() {
        return openBookmarks;
    }

    public WebElement getBookmarksIcon() {
        return bookmarksIcon;
    }

    public WebElement getContentButton() {
        return getContentButton;
    }

    public List<WebElement> getResearchCardMoreIcon() {
        return researchCardMoreIcon;
    }

    public List<WebElement> getAddBookmarkButton() {
        return addBookmarkButton;
    }

    public List<WebElement> getRemoveBookmarkButton() {
        return removeBookmarkButton;
    }

    public List<WebElement> getResearchCardOpenButton() {
        return researchCardOpenButton;
    }

    public WebElement getDirectUrlOpenButton() {
        return directUrlOpenButton;
    }

    public WebElement getFullArticleHeading() {
        return fullArticleHeading;
    }

    public WebElement getHighlightsHeading() {
        return highlightsHeading;
    }

    public WebElement getTopicsHeading() {
        return topicsHeading;
    }

    public WebElement getViewAllHighlightsButton() {
        return viewAllHighlightsButton;
    }

    public List<WebElement> getBookmarkResultCard() {
        return bookmarkResultCard;
    }

    public WebElement getNoBookmarkText() {
        return noBookmarkText;
    }

    public WebElement getReport() {
        return report;
    }

    public WebElement getNoContentMessage() {
        return noContentMessage;
    }

    public WebElement getFullArticleText() {
        return fullArticleText;
    }

    public WebElement getContextInsertWithCitation() {
        return contextInsertWithCitation;
    }

    public WebElement getResearchContextParaphrase() {
        return researchContextParaphrase;
    }

    public WebElement getResearchContextSummarize() {
        return researchContextSummarize;
    }

    public List<WebElement> getExploreButton() { return exploreButton; }

    public List<WebElement> getCiteButton() { return citeButton; }

    public List<WebElement> getAcademicPdfTitle() { return academicPdfTitle; }


    //Co-writer Notes Methods
    public void clickNotesTab() {
        clickElement(notesTabIcon.get(0));
        WaitsTwo.waitForElementToBeVisible(driver, notesEditor);
    }

    public void clickNotesOption() {
        clickElement(notesOption);
        WaitsTwo.waitForElementToBeVisible(driver, notesEditor);
    }

    public void enterNotes() {
        enterText(notesEditor, ConfigUtil.getDataFile("cowriter.json", "notesText"));
    }

    public void closeTab() {
        clickElement(closeTab);
    }

    //Co-writer Research tab Methods
    public void clickResearchOption() {
        clickElement(researchOption);
        WaitsTwo.waitForElementToBeVisible(driver, searchIcon);
        WaitsTwo.waitForElementToBeVisible(driver, searchInputField);
    }

    public void enterSearchText() {
        clickElement(searchInputField);
        searchInputField.sendKeys(ConfigUtil.getDataFile("cowriter.json", "researchSearch"));
    }

    public void removeBookmark() {
        clickElement(removeBookmarkButton.get(0));
        WaitsTwo.waitForElementToBeVisible(driver, addBookmarkButton.get(0));
    }

    public void directUrlSearch() throws InterruptedException {
        clickElement(researchOption);
        WaitsTwo.waitForElementToBeVisible(driver, searchInputField);
        clickElement(searchInputField);
        searchInputField.clear();
        searchInputField.sendKeys(ConfigUtil.getDataFile("cowriter.json", "researchSearchUrl"));
        clickElement(searchIcon);
        Thread.sleep(6000);
        WaitsTwo.waitForElementToBeVisible(driver, directUrlOpenButton);
    }

    public void openLink() {
        WaitsTwo.waitForElementToBeVisible(driver, researchCardMoreIcon.get(0));
        clickElement(researchCardMoreIcon.get(0));
        WaitsTwo.waitForElementToBeVisible(driver, openLink);
        clickElement(openLink);
    }

    public void report() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, researchCardMoreIcon.get(0));
        clickElement(researchCardMoreIcon.get(0));
        WaitsTwo.waitForElementToBeVisible(driver, report);
        clickElement(report);
        Thread.sleep(3000);
    }

    public void clickSearchTheWebButton() {
        clickElement(searchTheWebButton);
        WaitsTwo.waitForElementToBeInvisible(driver, searchTheWebButton);
        WaitsTwo.waitForElementToBeVisible(driver, getContentButton);
    }

    public void clickGetContentButton() throws InterruptedException {
        clickElement(getContentButton);
        Thread.sleep(5000);
        WaitsTwo.waitForElementToBeVisible(driver, viewAllHighlightsButton);
    }

    public void clickBackButton() {
        clickElement(researchBackButton);
        WaitsTwo.waitForElementToBeVisible(driver, researchCardOpenButton.get(0));
    }

    public void openBookmarkDrawer() {
        clickElement(openBookmarks);
        WaitsTwo.waitForElementToBeVisible(driver, noBookmarkText);
    }

    public void closeBookmarkDrawer() {
        clickElement(bookmarksCloseIcon.get(1));
        WaitsTwo.waitForElementToBeVisible(driver, searchTheWebButton);
    }

    public void addBookmark() throws InterruptedException {
        clickElement(addBookmarkButton.get(0));
        Thread.sleep(5000);
        WaitsTwo.waitForElementToBeVisible(driver, removeBookmarkButton.get(0));
    }

    public void openBookmarkSection() {
        clickElement(openBookmarks);
        WaitsTwo.waitForElementToBeVisible(driver, bookmarkResultCard.get(0));
    }

    public void deleteBookmark() {
        clickElement(deleteBookmark);
        WaitsTwo.waitForElementToBeVisible(driver, noBookmarkText);
    }

    public void closeBookmarkSection() {
        clickElement(closeBookmarks.get(1));
        WaitsTwo.waitForElementToBeVisible(driver, researchCardOpenButton.get(0));
    }

    public void openButton() {
        clickElement(directUrlOpenButton);
        WaitsTwo.waitForElementToBeVisible(driver, researchBackButton);
    }

    public void clickViewAllHighlights() throws InterruptedException {
        clickElement(researchOption);
        WaitsTwo.waitForElementToBeVisible(driver, searchInputField);
        clickElement(searchInputField);
        searchInputField.clear();
        searchInputField.sendKeys(ConfigUtil.getDataFile("cowriter.json", "researchSearch"));
        clickElement(searchIcon);
        Thread.sleep(6000);
        clickElement(getContentButton);
        Thread.sleep(5000);
        WaitsTwo.waitForElementToBeVisible(driver, viewAllHighlightsButton);
        clickElement(viewAllHighlightsButton);
    }

    public void clickViewHighlightsText() {
        WaitsTwo.waitForElementToBeVisible(driver, getHighlightedText.get(0));
        clickElement(getHighlightedText.get(0));
        clickElement(highlightsIcon);
    }

    public void clickViewFullArticleText() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, fullArticleHeading);
        clickElement(fullArticleHeading);
        Thread.sleep(3000);
    }

    public void selectArticleText() throws InterruptedException {
        if (fullArticleText.isDisplayed() && fullArticleText.isEnabled()) {
            Actions action = new Actions(driver);
            action.moveToElement(fullArticleText).doubleClick();
            action.click().build().perform();
            Thread.sleep(4000);
        } else {
            Assert.fail("User is not able to select Research text");
        }
    }

    public void performRightClick() throws InterruptedException {
        Actions action = new Actions(driver);
        action.contextClick(fullArticleText).perform();
        Thread.sleep(2000);
    }

    public void ribbonInsert() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(ribbonInsertButton.get(1)).perform();
        clickElement(ribbonInsertButton.get(1));
        Thread.sleep(3000);
    }

    public void ribbonParaphrase() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(ribbonParaphraseButton).perform();
        clickElement(ribbonParaphraseButton);
        Thread.sleep(4000);
    }

    public void ribbonSummarize() throws Exception {
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(ribbonSummarizeButton).perform();
        clickElement(ribbonSummarizeButton);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorSummarizerPage.summarizedOutputBox);
        Thread.sleep(3000);
    }

    public void clickContextMenuParaphrase() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, researchContextParaphrase);
        clickElement(researchContextParaphrase);
        Thread.sleep(4000);
    }

    public void clickContextMenuSummarize() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, researchContextSummarize);
        clickElement(researchContextSummarize);
        Thread.sleep(4000);
    }

    public void clickTopics() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, topicsHeading);
        clickElement(topicsHeading);
        Thread.sleep(3000);
        clickElement(topicsIcon);
    }

    public void checkTopicText() throws InterruptedException {
        Thread.sleep(6000);
        WaitsTwo.waitForElementToBeVisible(driver, chooseTopic.get(0));
        clickElement(chooseTopic.get(0));
        Thread.sleep(2000);
        clickElement(topicsIcon);
    }
    public void clickAcademicToggle() throws InterruptedException {
        clickElement(searchInputField);
        clickElement(academicToggle);
        Thread.sleep(3000);
    }

    public void clickAcademicExploreButton() throws InterruptedException {
        clickElement(exploreButton.get(0));
        Thread.sleep(5000);
    }

    public void clickAcademicCiteButton() throws InterruptedException {
        clickElement(researchBackButton);
        clickElement(citeButton.get(0));
        Thread.sleep(4000);
    }
}

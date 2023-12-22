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

import java.util.List;
import java.util.Random;

public class CwHomePage extends CwEditorPage {
    WebDriver driver;
    //Co-Writer Home page - Start New Web Elements
    @FindBy(xpath = "//p[text() = 'Co-Writer']")
    @CacheLookup
    WebElement homepageTitle;

    @FindBy(xpath = "//a[@href='/premium?referrer=header']")
    @CacheLookup
    WebElement upgradeToPremium;

    @FindBy(xpath = "//h3[text() = 'Start New']")
    @CacheLookup
    WebElement startNewHeading;

    @FindBy(css = "[data-testid=\"list_page/template_card\"]")
    @CacheLookup
    List<WebElement> templateCard;

    @FindBy(css = "[data-testid=\"list_page/template_card\"]+div")
    @CacheLookup
    List<WebElement> templateCardName;

    @FindBy(xpath = "//button[text()='Learn More']")
    @CacheLookup
    WebElement learnMoreButton;

    @FindBy(xpath = "//button[text()='Feedback']")
    @CacheLookup
    WebElement feedbackButton;

    @FindBy(css = "[id=\"feedbackText\"]")
    @CacheLookup
    WebElement feedbackInput;

    @FindBy(xpath = "//button[text()='Submit']")
    @CacheLookup
    WebElement feedbackSubmitButton;

    @FindBy(xpath = "//span[text()='Thank you for your questions and comments. We value your ideas, feedback and support.']")
    @CacheLookup
    WebElement feedbackSuccessText;

    //Co-Writer Landing page - Recent Projects Web Elements
    @FindBy(xpath = "//h3[text() = 'Recent Projects']")
    @CacheLookup
    WebElement recentProjectsHeading;

    @FindBy(css = "[data-testid=\"search-icon\"]")
    @CacheLookup
    List<WebElement> searchProjectIcon;

    @FindBy(css = "[data-testid=\"search-icon\"]+input")
    @CacheLookup
    WebElement searchProjectInputField;

    @FindBy(css = "[data-testid=\"list_page/list-view\"] [data-testid=\"list_page/project_card\"]")
    List<WebElement> projectCardListView;

    @FindBy(css = "[data-testid=\"list_page/grid-view\"] [data-testid=\"list_page/project_card\"]")
    List<WebElement> projectCardGridView;

    @FindBy(css = "[data-testid=\"list_page/grid-view\"] [data-testid=\"list_page/project_card\"] p")
    List<WebElement> projectCardGridViewPreviewText;

    @FindBy(css = "[data-testid=\"text-bullet-list-ltr-icon\"]")
    @CacheLookup
    WebElement listViewIcon;

    @FindBy(xpath = "//p[text() = 'Title']")
    WebElement listViewTitleColumn;

    @FindBy(xpath = "//p[text() = 'Size']")
    @CacheLookup
    WebElement listViewSizeColumn;

    @FindBy(xpath = "//p[text() = 'Date']")
    @CacheLookup
    WebElement listViewDateColumn;

    @FindBy(css = "[data-testid=\"list_page/list-view\"] [data-testid=\"arrow-download-icon\"]")
    WebElement projectCardExportIconListView;

    @FindBy(css = "[data-testid=\"list_page/list-view\"] [data-testid=\"more-vert-icon\"]")
    WebElement projectCardMoreIconListView;

    @FindBy(css = "[data-testid=\"list_page/grid-view\"] [data-testid=\"arrow-download-icon\"]")
    List<WebElement> projectCardExportIconGridView;

    @FindBy(css = "[data-testid=\"list_page/grid-view\"] [data-testid=\"more-vert-icon\"]")
    List<WebElement> projectCardMoreIconGridView;

    @FindBy(xpath = "//button[text() = 'Delete']")
    WebElement deleteProjectIcon;

    @FindBy(xpath = "//a[text() = 'Open in new tab']")
    @CacheLookup
    WebElement openInNewTabIcon;

    @FindBy(xpath = "//div[text()='Project moved to trash']")
    @CacheLookup
    WebElement deleteToasterMessage;

    @FindBy(css = "[data-testid=\"grid-icon\"]")
    @CacheLookup
    WebElement gridViewIcon;

    @FindBy(css = "[data-testid=\"text-sort-asc-icon\"]")
    WebElement sortByIcon;

    @FindBy(xpath = "//button[text() = 'Sort by date modified']")
    WebElement sortByDateModified;

    @FindBy(xpath = "//button[text() = 'Sort by name']")
    WebElement sortByName;

    @FindBy(xpath = "//button[text() = 'Sort by size']")
    WebElement sortBySize;

    @FindBy(css = "[data-testid=\"trash-unstriped-icon\"]")
    @CacheLookup
    WebElement trashIcon;

    //Co-Writer Trash page Web Elements
    @FindBy(xpath = "//p[text() = 'Trashed Projects']")
    WebElement trashPageHeading;

    @FindBy(xpath = "//button[text() = 'Back']")
    WebElement trashPageBackButton;

    @FindBy(xpath = "//button[text() = 'Delete All']")
    WebElement deleteAllButton;

    @FindBy(xpath = "//h2[text() = 'Delete Forever?']")
    WebElement deleteForeverPopup;

    @FindBy(xpath = "//p[text() = 'Cancel']")
    WebElement deleteAllCancel;

    @FindBy(xpath = "//p[text() = 'Delete All']")
    WebElement deleteAllConfirm;

    @FindBy(xpath = "//p[text() = 'No projects found. Deleted projects will appear here.']")
    WebElement deleteAllSuccessful;

    @FindBy(css = "[data-testid=\"history-icon\"]")
    WebElement restoreProjectIcon;

    @FindBy(css = "[data-testid=\"trash-icon\"]")
    WebElement deleteForeverIcon;

    @FindBy(css = "[data-testid=\"list_page/trash_project_card\"]")
    List<WebElement> trashProjectCard;

    @FindBy(css = "[data-testid=\"list_page/trash_project_card\"] p")
    List<WebElement> trashProjectCardPreviewText;

    public CwHomePage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomepageTitle() {
        return homepageTitle;
    }

    public WebElement getStartNewHeading() {
        return startNewHeading;
    }

    public WebElement getLearnMoreButton() {
        return learnMoreButton;
    }

    public WebElement getFeedbackButton() {
        return feedbackButton;
    }

    public WebElement getFeedbackSuccessText() {
        return feedbackSuccessText;
    }

    public WebElement getRecentProjectsHeading() {
        return recentProjectsHeading;
    }

    public List<WebElement> getSearchProjectIcon() {
        return searchProjectIcon;
    }

    public WebElement getSearchProjectInputField() {
        return searchProjectInputField;
    }

    public List<WebElement> getProjectCardListView() {
        return projectCardListView;
    }

    public List<WebElement> getProjectCardGridView() {
        return projectCardGridView;
    }

    public List<WebElement> getProjectCardGridViewPreviewText() {
        return projectCardGridViewPreviewText;
    }

    public WebElement getListViewIcon() {
        return listViewIcon;
    }

    public WebElement getListViewTitleColumn() {
        return listViewTitleColumn;
    }

    public WebElement getListViewSizeColumn() {
        return listViewSizeColumn;
    }

    public WebElement getListViewDateColumn() {
        return listViewDateColumn;
    }

    public WebElement getProjectCardExportIconListView() {
        return projectCardExportIconListView;
    }

    public WebElement getProjectCardMoreIconListView() {
        return projectCardMoreIconListView;
    }

    public List<WebElement> getProjectCardExportIconGridView() {
        return projectCardExportIconGridView;
    }

    public List<WebElement> getProjectCardMoreIconGridView() {
        return projectCardMoreIconGridView;
    }

    public WebElement getDeleteProjectIcon() {
        return deleteProjectIcon;
    }

    public WebElement getOpenInNewTabIcon() {
        return openInNewTabIcon;
    }

    public WebElement getDeleteToasterMessage() {
        return deleteToasterMessage;
    }

    public WebElement getGridViewIcon() {
        return gridViewIcon;
    }

    public WebElement getSortByIcon() {
        return sortByIcon;
    }

    public WebElement getSortByDateModified() {
        return sortByDateModified;
    }

    public WebElement getSortByName() {
        return sortByName;
    }

    public WebElement getSortBySize() {
        return sortBySize;
    }

    public WebElement getTrashIcon() {
        return trashIcon;
    }

    public WebElement getTrashPageHeading() {
        return trashPageHeading;
    }

    public WebElement getTrashPageBackButton() {
        return trashPageBackButton;
    }

    public WebElement getDeleteAllCancel() {
        return deleteAllCancel;
    }

    public WebElement getDeleteAllConfirm() {
        return deleteAllConfirm;
    }

    public WebElement getDeleteAllSuccessful() {
        return deleteAllSuccessful;
    }

    public WebElement getRestoreProjectIcon() {
        return restoreProjectIcon;
    }

    public WebElement getDeleteForeverIcon() {
        return deleteForeverIcon;
    }

    public List<WebElement> getTrashProjectCard() {
        return trashProjectCard;
    }

    public List<WebElement> getTrashProjectCardPreviewText() {
        return trashProjectCardPreviewText;
    }

    //Co-writer Home Page Methods
    public String getTextTemplateCard(int index) {
        WaitsTwo.waitForElementToBeVisible(driver, templateCardName.get(index));
        String getTemplateCardName = null;
        if (templateCardName.get(index).isDisplayed() && templateCardName.get(index).isEnabled()) {
            getTemplateCardName = templateCardName.get(index).getText();
        } else {
            Assert.fail("User is not able to get the text displayed of the template card");
        }
        return getTemplateCardName;
    }

    public void clickUpgradeToPremium() {
        clickElement(upgradeToPremium);
    }

    public void clickSearchIcon() {
        clickElement(searchProjectIcon.get(1));
        WaitsTwo.waitForElementToBeVisible(driver, searchProjectInputField);
        WaitsTwo.waitForElementToBeVisible(driver, searchProjectIcon.get(0));
    }

    public void enterProjectName() {
        String projectName = System.getProperty("Project name");
        enterText(searchProjectInputField, projectName);
        WaitsTwo.waitForElementToBeVisible(driver, searchProjectInputField);
        WaitsTwo.waitForElementToBeVisible(driver, projectCardGridView.get(0));
    }

    public void clearSearchProjectField() {
        if (device.equalsIgnoreCase("windows")) {
            searchProjectInputField.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        } else {
            searchProjectInputField.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        }
        searchProjectInputField.sendKeys(Keys.DELETE);
    }

    public void clickDeleteAll() throws InterruptedException {
        clickElement(deleteAllButton);
        WaitsTwo.waitForElementToBeVisible(driver, deleteForeverPopup);
        Thread.sleep(3000);
    }

    public void deleteAllConfirm() throws InterruptedException {
        clickElement(deleteAllConfirm);
        Thread.sleep(3000);
    }

    public void clickTrashIcon() {
        clickElement(trashIcon);
        WaitsTwo.waitForElementToBeVisible(driver, trashPageBackButton);
    }

    public void clickDeleteForeverIcon() {
        clickElement(deleteForeverIcon);
        WaitsTwo.waitForElementToBeVisible(driver, trashPageBackButton);
    }

    public void clickRestoreProjectIcon() {
        clickElement(restoreProjectIcon);
        WaitsTwo.waitForElementToBeVisible(driver, trashPageBackButton);
    }

    public void clickTrashBackButton() {
        clickElement(trashPageBackButton);
    }

    public void mouseoverProjectCard(int projectCard) throws InterruptedException {
        Actions actions = new Actions(driver);
        WaitsTwo.waitForElementToBeVisible(driver, projectCardGridView.get(projectCard));
        actions.moveToElement(projectCardGridView.get(projectCard)).perform();
        Thread.sleep(3000);
        WaitsTwo.waitForElementToBeVisible(driver, projectCardMoreIconGridView.get(projectCard));
    }

    public void clickProjectCard(int projectCard) throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        clickElement(projectCardGridView.get(projectCard));
        WaitsTwo.waitForElementToBeInvisible(driver, pageLoader);
        WaitsTwo.waitForElementToBeVisible(driver, projectTitleField);
        WaitsTwo.waitForElementToBeVisible(driver, menuBarFile);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorBottomBarPage.bottomBarParaphraseButton);
    }

    public void clickMoreIcon(int projectCard) {
        clickElement(projectCardMoreIconGridView.get(projectCard));
        WaitsTwo.waitForElementToBeVisible(driver, deleteProjectIcon);
    }

    public void deleteProject() {
        clickElement(deleteProjectIcon);
    }

    public void clickOpenInNewTab() {
        clickElement(openInNewTabIcon);
    }

    public void switchToNewWindow() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        WaitsTwo.waitForElementToBeInvisible(driver, pageLoader);
        WaitsTwo.waitForElementToBeVisible(driver, menuBarFile);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorBottomBarPage.bottomBarParaphraseButton);
    }

    public void clickBlankProjectTemplate() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        clickElement(templateCard.get(0));
        WaitsTwo.waitForElementToBeInvisible(driver, pageLoader);
        WaitsTwo.waitForElementToBeVisible(driver, menuBarFile);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorWritingAreaPage.pasteTextButton);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorBottomBarPage.bottomBarParaphraseButton);
        WaitsTwo.waitForElementToBeVisible(driver, projectTitleField);
    }

    public void clickEssayTemplate() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        clickElement(templateCard.get(2));
        Thread.sleep(5000);
        WaitsTwo.waitForElementToBeInvisible(driver, pageLoader);
        WaitsTwo.waitForElementToBeInvisible(driver, unsavedIcon);
        WaitsTwo.waitForElementToBeVisible(driver, menuBarFile);
        WaitsTwo.waitForElementToBeVisible(driver, coWriterHomeIcon);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorBottomBarPage.bottomBarParaphraseButton);
    }

    public void renameProjectTitle() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        if (device.equalsIgnoreCase("windows")) {
            projectTitleField.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        } else {
            projectTitleField.sendKeys(Keys.chord(Keys.COMMAND, "A"));
        }
        Thread.sleep(1000);
        projectTitleField.sendKeys(Keys.DELETE);
        Thread.sleep(1000);
        enterText(projectTitleField, "New project " + generateRandomNumber());
        cwEditorWritingAreaPage.clickWritingArea();
        System.setProperty("Project name", projectTitleField.getAttribute("data-value"));
        Thread.sleep(3000);
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100000);
    }

    public void clickCoWriterHomeIcon() throws InterruptedException {
        WaitsTwo.waitForElementToBeInvisible(driver, unsavedIcon);
        Thread.sleep(5000);
        WaitsTwo.waitForElementToBeVisible(driver, coWriterHomeIcon);
        clickElement(coWriterHomeIcon);
        WaitsTwo.waitForElementToBeInvisible(driver, pageLoader);
        WaitsTwo.waitForElementToBeVisible(driver, startNewHeading);
    }

    public void clickListViewIcon() {
        clickElement(listViewIcon);
        WaitsTwo.waitForElementToBeVisible(driver, listViewTitleColumn);
    }

    public void clickGridViewIcon() {
        clickElement(gridViewIcon);
        WaitsTwo.waitForElementToBeInvisible(driver, listViewTitleColumn);
    }

    public void clickSortByIcon() {
        clickElement(sortByIcon);
    }

    public void clickSortByName() {
        clickElement(sortByName);
        WaitsTwo.waitForElementToBeVisible(driver, listViewTitleColumn);
    }

    public void clickSortByDateModified() {
        clickElement(sortByDateModified);
        WaitsTwo.waitForElementToBeVisible(driver, listViewTitleColumn);
    }

    public void clickSortBySize() {
        clickElement(sortBySize);
        WaitsTwo.waitForElementToBeVisible(driver, listViewTitleColumn);
    }

    public void clickExportIcon() {
        clickElement(projectCardExportIconGridView.get(0));
        WaitsTwo.waitForElementToBeVisible(driver, projectExportMessage);
    }

    public void clickSampleProject() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        clickElement(templateCard.get(3));
        Thread.sleep(5000);
        WaitsTwo.waitForElementToBeInvisible(driver, pageLoader);
        WaitsTwo.waitForElementToBeInvisible(driver, unsavedIcon);
        WaitsTwo.waitForElementToBeVisible(driver, cwEditorBottomBarPage.bottomBarParaphraseButton);
    }

    public void clickLearnMore() {
        WaitsTwo.waitForElementToBeVisible(driver, learnMoreButton);
        clickElement(learnMoreButton);
    }

    public void sendFeedback() throws InterruptedException {
        WaitsTwo.waitForElementToBeVisible(driver, feedbackButton);
        clickElement(feedbackButton);
        WaitsTwo.waitForElementToBeVisible(driver, feedbackInput);
        clickElement(feedbackInput);
        feedbackInput.sendKeys(ConfigUtil.getDataFile("cowriter.json", "feedback"));
        clickElement(feedbackSubmitButton);
        Thread.sleep(3000);
    }
}

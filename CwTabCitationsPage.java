package main.java.com.quill.pages.cowriter;

import main.java.com.quill.common.TestPageHandler;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CwTabCitationsPage extends CwEditorPage {
    WebDriver driver;
    //Co-Writer Citation Tab page elements
    @FindBy(xpath = "//*[text()='Create Citation']")
    WebElement creationCitationButton;

    @FindBy(xpath = "//p[text()='No citations were found. Create a new citation. ']")
    @CacheLookup
    WebElement createCitationPlaceHolderText;

    @FindBy(css = "[id=\"citationCardsContainerId\"] [data-testid=\"MoreVertIcon\"]")
    @CacheLookup
    List<WebElement> citationCardMoreButton;

    @FindBy(css = "[aria-label=\"Insert Citation\"]")
    @CacheLookup
    List<WebElement> insertCitationCardButton;

    @FindBy(xpath = "//li/span[text() = \"Delete\"]")
    @CacheLookup
    WebElement deleteCitation;

    @FindBy(xpath = "//li/span[text() = \"Clone Citation\"]")
    @CacheLookup
    WebElement cloneCitation;

    @FindBy(css = "button[data-testid=\"citation_results/compose_citation\"]")
    WebElement composeButton;

    @FindBy(css = "[aria-label=\"View full-text citations\"]")
    WebElement viewWorksCited;

    public CwTabCitationsPage(WebDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCreateCitationPlaceHolderText() {
        return createCitationPlaceHolderText;
    }

    public List<WebElement> getInsertCitationCardButton() {
        return insertCitationCardButton;
    }

    //Co-writer Right section tab Methods
    public void clickCitationsOption() {
        clickElement(citationsOption);
        WaitsTwo.waitForElementToBeVisible(driver, creationCitationButton);
    }

    public void clickCreateCitationButton() {
        clickElement(creationCitationButton);
        WaitsTwo.waitForElementToBeVisible(driver, composeButton);
    }

    public CwTabCitationsPage clickCitationCardMoreButton() {
        clickElement(citationCardMoreButton.get(0));
        WaitsTwo.waitForElementToBeVisible(driver, cloneCitation);
        return this;
    }

    public void clickDeleteOption() {
        clickElement(deleteCitation);
    }

    public void clickInsertOption() {
        WaitsTwo.waitForElementToBeVisible(driver, insertCitationCardButton.get(0));
        clickElement(insertCitationCardButton.get(0));
    }

    public void clickWorkCited() {
        WaitsTwo.waitForElementToBeVisible(driver, viewWorksCited);
        clickElement(viewWorksCited);
    }
}

package test.java.com.quill.tests.coWriter.premiumUser;

import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.cowriter.*;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.TakeSnapshot;
import main.java.com.quill.utilities.WaitsTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTestTwo;

public class CwIntegrationTest extends BaseTestTwo {

    @Test(priority = 1,
            description = "TC_CW_132:Verify integration check at Co Writer Home page when navigating from PPHR",
            groups = {"Detailed", "Integration"})
    public void tcCw132NavigatePphrToCoWriter() throws Exception {
        LoginPage login = new LoginPage(driver);
        NavigationPage np = new NavigationPage(driver);
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);

        try {
            login
                    .click_New_Login_Link()
                    .Enter_UserName(ConfigUtil.getDataFile("cowriter.json", "premiumUsername"))
                    .Enter_Password(ConfigUtil.getDataFile("cowriter.json", "premiumPassword"))
                    .Click_Login_Button()
                    .allowBrowserNotifications();
            WaitsTwo.waitForElementToBeVisible(driver, cwEditorParaphraserPage.getPasteTextBtn());
            Assert.assertEquals(driver.getTitle(), "Paraphrasing Tool - QuillBot AI");

            np.navigateToCoWriter();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getStartNewHeading());
            Assert.assertEquals(driver.getTitle(), "Co-Writer | QuillBot AI");
            cwHomePageTest.tcCw03VerifyHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2,
            description = "TC_CW_165:Verify integration check at Co Writer Home page when navigating from SMZR",
            groups = {"Detailed", "Integration"})
    public void tcCw165NavigateSmzrToCoWriter() throws Exception {
        NavigationPage np = new NavigationPage(driver);
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);

        try {
            np.navigateToSummarizer();
            WaitsTwo.waitForElementToBeVisible(driver, cwEditorParaphraserPage.getPasteTextBtn());
            Assert.assertEquals(driver.getTitle(), "Text Summarizer | QuillBot AI");

            np.navigateToCoWriter();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getStartNewHeading());
            Assert.assertEquals(driver.getTitle(), "Co-Writer | QuillBot AI");
            cwHomePageTest.tcCw03VerifyHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3,
            description = "TC_CW_166:Verify integration check at Co Writer Home page when navigating from GC",
            groups = {"Detailed", "Integration"})
    public void tcCw166NavigateGcToCoWriter() throws Exception {
        NavigationPage np = new NavigationPage(driver);
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);

        try {
            np.navigateToGrammarChecker();
            Thread.sleep(2000);
            if (cwEditorParaphraserPage.getLocatorText("Write something amazing!").get(0).isDisplayed()) {
                Assert.assertEquals(cwEditorParaphraserPage.getGcEditor().getText(), "");
                Assert.assertEquals(driver.getTitle(), "Free Grammar Checker - QuillBot AI");
            } else {
                WaitsTwo.waitForElementToBeVisible(driver, cwEditorWritingAreaPage.getPasteTextButton());
                Assert.assertEquals(driver.getTitle(), "Free Grammar Checker - QuillBot AI");
            }
            np.navigateToCoWriter();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getStartNewHeading());
            cwHomePageTest.tcCw03VerifyHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_114:Verify Co Writer Paraphraser Mode availability for Premium user",
            groups = {"Detailed", "Integration"})
    public void tcCw114VerifyCwParaphraserMode() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw05CreateProject();
            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("textWithGCError"));
            cwEditorBottomBarPage.clickBottomBarParaphrase();
            cwEditorParaphraserPage.clickModesDropdown();
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(0).getText(), "Standard");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(0).getAttribute("aria-selected"), "true");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(1).getText(), "Fluency");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(1).getAttribute("aria-selected"), "false");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(2).getText(), "Formal");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(2).getAttribute("aria-selected"), "false");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(3).getText(), "Simple");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(3).getAttribute("aria-selected"), "false");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(4).getText(), "Creative");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(4).getAttribute("aria-selected"), "false");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(5).getText(), "Expand");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(5).getAttribute("aria-selected"), "false");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(6).getText(), "Shorten");
            Assert.assertEquals(cwEditorParaphraserPage.getPphrModes().get(6).getAttribute("aria-selected"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5,
            description = "TC_CW_128:verify Co Writer Paraphraser simple mode functionality for Premium user",
            groups = {"Detailed", "Integration"})
    public void tcCw128VerifyCwPphrSimpleMode() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);

        try {
            cwEditorParaphraserPage.clickPphrMode(3);
            Assert.assertTrue(cwEditorParaphraserPage.getLocatorText("Modes:").get(0).isDisplayed());
            Assert.assertEquals(cwEditorParaphraserPage.getPphrSelectedMode().getText(), "Simple");

            cwEditorParaphraserPage.mouseOverSynonymsSlider();
            Assert.assertEquals(cwEditorParaphraserPage.getLocatorText("Synonyms:").get(0).getCssValue("color"), "rgba(160, 160, 160, 1)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6,
            description = "TC_CW_127:Verify Co Writer Paraphrased text limit checker functionality for premium user",
            groups = {"Detailed", "Integration"})
    public void tcCw127VerifyCwPphrTextLimit() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorPageTest coWriterEditorPageTest = new CwEditorPageTest();
        CwHomePageTest cwHomePageTest = new CwHomePageTest();

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("textWith126Words"));
            coWriterEditorPageTest.tcCw72VerifyEditorContextMenu();
            cwEditorSuggestTextPage.clickContextMenuOption(0);
            cwEditorParaphraserPage.clickExpandMoreIcon();
            Assert.assertEquals(cwEditorParaphraserPage.pphrInputBoxText(),
                    ConfigUtil.getDataFile("cowriter.json", "textWith125Words") + " getting");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7, description = "TC_CW_145:Summarized text limit checker toaster message for 6000 words",
            groups = {"Detailed", "Regression"})
    public void tcCw145VerifySmzrTextLimiter() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorPageTest coWriterEditorPageTest = new CwEditorPageTest();
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwHomePageTest.tcCw56RenameProject();

            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("textWith6001Words"));
            coWriterEditorPageTest.tcCw72VerifyEditorContextMenu();
            cwEditorSuggestTextPage.clickContextMenuOption(1);
            WaitsTwo.waitForElementToBeVisible(driver, cwEditorSummarizerPage.getSmzrLimitToaster("6000"));
            TakeSnapshot takeSnapshot = new TakeSnapshot(driver);
            takeSnapshot.captureScreen("menu.png");
            Assert.assertTrue(cwEditorSummarizerPage.getSmzrLimitToaster("6000").isDisplayed());
            WaitsTwo.waitForElementToBeInvisible(driver, cwEditorSummarizerPage.getSmzrLimitToaster("6000"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8, description = "TC_CW_146:Summarized input gets trimmed after 6000 words for premium user",
            groups = {"Detailed", "Regression"}, enabled = false)
    public void tcCw146VerifySmzrInputBox() throws Exception {
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);

        try {
            cwEditorSummarizerPage.clickExpandMoreIcon();
            Assert.assertEquals(cwEditorSummarizerPage.getCwSummarizerInputBox().getText(),
                    ConfigUtil.getDataFile("cowriter.json", "textWith6000Words"));
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}


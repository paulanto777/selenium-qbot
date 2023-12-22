package test.java.com.quill.tests.coWriter.premiumUser;

import main.java.com.quill.common.RetryAnalyzer;
import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.cowriter.*;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTest;
import test.java.com.quill.tests.BaseTestTwo;


public class CwEditorPageTest extends BaseTestTwo {

    @Test(priority = 1, description = "TC_CW_01:Verify Co Writer login functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw01VerifyLogin() throws Exception {
        LoginPage login = new LoginPage(driver);
        NavigationPage np = new NavigationPage(driver);
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            np.navigateToCoWriter().getStartedWithCowriter();
            login
                    .Enter_UserName(ConfigUtil.getDataFile("cowriter.json", "premiumUsername"))
                    .Enter_Password(ConfigUtil.getDataFile("cowriter.json", "premiumPassword"))
                    .Click_Login_Button()
                    .allowBrowserNotifications();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getStartNewHeading());
            Assert.assertEquals(driver.getTitle(), "Co-Writer | QuillBot AI");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2, description = "TC_CW_268:Verify co-writer editor bottom bar option displayed in default state",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw268VerifyEditorBottomBar() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);

        try {
            cwHomePageTest.tcCw05CreateProject();
            cwHomePageTest.tcCw56RenameProject();
            Assert.assertTrue(cwEditorBottomBarPage.getParaphraseIcon().get(0).isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getBottomBarParaphraseButton().isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getSummarizeIcon().get(0).isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getBottomBarSummarizeButton().isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getBottomBarSuggestTextIcon(1).isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getBottomBarSuggestTextButton().isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getBottomBarViewStatistics().isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getBottomBarGrammarErrors().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_280:Verify Enter text in the writing area",
            groups = {"BAT", "Detailed", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void tcCw280VerifyWritingAtEditor() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("text"));
            Assert.assertEquals(cwEditorWritingAreaPage.getWritingArea().getText(), cwEditorWritingAreaPage.enterTextInEditor("text"));
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_112:Verify bottom bar Analytics",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw112VerifyAnalytics() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            Assert.assertEquals(cwEditorBottomBarPage.getBottomBarViewStatistics().getText(), "23 Words");
            cwEditorBottomBarPage.clickViewStatistics();
            Assert.assertTrue(cwEditorBottomBarPage.getStatisticsHeading().isDisplayed());
            Assert.assertEquals(cwEditorBottomBarPage.getStatisticsCharactersCount().getText(), "137");
            Assert.assertEquals(cwEditorBottomBarPage.getStatisticsWordsCount().getText(), "23");
            Assert.assertEquals(cwEditorBottomBarPage.getStatisticsSentencesCount().getText(), "1");
            Assert.assertEquals(cwEditorBottomBarPage.getStatisticsParagraphsCount().getText(), "1");
            Assert.assertTrue(cwEditorBottomBarPage.getStatisticsReadingTime().isDisplayed());

            cwEditorBottomBarPage.clickViewStatistics();
            cwEditorWritingAreaPage.clickWritingArea();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, description = "TC_CW_55:Verify export functionality through File Menu",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw55ExportThroughEditor() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            cwEditorToolBarPage.clickToolBarExportIcon();
            Assert.assertTrue(cwEditorToolBarPage.getProjectExportMessage().isDisplayed());
            WaitsTwo.waitForElementToBeInvisible(driver, cwEditorToolBarPage.getProjectExportMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6, description = "TC_CW_72:Verify editor right click options with selected text",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw72VerifyEditorContextMenu() throws Exception {
        CwEditorPage cwEditorPage = new CwEditorPage(driver);
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);

        try {
            cwEditorSuggestTextPage.rightClickEditorText();
            if (cwEditorPage.device.equalsIgnoreCase("windows")) {
                Assert.assertEquals(cwEditorSuggestTextPage.getContextMenu().get(0).getText(), "Paraphrase\n" + "Ctrl+Shift+P");
                Assert.assertEquals(cwEditorSuggestTextPage.getContextMenu().get(1).getText(), "Summarize\n" + "Ctrl+Shift+S");
                Assert.assertEquals(cwEditorSuggestTextPage.getContextMenu().get(2).getText(), "Suggest Text\n" + "Ctrl+Spacebar");
            } else {
                Assert.assertEquals(cwEditorSuggestTextPage.getContextMenu().get(0).getText(), "Paraphrase\n" + "+Shift+P");
                Assert.assertEquals(cwEditorSuggestTextPage.getContextMenu().get(1).getText(), "Summarize\n" + "+Shift+S");
                Assert.assertEquals(cwEditorSuggestTextPage.getContextMenu().get(2).getText(), "Suggest Text\n" + "Ctrl+Shift+Spacebar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7, description = "TC_CW_107:Verify bottom bar GC errors", groups = {"BAT", "Detailed"},
            retryAnalyzer = RetryAnalyzer.class, enabled = false)
    public void tcCw107VerifyGCErrors() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("textWithGCError"));
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().
                    contains(cwEditorWritingAreaPage.enterTextInEditor("textWithGCError")));
            Thread.sleep(12000);
            cwEditorBottomBarPage.clickBottomBarGrammarErrors();
            cwEditorBottomBarPage.clickGCCard();
            Assert.assertTrue(cwEditorBottomBarPage.getFixAllGCErrors().isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getFixAllGCErrors().isEnabled());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8, description = "TC_CW_91:Verify GC Toggle OFF functionality", groups = {"BAT", "Detailed"},
            enabled = false)
    public void tcCw91VerifyGCToggleON() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);

        try {
            cwEditorBottomBarPage.clickHideGrammarErrors();
            Assert.assertTrue(cwEditorBottomBarPage.getTextNotRedHighlighted().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9, description = "TC_CW_92:Verify GC Toggle ON functionality", groups = {"BAT", "Detailed"},
            enabled = false)
    public void tcCw92VerifyGCToggleON() throws Exception {
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);

        try {
            cwEditorBottomBarPage.clickBottomBarGrammarErrors();
            cwEditorBottomBarPage.clickGCCard();
            cwEditorBottomBarPage.clickShowGrammarErrors();
            Assert.assertTrue(cwEditorBottomBarPage.getTextRedHighlighted().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10, description = "TC_CW_46:Verify Co Writer Upload Doc functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw46VerifyUploadDoc() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwEditorWritingAreaPage.uploadDoc();
            Assert.assertFalse(cwEditorWritingAreaPage.getUploadDocButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 11, description = "TC_CW_53:To verify Co Writer undo/redo functionality from tool bar",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw53VerifyUndoRedoAndCopy() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            cwEditorToolBarPage.undoRedoToolbar();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(
                    "A Simple PDF File This is a small demonstration ."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 12, description = "TC_CW_313:Verify Co Writer Generate Outline functionality at editor page",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw313VerifyOutlineGeneration() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwEditorWritingAreaPage.suggestOutline();
            cwEditorWritingAreaPage.generateOutline();
            Assert.assertTrue(cwEditorWritingAreaPage.getOutlinesInsertButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 13, description = "TC_CW_314:Verify Co Writer Outline insertion functionality at editor page",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw314VerifyOutlineInsertion() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorWritingAreaPage.insertOutline();
            Assert.assertFalse(cwEditorWritingAreaPage.getUploadDocButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 14, description = "TC_CW_81:To verify Co Writer copy text functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw81EditMenuCopy() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorPage cwEditorPage = new CwEditorPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwHomePageTest.tcCw56RenameProject();

            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("text"));
            Assert.assertEquals(cwEditorWritingAreaPage.getWritingArea().getText(), cwEditorWritingAreaPage.enterTextInEditor("text"));

            cwEditorWritingAreaPage.selectEditorText();
            cwEditorPage.clickEditMenu();
            cwEditorPage.clickEditMenuCopy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 15, description = "TC_CW_48:To verify Co Writer editor page move to Research functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw48VerifyEditorResearchButton() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwEditorWritingAreaPage.researchButton();
            Assert.assertTrue(cwEditorWritingAreaPage.getSearchIcon().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 16,
            description = "TC_CW_58:To verify Co Writer Delete Cancel project functionality through File menu",
            groups = {"Detailed", "Regression"})
    public void tcCw58VerifyDeleteCancel() throws Exception {
        CwEditorPage cwEditorPage = new CwEditorPage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwEditorPage.menuBarDelete();
            cwEditorPage.deleteCancelButton();
            Assert.assertTrue(cwEditorWritingAreaPage.getPasteTextButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 17, description = "TC_CW_59:To verify Co Writer Delete project functionality through File menu",
            groups = {"Detailed", "Regression"})
    public void tcCw59VerifyDeleteFromEditor() throws Exception {
        CwEditorPage cwEditorPage = new CwEditorPage(driver);
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwEditorPage.menuBarDelete();
            cwEditorPage.moveToTrashButton();
            Assert.assertTrue(cwHomePage.getFeedbackButton().isDisplayed());
            Assert.assertTrue(cwHomePage.getLearnMoreButton().isDisplayed());
            Assert.assertTrue(cwHomePage.getRecentProjectsHeading().isDisplayed());
            Assert.assertTrue(cwHomePage.getTrashIcon().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 18, description = "TC_CW_60:To verify Co Writer Deleted project availability in Trash",
            groups = {"Detailed", "Regression"})
    public void tcCw60VerifyDeletedProjectAtTrash() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickTrashIcon();
            Thread.sleep(2000);
            Assert.assertTrue(cwHomePage.getTrashProjectCard().get(0).getText().contains("Untitled Project"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

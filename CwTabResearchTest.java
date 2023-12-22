package test.java.com.quill.tests.coWriter.premiumUser;

import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.cowriter.*;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.Switch;
import main.java.com.quill.utilities.WaitsTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTest;
import test.java.com.quill.tests.BaseTestTwo;

public class CwTabResearchTest extends BaseTestTwo {

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

    @Test(priority = 2, description = "TC_CW_178:Verify Research tab", groups = {"BAT", "Detailed", "Regression"})
    public void tcCw178VerifyResearchTab() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorPageTest coWriterEditorPageTest = new CwEditorPageTest();
        CwEditorIconsTest cwEditorIconsTest = new CwEditorIconsTest();

        try {
            coWriterEditorPageTest.tcCw268VerifyEditorBottomBar();
            cwEditorIconsTest.tcCw269VerifyEditorRightSection();
            coWriterTabResearchPage.clickResearchOption();
            Assert.assertTrue(coWriterTabResearchPage.getResearchTabIcon().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getNotesTabIcon().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getCitationsTabIcon().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getCloseTab().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getBookmarksIcon().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getOpenBookmarks().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getSearchIcon().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_182:To verify Co Writer View Bookmark Drawer open functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw182VerifyBookmarkOpen() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.openBookmarkDrawer();
            Assert.assertTrue(coWriterTabResearchPage.getNoBookmarkText().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_183:To verify Co Writer View Bookmark Drawer close functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw183VerifyBookmarkClose() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.closeBookmarkDrawer();
            Assert.assertTrue(coWriterTabResearchPage.getSearchTheWebButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, description = "TC_CW_184:Verify Research search functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw184VerifySearchItem() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.enterSearchText();
            coWriterTabResearchPage.clickSearchTheWebButton();
            Assert.assertTrue(coWriterTabResearchPage.getContentButton().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getSearchIcon().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getSearchInputField().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getResearchCardMoreIcon().get(0).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6, description = "TC_CW_199:Verify Get Content button functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw199VerifyGetSourceData() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.clickGetContentButton();
            Assert.assertTrue(coWriterTabResearchPage.getFullArticleHeading().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getHighlightsHeading().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getTopicsHeading().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getViewAllHighlightsButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7, description = "TC_CW_205:Verify Research back button functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw205VerifyResearchBack() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.clickBackButton();
            Assert.assertTrue(coWriterTabResearchPage.getResearchCardOpenButton().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getContentButton().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getSearchIcon().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getSearchInputField().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8, description = "TC_CW_192:Verify save bookmark functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw192VerifySaveBookmark() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.addBookmark();
            Assert.assertTrue(coWriterTabResearchPage.getRemoveBookmarkButton().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getResearchCardOpenButton().get(0).isDisplayed());
            Assert.assertEquals(coWriterTabResearchPage.getOpenBookmarks().getText(), "Bookmarks (1)");

            coWriterTabResearchPage.openBookmarkSection();
            Assert.assertEquals(coWriterTabResearchPage.getBookmarkResultCard().size(), 1);
            Assert.assertTrue(coWriterTabResearchPage.getResearchCardOpenButton().get(0).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9, description = "TC_CW_195:Verify delete bookmark functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw195VerifyDeleteBookmark() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.deleteBookmark();
            Assert.assertTrue(coWriterTabResearchPage.getNoBookmarkText().isDisplayed());
            Assert.assertEquals(coWriterTabResearchPage.getBookmarkResultCard().size(), 0);

            coWriterTabResearchPage.closeBookmarkSection();
            Assert.assertTrue(coWriterTabResearchPage.getResearchCardOpenButton().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getAddBookmarkButton().get(0).isDisplayed());
            Assert.assertEquals(coWriterTabResearchPage.getOpenBookmarks().getText(), "Bookmarks ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10, description = "TC_CW_150:Verify Notes tab", groups = {"BAT", "Detailed", "Regression"})
    public void tcCw150VerifyNotesTab() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.clickNotesTab();
            Assert.assertTrue(coWriterTabResearchPage.getResearchTabIcon().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getNotesTabIcon().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getNotesTabOpened().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getCitationsTabIcon().get(0).isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getCloseTab().isDisplayed());

            coWriterTabResearchPage.enterNotes();
            Assert.assertEquals(coWriterTabResearchPage.getNotesEditor().getText(),
                    "You can write down your notes and ideas.");

            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.clickNotesOption();
            Assert.assertEquals(coWriterTabResearchPage.getNotesEditor().getText(),
                    "You can write down your notes and ideas.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 11, description = "TC_CW_193:Verify delete bookmark through source functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw193VerifyRemoveBookmark() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.clickResearchOption();
            coWriterTabResearchPage.addBookmark();
            coWriterTabResearchPage.removeBookmark();
            Assert.assertTrue(coWriterTabResearchPage.getAddBookmarkButton().get(0).isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 12, description = "TC_CW_206:To verify Co Writer Search and open button functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw206VerifyOpenButton() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.openButton();
            Assert.assertTrue(coWriterTabResearchPage.getFullArticleHeading().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getHighlightsHeading().isDisplayed());
            coWriterTabResearchPage.clickBackButton();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 13, description = "TC_CW_185:To verify Co Writer direct url Search functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw185VerifyDirectUrlSearch() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.directUrlSearch();
            Assert.assertTrue(coWriterTabResearchPage.getDirectUrlOpenButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 14, description = "TC_CW_190:To verify Co Writer Search and Report functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw190VerifyReport() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.report();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 15, description = "TC_CW_189:To verify Co Writer  Open Link functionality at Research section",
            groups = {"Detailed", "Regression"})
    public void tcCw189VerifyOpenLink() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.openLink();
            Switch.switchFromChildToParentWindow("Wipro | Digital, Technology, Business Solutions");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 16, description = "TC_CW_207:To verify Co Writer View all highlights button functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw207VerifyAllHighlights() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.clickViewAllHighlights();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 17, description = "TC_CW_208:To verify Co Writer get highlighted text functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw208VerifyGetHighlightedText() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.clickViewHighlightsText();
            Assert.assertFalse(coWriterTabResearchPage.getNoContentMessage().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 18, description = "TC_CW_213:To verify Co Writer get Topics list functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw213VerifyTopics() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.clickTopics();
            Assert.assertFalse(coWriterTabResearchPage.getNoContentMessage().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 19, description = "TC_CW_214:To verify Co Writer get Topic text functionality",
            groups = {"Detailed", "Regression"}, enabled = false)
    public void tcCw214VerifySelectTopic() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.checkTopicText();
            Assert.assertFalse(coWriterTabResearchPage.getNoContentMessage().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 20, description = "TC_CW_211:To verify Co Writer get Full Article text functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw211VerifyGetFullArticleText() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.clickViewFullArticleText();
            Assert.assertFalse(coWriterTabResearchPage.getNoContentMessage().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 21, description = "TC_CW_219:Verify Co Writer ribbon options available at Research page",
            groups = {"Detailed", "Regression"})
    public void tcCw219VerifyRibbonOptions() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);

        try {
            coWriterTabResearchPage.selectArticleText();
            Assert.assertTrue(cwEditorBottomBarPage.getParaphraseIcon().get(1).isDisplayed());
            Assert.assertTrue(cwEditorBottomBarPage.getSummarizeIcon().get(1).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 22, description = "TC_CW_223:Verify Co Writer text insertion through ribbon functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw223VerifyRibbonInsert() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            coWriterTabResearchPage.ribbonInsert();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(
                    coWriterTabResearchPage.getFullArticleText().getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 23, description = "TC_CW_224:Verify Co Writer paraphrasing through ribbon functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw224VerifyRibbonParaphraser() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);


        try {
            coWriterTabResearchPage.selectArticleText();
            coWriterTabResearchPage.ribbonParaphrase();
            Assert.assertTrue(cwEditorParaphraserPage.getParaphrasedText().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 24,
            description = "TC_CW_225:Verify Co Writer Insert paraphrased text through ribbon functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw225VerifyRibbonParaphraseInsert() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorParaphraserPage.clickParaphraserInsert();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(
                    cwEditorParaphraserPage.getParaphrasedText().getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 25, description = "TC_CW_226:Verify Co Writer summarizing through ribbon functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw226VerifyRibbonSummarizer() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);

        try {
            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.clickResearchOption();
            coWriterTabResearchPage.openButton();
            coWriterTabResearchPage.selectArticleText();
            coWriterTabResearchPage.ribbonSummarize();
            Assert.assertTrue(cwEditorSummarizerPage.getSummarizedOutputBox().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 26, description = "TC_CW_227:Verify Co Writer Insert summarized text through ribbon functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw227VerifyRibbonSummarizeInsert() throws Exception {
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorSummarizerPage.clickSummarizerInsert();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(
                    cwEditorSummarizerPage.getSummarizedOutputBox().getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 27,
            description = "TC_CW_217:Verify Co Writer research text operations through context menu functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw217VerifyContextMenuOperations() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);

        try {
            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.clickResearchOption();
            coWriterTabResearchPage.openButton();
            coWriterTabResearchPage.selectArticleText();
            coWriterTabResearchPage.performRightClick();
            Assert.assertTrue(coWriterTabResearchPage.getContextInsertWithCitation().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getResearchContextParaphrase().isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getResearchContextSummarize().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 28,
            description = "TC_CW_121:Verify Co Writer Paraphrase text functionality from Research Tab through right click",
            groups = {"Detailed", "Regression"})
    public void tcCw121VerifyContextMenuParaphrase() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);

        try {
            coWriterTabResearchPage.clickContextMenuParaphrase();
            Assert.assertTrue(cwEditorParaphraserPage.getParaphrasedText().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 29,
            description = "TC_CW_122:Verify Co Writer Paraphrased text Insert functionality from Research Tab",
            groups = {"Detailed", "Regression"})
    public void tcCw122VerifyContextMenuParaphraseInsert() throws Exception {
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorParaphraserPage.clickParaphraserInsert();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(
                    cwEditorParaphraserPage.getParaphrasedText().getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 30,
            description = "TC_CW_139:Verify Co Writer Summarize text functionality from Research Tab through right click",
            groups = {"Detailed", "Regression"})
    public void tcCw139VerifyContextMenuSummarize() throws Exception {
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);

        try {
            coWriterTabResearchPage.closeTab();
            coWriterTabResearchPage.clickResearchOption();
            coWriterTabResearchPage.openButton();
            coWriterTabResearchPage.selectArticleText();
            coWriterTabResearchPage.performRightClick();
            coWriterTabResearchPage.clickContextMenuSummarize();
            Assert.assertTrue(cwEditorSummarizerPage.getSummarizedOutputBox().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 31,
            description = "TC_CW_140:Verify Co Writer Summarize text Insert functionality from Research Tab",
            groups = {"Detailed", "Regression"})
    public void tcCw140VerifyContextMenuSummarizeInsert() throws Exception {
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorSummarizerPage.clickSummarizerInsert();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(
                    cwEditorSummarizerPage.getSummarizedOutputBox().getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
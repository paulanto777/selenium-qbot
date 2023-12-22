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

public class CwEditorSummarizerTest extends BaseTestTwo {
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

    @Test(priority = 2, description = "TC_CW_135:Verify Summarizer tab", groups = {"BAT", "Detailed", "Regression"},
            retryAnalyzer = RetryAnalyzer.class)
    public void tcCw135VerifyContextMenuSummarizer() throws Exception {
        CwEditorSummarizerPage cwEditorSummarizerPage = new CwEditorSummarizerPage(driver);
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorPageTest cwEditorPageTest = new CwEditorPageTest();
        CwEditorParaphraserPage cwEditorParaphraserPage = new CwEditorParaphraserPage(driver);

        try {
            cwHomePageTest.tcCw05CreateProject();
            cwHomePageTest.tcCw56RenameProject();
            cwEditorPageTest.tcCw280VerifyWritingAtEditor();
            cwEditorPageTest.tcCw72VerifyEditorContextMenu();
            cwEditorSuggestTextPage.clickContextMenuOption(1);
            Assert.assertEquals(cwEditorSummarizerPage.getKeySentencesButton().get(0).getText(), "Key Sentences");
            Assert.assertEquals(cwEditorSummarizerPage.getSummarizerParagraphButton().get(0).getText(), "Paragraph");
            Assert.assertTrue(cwEditorParaphraserPage.getLocatorText("Summary Length").get(1).isDisplayed());
            Assert.assertTrue(cwEditorParaphraserPage.getLocatorText("Short").get(0).isDisplayed());
            Assert.assertTrue(cwEditorParaphraserPage.getLocatorText("Long").get(0).isDisplayed());
            Assert.assertTrue(cwEditorSummarizerPage.getSmzrSummaryLengthSlider().get(1).isDisplayed());
            Assert.assertTrue(cwEditorParaphraserPage.getExpandMoreIcon().isDisplayed());
            Assert.assertTrue(cwEditorParaphraserPage.getPreviousParagraphArrow().isDisplayed());
            Assert.assertTrue(cwEditorParaphraserPage.getNextParagraphArrow().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_138:Verify Summarizer Insert button functionality",
            groups = {"BAT", "Detailed", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void tcCw138VerifySummarizerInsertButton() throws Exception {
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

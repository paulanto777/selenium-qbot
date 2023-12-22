package test.java.com.quill.tests.coWriter.premiumUser;

import main.java.com.quill.common.RetryAnalyzer;
import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.cowriter.CwEditorBottomBarPage;
import main.java.com.quill.pages.cowriter.CwEditorSuggestTextPage;
import main.java.com.quill.pages.cowriter.CwEditorWritingAreaPage;
import main.java.com.quill.pages.cowriter.CwHomePage;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTest;
import test.java.com.quill.tests.BaseTestTwo;

public class CwEditorSuggestTextTest extends BaseTestTwo {

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

    @Test(priority = 2, description = "TC_CW_80:Verify Suggest Content Context Menu functionality",
            groups = {"BAT", "Detailed", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void tcCw80VerifyContextMenuSuggestContent() throws Exception {
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorPageTest cwEditorPageTest = new CwEditorPageTest();
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePageTest.tcCw05CreateProject();
            cwHomePageTest.tcCw56RenameProject();

            cwEditorPageTest.tcCw280VerifyWritingAtEditor();
            cwEditorPageTest.tcCw72VerifyEditorContextMenu();

            cwEditorSuggestTextPage.clickContextMenuOption(2);
            WaitsTwo.waitForElementToBeVisible(driver, cwEditorSuggestTextPage.getSuggestContentList());
            String suggestContentText = cwEditorSuggestTextPage.getSuggestContentList().getText();
            cwEditorSuggestTextPage.selectSuggestion();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(suggestContentText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_77:Verify Suggest Content functionality through bottom bar",
            groups = {"Detailed", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void tcCw77SuggestContentByBottomBar() throws Exception {
        CwHomePageTest cwHomePageTest = new CwHomePageTest();
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);

        try {
            cwHomePageTest.tcCw43HomeIcon();
            cwHomePageTest.tcCw05CreateProject();
            cwHomePageTest.tcCw56RenameProject();

            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("text"));
            Assert.assertEquals(cwEditorWritingAreaPage.getWritingArea().getText(), cwEditorWritingAreaPage.enterTextInEditor("text"));
            cwEditorBottomBarPage.clickBottomBarSuggestContent();

            String suggestContentText = cwEditorSuggestTextPage.getSuggestContentList().getText();
            cwEditorSuggestTextPage.selectSuggestion();
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(suggestContentText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_61:Verify Suggest Content functionality through shortcuts",
            groups = {"BAT", "Detailed", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void tcCw61SuggestContentByHotKeys() throws Exception {
        CwEditorSuggestTextPage cwEditorSuggestTextPage = new CwEditorSuggestTextPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("textWith126Words"));
            String suggestContentText = cwEditorSuggestTextPage.suggestContent();
            cwEditorSuggestTextPage.selectSuggestion();
            Thread.sleep(5000);
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains(suggestContentText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

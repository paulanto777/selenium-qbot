package test.java.com.quill.tests.coWriter.premiumUser;

import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.citationGenerator.CGPage;
import main.java.com.quill.pages.cowriter.CwHomePage;
import main.java.com.quill.pages.cowriter.CwTabCitationsPage;
import main.java.com.quill.pages.cowriter.CwTabResearchPage;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTest;
import test.java.com.quill.tests.BaseTestTwo;
import test.java.com.quill.tests.citationGenerator.not_logged_In_User.CGGuestUserBAT;

public class CwTabCitationsTest extends BaseTestTwo {

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

    @Test(priority = 2, description = "TC_CW_230:Verify Citations tab", groups = {"BAT", "Detailed", "Regression"})
    public void tcCw230VerifyCitationsTab() throws Exception {
        CwEditorPageTest coWriterEditorPageTest = new CwEditorPageTest();
        CwTabCitationsPage coWriterTabCitationsPage = new CwTabCitationsPage(driver);
        CwTabResearchPage coWriterTabResearchPage = new CwTabResearchPage(driver);
        CwEditorIconsTest cwEditorIconsTest = new CwEditorIconsTest();

        CGPage cgPage = new CGPage(driver);

        try {
            coWriterEditorPageTest.tcCw268VerifyEditorBottomBar();
            cwEditorIconsTest.tcCw269VerifyEditorRightSection();

            coWriterTabCitationsPage.clickCitationsOption();
            Assert.assertTrue(coWriterTabCitationsPage.getCreateCitationPlaceHolderText().isDisplayed());
            Assert.assertEquals(cgPage.getCitationName(), "MLA: Modern Language Association 9th edition");
            Assert.assertTrue(cgPage.citationStyleLabel.isDisplayed());
            Assert.assertTrue(coWriterTabResearchPage.getCloseTab().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_243:Verify compose citation functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw243VerifyComposeCitation() throws Exception {
        CGGuestUserBAT cGGuestUserBAT = new CGGuestUserBAT();
        CwTabCitationsPage coWriterTabCitationsPage = new CwTabCitationsPage(driver);

        try {
            coWriterTabCitationsPage.clickCreateCitationButton();
            cGGuestUserBAT.compose_Button_Create_Citation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_236:Create citation with Website citation source",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw236VerifyWebCitationCreation() throws Exception {
        CGGuestUserBAT cGGuestUserBAT = new CGGuestUserBAT();
        CwTabCitationsPage coWriterTabCitationsPage = new CwTabCitationsPage(driver);

        try {
            coWriterTabCitationsPage.clickCreateCitationButton();
            cGGuestUserBAT.cite_Website_Citation_Source();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, description = "TC_CW_250:Verify clone citation functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw250VerifyCloneCitation() throws Exception {
        CGPage cgPage = new CGPage(driver);
        CwTabCitationsPage coWriterTabCitationsPage = new CwTabCitationsPage(driver);

        try {
            coWriterTabCitationsPage.clickCitationCardMoreButton();
            cgPage.clickCloneCitation();
            WaitsTwo.waitForElementToBeVisible(driver, cgPage.composeCitationCard.get(1));
            Assert.assertEquals(coWriterTabCitationsPage.getInsertCitationCardButton().size(), 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6, description = "TC_CW_251:Verify delete citation functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw251VerifyCloneCitation() throws Exception {
        CwTabCitationsPage coWriterTabCitationsPage = new CwTabCitationsPage(driver);

        try {
            coWriterTabCitationsPage
                    .clickCitationCardMoreButton()
                    .clickDeleteOption();
            Assert.assertEquals(coWriterTabCitationsPage.getInsertCitationCardButton().size(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

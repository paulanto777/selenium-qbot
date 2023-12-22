package test.java.com.quill.tests.coWriter.premiumUser;

import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.cowriter.CwEditorPage;
import main.java.com.quill.pages.cowriter.CwEditorToolBarPage;
import main.java.com.quill.pages.cowriter.CwHomePage;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.WaitsTwo;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTest;
import test.java.com.quill.tests.BaseTestTwo;


public class CwEditorIconsTest extends BaseTestTwo {

    @Test(priority = 1, description = "TC_CW_01:Verify Co Writer login functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw01VerifyLogin() throws Exception {
        LoginPage login = new LoginPage(driver);
        NavigationPage np = new NavigationPage(driver);
        CwEditorPageTest cwEditorPageTest = new CwEditorPageTest();
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
            cwEditorPageTest.tcCw268VerifyEditorBottomBar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2,
            description = "TC_CW_269:Verify co-writer editor Research/Notes/Citations/feedback Tab displayed in default state",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw269VerifyEditorRightSection() throws Exception {
        CwEditorPage cwEditorPage = new CwEditorPage(driver);

        try {
            Assert.assertTrue(cwEditorPage.getResearchTabIcon().get(1).isDisplayed());
            Assert.assertTrue(cwEditorPage.getResearchOption().isDisplayed());
            Assert.assertTrue(cwEditorPage.getNotesTabIcon().get(1).isDisplayed());
            Assert.assertTrue(cwEditorPage.getNotesOption().isDisplayed());
            Assert.assertTrue(cwEditorPage.getCitationsTabIcon().get(1).isDisplayed());
            Assert.assertTrue(cwEditorPage.getCitationsOption().isDisplayed());
            Assert.assertTrue(cwEditorPage.getEditorFeedBack().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_270:Verify co-writer editor menu bar displayed",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw270VerifyEditorMenuBar() throws Exception {
        CwEditorPage cwEditorPage = new CwEditorPage(driver);

        try {
            Assert.assertTrue(cwEditorPage.getMenuBarFile().isDisplayed());
            Assert.assertTrue(cwEditorPage.getMenuBarEdit().isDisplayed());
            Assert.assertTrue(cwEditorPage.getMenuBarInsert().isDisplayed());
            Assert.assertTrue(cwEditorPage.getMenuBarFormat().isDisplayed());
            Assert.assertTrue(cwEditorPage.getMenuBarHelp().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_271:Verify co-writer editor tool bar Undo and Redo icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw271VerifyUndoRedoIcons() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarUndoIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarUndoIcon().getAttribute("aria-disabled"), "true");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarRedoIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarRedoIcon().getAttribute("aria-disabled"), "true");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, description = "TC_CW_272:Verify co-writer editor tool bar Format dropdown",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw272VerifyFormatDropdown() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarFormatDropdown().isEnabled());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarFormatDropdown().getAttribute("aria-expanded"), "false");
            Assert.assertEquals(cwEditorToolBarPage.getToolbarFormatDropdown().getText(), "Paragraph");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6, description = "TC_CW_273:Verify co-writer editor tool bar Font dropdown",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw273VerifyFontsDropdown() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarFontsDropdown().isEnabled());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarFontsDropdown().getAttribute("aria-expanded"), "false");
            Assert.assertEquals(cwEditorToolBarPage.getToolbarFontsDropdown().getText(), "Arial");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7, description = "TC_CW_274:Verify co-writer editor tool bar Font Style icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw274VerifyFontStyles() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarBoldIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarBoldIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarItalicIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarItalicIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarUnderlineIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarUnderlineIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarTextColorIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarTextColorIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarBackgroundColorIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarBackgroundColorIcon().
                    getAttribute("aria-disabled"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8, description = "TC_CW_275:Verify co-writer editor tool bar Alignment icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw275VerifyToolbarAlignmentIcons() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarAlignLeftIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarAlignLeftIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarAlignCenterIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarAlignCenterIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarAlignRightIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarAlignRightIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarJustifyIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarJustifyIcon().getAttribute("aria-disabled"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9, description = "TC_CW_276:Verify co-writer editor tool bar Line Height icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw276VerifyLineHeightIcons() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarLineHeightIcon().isEnabled());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarLineHeightIcon().getAttribute("aria-expanded"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10,
            description = "TC_CW_277:Verify co-writer editor tool bar Bullet List, Numbered List, Decrease Indent and Increase Indent icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw277VerifyListAndIndentIcons() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarBulletListIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarBulletListIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarNumberedListIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarNumberedListIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarDecreaseIndentIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarDecreaseIndentIcon().getAttribute("aria-disabled"), "true");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarIncreaseIndentIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarIncreaseIndentIcon().getAttribute("aria-disabled"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 11, description = "TC_CW_278:Verify co-writer editor tool bar Clear Formatting icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw278VerifyClearFormattingIcon() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarClearFormattingIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarClearFormattingIcon().
                    getAttribute("aria-disabled"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 12, description = "TC_CW_279:Verify co-writer editor tool bar Print and Export icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw279VerifyPrintAndExportIcon() throws Exception {
        CwEditorToolBarPage cwEditorToolBarPage = new CwEditorToolBarPage(driver);

        try {
            Assert.assertTrue(cwEditorToolBarPage.getToolbarPrintIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarPrintIcon().getAttribute("aria-disabled"), "false");
            Assert.assertTrue(cwEditorToolBarPage.getToolbarExportIcon().isDisplayed());
            Assert.assertEquals(cwEditorToolBarPage.getToolbarExportIcon().getAttribute("aria-disabled"), "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

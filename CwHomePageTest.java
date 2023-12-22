package test.java.com.quill.tests.coWriter.premiumUser;

import com.aventstack.extentreports.Status;
import main.java.com.quill.common.RetryAnalyzer;
import main.java.com.quill.pages.LoginPage;
import main.java.com.quill.pages.NavigationPage;
import main.java.com.quill.pages.cowriter.CwEditorBottomBarPage;
import main.java.com.quill.pages.cowriter.CwEditorPage;
import main.java.com.quill.pages.cowriter.CwEditorWritingAreaPage;
import main.java.com.quill.pages.cowriter.CwHomePage;
import main.java.com.quill.utilities.ConfigUtil;
import main.java.com.quill.utilities.Switch;
import main.java.com.quill.utilities.WaitsTwo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.com.quill.tests.BaseTest;
import test.java.com.quill.tests.BaseTestTwo;

public class CwHomePageTest extends BaseTestTwo {

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

    @Test(priority = 2, description = "TC_CW_03:Verify Co-Writer home page", groups = {"BAT", "Detailed"})
    public void tcCw03VerifyHomePage() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            Assert.assertTrue(cwHomePage.getHomepageTitle().isDisplayed());
            Assert.assertTrue(cwHomePage.getStartNewHeading().isDisplayed());
            Assert.assertEquals(cwHomePage.getTextTemplateCard(0), "Blank Project");
            Assert.assertEquals(cwHomePage.getTextTemplateCard(1), "Blog");
            Assert.assertEquals(cwHomePage.getTextTemplateCard(2), "Essay");
            Assert.assertEquals(cwHomePage.getTextTemplateCard(3), "Research Paper\n" + "MLA Style");
            Assert.assertEquals(cwHomePage.getTextTemplateCard(4), "Research Paper\n" + "APA Style");
            Assert.assertTrue(cwHomePage.getFeedbackButton().isDisplayed());
            Assert.assertTrue(cwHomePage.getLearnMoreButton().isDisplayed());
            Assert.assertTrue(cwHomePage.getRecentProjectsHeading().isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardGridView().get(0).isDisplayed());
            Assert.assertTrue(cwHomePage.getSearchProjectIcon().get(1).isDisplayed());
            Assert.assertTrue(cwHomePage.getListViewIcon().isDisplayed());
            Assert.assertTrue(cwHomePage.getSortByIcon().isDisplayed());
            Assert.assertTrue(cwHomePage.getTrashIcon().isDisplayed());
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3, description = "TC_CW_05:Create new project using Blank project template",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw05CreateProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwEditorPage cwEditorPage = new CwEditorPage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);

        try {
            cwHomePage.clickBlankProjectTemplate();
            Assert.assertEquals(cwEditorWritingAreaPage.getEditorPlaceholder().getText(),
                    "Start writing or search for content by clicking \n" + "Research\n" + "Paste Text\n" + "Upload Doc\n"
                            + "Suggest Outline");
            Assert.assertTrue(cwEditorWritingAreaPage.getPasteTextButton().isDisplayed());
            Assert.assertTrue(cwEditorWritingAreaPage.getUploadDocButton().isDisplayed());
            Assert.assertEquals(cwEditorBottomBarPage.getBottomBarViewStatistics().getText(), "0 Words");
            Assert.assertEquals(cwEditorPage.getProjectTitleField().getAttribute("data-value"), "Untitled Project");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, description = "TC_CW_56:Verify Edit and rename project title",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw56RenameProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.renameProjectTitle();
            Assert.assertTrue(cwHomePage.getProjectTitleField().getAttribute("data-value").contains(
                    System.getProperty("Project name")));
            logger.log(Status.INFO, "Project name is "+ System.getProperty("Project name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 5, description = "TC_CW_49:Enter text in the writing area",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw49EnterText() throws Exception {
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwEditorWritingAreaPage.writingEditor(cwEditorWritingAreaPage.enterTextInEditor("text"));
            Assert.assertEquals(cwEditorWritingAreaPage.getWritingArea().getText(), cwEditorWritingAreaPage.enterTextInEditor("text"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 6, description = "TC_CW_43:Verify the Editor Co-writer home icon functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw43HomeIcon() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickCoWriterHomeIcon();
            tcCw03VerifyHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 7, description = "TC_CW_21:Verify co-writer homepage - Search Project icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw21SearchProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickSearchIcon();
            Assert.assertTrue(cwHomePage.getSearchProjectInputField().isDisplayed());
            Assert.assertTrue(cwHomePage.getSearchProjectIcon().get(0).isDisplayed());

            cwHomePage.enterProjectName();
            Thread.sleep(5000);
            Assert.assertTrue(cwHomePage.getProjectCardGridView().get(0).getText().contains(System.getProperty("Project name")));
            Assert.assertEquals(cwHomePage.getProjectCardGridView().size(), 1);

            cwHomePage.clearSearchProjectField();
            Thread.sleep(5000);
            Assert.assertTrue(cwHomePage.getProjectCardGridView().size() > 1);
            Assert.assertTrue(cwHomePage.getProjectCardGridView().get(0).getText().contains(System.getProperty("Project name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 8, description = "TC_CW_18:Verify co-writer homepage - List View icon",
            groups = {"BAT", "Detailed"})
    public void tcCw18ListView() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickListViewIcon();
            Assert.assertTrue(cwHomePage.getListViewTitleColumn().isDisplayed());
            Assert.assertTrue(cwHomePage.getListViewSizeColumn().isDisplayed());
            Assert.assertTrue(cwHomePage.getListViewDateColumn().isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardListView().get(0).isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardExportIconListView().isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardMoreIconListView().isDisplayed());
            Assert.assertTrue(cwHomePage.getGridViewIcon().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 9, description = "TC_CW_20:Verify co-writer homepage - Sort By icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw20SortBy() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickSortByIcon();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getSortByDateModified());
            Assert.assertTrue(cwHomePage.getSortByDateModified().isDisplayed());
            Assert.assertTrue(cwHomePage.getSortByName().isDisplayed());
            Assert.assertTrue(cwHomePage.getSortBySize().isDisplayed());
            cwHomePage.clickSortByName();
            Assert.assertFalse(cwHomePage.getProjectCardListView().get(0).getText().contains(System.getProperty("Project name")));

            cwHomePage.clickSortByIcon();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getSortBySize());
            cwHomePage.clickSortBySize();
            Assert.assertFalse(cwHomePage.getProjectCardListView().get(0).getText().contains(System.getProperty("Project name")));

            cwHomePage.clickSortByIcon();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getSortBySize());
            cwHomePage.clickSortByDateModified();
            Assert.assertTrue(cwHomePage.getProjectCardListView().get(0).getText().contains(System.getProperty("Project name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 10, description = "TC_CW_19:Verify co-writer homepage - Grid View icon",
            groups = {"BAT", "Detailed"})
    public void tcCw19GridView() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickGridViewIcon();
            Assert.assertTrue(cwHomePage.getListViewIcon().isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardGridView().get(0).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 11, description = "TC_CW_11:Verify co-writer delete project functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw11DeleteProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.mouseoverProjectCard(0);
            Assert.assertTrue(cwHomePage.getProjectCardMoreIconGridView().get(0).isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardExportIconGridView().get(0).isDisplayed());

            cwHomePage.clickMoreIcon(0);
            Assert.assertTrue(cwHomePage.getDeleteProjectIcon().isDisplayed());
            Assert.assertTrue(cwHomePage.getOpenInNewTabIcon().isDisplayed());

            cwHomePage.deleteProject();
            WaitsTwo.waitForElementToBeVisible(driver, cwHomePage.getDeleteToasterMessage());
            Assert.assertTrue(cwHomePage.getDeleteToasterMessage().isDisplayed());
            WaitsTwo.waitForElementToBeInvisible(driver, cwHomePage.getDeleteToasterMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 12, description = "TC_CW_12:Verify co-writer homepage - Trash icon",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw12TrashIcon() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickTrashIcon();
            Thread.sleep(5000);
            Assert.assertTrue(cwHomePage.getTrashPageHeading().isDisplayed());
            Assert.assertTrue(cwHomePage.getTrashPageBackButton().isDisplayed());
            Assert.assertTrue(cwHomePage.getDeleteForeverIcon().isDisplayed());
            Assert.assertTrue(cwHomePage.getRestoreProjectIcon().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 13, description = "TC_CW_14:Verify deleted project is displayed in Trashed projects",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw14TrashedProjects() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            Assert.assertTrue(cwHomePage.getTrashProjectCard().get(0).getText().contains(System.getProperty("Project name")));
            Assert.assertEquals(cwHomePage.getTrashProjectCardPreviewText().get(0).getText(),
                    (cwEditorWritingAreaPage.enterTextInEditor("text")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 14, description = "TC_CW_15:Verify co-writer Trash - Restore project option",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw15RestoreProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            int beforeRestoreProject = cwHomePage.getTrashProjectCard().size();
            cwHomePage.clickRestoreProjectIcon();
            Thread.sleep(5000);
            int afterRestoreProject = cwHomePage.getTrashProjectCard().size() + 1;
            Assert.assertEquals(beforeRestoreProject, afterRestoreProject);
            Assert.assertFalse(cwHomePage.getTrashProjectCard().get(0).getText().contains(System.getProperty("Project name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 15, description = "TC_CW_13:Verify co-writer Trash back button functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw13TrashBackButton() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePage.clickTrashBackButton();
            Thread.sleep(5000);
            Assert.assertTrue(cwHomePage.getProjectCardGridView().get(0).getText().contains(System.getProperty("Project name")));
            Assert.assertEquals(cwHomePage.getProjectCardGridViewPreviewText().get(0).getText(),
                    (cwEditorWritingAreaPage.enterTextInEditor("text")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 16, description = "TC_CW_16:Verify co-writer Trash - Delete Forever option",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw16DeleteForever() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            tcCw11DeleteProject();
            tcCw12TrashIcon();

            int beforeProjectDeletion = cwHomePage.getTrashProjectCard().size();
            cwHomePage.clickDeleteForeverIcon();
            Thread.sleep(5000);
            int afterProjectDeletion = cwHomePage.getTrashProjectCard().size() + 1;
            Assert.assertEquals(beforeProjectDeletion, afterProjectDeletion);
            Assert.assertNotEquals(cwHomePage.getTrashProjectCard().get(0).getText(), (System.getProperty("Project name")));

            cwHomePage.clickTrashBackButton();
            Thread.sleep(5000);
            Assert.assertNotEquals(cwHomePage.getProjectCardGridView().get(0).getText(), (System.getProperty("Project name")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 17, description = "TC_CW_07:Create new project using Essay template", groups = {"BAT", "Detailed"})
    public void tcCw07EssayTemplate() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);
        CwEditorBottomBarPage cwEditorBottomBarPage = new CwEditorBottomBarPage(driver);
        CwEditorIconsTest cwEditorIconsTest = new CwEditorIconsTest();

        try {
            cwHomePage.clickEssayTemplate();
            Assert.assertEquals(cwHomePage.getProjectTitleField().getAttribute("data-value"), "Essay");
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains("Include your title here."));
            Assert.assertFalse(cwEditorWritingAreaPage.getPasteTextButton().isDisplayed());
            Assert.assertFalse(cwEditorWritingAreaPage.getUploadDocButton().isDisplayed());
            Assert.assertEquals(cwEditorBottomBarPage.getBottomBarViewStatistics().getText(), "529 Words");

            cwEditorIconsTest.tcCw269VerifyEditorRightSection();
            cwEditorIconsTest.tcCw270VerifyEditorMenuBar();
            cwHomePage.clickCoWriterHomeIcon();
            tcCw03VerifyHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 18, description = "TC_CW_10:Verify home page export functionality", groups = {"BAT", "Detailed"},
            enabled = false)
    public void tcCw10HomeProjectExport() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwEditorPage cwEditorPage = new CwEditorPage(driver);

        try {
            cwHomePage.mouseoverProjectCard(0);
            cwHomePage.clickExportIcon();
            Assert.assertTrue(cwEditorPage.getProjectExportMessage().isDisplayed());
            WaitsTwo.waitForElementToBeInvisible(driver, cwEditorPage.getProjectExportMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 19,
            description = "TC_CW_09:To verify Co Writer Open in new tab for existing projects functionality",
            groups = {"BAT", "Detailed", "Regression"})
    public void tcCw09OpenInNewTab() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            System.setProperty("Project title", cwHomePage.getProjectCardGridView().get(0).getText());
            cwHomePage.mouseoverProjectCard(0);
            Assert.assertTrue(cwHomePage.getProjectCardMoreIconGridView().get(0).isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardExportIconGridView().get(0).isDisplayed());

            cwHomePage.clickMoreIcon(0);
            Assert.assertTrue(cwHomePage.getDeleteProjectIcon().isDisplayed());
            Assert.assertTrue(cwHomePage.getOpenInNewTabIcon().isDisplayed());

            cwHomePage.clickOpenInNewTab();
            Switch.SwitchToLastWindow();
            cwHomePage.switchToNewWindow();
            Assert.assertTrue((System.getProperty("Project title")).contains(
                    cwHomePage.getProjectTitleField().getAttribute("data-value")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 20, description = "TC_CW_08:Open existing projects displayed under Recent projects",
            groups = {"BAT", "Detailed", "Regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void tcCw08OpenExistingProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickCoWriterHomeIcon();
            tcCw03VerifyHomePage();

            System.setProperty("Project title", cwHomePage.getProjectCardGridView().get(1).getText());
            cwHomePage.mouseoverProjectCard(1);
            Assert.assertTrue(cwHomePage.getProjectCardMoreIconGridView().get(1).isDisplayed());
            Assert.assertTrue(cwHomePage.getProjectCardExportIconGridView().get(1).isDisplayed());

            cwHomePage.clickProjectCard(1);
            Thread.sleep(4000);
            Assert.assertTrue((System.getProperty("Project title")).contains(
                    cwHomePage.getProjectTitleField().getAttribute("data-value")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 21, description = "TC_CW_06:To verify Co Writer Sample projects functionality",
            groups = {"Detailed", "Regression"})
    public void tcCw06VerifySampleProject() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);
        CwEditorWritingAreaPage cwEditorWritingAreaPage = new CwEditorWritingAreaPage(driver);

        try {
            cwHomePage.clickCoWriterHomeIcon();
            cwHomePage.clickSampleProject();
            Assert.assertEquals(cwHomePage.getProjectTitleField().getAttribute("data-value"), "Research Paper");
            Assert.assertTrue(cwEditorWritingAreaPage.getWritingArea().getText().contains("The Title of Your Report"));
            Assert.assertFalse(cwEditorWritingAreaPage.getPasteTextButton().isDisplayed());
            Assert.assertFalse(cwEditorWritingAreaPage.getUploadDocButton().isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 22, description = "TC_CW_04:To verify Co Writer Tutorials page",
            groups = {"Detailed", "Regression"})
    public void tcCw04VerifyLearnMore() throws Exception {
        CwHomePage cwHomePage = new CwHomePage(driver);

        try {
            cwHomePage.clickCoWriterHomeIcon();
            cwHomePage.clickLearnMore();
            Switch.switchToWindowtitle("Co-Writer | QuillBot Help Center");
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

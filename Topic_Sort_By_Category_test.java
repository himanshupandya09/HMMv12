package com.qait.hbp.hmm12.tests;

import org.testng.annotations.Test;

import com.qait.hbp.automation.TestSessionInitiator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static com.qait.hbp.automation.utils.YamlReader.getData;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class Topic_Sort_By_Category_test {

	TestSessionInitiator test;
	String[] browserSizes={"720x360"};
	String layoutTags[]={"all"};

	@BeforeClass
	@Parameters("browser")
	public void start_test_session(@Optional String browser) {
		test=new TestSessionInitiator("BaseAnnotation_Test","chrome");
		test.loginpage.getBaseUrlToTest(); }	

	@Test
	public void Test01_Launch_Application() {
		test.loginpage.launchApplication("hmm12");
		test.loginpage.verify_login_page();	 
	}

	@Test
	public void Test02_Login_To_Application_Using_Correct_Base_User_Credentials()
	{
		test.loginpage.login_to_the_application_as(getData("HMM12.LxUsers.default.username"), getData("HMM12.LxUsers.default.password"));
		test.homepage.verify_Home_Page();
	}

	@Test
	public void Test03_Verify_Category_Dropdown_On_HomePage_Displayed()
	{
		test.lxHomePage.VerifyThatViewCategoryOrRoleDropdownIsDisplayed1();
	}

	@Test
	public void Test04_Ensure_All_The_Option_Are_Present_Under_The_List_View_Options1_On_HomePage_Displayed()
	{
		test.lxHomePage.EnsureAllTheOptionArePresentUnderTheListViewOptions1();
	}

	@Test
	public void Test05_Verify_That_Learner_Can_Browse_List_Of_Topics_By_Categories1_On_HomePage_Displayed()
	{
		test.lxHomePage.VerifyThatLearnerCanBrowseListOfTopicsByCategories1();
	}

	@Test
	public void Test06_Verify_That_Topics_Related_To_Lead_Yourself_Are_Displayed()
	{
		test.lxHomePage.SelectCategoryLeadYourSelf();
		test.lxHomePage.VerifyThatTopicsRelatedToLeadYourselfAreDisplayed();
	}

	@Test
	public void Test07_Verify_That_Topics_Related_To_Lead_Others_Are_Displayed(){
		test.lxHomePage.SelectCategoryLEADOTHERS();
		test.lxHomePage.VerifyThatTopicsRelatedToLeadOthersAreDisplayed();
	}
	@Test
	public void Test08_Verify_That_Topics_Related_To_Lead_Others_Are_Displayed(){
		test.lxHomePage.SelectCategoryLEADTHEBUSINESS();
		test.lxHomePage.VerifyThatTopicsRelatedLEADTHEBUSINESSAreDisplayed();
	}


	@AfterMethod
	public void takeScreenshotonFailure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result); 
	}
	@AfterClass
	public void Stop_Test_Session() {
		test.closeTestSession();
	}

}

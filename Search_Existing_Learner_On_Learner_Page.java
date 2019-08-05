package com.qait.hbp.hmm12.tests_AX;

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

public class Search_Existing_Learner_On_Learner_Page {
	
	
	TestSessionInitiator test;

	String[] browserSizes = {"720x360"}; 
	String [] layoutTags = {"all"};
	@BeforeClass
	   @Parameters("browser")
		public void start_test_session(@Optional String browser) {
			test = new TestSessionInitiator("Learner_Registration_Test", browser);
			test.loginpage.getBaseUrlToTest();
		}
	@Test
	public void Test01_Launch_Application(){
		test.loginpage.launchApplication("hmm12admin");
		test.loginpage.verify_User_Is_On_Login_Page();
	}

	@Test
	public void Test02_Login_To_Application_Using_Correct_Admin_Credentials() {
		test.loginpage.login_to_the_application_as(getData("HMM12.AxUsers.CompanyMesage.username"),getData("HMM12.AxUsers.CompanyMesage.password"));
		test.homepage.verify_user_is_on_admin_page();
	}
	@Test
	public void Test04_Verify_Learner_Is_Navigated_To_Learners_Tab_On_Admin_Console(){
		test.userReg.isLearnerTabPresentOnAdminConsole();
		}
//	@Test
//	public void Test05_Search_The_Existing_Learner_On_Learner_Page()
//	{	
//		
//		//test.adminConsole.EnsureThatSearchByFirstNameTextBoxIsDisplayedFunctional();
//		//test.adminConsole.performSearch("Himanshu");
//	    	}
  
  @Test
  public void Test06_Display_Learner_Search_Result_Of_Learner_On_Admin_Console()
  {
	  test.learnersTab.killtour();
	test.adminConsole.performSearch("Himanshu");
	  //test.adminConsole.DisplayTheSearchResultOfLearnerOnAdminConsole();
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

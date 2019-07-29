package com.qait.hbp.hmm12.tests;

import org.testng.annotations.Test;



import com.qait.hbp.automation.TestSessionInitiator;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import static com.qait.hbp.automation.utils.YamlReader.getData;

import javax.xml.ws.spi.http.HttpContext;

import static com.qait.hbp.automation.utils.YamlReader.getData;
public class Landing_Course_Page_Test {
	
	//WebDriver driver=new ChromeDriver();
	TestSessionInitiator test;
	String[] browserSizes={"720x360"};
	String layoutTags[]={"all"};
	
	
	@BeforeClass
	@Parameters("browser")
	  public void start_test_session(@Optional String browser) {
		test=new TestSessionInitiator("BaseAnnotation_Test","chrome");
		test.loginpage.getBaseUrlToTest();
		
	  }	
  @Test
  public void Test01_Launch_Application() {
	  test.loginpage.launchApplication("hmm12");
	   
	  test.loginpage.verify_login_page();
	 
	 
  }
 @Test
  public void Test02_Login_To_Application_Using_Correct_Base_User_Credentials()
  {
	 test.loginpage.login_to_the_application_as(getData("HMM12.LxUsers.default.username"), getData("HMM12.LxUsers.default.password"));
	  //test.loginpage.Login_To_Application_Using_Correct_Credentials();
	 test.homepage.verify_Home_Page();
  }
  
 @Test
 public void Test03_Verify_Home_Page()
 {
	 test.homepage.verify_Home_Page();
 }
 @Test
 public void Test04_Verify_Topic_Landing_Page()
 {
	  test.homepage.Go_To_topicLandingPage(getData("topic_name1"));
 }
  @Test
  public void Test05_Comany_Image_Is_Displayed() {
	  test.homepage.Company_Image_Is_Played();
  }
  
  @Test
  public void Test06_Learner_Name_Is_Displayed()
  {
	  test.homepage.LearnerNameIsDisplayed();
  }
//  @Test
//  public void Test05_Go_to_Topic_Landing_Page(String path)
//  {
//	   
//	  test.homepage.Go_To_topicLandingPage();
//  }
  
  
  
  @Test
  public void Test07_Home_Link_Is_Displayed()
  {
	  test.homepage.HomeLinkIsDisplayed();
  }
  
//   @Test
//  public void Test08_Lesson_Assesment_OTJ_Link_Is_Displayed()
//  {
//	  test.homepage.Lesson_Assesment_OnTheJob_isDisplayed();
//  }
  @Test
  public void Test08_Video_Link_Is_Displayed()
  {
	  test.homepage.video_related_topic_is_displayed();
  }
  
  @Test
  public void Test09_More_Hiring_Heading_Is_Displayed()
  {
	  test.homepage.More_On_Hiring_Heading_Is_Displayed();
  }
  
  @Test
  public void Test10_Hiring_Best_People_Link_Is_Displayed()
  {
	  test.homepage.Hiring_Best_People_Link_Is_Displayed();
  }
  
  @Test
  public void Test11_Uncovering_Passion_Link_Is_Displayed()
  {
	  test.homepage.Uncovering_Passion_Link_Is_Displayed();
  }
  
  @Test
  public void Test12_More_Articles_Link_Is_Displayed()
  {
	  test.homepage.More_Articles_Link_Is_Displayed();
  }
  
  @Test
  public void Test13_System_Check_Is_Displayed()
  {
	  test.homepage.System_Check_Link_Is_Displayed();
  }
  
  @Test
  public void Test14_Feedback_Link_Is_Displayed()
  {
	  test.homepage.Feedback_Link_Is_Displayed();
  }
  
  @Test
  public void Test15_Learner_Sub_Link_Is_Displayed()
  {
	  test.homepage.launchSpecificUrl("https://qa-myhbp.org/hmm12/home.html");
	  //test.homepage.Lerner_SubLink_Is_Displayed();
  }
  @AfterClass
  public void stop_test_session() {
	  test.closeTestSession();
  }

  
  
   @AfterMethod
  public void takeScreenshotonFailure(ITestResult result) {
	  test.takescreenshot.takeScreenShotOnException(result);
  }

  

 
}

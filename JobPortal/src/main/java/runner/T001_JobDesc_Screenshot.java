package runner;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.JobListingPage;

public class T001_JobDesc_Screenshot extends BaseClass{
	
	@Test
	public void jobDescScreenShot() throws IOException {
		HomePage homepg = new HomePage();
		JobListingPage jobListingpg = new JobListingPage();
		homepg.clickSearchJob().enterJobDetails("Test Engineer", "Banglore").clickSearch();
		jobListingpg.clickJobDesc();
		
	}


}

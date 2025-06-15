package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import io.cucumber.java.en.And;

public class JobListingPage extends BaseClass{
	
	public List<String> window;
	
	//Open a job description from results.
	
	@And("any of the job opening box is clicked a new window with the job details will open")
	public void clickJobDesc(){
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class, 'cust-job-tuple layout')])[1]")));
		
		getDriver().findElement(By.xpath("(//div[contains(@class, 'cust-job-tuple layout')])[1]")).click();
		Set<String> windowHandles = getDriver().getWindowHandles();
		
		window = new ArrayList<String>(windowHandles);
		getDriver().switchTo().window(window.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Job description']")));
			
	}
	
	@And("screenshot of the job desction will be taken")
	public void takeScreenShot() throws IOException {
		//Job Description screenshot
				File src = getDriver().getScreenshotAs(OutputType.FILE);
				File dst = new File("./Snapshot/jobdesc.png");
				FileUtils.copyFile(src, dst);
				
				getDriver().switchTo().window(window.get(0));
				File srcParent = getDriver().getScreenshotAs(OutputType.FILE);
				File dstParent = new File("./Snapshot/parentWindow.png");
				FileUtils.copyFile(srcParent, dstParent);
	}
	

}

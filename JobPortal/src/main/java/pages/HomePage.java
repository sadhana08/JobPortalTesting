package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass{
	
	//Select The Search Jobs in HomePage
	
	@When("search jobs is clicked")
	public HomePage clickSearchJob() {
		getDriver().findElement(By.xpath("//span[text()='Search jobs here']")).click();
		return this;
	}
	
	//Search for a job (e.g., “Test Engineer”).
	//Apply filters like Location or Experience.
	
	@And("enter the designation as {string}, years of experience and location as {string}")
	public HomePage enterJobDetails(String role, String location) {
		getDriver().findElement(By.xpath("(//input[@class='suggestor-input '])[1]")).sendKeys(role);
		getDriver().findElement(By.xpath("//input[@id='experienceDD']")).click();
		getDriver().findElement(By.xpath("//span[text()='2 years']")).click();
		getDriver().findElement(By.xpath("(//input[@class='suggestor-input '])[2]")).sendKeys(location);
		return this;
	}
	
	//Click Search
	@And("click search")
	public JobListingPage clickSearch() {
		getDriver().findElement(By.xpath("//span[text()='Search']")).click();
		return new JobListingPage();
	}

}

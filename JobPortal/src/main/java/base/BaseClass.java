package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	//public static ChromeDriver driver;
	
	private static final ThreadLocal<RemoteWebDriver> tldriver = new ThreadLocal<RemoteWebDriver>();

	public void setDriver() {
		tldriver.set(new ChromeDriver());
	}
	
	public RemoteWebDriver getDriver() {
		return tldriver.get();
	}
	
	@BeforeMethod
	public void preCondition() {
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().get("https://www.naukri.com/mnjuser/homepage");
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Search jobs here']")));
	}
	
	@AfterMethod
	public void postCondition() {
		getDriver().quit();
	}
	

}

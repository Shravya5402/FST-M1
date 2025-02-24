package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.When;

public class Activity5 {
	WebDriver driver;
	
	@When("the User enters {string} and {string}")
    public void user_enters_and(String username, String password) throws Throwable {
		Thread.sleep(2000);
		 driver = new FirefoxDriver();
	      //  wait = new WebDriverWait(driver, 10);
	        
	        //Open browser
	        driver.get("https://training-support.net/webelements/login-form");
		//Enter username from Feature file		 
		driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
}
}

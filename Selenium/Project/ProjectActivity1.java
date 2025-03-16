package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity1 {
	public static void main(String[] args) {
		// create a webDriver instance
WebDriver driver = new FirefoxDriver();
		
		driver.get("https://alchemy.hguy.co/lms/");
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Alchemy LMS – An LMS Application";
		
		if (actualTitle.equals(expectedTitle))
		{
			System.out.println("Title matches exactly: "+actualTitle );
		}
		
		else
		{
			System.out.println("Title doesn't match, actual title is:" + actualTitle);
		}
		driver.quit();
	}

}

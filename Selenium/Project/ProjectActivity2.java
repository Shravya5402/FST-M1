package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity2 {
	public static void main(String[] args) {
		// create a webDriver instance
WebDriver driver = new FirefoxDriver();


try {
	
	driver.get("https://alchemy.hguy.co/lms/");
	
	WebElement  actualHeading = driver.findElement(By.xpath("//h1[contains(text(),'Learn from Industry Experts)]"));
	
	String expectedTitle = actualHeading.getText();
	String expectedHeading = "Learn from Industry Experts";

    // Verify the heading matches exactly
    if (actualHeading.equals(expectedHeading)) {
        System.out.println("Heading matches exactly: " + actualHeading);
    } else {
        System.out.println("Heading does not match. Actual heading: " + actualHeading);
    }
} 
	catch (Exception e) {
    e.printStackTrace();
} finally {
    // Close the browser
    driver.quit();
}
}
	
}



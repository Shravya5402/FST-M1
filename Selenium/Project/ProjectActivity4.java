package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity4 {

    public static void main(String[] args) {
    	WebDriver driver = new FirefoxDriver();
    	
        try {
            // Step a: Open a browser.
            driver.manage().window().maximize();

            // Step b: Navigate to ‘https://alchemy.hguy.co/lms’.
            driver.get("https://alchemy.hguy.co/lms");

            // Step c: Get the title of the second most popular course.
            // Assuming the courses are listed in a specific section, use appropriate locators.
            WebElement secondPopularCourseTitle = driver.findElement(By.xpath("//h3[@class='entry-title' and contains(text(), 'Popular Courses')]/../following-sibling::div//article[2]//h3"));

            // Step d: Make sure it matches “Email Marketing Strategies” exactly.
            String expectedTitle = "Email Marketing Strategies";
            String actualTitle = secondPopularCourseTitle.getText();

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Title matches: " + actualTitle);

                // Step e: If it matches, close the browser.
                driver.quit();
            } else {
                System.out.println("Title does not match. Expected: " + expectedTitle + ", but found: " + actualTitle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the browser is closed in case of an exception
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity3 {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
    	WebDriver driver = new FirefoxDriver();
        try {
            // Step a: Open a browser.
            driver.manage().window().maximize();

            // Step b: Navigate to ‘https://alchemy.hguy.co/lms’.
            driver.get("https://alchemy.hguy.co/lms");

            // Step c: Get the title of the first info box.
            WebElement firstInfoBoxTitle = driver.findElement(By.xpath("//h3[text()=' Actionable Training ']"));

            // Step d: Make sure it matches “Actionable Training” exactly.
            String expectedTitle = "Actionable Training";
            String actualTitle = firstInfoBoxTitle.getText();

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

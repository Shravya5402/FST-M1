package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity5 {

    public static void main(String[] args) {
    	WebDriver driver = new FirefoxDriver();

        try {
            // Step a: Open a browser.
            driver.manage().window().maximize();

            // Step b: Navigate to ‘https://alchemy.hguy.co/lms’.
            driver.get("https://alchemy.hguy.co/lms");

            // Step c: Find the navigation bar.
            // Assuming the navigation bar is identified by a specific class or id
            WebElement navBar = driver.findElement(By.id("primary-menu"));

            // Step d: Select the menu item that says “My Account” and click it.
            WebElement myAccountMenuItem = navBar.findElement(By.linkText("My Account"));
            myAccountMenuItem.click();

            // Step e: Read the page title and verify that you are on the correct page.
            String expectedTitle = "My Account – Alchemy LMS";
            String actualTitle = driver.getTitle();

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Successfully navigated to My Account page. Title matches: " + actualTitle);
            } else {
                System.out.println("Failed to navigate to My Account page. Expected: " + expectedTitle + ", but found: " + actualTitle);
            }

            // Step f: Close the browser.
            driver.quit();
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


package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ProjectActivity7 {

    public static void main(String[] args) {
        
    	WebDriver driver = new FirefoxDriver();

        try {
            // Step a: Open a browser.
            driver.manage().window().maximize();

            // Step b: Navigate to ‘https://alchemy.hguy.co/lms’.
            driver.get("https://alchemy.hguy.co/lms");

            // Step c: Find the navigation bar.
            WebElement navBar = driver.findElement(By.id("primary-menu"));

            // Step d: Select the menu item that says “All Courses” and click it.
            WebElement allCoursesMenuItem = navBar.findElement(By.linkText("All Courses"));
            allCoursesMenuItem.click();

            // Step e: Find all the courses on the page.
            List<WebElement> courses = driver.findElements(By.cssSelector(".ld-course-list-items .ld_course_grid"));

            // Step f: Print the number of courses on the page.
            System.out.println("Number of courses on the page: " + courses.size());

            // Close the browser.
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

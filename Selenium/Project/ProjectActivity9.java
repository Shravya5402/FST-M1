package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity9 {

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

            // Step e: Select any course and open it.
            WebElement course = driver.findElement(By.cssSelector(".ld_course_grid a"));
            course.click();

            // Step f: Click on a lesson in the course. Verify the title of the course.
            WebElement lesson = driver.findElement(By.cssSelector(".ld-lesson-item-preview a"));
            lesson.click();

            // Verify the title of the course (optional step if you want to print or check the title)
            String lessonTitle = driver.getTitle();
            System.out.println("Lesson title: " + lessonTitle);

            // Step g: Click the Mark Complete button on the page (if available).
            try {
                WebElement markCompleteButton = driver.findElement(By.cssSelector(".learndash_mark_complete_button"));
                markCompleteButton.click();
                System.out.println("Marked lesson as complete.");
            } catch (Exception e) {
                System.out.println("Mark Complete button not found or lesson already completed.");
            }

            // Step h: Close the browser.
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

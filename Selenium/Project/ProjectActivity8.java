package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity8 {

    public static void main(String[] args) {
    	WebDriver driver = new FirefoxDriver();

        try {
            // Step a: Open a browser.
            driver.manage().window().maximize();

            // Step b: Navigate to ‘https://alchemy.hguy.co/lms’.
            driver.get("https://alchemy.hguy.co/lms");

            // Step c: Find the navigation bar.
            WebElement navBar = driver.findElement(By.id("primary-menu"));

            // Step d: Select the menu item that says “Contact” and click it.
            WebElement contactMenuItem = navBar.findElement(By.linkText("Contact"));
            contactMenuItem.click();

            // Step e: Find the contact form fields (Full Name, email, etc.)
            WebElement fullNameField = driver.findElement(By.id("wpforms-8-field_0"));
            WebElement emailField = driver.findElement(By.id("wpforms-8-field_1"));
            WebElement messageField = driver.findElement(By.id("wpforms-8-field_2"));

            // Step f: Fill in the information and leave a message.
            fullNameField.sendKeys("John Doe");
            emailField.sendKeys("john.doe@example.com");
            messageField.sendKeys("This is a test message.");

            // Step g: Click submit.
            WebElement submitButton = driver.findElement(By.id("wpforms-submit-8"));
            submitButton.click();

            // Step h: Read and print the message displayed after submission.
            WebElement confirmationMessage = driver.findElement(By.cssSelector(".wpforms-confirmation-container"));
            System.out.println("Confirmation message: " + confirmationMessage.getText());

            // Step i: Close the browser.
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


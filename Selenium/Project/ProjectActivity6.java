package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProjectActivity6 {

    public static void main(String[] args) {
    	WebDriver driver = new FirefoxDriver();
        try {
            // User credentials
            String username = "username";
            String password = "password";

            // Step a: Open a browser.
            driver.manage().window().maximize();

            // Step b: Navigate to ‘https://alchemy.hguy.co/lms’.
            driver.get("https://alchemy.hguy.co/lms");

            // Step c: Find the navigation bar.
            WebElement navBar = driver.findElement(By.id("primary-menu"));

            // Step d: Select the menu item that says “My Account” and click it.
            WebElement myAccountMenuItem = navBar.findElement(By.linkText("My Account"));
            myAccountMenuItem.click();

            // Step e: Read the page title and verify that you are on the correct page.
            String expectedTitle = "My Account";
            
            String actualTitle = driver.getTitle();
            System.out.println(actualTitle);
            if (!actualTitle.equals(expectedTitle)) {
                System.out.println("Failed to navigate to My Account page. Expected: " + expectedTitle + ", but found: " + actualTitle);
                return;
            }

            // Step f: Find the “Login” button on the page and click it.
            WebElement loginButton = driver.findElement(By.linkText("Login"));
            loginButton.click();

            // Step g: Find the username field of the login form and enter the username into that field.
            WebElement usernameField = driver.findElement(By.id("user_login"));
            usernameField.sendKeys(username);

            // Step h: Find the password field of the login form and enter the password into that field.
            WebElement passwordField = driver.findElement(By.id("user_pass"));
            passwordField.sendKeys(password);

            // Step i: Find the login button and click it.
            WebElement submitButton = driver.findElement(By.id("wp-submit"));
            submitButton.click();

            // Step j: Verify that you have logged in.
       /*     WebElement logoutButton = driver.findElement(By.linkText("Logout"));
            if (logoutButton.isDisplayed()) {
                System.out.println("Successfully logged in.");
            } else {
                System.out.println("Failed to log in.");
            }*/

            // Step k: Close the browser.
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



package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Activity4 {
    WebDriver driver;
   // WebDriverWait wait;
    
    @Given("new User is on Login page")
    public void loginPage() {
        //Setup instances
        driver = new FirefoxDriver();
      
       
        //Open browser
        driver.get("https://training-support.net/webelements/login-form");
    }
    
    @When("new User enters username and password")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    
    @When("new User enters {string} and {string}")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
    }
    
    @Then("new Read the page title and confirmation message")
    public void readTitleAndHeading() {
        
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div/main/div/div/div/div/div/h1/span")));
        
        //Read the page title and heading
        String pageTitle = driver.getTitle();
      String confirmMessage = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div/h1/span")).getText();
        
        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);

       
        //Assertion
     Assert.isTrue(true, confirmMessage, "Selenium: Login Success!");
    }
    
    @And("new Close the Browser")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }

}
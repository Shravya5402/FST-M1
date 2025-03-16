import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Projectactivity4 {
    private static AndroidDriver<MobileElement> driver;
    
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Update with actual device name
        caps.setCapability("browserName", "Chrome");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.get("https://v1.training-support.net/selenium");
        
        scrollAndClick(wait, "To-Do List");
        
        addTask(wait, "Add tasks to list");
        addTask(wait, "Get number of tasks");
        addTask(wait, "Clear the list");
        
        completeTask(wait, "Add tasks to list");
        completeTask(wait, "Get number of tasks");
        completeTask(wait, "Clear the list");
        
        clearList(wait);
        
        assertTasksCleared(wait);
        
        System.out.println("To-Do List Test Passed!");
        driver.quit();
    }
    
    private static void scrollAndClick(WebDriverWait wait, String cardText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        
        MobileElement card = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='" + cardText + "']")));
        card.click();
    }
    
    private static void addTask(WebDriverWait wait, String task) {
        MobileElement taskInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='text']")));
        taskInput.sendKeys(task);
        
        MobileElement addButton = driver.findElement(By.xpath("//button[text()='Add Task']"));
        addButton.click();
    }
    
    private static void completeTask(WebDriverWait wait, String task) {
        MobileElement taskElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li/span[text()='" + task + "']")));
        taskElement.click();
    }
    
    private static void clearList(WebDriverWait wait) {
        MobileElement clearButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Clear List']")));
        clearButton.click();
    }
    
    private static void assertTasksCleared(WebDriverWait wait) {
        List<MobileElement> tasks = driver.findElements(By.xpath("//li"));
        assert tasks.size() == 0 : "Tasks were not cleared successfully!";
    }
}

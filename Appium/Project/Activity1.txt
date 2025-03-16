import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Projectactivity1 {
    private static AndroidDriver<MobileElement> driver;
    
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Update with actual device name
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        addTask(wait, "Complete Activity with Google Tasks");
        addTask(wait, "Complete Activity with Google Keep");
        addTask(wait, "Complete the second Activity Google Keep");
        
        verifyTask(wait, "Complete Activity with Google Tasks");
        verifyTask(wait, "Complete Activity with Google Keep");
        verifyTask(wait, "Complete the second Activity Google Keep");
        
        System.out.println("All tasks successfully added and verified!");
        driver.quit();
    }

    private static void addTask(WebDriverWait wait, String taskName) {
        MobileElement addTaskButton = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElementByAccessibilityId("Create new task")));
        addTaskButton.click();
        
        MobileElement taskInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.google.android.apps.tasks:id/add_task_title")));
        taskInput.sendKeys(taskName);
        
        MobileElement saveButton = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
        saveButton.click();
    }
    
    private static void verifyTask(WebDriverWait wait, String taskName) {
        MobileElement taskElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='" + taskName + "']")));
        assert taskElement != null : "Task '" + taskName + "' not found!";
    }
}

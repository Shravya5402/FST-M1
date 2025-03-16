import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class Projectactivity3 {
    private static AndroidDriver<MobileElement> driver;
    
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // Update with actual device name
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        addNoteWithReminder(wait, "Meeting Notes", "Discuss project milestones and deadlines.");
        verifyReminder(wait, "Meeting Notes");
        
        System.out.println("Note with reminder successfully added and verified!");
        driver.quit();
    }

    private static void addNoteWithReminder(WebDriverWait wait, String title, String description) {
        MobileElement createNoteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.keep:id/new_note_button")));
        createNoteButton.click();
        
        MobileElement titleInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.google.android.keep:id/editable_title")));
        titleInput.sendKeys(title);
        
        MobileElement descriptionInput = driver.findElement(By.id("com.google.android.keep:id/edit_note_text"));
        descriptionInput.sendKeys(description);
        
        MobileElement reminderButton = driver.findElement(By.id("com.google.android.keep:id/menu_reminder"));
        reminderButton.click();
        
        MobileElement afternoonReminder = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Afternoon']")));
        afternoonReminder.click();
        
        MobileElement saveReminder = driver.findElement(By.id("com.google.android.keep:id/save"));
        saveReminder.click();
        
        driver.navigate().back(); // Press the back button to save the note
        
        MobileElement navigationMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")));
        navigationMenu.click();
        
        MobileElement remindersTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Reminders']")));
        remindersTab.click();
    }
    
    private static void verifyReminder(WebDriverWait wait, String title) {
        MobileElement noteElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='" + title + "']")));
        assert noteElement != null : "Reminder for note '" + title + "' not found!";
    }
}

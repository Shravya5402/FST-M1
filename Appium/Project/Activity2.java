import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;

public class Projectactivity2 {
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
        
        addNote(wait, "Meeting Notes", "Discuss project milestones and deadlines.");
        verifyNote(wait, "Meeting Notes");
        
        System.out.println("Note successfully added and verified!");
        driver.quit();
    }

    private static void addNote(WebDriverWait wait, String title, String description) {
        MobileElement createNoteButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.google.android.keep:id/new_note_button")));
        createNoteButton.click();
        
        MobileElement titleInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.google.android.keep:id/editable_title")));
        titleInput.sendKeys(title);
        
        MobileElement descriptionInput = driver.findElement(By.id("com.google.android.keep:id/edit_note_text"));
        descriptionInput.sendKeys(description);
        
        driver.navigate().back(); // Press the back button to save the note
    }
    
    private static void verifyNote(WebDriverWait wait, String title) {
        MobileElement noteElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.TextView[@text='" + title + "']")));
        assert noteElement != null : "Note '" + title + "' not found!";
    }
}

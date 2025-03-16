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

public class Projectactivity5 {
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
        
        scrollAndClick(wait, "Login Form");
        
        testLogin(wait, "admin", "password", "Welcome Back, admin"); // Correct credentials test
        testLogin(wait, "admin", "wrongpassword", "Invalid Credentials"); // Incorrect credentials test
        
        System.out.println("Login Test Completed!");
        driver.quit();
    }
    
    private static void scrollAndClick(WebDriverWait wait, String cardText) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        
        MobileElement card = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='" + cardText + "']")));
        card.click();
    }
    
    private static void testLogin(WebDriverWait wait, String username, String password, String expectedMessage) {
        MobileElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        
        MobileElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        
        MobileElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginButton.click();
        
        MobileElement confirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("action-confirmation")));
        assert confirmationMessage.getText().equals(expectedMessage) : "Test Failed: Expected '" + expectedMessage + "' but got '" + confirmationMessage.getText() + "'";
    }
}

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class GettingStarted {
    @Test
    public void testGoogleSearch() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.youtube.com/");

        Thread.sleep(5000);  // Let the user actually see something!

        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys("ChromeDriver");

        WebElement searchIcon = driver.findElement(By.id("search-icon-legacy"));
        searchIcon.click();

        assert driver.getTitle().equals("ChromeDriver - YouTube");

        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }
}
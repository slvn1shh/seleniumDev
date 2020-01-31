import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstExample {
    public static void main(String...strings) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.youtube.com");

        WebElement element = driver.findElement(By.id("search"));

        element.sendKeys("Selenium");

        driver.findElement(By.id("search-icon-legacy")).click();

        System.out.println("Page title is: " + driver.getTitle());

        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) d -> {
            assert d != null;
            return d.getTitle().toLowerCase().startsWith("selenium");
        });

        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
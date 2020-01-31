import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class testHTML5LocalStorage {
    @Test
    public void testHTML5Local() throws Exception {
        WebDriver driver = new ChromeDriver();

        String lastName;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the current value of localStorage.lastname, this should be Smith
        lastName = (String) jsExecutor.executeScript("return localStorage;");
        System.out.println("lastName = " + lastName);
        //assertEquals("Smith", lastName);

        driver.quit();
    }
}
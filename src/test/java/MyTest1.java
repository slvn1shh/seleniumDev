import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyTest1 {
    public void testDoubleClick() throws Exception
    {
        WebDriver driver = new ChromeDriver();
        Path path = Paths.get("src/test/resourses/page.html");
        driver.get(path.toUri().toString());
        WebElement message = driver.findElement(By.id("message"));

        //Verify color is Blue
        assertEquals("rgb(0, 0, 255)",
                message.getCssValue("background-color").toString());
        Actions builder = new Actions(driver);
        builder.doubleClick(message).build().perform();

        //Verify Color is Yellow
        assertEquals("rgb(255, 255, 0)",
                message.getCssValue("background-color").toString());
        driver.close();
    }
    public void localFileExample(){
        WebDriver driver = new ChromeDriver();

    }

    public void testWindowPopup()
    {
        WebDriver driver = new ChromeDriver();

        //Save the WindowHandle of Parent Browser Window
        String parentWindowId = driver.getWindowHandle();

        //Clicking Help Button will open Help Page in a new Popup Browser Window
        WebElement helpButton = driver.findElement(By.id("helpbutton"));
        helpButton.click();
        try {
            //Switch to the Help Popup Browser Window
            driver.switchTo().window("HelpWindow");

        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        //Verify the driver context is in Help Popup Browser Window
        assertEquals("Help", driver.getTitle());

        //Close the Help Popup Window
        driver.close();

        //Move back to the Parent Browser Window
        driver.switchTo().window(parentWindowId);

        //Verify the driver context is in Parent Browser Window
        assertEquals("Build my Car - Configuration", driver.getTitle());
    }

    public static void main(String[] args) throws Exception{
        new MyTest1().testDoubleClick();
    }
}


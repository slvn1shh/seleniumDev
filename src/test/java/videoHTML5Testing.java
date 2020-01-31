import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

public class videoHTML5Testing {
    @Test
    public void testHTML5VideoPlayer() {
        WebDriver driver = new ChromeDriver();
        File scrFile;
        driver.get("https://bestvpn.org/html5demos/assets/dizzy.mp4");

        //Get the HTML5 Video Element
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/video")));

        WebElement videoPlayer = driver.findElement(By.xpath("/html/body/video"));

        //We will need a JavaScript Executor for interacting
        //with Video Element's
        //methods and properties for automation
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Get the Source of Video that will be played in Video Player
//        String source = (String) jsExecutor.executeScript("document.getElementsByName(\"media\").valueOf(0)[0].currentSrc", videoPlayer);

        //Get the Duration of Video
        RemoteWebElement duration = (RemoteWebElement) jsExecutor.executeScript("return arguments[0]", videoPlayer);
        System.out.println(duration.getAttribute("duration"));

        //Verify Correct Video is loaded and duration
//        assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
//        assertEquals(25, duration);

        //Play the Video
        jsExecutor.executeScript("arguments[0].play()", videoPlayer);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        //Pause the video
        jsExecutor.executeScript("arguments[0].pause()", videoPlayer);

        //Take a screen-shot for later verification
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("\\resources\\pause_play.png"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
        driver.quit();
    }

}
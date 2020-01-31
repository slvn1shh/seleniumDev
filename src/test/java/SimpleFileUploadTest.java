import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class SimpleFileUploadTest {
    public static File captureElementBitmap(WebDriver driver, WebElement element) throws Exception {
        // Делаем скриншот страницы
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Создаем экземпляр BufferedImage для работы с изображением
        BufferedImage img = ImageIO.read(screen);
        // Получаем размеры элемента
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // Создаем прямоуголник (Rectangle) с размерами элемента
        java.awt.Rectangle rect = new java.awt.Rectangle(width,height);
        // Получаем координаты элемента
        Point p = element.getLocation();
        // Вырезаем изображенеи элемента из общего изображения
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // Перезаписываем File screen
        ImageIO.write(dest, "png", screen);
        // Возвращаем File c изображением элемента
        return screen;
    }
    @Test
    public void uploadTest(){
        WebDriver driver = new ChromeDriver();

        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));
        upload.sendKeys("D:\\Code\\seleniumDev\\src\\test\\java\\FirstExample.java");
        try {
            File image = captureElementBitmap(driver, upload);
            FileUtils.copyFile(image, new File("D:\\Code\\seleniumDev\\src\\test\\resources\\" + image.getName()));

            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File("D:\\Code\\seleniumDev\\src\\test\\resources\\" + screen.getName()));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        driver.findElement(By.id("file-submit")).click();

        //make assertions here


        driver.quit();
    }

}
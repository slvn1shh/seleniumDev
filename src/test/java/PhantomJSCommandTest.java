import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import static junit.framework.TestCase.assertEquals;

public class PhantomJSCommandTest{

    @Test
    public void executePhantomJS() {
        System.setProperty("phantomjs.binary.path","D:\\WebDriver\\bin\\phantomjs.exe");
        PhantomJSDriver d = new PhantomJSDriver();

        // Do we get results back?
        Object result = d.executePhantomJS("return 1 + 1");
        assertEquals(2L, result);

        // Can we read arguments?
        result = d.executePhantomJS("return arguments[0] + arguments[0]", 1L);
        assertEquals(2L, result);

//         Can we override some browser JavaScript functions in the page context?
        result = d.executePhantomJS("var page = this;" +
                "page.onInitialized = function () { " +
                "page.evaluate(function () { " +
                "Math.random = function() { return 42 / 100 } " +
                "})" +
                "}");

        d.get("http://ariya.github.com/js/random/");

        WebElement numbers = d.findElement(By.id("numbers"));
        boolean foundAtLeastOne = false;
        for(String number : numbers.getText().split(" ")) {
            foundAtLeastOne = true;
            assertEquals("42", number);
        }
        assert(foundAtLeastOne);
    }

}
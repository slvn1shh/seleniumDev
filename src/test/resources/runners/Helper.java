package runners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {
    WebDriver driver;

    public Helper(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementExistsOnPage(By element){
        return driver.findElements(element).size() > 0;
    }
}

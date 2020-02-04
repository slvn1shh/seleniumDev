package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helpers {
    WebDriver driver;

    public Helpers(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementExistsOnPage(By element){
        return driver.findElements(element).size() > 0;
    }
}

package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class Helper {
    private final WebDriver driver;

    Helper(WebDriver driver){
        this.driver = driver;
    }

    public boolean isElementExistsOnPage(By element){
        return driver.findElements(element).size() > 0;
    }

}

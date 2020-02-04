package pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmazonSearch {
    WebDriver driver;


    public AmazonSearch(WebDriver driver){
        this.driver = driver;
    }

    public List<WebElement> getSearchResults(String query){
        return driver.findElements(By.xpath("//span[contains(text(),'"+
                StringUtils.capitalize(query) +"')]"));
    }
    public void openFirstFoundItem(){
        driver.findElement(
                By.xpath("//div[@data-index='0']")).click();
    }
}

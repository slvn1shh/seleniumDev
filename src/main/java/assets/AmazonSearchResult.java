package assets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchResult extends PageObject{

    @FindBy(xpath = "//div[@data-index='0']")
    WebElement firstSearchResult;

    public AmazonSearchResult(WebDriver driver) {
        super(driver);
    }
}

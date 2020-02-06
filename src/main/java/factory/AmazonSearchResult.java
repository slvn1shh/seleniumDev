package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import runner.PageObject;

import java.util.List;

public class AmazonSearchResult extends PageObject {
    protected By linkToNextElement = By.xpath("//a[@class='a-link-normal a-text-normal']");
    /**
     * Use this to ensure entire product page is loaded properly.
     */
    @FindBy(id = "productTitle")
    WebElement productTitle;

    @FindBy(xpath = "//div[@data-index]")
    List<WebElement> searchResults;

    @FindBy(xpath = "//div[@data-index='0']")
    WebElement firstSearchResult;

    public AmazonSearchResult(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstSearchResult() {
        return firstSearchResult;
    }

    /**
     * @param number number of results block you want to get (value 0 represents 1-st element)
     * @return Element by given number or null if element is not found.
     */
    public WebElement getSearchResult(int number) {
        for (WebElement element : searchResults)
            if (Integer.parseInt(element.getAttribute("data-index")) == number)
                return element;
        return null;
    }
    public WebElement getPageLoadedCondition(){
        return productTitle;
    }
}

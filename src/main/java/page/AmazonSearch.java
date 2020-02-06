package page;

import factory.AmazonSearchResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearch extends AmazonSearchResult {

    public AmazonSearch(WebDriver driver) {
        super(driver);
    }

/*    public List<WebElement> getSearchResults(String query) {
        return driver.findElements(By.xpath("//span[contains(text(),'" +
                StringUtils.capitalize(query) + "')]"));
    }*/

    public void openFirstFoundItem() {
        getFirstSearchResult().click();
    }
    public void openSearchResult(int num){
        getSearchResult(num).findElement(linkToNextElement).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfAllElements(getPageLoadedCondition())
        );
    }
}

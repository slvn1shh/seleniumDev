package page;

import factory.AmazonSearchResult;
import org.openqa.selenium.WebDriver;

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
        getSearchResult(num).click();
    }
}

package steps;

import page.search.AmazonSearch;
import runner.BaseSteps;
import runner.DriverManager;

public class AmazonSearchSteps extends BaseSteps {

    AmazonSearchSteps(DriverManager driver) {
        super(driver);
    }

    public AmazonItemSteps openItemFromSearch() {
        onPage().searchResults().get(0).linkToItem().click();
        return new AmazonItemSteps(getDriverManager());
    }

    private AmazonSearch onPage() {
        return on(AmazonSearch.class);
    }
}

package steps;

import page.AmazonSearch;
import page.core.runner.BaseSteps;
import page.core.runner.DriverManager;

import java.util.Random;

public class AmazonSearchSteps extends BaseSteps {

    AmazonSearchSteps(DriverManager driver) {
        super(driver);
    }

    public AmazonItemSteps openItemFromSearch() {
        int resultsSize = new Random().nextInt(onPage().searchResults().size());
        onPage().searchResults().get(resultsSize).linkToItem().click();
        return new AmazonItemSteps(getDriverManager());
    }

    private AmazonSearch onPage() {
        return on(AmazonSearch.class);
    }
}

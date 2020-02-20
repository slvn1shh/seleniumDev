package steps;

import page.general.AmazonUI;
import runner.BaseSteps;
import runner.DriverManager;

public class AmazonUISteps extends BaseSteps {

    protected AmazonUISteps(DriverManager driver) {
        super(driver);
    }

    protected AmazonUISteps selectCategory(){
        onPage().searchDropdownBox().babySearchCategory().click();
        return this;
    }

    protected AmazonSearchSteps performSearch(String...query){
        onPage().searchBox().sendKeys(query);
        onPage().searchBox().submit();

        return new AmazonSearchSteps(getDriverManager());
    }

    private AmazonUI onPage(){
        return on(AmazonUI.class);
    }
}

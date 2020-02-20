package steps;

import page.AmazonUI;
import runner.BaseSteps;
import runner.DriverManager;

public class AmazonUISteps extends BaseSteps {

    public AmazonUISteps(DriverManager driver) {
        super(driver);
    }

    public AmazonUISteps selectCategory(){
        onPage().searchDropdownBox().babySearchCategory().click();
        return this;
    }

    public AmazonSearchSteps performSearch(String...query){
        onPage().searchBox().sendKeys(query);
        onPage().searchBox().submit();

        return new AmazonSearchSteps(getDriverManager());
    }

    private AmazonUI onPage(){
        return on(AmazonUI.class);
    }
}

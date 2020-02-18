package steps;

import page.item.AmazonItem;
import runner.BaseSteps;
import runner.DriverManager;

public class AmazonItemSteps extends BaseSteps {

    public AmazonItemSteps(DriverManager driver) {
        super(driver);
    }

    public AmazonItemSteps findItemInBabyCategory(){

        return this;
    }
    protected AmazonItem onPage(){
        return on(AmazonItem.class);
    }
}

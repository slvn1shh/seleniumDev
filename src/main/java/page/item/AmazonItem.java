package page.item;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import io.qameta.htmlelements.element.Link;

public interface AmazonItem extends WebPage {
    @FindBy("//div[@id='unifiedPrice_feature_div' and not(@class='feature js-feature-refresh-overlay')]")
    HtmlElement sizeScriptDoneCondition();

    @FindBy("//span[@class='a-dropdown-prompt'][contains(text(),'Select')]")
    HtmlElement itemSizeSelector();

    @FindBy(".//li[@id='size_name_0']")
    HtmlElement dropdownSizeItem();

    @FindBy("//span[@class='a-button-inner']//input[@id='add-to-cart-button']")
    HtmlElement addToCartButton();

    @FindBy("//span[@id='nav-cart-count']")
    HtmlElement cartItemsCount();

    @FindBy("//span[@id='priceblock_ourprice']")
    HtmlElement searchResultPrice();

    @FindBy("//span[@id='attach-sidesheet-view-cart-button']")
    HtmlElement sideSheetLinkToCart();

    @FindBy("//a[@id='nav-cart']")
    Link linkToCart();
}

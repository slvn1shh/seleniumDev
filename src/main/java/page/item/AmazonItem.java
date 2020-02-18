package page.item;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.HtmlElement;
import io.qameta.htmlelements.element.Link;
import page.item.elements.ItemSizePicker;
import page.item.elements.SidesheetItem;

public interface AmazonItem extends WebPage {
    @FindBy("//div[@id='unifiedPrice_feature_div' and not (@class='feature js-feature-refresh-overlay')]")
    HtmlElement sizeScriptDoneCondition();

    @FindBy("//input[@id='add-to-cart-button']")
    HtmlElement addToCartButton();

    @FindBy("//span[@id='nav-cart-count']")
    HtmlElement cartItemsCount();

    @FindBy("//span[@id='priceblock_ourprice']")
    HtmlElement searchResultPrice();

    @FindBy("//div[@id='centerCol']")
    ItemSizePicker itemSizeContainer();

    @FindBy("//li[@id='size_name_0']")
    HtmlElement dropdownSizeItem();

    @FindBy("//div[@id='attach-added-to-cart-message']")
    SidesheetItem sidesheetContainer();

    @FindBy("//a[@id='nav-cart']")
    Link linkToCart();

    @FindBy("//a[@id='buybox-see-all-buying-choices-announce']")
    Link linkToOtherSellers();

    @FindBy("//span[@class='a-size-large a-color-price olpOfferPrice a-text-bold']")
    HtmlElement itemPriceOfferListing();

    @FindBy("//input[@name='submit.addToCart']")
    HtmlElement addToCartOfferListing();
}

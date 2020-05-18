package page;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import io.qameta.htmlelements.element.HtmlElement;
import io.qameta.htmlelements.element.Link;
import page.elements.ItemSizePicker;
import page.elements.SidesheetItem;

public interface AmazonItem extends BasePage {
    @FindBy("//div[@id='unifiedPrice_feature_div' and (@class='celwidget js-feature-refresh-overlay')]")
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

    @FindBy("//span[@id='productTitle']")
    HtmlElement productTitle();

    @FindBy("//div[@id='fitZone_feature_div']")
    ExtendedList<HtmlElement> itemSizeContainerZone(); // use to ensure that item have size picker

    @FindBy("//a[@id='buybox-see-all-buying-choices-announce']")
    ExtendedList<HtmlElement> buyBox(); // use to ensure that item is available from sellers; otherwise use alternative way

    @FindBy("//div[@id='attach-added-to-cart-message']")
    ExtendedList<HtmlElement> sidesheetContainerCart(); // use to know which type of popup is appeared after adding item to the cart
}

package page.elements;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import io.qameta.htmlelements.element.Link;


public interface SearchItem extends ExtendedWebElement<SearchItem> {
    @FindBy(".//a[@class='a-link-normal']")
    Link linkToItem();
}

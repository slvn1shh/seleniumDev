package page;

import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import page.elements.SearchItem;

public interface AmazonSearch extends BasePage {
    @FindBy("//div[@data-index]")
    ExtendedList<SearchItem> searchResults();

    @FindBy("//div[@data-index='0']")
    SearchItem firstSearchResult();
}
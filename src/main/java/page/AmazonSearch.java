package page;

import element.SearchItem;
import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;

public interface AmazonSearch extends WebPage {
    @FindBy("//div[@data-index]")
    ExtendedList<SearchItem> searchResults();

    @FindBy("//div[@data-index='0']")
    SearchItem firstSearchResult();
}
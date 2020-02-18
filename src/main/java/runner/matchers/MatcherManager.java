package runner.matchers;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

public class MatcherManager {
    private MatcherManager() {
    }

    public static Matcher<WebElement> hasText(String text) {
        return HasTextMatcher.hasText(text);
    }

    public static Matcher<WebElement> hasText(String textMatcher, int timeout) {
        return HasTextMatcher.hasText(textMatcher, timeout);
    }

    public static Matcher<WebElement> isDisplayed() {
        return IsDisplayedMatcher.isDisplayed();
    }

    public static Matcher<WebElement> isDisplayed(int timeout) {
        return IsDisplayedMatcher.isDisplayed(timeout);
    }

    public static Matcher<WebElement> isDisappeared(int timeout) {
        return IsDisappearedMatcher.isDisappeared(timeout);
    }

    public static Matcher<WebElement> isDisappeared() {
        return IsDisappearedMatcher.isDisappeared();
    }

    public static Matcher<WebElement> isScriptExecuted(){
        return LoadScriptExecutedMatcher.isExecuted();
    }

}


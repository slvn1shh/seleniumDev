package runner.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HasTextMatcher extends TypeSafeMatcher<WebElement> {
    private int timeout = 10;
    private String text;

    private HasTextMatcher(String text) {
        this.text = text;
    }

    private HasTextMatcher(String text, int timeout) {
        this.text = text;
        this.timeout = timeout;
    }
    @Override
    public void describeTo(Description description) {
        description.appendValue("Matches to text ").appendValue(text);
    }
    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("text of element ").appendValue(item).appendText(" was ")
                .appendValue(item.getText()).appendText(" while waiting ").appendValue(timeout).appendText(" seconds.");
    }
    @Override
    protected boolean matchesSafely(WebElement item) {
        long waitUntil = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeout);
        boolean matched = false;
        while (System.currentTimeMillis() <= waitUntil && !matched) {
            try {
                matched = item.getText().contains(text);
                Thread.sleep(250);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return matched;
    }

    @Factory
    static Matcher<WebElement> hasText(final String textMatcher) {
        return new HasTextMatcher(textMatcher);
    }

    @Factory
    static Matcher<WebElement> hasText(final String textMatcher, int timeout) {
        return new HasTextMatcher(textMatcher, timeout);
    }
}

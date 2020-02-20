package page.core.runner.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

class IsDisappearedMatcher extends TypeSafeMatcher<WebElement> {
    private int timeout = 10;

    private IsDisappearedMatcher() {
    }

    private IsDisappearedMatcher(int timeout) {
        this.timeout = timeout;
    }

    @Factory
    static Matcher<WebElement> isDisappeared() {
        return new IsDisappearedMatcher();
    }

    @Factory
    static Matcher<WebElement> isDisappeared(int timeout) {
        return new IsDisappearedMatcher(timeout);
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        long waitUntil = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(timeout);
        boolean isDisappeared = false;
        while (System.currentTimeMillis() <= waitUntil && !isDisappeared) {
            try {
                Thread.sleep(250);
                isDisappeared = !item.isDisplayed();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return isDisappeared;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("element is disappeared on pageName");
    }
}

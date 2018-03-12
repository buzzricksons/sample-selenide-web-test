package com.example.page.google;

import com.example.AbstractTests;
import com.example.Settings;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Test for Google Search.
 *
 * @author HyungCheol Kim
 *
 */
public class GooglePageTests extends AbstractTests {
    @Autowired
    private Settings settings;

    /**
     * Test for keyword "selenide".
     *
     */
    @Test
    public void testGoogleSearch() {
        GoogleSearchPage searchPage = open(settings.getGooglePage(), GoogleSearchPage.class);
        GoogleResultsPage resultsPage = searchPage.keywordSearchBy("selenide");

        resultsPage.firstSectionText().shouldBe(text("Selenide: concise UI tests in Java"));
        resultsPage.result().shouldHaveSize(10);//Assert.assertEquals(10, resultsPage.result().size());
    }
}

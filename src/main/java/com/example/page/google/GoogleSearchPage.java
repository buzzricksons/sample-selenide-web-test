package com.example.page.google;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
/**
 * Page Object for Google Search.
 *
 * @author HyungCheol Kim
 */
public class GoogleSearchPage {
    public GoogleResultsPage search(String searchKeyword) {
        $(By.name("q")).val(searchKeyword).pressEnter();
        return page(GoogleResultsPage.class);
    }
}

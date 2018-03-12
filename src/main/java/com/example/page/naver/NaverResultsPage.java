package com.example.page.naver;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Page Object for Naver.com Search Result.
 *
 * @author HyungCheol Kim
 */
public class NaverResultsPage {
    private final ElementsCollection result = $$(".main_pack");
    public ElementsCollection result() {
        return result;
    }

    public SelenideElement firstResultSectionText() {
        return result.get(0).find(".dic_dsc");
    }
}

package io.artbi.automation.test_coverage.steps;

import io.artbi.automation.test_coverage.pages.GoogleMainPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class UserOnResultPage extends GoogleUser {

    private final GoogleMainPage google = new GoogleMainPage();

    public UserOnResultPage expectedNumberOfResults(int number) {
        google.results().shouldHave(size(number));
        return this;
    }

    public UserOnResultPage expectedResultWithText(int index, String text) {
        google.results().get(index).shouldHave(text(text));
        return this;
    }

    public UserOnResultPage followResultLink(int index) {
        google.resultsLink(index).click();
        return this;
    }
}

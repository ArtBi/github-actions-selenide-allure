package io.artbi.automation.test_coverage.steps;

import io.artbi.automation.test_coverage.pages.GoogleMainPage;

import static com.codeborne.selenide.Selenide.open;


public class GoogleUser {
    private final GoogleMainPage google = new GoogleMainPage();

    public GoogleUser openGoogle() {
        open("https://www.google.com/");
        return this;
    }

    public UserOnResultPage search(String text) {
        this.google.searchField().setValue(text).pressEnter();
        return new UserOnResultPage();
    }

}

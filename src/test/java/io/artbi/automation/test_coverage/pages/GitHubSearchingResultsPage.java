package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class GitHubSearchingResultsPage {

    public ElementsCollection results = $$(".repo-list > .repo-list-item");


    public SelenideElement resultLink(int index) {
        return results.get(index).$("a[data-hydro-click-hmac]");
    }

}

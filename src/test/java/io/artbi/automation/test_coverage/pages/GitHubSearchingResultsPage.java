package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;

public class GitHubSearchingResultsPage {

    public ElementsCollection results = $$x("//*[@class ='repo-list']/li[contains(@class,'repo-list-item')]");


    public SelenideElement resultLink(int index) {
        return results.get(index).$x(".//a[@data-hydro-click-hmac]");
    }

}

package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubWelcomePage {

    public SelenideElement searchInput = $(By.name("q"));
    public ElementsCollection results = $$(".repo-list > .repo-list-item");


    public SelenideElement resultsLink(int index) {
        return results.get(index).$("a[data-hydro-click-hmac]");
    }


}

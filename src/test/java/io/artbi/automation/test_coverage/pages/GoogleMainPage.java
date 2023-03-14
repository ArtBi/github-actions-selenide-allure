package io.artbi.automation.test_coverage.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class GoogleMainPage {

    public SelenideElement searchField() {
        return $(By.name("q"));
    }

    public ElementsCollection results() {
        return $$x("//div[@id = 'rso']//div[@class='MjjYud']");
    }

    public SelenideElement resultsLink(int index) {
        return results().get(index).$(".r>a");
    }


}

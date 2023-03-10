package io.artbi.automation.test_coverage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public static String URL = "https://rozetka.com.ua";
    public SelenideElement searchField = $x("//input[@name='search']");
    public SelenideElement searchButton = $x("//button[contains(@class,'search-form__submit')]");
    public SelenideElement searchResult = $x("//div[contains(@class,'search-suggest')]/ul");
}

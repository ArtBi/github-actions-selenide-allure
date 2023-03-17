package io.artbi.automation.test_coverage.steps;

import io.artbi.automation.test_coverage.pages.GitHubSearchingResultsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class UserOnResultsPage extends GitHubUser {

    private final GitHubSearchingResultsPage searchingResultsPage = new GitHubSearchingResultsPage();

    @Step("Number of results should be: {0}")
    public UserOnResultsPage expectsNumberOfResultsShouldBe(int number) {
        searchingResultsPage.results.shouldHave(size(number));
        return this;
    }

    @Step("User expects that result number {0} has text: {1}")
    public UserOnResultsPage expectsResultHasText(int index, String text) {
        searchingResultsPage.results.get(index).shouldHave(text(text));
        return this;
    }

    @Step("The user clicks the repo link for {0} result")
    public UserOnRepositoryPage followsRepoLink(int index) {
        searchingResultsPage.resultLink(index).click();
        return new UserOnRepositoryPage();
    }
}

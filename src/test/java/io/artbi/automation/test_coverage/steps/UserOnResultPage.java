package io.artbi.automation.test_coverage.steps;

import io.artbi.automation.test_coverage.pages.GitHubWelcomePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class UserOnResultPage extends GitHubUser {

    private final GitHubWelcomePage github = new GitHubWelcomePage();

    @Step("User expects number of results: {0}")
    public UserOnResultPage expectedNumberOfResults(int number) {
        github.results.shouldHave(size(number));
        return this;
    }
    @Step("User expects result {0} with text: {1}")
    public UserOnResultPage expectedResultWithText(int index, String text) {
        github.results.get(index).shouldHave(text(text));
        return this;
    }
    @Step("User follow {0} repo link")
    public UserOnResultPage followRepoLink(int index) {
        github.resultsLink(index).click();
        return this;
    }
}

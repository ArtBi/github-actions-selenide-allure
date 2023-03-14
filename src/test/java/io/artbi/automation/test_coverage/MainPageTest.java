package io.artbi.automation.test_coverage;

import io.artbi.automation.test_coverage.steps.GoogleUser;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class MainPageTest extends BaseTest {

    @Test
    @Description("Search test for new user")
    public void search() {
        new GoogleUser().openGoogle()
                .search("Selenide")
                .expectedNumberOfResults(7)
                .expectedResultWithText(0, "Selenide");
    }


}



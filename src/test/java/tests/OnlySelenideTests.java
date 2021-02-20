package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OnlySelenideTests {

    private static final String BASE_URL = "http://github.com";

    private static final String ISSUES = "Issues";

    private static final String REPOSITORY = "Dmitriy9210/Lesson5_Allure";
    private static final String ISSUE_NUMBER = "#1";

    @Test
    @Owner("Dima")
    @Severity(SeverityLevel.MINOR)
    @Tags({@Tag("web"), @Tag("minor")})
    @Link(name = "Base URL", value = BASE_URL)

    @Feature("Issues")
    @Story("Поск Issue")
    @DisplayName("Поиск Issue по номеру в репозитории")
    public void testIssueSearch() {
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUES)).click();
        $(withText(ISSUE_NUMBER)).should(exist);
    }
}

package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTests {

    private static final String BASE_URL = "http://github.com";
    private static final String ISSUES = "Issues";
    private static final String REPOSITORY = "Dmitriy9210/Lesson5_Allure";
    private static final String ISSUE_NUMBER = "#1";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу " + BASE_URL, () -> {
            open(BASE_URL);
        });
        step("Ищем репоизторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Переходим в раздел " + ISSUES, () -> {
            $(withText(ISSUES)).click();
        });
        step("Проверяем что Issue с номером " + ISSUE_NUMBER + " существует", () -> {
            $(withText(ISSUE_NUMBER)).should(exist);
        });
    }
}

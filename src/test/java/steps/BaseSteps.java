package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

        private static final String BASE_URL = "http://github.com";

        private static final String ISSUES = "Issues";

        @Step("Открываем страницу " + BASE_URL)
        public void openLink() {
            open(BASE_URL);
        }

        @Step("Ищем репоизторий {repository}")
        public void searchRepo(String repository) {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        }


        @Step("Переходим в репозиторий {repository}")
        public void goInRepo(String repository) {
            $(By.linkText(repository)).click();
        }

        @Step("Переходим в раздел " + ISSUES)
        public void goInIssue() {
            $(withText(ISSUES)).click();
        }

        @Step("Проверяем что Issue с номером {issueNumber} существует")
        public void checkIssue(String issueNumber) {
            $(withText(issueNumber)).should(exist);
        }
    }

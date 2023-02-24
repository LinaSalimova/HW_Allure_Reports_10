package test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsTest extends TestBase {
    @Test
    @DisplayName("Проверка имени Issue через Lambda steps")
    public void checkNameIssueLambdaSteps() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу issues проекта Selenide", () -> {
            open(REPO);
        });
        step("Вводим в строке поиска id Issue " + ISSUE_NUMBER,  () -> {
            search.click();
            search.setValue(ISSUE_NUMBER);
            search.pressEnter();

        });
        step("Проверяем название Issue " + ISSUE_NUMBER, () -> {
            check.shouldHave(Condition.
                    text(TEXT));
        });
    }
    @Test
    @DisplayName("Проверка имени Issue через annotation steps")
    public void checkNameIssueAnnotatedSteps() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openPage(REPO);
        steps.inputIssueIdInSearchField(ISSUE_NUMBER);
        steps.checkIssueName(ISSUE_NUMBER, TEXT);
    }
}

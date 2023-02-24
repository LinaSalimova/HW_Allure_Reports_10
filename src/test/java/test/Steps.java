package test;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class Steps extends TestBase {
    @Step("Открываем страницу https://github.com/{page}")
    public void openPage(String page) {
        open("https://github.com/" + page);
    }
    @Step("Вводим в строке поиска ISSUE_NUMBER {ISSUE_NUMBER}")
    public void inputIssueIdInSearchField(String ISSUE_NUMBER) {
        search.click();
        search.setValue(ISSUE_NUMBER);
        search.pressEnter();
    }

    @Step("Проверяем название Issue {ISSUE_NUMBER}" )
    public void checkIssueName(String ISSUE_NUMBER, String TEXT) {
        check.shouldHave(Condition.
                text(TEXT));
    }
}
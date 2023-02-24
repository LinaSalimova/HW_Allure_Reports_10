package test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest extends TestBase {

    @Test
    @DisplayName("Проверка имени Issue без степов")
    public void checkNameIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open(REPO);
        search.click();
        search.setValue(ISSUE_NUMBER);
        search.pressEnter();
        check .shouldHave(Condition.
                text(TEXT));
    }
}


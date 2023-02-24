package test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    public final String
            REPO = "https://github.com/selenide/selenide/issues",
            ISSUE_NUMBER = "1636",
            TEXT = "Get web console logs from firefox";
    public  SelenideElement search = $("#js-issues-search");
    public  SelenideElement check = $("#issue_1636_link");
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
    }

}

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class GitHubSolutionsHoverTests {
        public static String expected = "The AI-powered\n" +
                "developer platform";
        @BeforeAll
        public static void configureTests() {
            Configuration.pageLoadStrategy = "eager";
            //Configuration.holdBrowserOpen = true;
            Configuration.timeout = 4000;
            Configuration.baseUrl = "https://github.com";
        }
        @Test
        public void pageHasText() {
            open("");
            $x("//button[contains(text(), 'Solutions')]").hover();
            $(".HeaderMenu-dropdown a[href=\"/enterprise\"]").click();
            $("#hero-section-brand-heading")
                    .shouldHave(text(expected));
        }
        @AfterAll
        public static void clearAll() {
            clearBrowserCookies();
            clearBrowserLocalStorage();
            closeWindow();
            closeWebDriver();
        }
    }




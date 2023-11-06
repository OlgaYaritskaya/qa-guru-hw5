import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
public class DragAndDropTests {
    @BeforeAll
    public static void configurationTests() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 4000;
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void actionDragAndDropTest() {
        open("/drag_and_drop");
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#columns").$("div header").shouldHave(text("B"));
    }

    @Test
    void selenideDragAndDropTest() {
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#columns").$("div header").shouldHave(text("B"));
    }

    @AfterAll
    public static void clearAll() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
        closeWebDriver();
    }
}

package test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class CssAndXpathExamples {
    @Test
    void CssAndXpathExamples() {
            $("[name=q]");
            $("testarea[name=q]"); //css-selector

            $x("//textarea[@name='q']");
            $(xpath("//textarea[@name='q']"));  // xpath-selector

            $(byName("q"));



    }
}

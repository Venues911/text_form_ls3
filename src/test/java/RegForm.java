import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager"; }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form)"));
        $("#userName").setValue("IP");
        $("#userEmail").setValue("vanusezzz@gmail.com");

        $("#gender-radio-1").parent().click(); // or $(byText("Male")).click();



        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another address 1");
        $("#submit").click();
        //check values in fill
        $("#output").$("#name").shouldHave(text("IP"));
        $("#output #name").shouldHave(text("IP"));
        $("#output #email").shouldHave(text("vanusezzz@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Another address 1"));
    }
}

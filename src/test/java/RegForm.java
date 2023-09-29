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
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen=true;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("IP");
        $("#lastName").setValue("AN");
        $("#userEmail").setValue("vanusezzz@gmail.com");

        $("#gender-radio-1").parent().click(); // or $(byText("Male")).click();
        $("#userNumber").setValue("+79997998872");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September"); // OR .selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsContainer").setValue("Some address");
        $("#currentAddress").setValue("Some address 1");

//        $("#submit").click();
//        //check values in fill
//        $("#output").$("#name").shouldHave(text("IP"));
//        $("#output #name").shouldHave(text("IP"));
//        $("#output #email").shouldHave(text("vanusezzz@gmail.com"));
//        $("#output #currentAddress").shouldHave(text("Some address 1"));
//        $("#output #permanentAddress").shouldHave(text("Another address 1"));
    }
}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegFormTest {
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
        Selenide.executeJavaScript("$('#fixedban').remove()"); // remove banner
        Selenide.executeJavaScript("$('footer').remove()"); // remove banner

        $("#firstName").setValue("IP");
        $("#lastName").setValue("AN");
        $("#userEmail").setValue("vanusezzz@gmail.com");

        $("#genterWrapper").$(byText("Male")).click(); // or .$(byText("Male")).click();
        $("#userNumber").setValue("79997998872");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September"); // OR .selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath ("img/1.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("IP"));
        $(".table-responsive").shouldHave(text("AN"));
        $(".table-responsive").shouldHave(text("vanusezzz@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("7999799887"));
        $(".table-responsive").shouldHave(text("02 September,1997"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("Some address 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}

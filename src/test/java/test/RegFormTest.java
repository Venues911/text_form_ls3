package test;

import components.RegistrationPage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegFormTest extends TestBase {

    private static final String endPoint = "/automation-practice-form";
    @Test
    void fillFormTest() {
    RegistrationPage.openThePage(endPoint).
            setFirstName("Ivan").
            setLastName("Pugachev").
            setEmail("somemail@g.com").
            setGender("Male").
            setNumber("89999999988").
            setDateOfBirth("02","02","1999").
            setSubject("Maths").
            setHobbies("Sports").
            uploadPicture("1.png").
            setAddress("Some address 1").
            setState("NCR").
            setCity("Delhi").
            clickSubmit();

    RegistrationPage.verifyFinalResult().
            verifyResult("Student Name","Ivan Pugachev").
            verifyResult("Student Email", "somemail@g.com").
            verifyResult("Gender", "Male").
            verifyResult("Mobile", "89999999988").
            verifyResult("Date of Birth", "02","02","1999").
            verifyResult("Subjects", "Maths").
            verifyResult("Hobbies", "Sports").
            verifyResult("Picture", "1.png").
            verifyResult("Address", "Some address 1").
            verifyResult("State and City", "NCR Delhi");
    }
}

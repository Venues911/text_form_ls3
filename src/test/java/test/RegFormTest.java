package test;

import components.RegistrationPage;
import org.junit.jupiter.api.Test;


public class RegFormTest extends TestBase {

    private static final String ENDPOINT = "/automation-practice-form";
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void fillFormTest() {
        registrationPage.openThePage(ENDPOINT).
            setFirstName("Ivan").
            setLastName("Pugachev").
            setEmail("somemail@g.com").
            setGender("Male").
            setNumber("89999999999").
            setDateOfBirth("11","October","2011").
            setSubject("Maths").
            setHobbies("Sports").
            uploadPicture("img/1.png").
            setAddress("Some address 1").
            setState("NCR").
            setCity("Delhi").
            clickSubmit();

        registrationPage.verifyFinalResult().
            verifyResult("Student Name","Ivan Pugachev").
            verifyResult("Student Email", "somemail@g.com").
            verifyResult("Gender", "Male").
            verifyResult("Mobile", "8999999999").
            verifyResult("Date of Birth", "11 October,2011").
            verifyResult("Subjects", "Maths").
            verifyResult("Hobbies", "Sports").
            verifyResult("Picture", "1.png").
            verifyResult("Address", "Some address 1").
            verifyResult("State and City", "NCR Delhi");
    }
}

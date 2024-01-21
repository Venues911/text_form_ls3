package test;

import com.github.javafaker.Faker;
import components.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


public class RegFormTest extends TestBase {

    private static final String ENDPOINT = "/automation-practice-form";
    RegistrationPage registrationPage = new RegistrationPage();

    public static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomHobbies() {
        String[] hobbies = { "Sports", "Reading", "Music"};
        return getRandomHobbiesFromArray(hobbies);
    }

    public static String getRandomHobbiesFromArray(String[] array) {
        int index = getRandom(0, 2);
        return array[index];
    }



    @Test
    void fillFormTest() {

        Faker faker = new Faker();
        String fakeFirstName = faker.name().firstName(); // Emory
        String fakeLastName = faker.name().lastName(); // Barton
        String fakeEmail = faker.internet().emailAddress();
        String fakeGender = faker.demographic().sex();
        String fakerNumber = faker.phoneNumber().subscriberNumber(10);
        String fakerSubject = faker.witcher().witcher();
        String fakeAdress = faker.address().streetAddress();






        registrationPage.openThePage(ENDPOINT).
            setFirstName(fakeFirstName).
            setLastName(fakeLastName).
            setEmail(fakeEmail).
            setGender(fakeGender).
            setNumber(fakerNumber).
            setDateOfBirth("11" , "09", "2000").
            setSubject(fakerSubject).
            setHobbies(getRandomHobbies()).uploadPicture("img/1.png").
            setAddress(fakeAdress).
            setState("NCR").
            setCity("Noida").
            clickSubmit();

        registrationPage.verifyFinalResult().
            verifyResult("Student Name", fakeFirstName + " " + fakeLastName).
            verifyResult("Student Email", fakeEmail).
            verifyResult("Gender", fakeGender).
            verifyResult("Mobile", fakerNumber).
            verifyResult("Date of Birth", "11 September,2000").
            verifyResult("Subjects", fakerSubject).
            verifyResult("Hobbies", getRandomHobbies()).
            verifyResult("Picture", "1.png").
            verifyResult("Address", fakeAdress).
            verifyResult("State and City", "NCR Noida");
    }
}

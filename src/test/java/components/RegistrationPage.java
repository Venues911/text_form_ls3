package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends RemoveBanner {

    /// Selenide Elements

    CalendarComponent calendar = new CalendarComponent();
    CheckResult finalResult = new CheckResult();


    SelenideElement
        lable = $(".practice-form-wrapper"),
        firstName = $("#firstName"),
        lastName = $("#lastName"),
        email = $("#userEmail"),
        gender = $("#genterWrapper"),
        number  = $("#userNumber"),
        dateOfBirth = $("#dateOfBirthInput"),
        subject = $("#subjectsInput"),
        hobbies = $("#hobbiesWrapper"),
        picture =  $("#uploadPicture"),
        address = $("#currentAddress"),
        state = $("#state"),
        city = $("#city"),
        stateAndCity = $("#stateCity-wrapper"),
        submitButton = $("#submit") ;



    ////Elements


public RegistrationPage openThePage(String url) {
        open(url);
        removeBanner();
        return this;
    }

public RegistrationPage setFirstName(String value) {
    firstName.setValue(value);
    return this;
}

public RegistrationPage setLastName(String value) {
    lastName.setValue(value);
    return this;
    }

public RegistrationPage setEmail(String value) {
    email.setValue(value);
    return this;
    }

public RegistrationPage setGender(String value) {
    gender.$(byText("value")).click();
    return this;
    }
public RegistrationPage setNumber(String value) {
    number.setValue(value);
    return this;
    }
public RegistrationPage setDateOfBirth(String day, String month, String year) {
    dateOfBirth.click();
    calendar.setDateMethod(day, month, year);
    return this;
    }
public RegistrationPage setSubject(String value) {
    subject.setValue(value).pressEnter();
    return this;
    }
public RegistrationPage setHobbies(String value) {
    hobbies.$(byText(value)).click();
    return this;
    }
public RegistrationPage uploadPicture(String value) {
    picture.uploadFromClasspath (value);
    return this;
    }

public RegistrationPage setAddress(String value) {
    address.setValue(value);
    return this;
    }
public RegistrationPage setState(String value) {
    state.click();
    stateAndCity.$(byText(value)).click();
    return this;
    }
public RegistrationPage setCity(String value) {
    city.click();
    stateAndCity.$(byText(value)).click();
    return this;
    }
public RegistrationPage clickSubmit() {
    submitButton.click();
    return this;
    }
public RegistrationPage verifyFinalResult(String value) {
    finalResult.modalDialog();
    return this;
    }
public RegistrationPage verifyResult (String key, String value) {
    finalResult.verifyResult(key, value);
    return this;
    }
}

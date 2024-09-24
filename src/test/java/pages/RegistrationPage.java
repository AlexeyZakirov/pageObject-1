package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends ResultTableComponent {

    private final String registrationEndpoint = "/automation-practice-form";
    public final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            studentGenderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");


    public void removeAdd() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage openPage() {
        open(registrationEndpoint);
        removeAdd();
        return this;
    }

    public RegistrationPage setStudentName(String first, String last) {
        firstNameInput.setValue(first);
        lastNameInput.setValue(last);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setStudentGenderWrapper(String gender) {
        studentGenderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setStudentNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setDateOfBirth(String month, String year, int day) {
        CalendarComponent calendarComponent = new CalendarComponent();
        dateOfBirthInput.click();
        calendarComponent.setDate(month, year, day);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setCurrentAddressInput(String picture) {
        currentAddressInput.setValue(picture);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage submitRegistration() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkRegistrationResult(String key, String value) {
        checkResultTable(key, value);
        return this;
    }

    public void checkInvalidResult() {
        resultDialog.shouldNot(appear);
    }
}

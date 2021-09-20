package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final static String PAGE_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";

    private SelenideElement
            finalTitle = $("#example-modal-sizes-title-lg"),
            titleForm = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            finalClick = $("#submit"),
            modal = $(".table-responsive");

    private Calendar calendar = new Calendar();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleForm.shouldHave(text(PAGE_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;

    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;

    }

    public RegistrationPage typeEmail(String email) {
        userEmail.setValue(email);
        return this;

    }

    public RegistrationPage typePhone(String phone) {
        userNumber.setValue(phone);
        return this;

    }


    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;

    }

    public RegistrationPage typeGender(String gender) {
        genterWrapper.$(byText(gender)).click();
        return this;

    }

    public RegistrationPage typeSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;

    }

    public RegistrationPage typeHobby(String hobby) {
        hobbieWrapper.$(byText(hobby)).click();
        return this;

    }

    public RegistrationPage typePicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;

    }

    public RegistrationPage currentAddress(String adress) {
        currentAddress.val(adress);
        return this;

    }

    public RegistrationPage currentState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;

    }

    public RegistrationPage currentCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;

    }

    public RegistrationPage submit() {
        finalClick.click();
        return this;
    }

    public void checkResultsTitle() {
        finalTitle.shouldHave(text(RESULTS_TITLE));
    }

    public void checkResultsValue(String value) {
        modal.shouldHave(text(value));

    }
}

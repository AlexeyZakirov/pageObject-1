import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationTests extends BaseSetUp {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void fillAllFieldsTest() {
        registrationPage.openPage()
                .setStudentName("Alexey", "Zakirov")
                .setEmail("azakirov@mail.ru")
                .setStudentGenderWrapper("Male")
                .setStudentNumber("1111111111")
                .setDateOfBirth("July", "2000", 3)
                .setSubjects("Maths")
                .setHobby("Sports")
                .setHobby("Music")
                .uploadPicture("cat.png")
                .setCurrentAddressInput("3204 Canyon Lake Drive")
                .setStateAndCity("NCR", "Delhi")
                .submitRegistration()

                .checkRegistrationResult("Student Name", "Alexey Zakirov")
                .checkRegistrationResult("Student Email", "azakirov@mail.ru")
                .checkRegistrationResult("Gender", "Male")
                .checkRegistrationResult("Mobile", "1111111111")
                .checkRegistrationResult("Date of Birth", "3 July,2000")
                .checkRegistrationResult("Subjects", "Maths")
                .checkRegistrationResult("Hobbies", "Sports, Music")
                .checkRegistrationResult("Picture", "cat.png")
                .checkRegistrationResult("Address", "3204 Canyon Lake Drive")
                .checkRegistrationResult("State and City", "NCR Delhi");
    }

    @Test
    public void fillMinimumFieldsTest() {
        registrationPage.openPage()
                .setStudentName("Alexey", "Zakirov")
                .setEmail("azakirov@mail.ru")
                .setStudentGenderWrapper("Male")
                .setStudentNumber("1111111111")
                .setDateOfBirth("July", "2000", 20)
                .submitRegistration()

                .checkRegistrationResult("Student Name", "Alexey Zakirov")
                .checkRegistrationResult("Student Email", "azakirov@mail.ru")
                .checkRegistrationResult("Gender", "Male")
                .checkRegistrationResult("Mobile", "1111111111")
                .checkRegistrationResult("Date of Birth", "20 July,2000");
    }

    @Test
    public void fillMinimumFieldsWithNonNumericNumberTest() {
        registrationPage.openPage()
                .setStudentName("Alexey", "Zakirov")
                .setEmail("azakirov@mail.ru")
                .setStudentGenderWrapper("Male")
                .setStudentNumber("invalid")
                .setDateOfBirth("July", "2000", 20)
                .submitRegistration()

                .checkInvalidResult();
    }
}

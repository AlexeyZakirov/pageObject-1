import org.junit.jupiter.api.Test;
import pages.TextBoxPage;


public class TextBoxTests extends BaseSetUp {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillAllFieldsTest() {
        textBoxPage.openPage()
                .setName("Fedor")
                .setEmail("fed@google.com")
                .setCurrentAddress("address current")
                .setPermanentAddress("address permanent")
                .submit()
                .checkResultName("Fedor")
                .checkResultEmail("fed@google.com")
                .checkResultCurrentAddress("address current")
                .checkResultPermanentAddress("address permanent");
    }
}

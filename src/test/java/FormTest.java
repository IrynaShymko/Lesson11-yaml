import Pages.Form;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends TestBase {

    private static Logger logger = LoggerFactory.getLogger("FormTest.class");

    @Tag("Form")
    @Test
    public void shouldShowSuccessValidationMessage() {
        Form form = new Form(driver);
        form.fillFirstName(System.getProperty("firstName"))
                .fillLastName(System.getProperty("lastName"))
                .fillEmail(System.getProperty("email"))
                .checkSexRadioButton()
                .fillAge()
                .checkYearOfExperienceRadioButton()
                .checkProfession()
                .selectContinent()
                .selectSeleniumCommands(System.getProperty("command1"), System.getProperty("command2"))
                .uploadFile(new File(System.getProperty("pathToFileForUpload")));
        form.clickSignInButton();
        assertThat("Validation message is incorrect", form.getValidationMessage(), equalTo(System.getProperty("expectedMessage")));
    }
}

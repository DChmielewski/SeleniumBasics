package highsite;

import utils.TestBase;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("http://51.75.61.161:9102/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.fillFirstName("Dominik");
        formPage.fillLastName("Jachaś");
        formPage.fillEmail("dominojachas@sii.pl");
        formPage.selectRandomGender();
        formPage.fillAgeNumber("25");
        formPage.selectRandomExperience();
        formPage.selectProfession();
        formPage.selectRandomContinent();
        formPage.multiselectCommands();
        formPage.addingFileToForm();
        formPage.signInButton();
        String message = formPage.getValidatorMessage();
        assertThat(message).isEqualTo("Form send with success");

    }
}


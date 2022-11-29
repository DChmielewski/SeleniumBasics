package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;
    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;
    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;
    @FindBy(css = "[name=gridRadiosSex]")
    private List<WebElement> genders;
    @FindBy(css = "#inputAge3")
    private WebElement ageNumber;
    @FindBy(css = "[name=gridRadiosExperience]")
    private List<WebElement> experience;
    @FindBy(css = "#gridCheckAutomationTester")
    private WebElement profession;
    @FindBy(css = "#selectContinents")
    private WebElement continents;
    @FindBy(css = "#selectSeleniumCommands")
    private WebElement seleniumCommands;
    @FindBy(css = "#chooseFile")
    private WebElement browseFile;

    @FindBy(css = ".btn-primary")
    private WebElement singIn;
    @FindBy(css = "#validator-message")
    private WebElement validatorMessage;

    public void fillFirstName(String name) {
        firstNameInput.sendKeys(name);

    }


    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }


    public void fillEmail(String email) {
        emailInput.sendKeys(email);
    }


    public void selectRandomGender() {
        genders.get(new Random().nextInt(genders.size())).click();
    }

    public void fillAgeNumber(String age) {
        ageNumber.sendKeys(age);

    }

    public void selectRandomExperience() {
        experience.get(new Random().nextInt(experience.size())).click();
    }

    public void selectProfession() {
        profession.click();
    }

    //TODO napisz to lepiej niz chinczyk na yt
    public void selectRandomContinent() {
        Select selectContinents = new Select(continents);
        selectContinents.selectByIndex(new Random().nextInt(6) + 1);

    }

    public void multiselectCommands() {
        Select selectMultiselectCommands = new Select(seleniumCommands);
        selectMultiselectCommands.selectByValue("switch-commands");
        selectMultiselectCommands.selectByValue("wait-commands");
    }


    public void addingFileToForm() {
        File file = new File("src/main/resources/testowy.txt");
        browseFile.sendKeys(file.getAbsolutePath());
    }

    public void signInButton() {
        singIn.click();
    }

    public String getValidatorMessage() {
        return validatorMessage.getText();
    }
}

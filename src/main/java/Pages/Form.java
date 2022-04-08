package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Form {
    private WebDriver driver;

    public Form(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input [@id='inputFirstName3']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input [@id='inputLastName3']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input [@id='inputEmail3']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='gridRadiosSex']")
    private List<WebElement> sexRadioButtonsList;

    @FindBy(xpath = "//input[@id='inputAge3']")
    private WebElement age;

    @FindBy(xpath = "//input[@name='gridRadiosExperience']")
    private List<WebElement> yearOfExperienceRadioButtonsList;

    @FindBy(xpath = "//*[@for='gridCheckAutomationTester']")
    private WebElement profession;

    @FindBy(xpath = "//select[@id='selectContinents']")
    private WebElement continentField;

    @FindBy(xpath = "//select[@id='selectContinents']//option")
    List<WebElement> continentsList;

    @FindBy(xpath = "//select[@id='selectSeleniumCommands']")
    private WebElement seleniumCommandsField;

    @FindBy(xpath = "//input[@id= 'chooseFile']")
    private WebElement uploadFileField;

    @FindBy(xpath = "//button[contains(text(), 'Sign in')]")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='validator-message']")
    private WebElement validationMessage;

    public Form fillFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public Form fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public Form fillEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public Form checkSexRadioButton() {
        sexRadioButtonsList.get(new Random().nextInt(sexRadioButtonsList.size())).click();
        return this;
    }

    public Form fillAge() {
        int generatedAge = new Random().nextInt(100);
        for (int i = 0; i <= generatedAge; i++) {
            age.sendKeys(Keys.ARROW_UP);
        }
        return this;
    }

    public Form checkYearOfExperienceRadioButton() {
        yearOfExperienceRadioButtonsList.get(new Random().nextInt(yearOfExperienceRadioButtonsList.size())).click();
        return this;
    }

    public Form checkProfession() {
        profession.click();
        return this;
    }

    public Form selectContinent() {
        int index = (int) (Math.random() * (continentsList.size() - 1)) + 1;
        Select drpDwnContinents = new Select(continentField);
        drpDwnContinents.selectByIndex(index);
        return this;
    }

    public Form selectSeleniumCommands(String command1, String command2) {
        Select drpDwnSeleniumCommands = new Select(seleniumCommandsField);
        Actions action = new Actions(driver);
        action.keyDown(Keys.LEFT_SHIFT);
        drpDwnSeleniumCommands.selectByVisibleText(command1);
        drpDwnSeleniumCommands.selectByVisibleText(command2);
        action.keyUp(Keys.LEFT_SHIFT);
        return this;
    }

    public Form uploadFile(File file) {
        uploadFileField.sendKeys(file.getAbsolutePath());
        return this;
    }

    public Form clickSignInButton() {
        signInButton.click();
        return this;
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

    public void fillForm(String firstName, String lastName, String email, String command1, String command2, File file) {
        fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .checkSexRadioButton()
                .fillAge()
                .checkYearOfExperienceRadioButton()
                .checkProfession()
                .selectContinent()
                .selectSeleniumCommands(command1, command2)
                .uploadFile(file);
    }

}
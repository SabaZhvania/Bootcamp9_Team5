package ge.tbcitacademy.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcitacademy.data.Constants;
import ge.tbcitacademy.pages.CommonPage;
import ge.tbcitacademy.pages.RegistrationPage;
import ge.tbcitacademy.util.UrlUtils;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;

public class RegistrationSteps {

    CommonPage commonPage = new CommonPage();
    private final RegistrationPage registrationPage = new RegistrationPage();



    @Step("Click 'Register' button")
    public RegistrationSteps clickRegisterButton() {
        commonPage.registerBtn.click();
        return this;
    }

    @Step("Validate login page is displayed")
    public RegistrationSteps validateLoginPage() {
        registrationPage.LoginRegistrationPageHeader.shouldBe(visible);
        return this;
    }

    @Step("Enter invalid email: {invalidEmail}")
    public RegistrationSteps enterInvalidEmail(String invalidEmail) {
        registrationPage.EmailInput.setValue(invalidEmail);
        registrationPage.ContinueWithEmailButton.click();
        return this;
    }

    @Step("Validate invalid email error message is shown")
    public RegistrationSteps validateInvalidEmailErrorMessage() {
        registrationPage.InvalidEmailErrorMessage.shouldHave(text(Constants.INVALID_EMAIL_ERROR_MESSAGE));
        return this;
    }

    @Step("Click 'Sign in with Google' button")
    public void clickSignInWithGoogleButton() {
        registrationPage.SignInWithGoogleButton.click();
    }

    @Step("Check if Google sign-in page is opened")
    public boolean isGoogleSignInPageOpened() {
        String currentWindow = Selenide.switchTo().window(0).getTitle();
        Selenide.switchTo().window(1);

        boolean isDisplayed = $x("//*[contains(text(),'Sign in with Google')]")
                .shouldBe(visible)
                .isDisplayed();
        Selenide.closeWindow();
        Selenide.switchTo().window(currentWindow);

        return isDisplayed;
    }

    @Step("Enter valid email: {validEmail}")
    public RegistrationSteps enterValidEmail(String validEmail) {
        registrationPage.EmailInput.setValue(validEmail);
        registrationPage.ContinueWithEmailButton.click();
        return this;
    }

    @Step("Enter invalid password: {invalidPassword}")
    public RegistrationSteps enterInvalidPassword(String invalidPassword) {
        enterPassword(invalidPassword);
        confirmPassword(invalidPassword);
        return this;
    }

    @Step("Enter valid password: {validPassword}")
    public RegistrationSteps enterValidPassword(String validPassword) {
        enterPassword(validPassword);
        confirmPassword(validPassword);
        return this;
    }

    @Step("Enter password: {password}")
    private void enterPassword(String password) {
        registrationPage.PasswordInput.clear();
        registrationPage.PasswordInput.setValue(password);
    }

    @Step("Confirm password: {password}")
    private void confirmPassword(String password) {
        registrationPage.ConfirmPasswordInput.clear();
        registrationPage.ConfirmPasswordInput.setValue(password);
    }

    @Step("Click 'Create Account' button")
    public RegistrationSteps clickCreateAccountButton() {
        registrationPage.CreateAccountButton.click();
        return this;
    }

    @Step("Validate URL contains parameters: {parameters}")
    public void validateUrlContainsParameters(String... parameters) {
        for (String parameter : parameters) {
            Wait().withTimeout(Duration.ofSeconds(10))
                    .until(driver -> WebDriverRunner.url().contains(parameter));
        }
        UrlUtils.assertUrlContainsParameters(WebDriverRunner.url(), parameters);
    }
}

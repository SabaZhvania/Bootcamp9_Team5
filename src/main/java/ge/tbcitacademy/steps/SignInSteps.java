package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.RegistrationPage;
import ge.tbcitacademy.pages.SignInPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SignInSteps {

    SignInPage signInPage = new SignInPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Validate sign in text is displayed")
    public SignInSteps validateSignInPage(){
        signInPage.signInText.shouldBe(visible);
        return this;
    }

    @Step("Validate continue with email is displayed")
    public SignInSteps validateContinueWithEmail(){
        signInPage.continueWithEmail.shouldHave(text("Continue with email")).shouldBe(visible);
        return this;
    }

    @Step("Validate social buttons are displayed and clickable")
    public SignInSteps validateSocialButtons(){
        signInPage.socialBtns.forEach(b -> b.shouldBe(visible).shouldBe(clickable));
        return this;
    }

    @Step("Click 'Sign In' button")
    public SignInSteps clickSignInButton() {
        signInPage.signInBtn.click();
        return this;
    }

    @Step("Enter email: {email}")
    public SignInSteps enterEmail(String email) {
        signInPage.getEmailInput.setValue(email);
        return this;
    }

    @Step("Click 'Continue with email' button")
    public SignInSteps clickContinueWithEmailButton() {
        registrationPage.ContinueWithEmailButton.click();
        return this;
    }

    @Step("Enter password: {password}")
    public SignInSteps enterPassword(String password) {
        signInPage.getPasswordInput.setValue(password);
        return this;
    }

    @Step("Click 'Sign In' button on sign-in page")
    public void clickSignInButtonOnSignInPage() {
        signInPage.getSignInButton.click();
    }
}

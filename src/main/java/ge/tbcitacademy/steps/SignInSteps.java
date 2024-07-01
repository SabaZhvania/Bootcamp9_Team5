package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SignInPage;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SignInSteps {
    SignInPage signInPage = new SignInPage();

    @Step("Enter email")
    public SignInSteps enterEmail() {
        signInPage.emailInput.setValue("teamfivetbc@gmail.com");
        return this;
    }

    @Step("Enter password: {password}")
    public SignInSteps enterPassword(String password) {
        signInPage.passwordInput.setValue(password);
        return this;
    }

    @Step("Click 'Sign In' button on sign-in page")
    public SignInSteps clickSignInButtonOnSignInPage() {
        signInPage.signInButton.click();
        return this;
    }
}

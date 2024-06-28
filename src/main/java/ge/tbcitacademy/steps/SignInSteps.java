package ge.tbcitacademy.steps;

import ge.tbcitacademy.pages.SignInPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class SignInSteps {
    SignInPage signInPage = new SignInPage();

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
}

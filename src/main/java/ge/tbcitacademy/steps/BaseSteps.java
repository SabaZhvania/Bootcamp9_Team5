package ge.tbcitacademy.steps;

import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbcitacademy.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class BaseSteps extends CommonSteps {
    BasePage basePage = new BasePage();

    @Step("Wait for page to load")
    public BaseSteps validatePageLoad() {
        basePage.promotionalOffers.first().shouldBe(allOf(visible, clickable));
        basePage.promotionalOffers.last().shouldBe(allOf(visible, clickable));
        return this;
    }

    @Step("Close the sign in or register pop up")
    public BaseSteps closeSignInPopUp() {
        try {
            basePage.signInPopUpCloseButton.shouldBe(visible, Duration.ofSeconds(3));
            basePage.signInPopUpCloseButton.click();
        } catch (NoSuchElementException | ElementNotFound e) {
            System.out.println("No pop up detected");
        }
        return this;
    }


}

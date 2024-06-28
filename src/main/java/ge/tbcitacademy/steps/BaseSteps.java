package ge.tbcitacademy.steps;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementNotFound;
import ge.tbcitacademy.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

public class BaseSteps {
    BasePage basePage = new BasePage();
    @Step("Close save money popup")
    public BaseSteps closePopup(){
        try {
            basePage.dismissButton.shouldBe(visible, Duration.ofSeconds(3));
            basePage.dismissButton.click();
        }catch (NoSuchElementException | ElementNotFound e){
            System.out.println("Element is not visible");
        }
        return this;
    }

    @Step("Navigate to previous page")
    public BaseSteps navigateBack(){
        Selenide.back();
        return this;
    }
}

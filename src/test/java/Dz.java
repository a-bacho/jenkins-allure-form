import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class Dz extends TestBase {

    @Test
    @DisplayName("Successful fill registration test")
    void dz () {
        step("Open registration form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });
        step("Fill registration form", () -> {
            open("https://demoqa.com/automation-practice-form");
            $("#firstName").setValue("Johny");
            $("#lastName").setValue("Depp");
            $("#userEmail").setValue("johny@depp.com");
            $("#genterWrapper").$(byText("Male")).click();
            $("#currentAddress").scrollIntoView(true);
            $("#userNumber").setValue("2222222222222");

            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2010");

            $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#subjectsInput").setValue("science").pressEnter();
            $("#uploadPicture").uploadFile(new File("src/test/resources/img/peterthegreat.png"));
            $("#currentAddress").setValue("Main street");

            $("#state").click();

            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Noida")).scrollTo().click();
            $("#submit").click();
        });
        step("Verify form data", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        });



    }
}


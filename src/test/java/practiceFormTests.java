import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class practiceFormTests {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.timeout = 40000;
    }

    @Test
    void successFillFormTest(){
        open("/automation-practice-form");

        // ожидание загрузки элементов формы
        $("#firstName").shouldBe(visible);
        $("#lastName").shouldBe(visible);
        $("#userEmail").shouldBe(visible);
        $("[for=gender-radio-1]").shouldBe(visible);
        $("#userNumber").shouldBe(visible);

// ввод данных в форму
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan@mail.ru");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");

// отправка формы
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

//    @Test
//    void dateSelectionSuccessTest(){
//        open("/automation-practice-form");
//
//
////         ожидание загрузки элементов формы
//        $("#firstName").shouldBe(visible);
//        $("#lastName").shouldBe(visible);
//        $("#userEmail").shouldBe(visible);
//        $("[for=gender-radio-1]").shouldBe(visible);
//        $x("//input[@id='dateOfBirthInput']").shouldBe(visible);
//        $("#userNumber").shouldBe(visible);
//
//
//        $x("//input[@id='dateOfBirthInput']").click();
//
//        $("[class=react-datepicker__year-select]").shouldBe(visible);
//        $("[class=react-datepicker__month-select]").shouldBe(visible);
//        $("[class=react-datepicker__week]").shouldBe(visible);
//
//        $("[class=react-datepicker__year-select]").$("[value=1981]").click();
//        $("[class=react-datepicker__month-select]").$(byText("April")).click();
//        $("[class=react-datepicker__week]").$(byText("15")).click();
//
//        $("#dateOfBirthInput").shouldHave(Condition.attribute("[value=15 April 1981]"));
//    }
}

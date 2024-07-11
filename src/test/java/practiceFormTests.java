import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class practiceFormTests {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.timeout = 60000;
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

// ожидание появления модального окна
//        $(".modal-dialog").shouldBe(visible);


//        $("#dateOfBirthInput").click(); // выбираем дату далее для другого теста установку даты проверять буду
//        $("option.value=1965").click();
//        $("option.value=3").click();
//        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));





    }
}

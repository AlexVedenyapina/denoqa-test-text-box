import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class practiceFormTests {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl= "https://demoqa.com";
        Configuration.timeout = 35000;
    }

    @Test
    void successFillFormTest(){
        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivan");// 2  таких id  нужно искать
        $("for=gender-radio-1").click();
        $("#userNumber").setValue("1234567890");

//        $("#dateOfBirthInput").click(); // выбираем дату далее для другого теста установку даты проверять буду
//        $("option.value=1965").click();
//        $("option.value=3").click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));




    }
}

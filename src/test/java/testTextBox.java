import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class testTextBox {

    @BeforeAll
    static void beforAll(){
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl= "https://demoqa.com";
    }

    @Test
    void fileFromTest(){
        Selenide.withTimeout(5000).open("/text-box");
//         open("/text-box");
        $("#userName").setValue("Svetlana Kirchenko");
        $("#userEmail").setValue("svetlana@kirchenko.ru");
        $("#currentAddress").setValue("Stavropol, Mira 123");
        $("#permanentAddress").setValue("Address 2");
        $("#submit").click();

        $("#output").shouldHave(text("Svetlana Kirchenko"), text("svetlana@kirchenko.ru"),
                text("Stavropol, Mira 123"), text("Address 2"));

    }

}

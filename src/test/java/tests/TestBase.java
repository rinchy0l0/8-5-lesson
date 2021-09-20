package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }
}

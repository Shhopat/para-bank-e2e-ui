package config;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    public  void setAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 50000;

    }

    @BeforeEach
    public  void init() {
        setAll();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }

    @AfterEach
    public  void down() {
        Selenide.closeWebDriver();
    }
}

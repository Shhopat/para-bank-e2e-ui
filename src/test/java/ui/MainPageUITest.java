package ui;

import config.AutomationConfig;
import config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

@Tag("smoke")
public class
MainPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void shouldOpenMainPage() {
        Assertions.assertEquals(AutomationConfig.BANK_NAME, mainPage.getNameBankFromMainPage());
    }

    @Test
    public void shouldDisplayLoginFrom() {
        Assertions.assertTrue(mainPage.isLoginFormVisible());
    }

    @Test
    public void shouldEnabledButtonLogin() {
        Assertions.assertTrue(mainPage.isEnabledButtonLogin());
    }

    @Test
    public void shouldEnabledHrefRegister() {
        Assertions.assertTrue(mainPage.isEnabledHrefRegister());
    }

    @Test
    public void shouldEnabledHrefForgotLoginInfo() {
        Assertions.assertTrue(mainPage.isEnabledHrefForgotLoginInfo());
    }


}

package ui;

import config.AutomationConfig;
import config.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

@Owner("Ibragim")
@Tag("smoke")
public class
MainPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    @Description("Проверяем, что открыта главная страница банка")
    public void shouldOpenMainPage() {
        Assertions.assertEquals(AutomationConfig.BANK_NAME, mainPage.getNameBankFromMainPage());
    }

    @Test
    @Description("Проверяем отображение формы логина на главной странице")
    public void shouldDisplayLoginFrom() {
        Assertions.assertTrue(mainPage.isLoginFormVisible());
    }

    @Test
    @Description("Проверяем, что кнопка входа активна и кликабельна")
    public void shouldEnabledButtonLogin() {
        Assertions.assertTrue(mainPage.isEnabledButtonLogin());
    }

    @Test
    @Description("Проверяем кликабельность ссылки регистрации нового пользователя")
    public void shouldEnabledHrefRegister() {
        Assertions.assertTrue(mainPage.isEnabledHrefRegister());
    }

    @Test
    @Description("Проверяем кликабельность ссылки 'Забыли логин/пароль'")
    public void shouldEnabledHrefForgotLoginInfo() {
        Assertions.assertTrue(mainPage.isEnabledHrefForgotLoginInfo());
    }


}

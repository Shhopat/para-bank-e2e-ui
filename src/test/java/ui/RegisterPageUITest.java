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
public class RegisterPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    @Description("Проверяем, что открыта страница регистрации")
    public void shouldOpenRegisterPage() {
        Assertions.assertEquals(AutomationConfig.TEXT_REGISTER_FORM, mainPage.openRegisterPage().getTextRegisterForm());
    }

    @Test
    @Description("Проверяем отображение формы регистрации")
    public void shouldOpenRegisterForm() {
        Assertions.assertTrue(mainPage.openRegisterPage().isVisibleFormRegister());
    }

    @Test
    @Description("Проверяем, что все поля ввода на форме регистрации активны")
    public void shouldEnabledAllInputFields() {
        Assertions.assertTrue(mainPage.openRegisterPage().isFirstNameEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isLastNameEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isAddressEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isSsnEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isStateEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isCityEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isZipCodeEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isUsernameEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isPasswordEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isRepeatedPasswordEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isPhoneNumberEnabled());
    }

    @Test
    @Description("Проверяем, что кнопка регистрации активна и кликабельна")
    public void shouldEnabledButtonRegister() {
        Assertions.assertTrue(mainPage.openRegisterPage().isEnabledButtonRegister());
    }


}

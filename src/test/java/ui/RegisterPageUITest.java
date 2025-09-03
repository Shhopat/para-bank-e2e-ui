package ui;

import config.AutomationConfig;
import config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

@Tag("smoke")
public class RegisterPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void shouldOpenRegisterPage() {
        Assertions.assertEquals(AutomationConfig.TEXT_REGISTER_FORM, mainPage.openRegisterPage().getTextRegisterForm());
    }

    @Test
    public void shouldOpenRegisterForm() {
        Assertions.assertTrue(mainPage.openRegisterPage().isVisibleFormRegister());
    }

    @Test
    public void shouldEnabledButtonRegister() {
        Assertions.assertTrue(mainPage.openRegisterPage().isEnabledButtonRegister());
    }
}

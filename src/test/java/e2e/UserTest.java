package e2e;

import annotation.Retry;
import annotation.UserRandom;
import config.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import model.UserLogin;
import model.UserRegistration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import page.MainPage;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;

@Owner("ibragim")
@Tag("regress")
public class UserTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private UserRegistration userRegistration;
    private final UserLogin userLogin = new UserLogin();

    @BeforeEach
    public void init(@UserRandom UserRegistration userRegistration) {
        this.userRegistration = userRegistration;

    }

    @Retry(2)
    @Description(value = "Регистрация нового юзера")
    @Test
    public void shouldRegisterNewUser() {
        Assertions.assertTrue(mainPage.openRegisterPage().register(userRegistration));
    }

    @Description("Вход с существующего аккаунта и проверка кликабельности кнопки выхода")
    @Test
    public void shouldLoginThenLogoutEnabledButtonLogin() {
        Assertions.assertTrue(mainPage.login(userLogin).logout().isEnabledButtonLogin());
    }


}

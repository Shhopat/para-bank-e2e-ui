package e2e;

import annotation.Retry;
import annotation.UserRandom;
import config.BaseTest;
import model.UserLogin;
import model.UserRegistration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import page.MainPage;
import org.junit.jupiter.api.Test;


public class UserTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private UserRegistration userRegistration;
    private final UserLogin userLogin = new UserLogin();

    @BeforeEach
    public void init(@UserRandom UserRegistration userRegistration) {
        this.userRegistration = userRegistration;

    }

    @Retry(2)
    @Tag("regress")
    @Test
    public void shouldRegisterNewUser() {
        Assertions.assertTrue(mainPage.openRegisterPage().register(userRegistration));
    }


    @Test
    public void shouldLoginThenLogoutEnabledButtonLogin() {
        Assertions.assertTrue(mainPage.login(userLogin).logout().isEnabledButtonLogin());
    }


}

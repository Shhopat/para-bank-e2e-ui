package ui;

import config.BaseTest;
import lombok.ToString;
import model.UserLogin;
import org.junit.jupiter.api.*;
import page.AccountPage;
import page.MainPage;

@Tag("smoke")
public class AccountPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final UserLogin userLogin = new UserLogin();
    private final AccountPage accountPage = new AccountPage();

    @BeforeEach
    public void init() {
        mainPage.login(userLogin);

    }

    @Test
    public void shouldEnabledHrefOpenNewAccount() {
        Assertions.assertTrue(accountPage.isEnabledHrefOpenNewAccount());
    }

    @Test
    public void shouldEnabledHrefAccountOverview() {
        Assertions.assertTrue(accountPage.isEnabledHrefAccountOverview());
    }

    @Test
    public void shouldEnabledHrefTransfer() {
        Assertions.assertTrue(accountPage.isEnabledHrefTransferFunds());
    }
    @Test
    public void shouldEnabledHrefBillPay() {
        Assertions.assertTrue(accountPage.isEnabledHrefBillPay());
    }

    @Test
    public void shouldEnabledHrefFindTrans() {
        Assertions.assertTrue(accountPage.isEnabledHrefFindTrans());
    }

    @Test
    public void shouldEnabledHrefUpdateProfile() {
        Assertions.assertTrue(accountPage.isEnabledHrefUpdateProfile());
    }

    @Test
    public void shouldEnabledHrefRequestLoan() {
        Assertions.assertTrue(accountPage.isEnabledHrefRequestLoan());
    }

    @Test
    public void shouldEnabledHrefLogout() {
        Assertions.assertTrue(accountPage.isEnabledHrefLogout());
    }





}

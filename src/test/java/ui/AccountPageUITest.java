package ui;

import config.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import lombok.ToString;
import model.UserLogin;
import org.junit.jupiter.api.*;
import page.AccountPage;
import page.MainPage;

@Owner("Ibragim")
@Tag("smoke")
public class AccountPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final UserLogin userLogin = new UserLogin();
    private final AccountPage accountPage = new AccountPage();

    @BeforeEach
    public void initData() {
        mainPage.login(userLogin);

    }

    @Test
    @Description("Проверяем кликабельность кнопки создания нового счёта")
    public void shouldEnabledHrefOpenNewAccount() {
        Assertions.assertTrue(accountPage.isEnabledHrefOpenNewAccount());
    }

    @Test
    @Description("Проверяем кликабельность кнопки просмотра счетов (Account Overview)")
    public void shouldEnabledHrefAccountOverview() {
        Assertions.assertTrue(accountPage.isEnabledHrefAccountOverview());
    }

    @Test
    @Description("Проверяем кликабельность кнопки перевода средств (Transfer Funds)")
    public void shouldEnabledHrefTransfer() {
        Assertions.assertTrue(accountPage.isEnabledHrefTransferFunds());
    }

    @Test
    @Description("Проверяем кликабельность кнопки оплаты счетов (Bill Pay)")
    public void shouldEnabledHrefBillPay() {
        Assertions.assertTrue(accountPage.isEnabledHrefBillPay());
    }

    @Test
    @Description("Проверяем кликабельность кнопки поиска транзакций (Find Transactions)")
    public void shouldEnabledHrefFindTrans() {
        Assertions.assertTrue(accountPage.isEnabledHrefFindTrans());
    }

    @Test
    @Description("Проверяем кликабельность кнопки обновления профиля (Update Profile)")
    public void shouldEnabledHrefUpdateProfile() {
        Assertions.assertTrue(accountPage.isEnabledHrefUpdateProfile());
    }

    @Test
    @Description("Проверяем кликабельность кнопки запроса кредита (Request Loan)")
    public void shouldEnabledHrefRequestLoan() {
        Assertions.assertTrue(accountPage.isEnabledHrefRequestLoan());
    }

    @Test
    @Description("Проверяем кликабельность кнопки выхода из аккаунта (Logout)")
    public void shouldEnabledHrefLogout() {
        Assertions.assertTrue(accountPage.isEnabledHrefLogout());
    }



}

package e2e;

import config.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import model.Transfer;
import model.TransferPayee;
import model.UserLogin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.AccountPage;
import page.BilPayPage;
import page.MainPage;
import page.TransferFundsPage;

@Owner("Ibragim")
@Tag("smoke")
public class TransferTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final UserLogin userLogin = new UserLogin();
    private final Transfer transfer = new Transfer();
    private final AccountPage accountPage = new AccountPage();
    private final TransferFundsPage transferFundsPage = new TransferFundsPage();
    private final BilPayPage bilPayPage = new BilPayPage();


    @BeforeEach
    public void init() {
        mainPage.login(userLogin);
        transfer.setAmount("1000");
    }

    @Test
    @Description(value = "Перевод денег между счетами")
    public void shouldTransferMoneyEachOtherAccounts() {
        Assertions.assertTrue(accountPage.openTransfer()
                .transferMoneyFromTo(Transfer.builder()
                        .fromAccount(transferFundsPage.getValueFromAccount())
                        .toAccount(transferFundsPage.getValueToAccount())
                        .build())
                .isTransferComplete());
    }

    @Test
    @Description(value = "Перевод на счет другого аккаунта")
    public void shouldPayFromAccountToAccount() {
        Assertions.assertTrue(accountPage.openBilPayPage()
                .billPayFromTo(TransferPayee.builder().fromAccountNumber(
                        bilPayPage.getValueFromAccount()).build())
                .isPaymentComplete());
    }
}

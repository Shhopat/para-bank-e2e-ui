package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ui.AccountPageUITest;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {
    private final SelenideElement LOGOUT = $x("//a[@href='logout.htm']");
    private final SelenideElement HREF_OPEN_NEW_ACCOUNT = $x("//a[@href='openaccount.htm']");
    private final SelenideElement HREF_ACCOUNT_OVERVIEW = $x("//a[@href='overview.htm']");
    private final SelenideElement HREF_TRANSFER_FUNDS = $x("//a[@href='transfer.htm']");
    private final SelenideElement HREF_BILL_PAY = $x("//a[@href='billpay.htm']");
    private final SelenideElement HREF_FIND_TRANS = $x("//a[@href='findtrans.htm']");
    private final SelenideElement HREF_UPDATE_PROFILE = $x("//a[@href='updateprofile.htm']");
    private final SelenideElement HREF_REQUEST_LOAN = $x("//a[@href='requestloan.htm']");


    public boolean isEnabledHrefLogout() {
        return LOGOUT.isEnabled();
    }

    public MainPage logout() {
        LOGOUT.shouldBe(Condition.enabled).click();
        return new MainPage();
    }

    public boolean isEnabledHrefOpenNewAccount() {
        return HREF_OPEN_NEW_ACCOUNT.isEnabled();
    }

    public boolean isEnabledHrefAccountOverview() {
        return HREF_ACCOUNT_OVERVIEW.isEnabled();
    }

    public boolean isEnabledHrefTransferFunds() {
        return HREF_TRANSFER_FUNDS.isEnabled();
    }

    public boolean isEnabledHrefBillPay() {
        return HREF_BILL_PAY.isEnabled();
    }

    public boolean isEnabledHrefFindTrans() {
        return HREF_FIND_TRANS.isEnabled();
    }

    public boolean isEnabledHrefUpdateProfile() {
        return HREF_UPDATE_PROFILE.isEnabled();
    }

    public boolean isEnabledHrefRequestLoan() {
        return HREF_REQUEST_LOAN.isEnabled();
    }




}

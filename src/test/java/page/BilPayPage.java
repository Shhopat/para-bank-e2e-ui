package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.TransferPayee;

import static com.codeborne.selenide.Selenide.$x;

public class BilPayPage {
    private final SelenideElement PAYEE_NAME = $x("//input[@class='input' and contains(@name,'name')]");
    private final SelenideElement ADDRESS = $x("//input[@class='input' and contains(@name,'address.street')]");
    private final SelenideElement CITY = $x("//input[@class='input' and contains(@name,'address.city')]");
    private final SelenideElement STATE = $x("//input[@class='input' and contains(@name,'address.state')]");
    private final SelenideElement ZIP_CODE = $x("//input[@class='input' and contains(@name,'address.zipCode')]");
    private final SelenideElement PHONE_NUMBER = $x("//input[contains(@class,'input phone-number') and contains(@name,'phoneNumber')]");
    private final SelenideElement ACCOUNT_NUMBER = $x("//input[@class='input' and contains(@name,'accountNumber')]");
    private final SelenideElement VERIFY_ACCOUNT = $x("//input[@class='input' and contains(@name,'verifyAccount')]");
    private final SelenideElement AMOUNT = $x("//input[@class='input' and contains(@name,'amount')]");
    private final SelenideElement FROM_ACCOUNT = $x("//select[contains(@name,'fromAccount')]");
    private final SelenideElement BUTTON_SEND_PAYMENT = $x("//input[@type='button']");
    private final SelenideElement MESSAGE_COMPLETE = $x("//h1[contains(text(),'Complete')]");
    private final SelenideElement FROM_ACCOUNT_VAlUE = $x("//select[@name='fromAccountId']/option[@value]");

    @Step("отправляем средства в размере {transferPayee.amount} co счета {transferPayee.fromAccountNumber} получателю {transferPayee.payeeName} на счет {transferPayee.accountNumber}")
    public BilPayPage billPayFromTo(TransferPayee transferPayee) {
        PAYEE_NAME.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getPayeeName());
        ADDRESS.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getAddress());
        CITY.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getCity());
        STATE.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getState());
        ZIP_CODE.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getZipCode());
        PHONE_NUMBER.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getPhoneNumber());
        ACCOUNT_NUMBER.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getAccountNumber());
        VERIFY_ACCOUNT.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getVerifyAccountNumber());
        AMOUNT.shouldBe(Condition.visible, Condition.enabled).setValue(transferPayee.getAmount());
        FROM_ACCOUNT.shouldBe(Condition.visible, Condition.enabled).selectOptionByValue(transferPayee.getFromAccountNumber());
        BUTTON_SEND_PAYMENT.shouldBe(Condition.visible, Condition.enabled).click();
        return this;

    }

    @Step("Проверяем успешное завершение платежа")
    public boolean isPaymentComplete() {
        return MESSAGE_COMPLETE.shouldBe(Condition.visible, Condition.enabled).isDisplayed();
    }


    public String getValueFromAccount() {
        return FROM_ACCOUNT_VAlUE.getAttribute("value");
    }


}

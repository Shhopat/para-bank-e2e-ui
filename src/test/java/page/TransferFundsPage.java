package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import model.Transfer;
import model.TransferPayee;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$x;


public class TransferFundsPage {
    private final SelenideElement INPUT_AMOUNT = $x("//input[@id='amount']");
    private final SelenideElement INPUT_FROM_ACCOUNT = $x("//select[@id='fromAccountId']");
    private final SelenideElement INPUT_TO_ACCOUNT = $x("//select[@id='toAccountId']");
    private final SelenideElement BUTTON_TRANSFER = $x("//input[@type='submit']");
    private final SelenideElement MESSAGE_TRANSFER = $x("//h1[@class='title' and contains(text(),'Complete')]");


    @Step("Перевести {transfer.amount} со счета {transfer.fromAccount} на счет {transfer.toAccount}")
    public TransferFundsPage transferMoneyFromTo(Transfer transfer) {
        INPUT_AMOUNT.shouldBe(Condition.visible, Condition.enabled).setValue(transfer.getAmount());
        INPUT_FROM_ACCOUNT.shouldBe(Condition.visible, Condition.enabled).selectOptionByValue(transfer.getFromAccount());
        INPUT_TO_ACCOUNT.shouldBe(Condition.visible, Condition.enabled).selectOptionByValue(transfer.getToAccount());
        BUTTON_TRANSFER.shouldBe(Condition.visible, Condition.enabled).click();
        return this;
    }

    @Step("Проверяем успешный перевод между счетами")
    public boolean isTransferComplete() {
        return MESSAGE_TRANSFER.shouldBe(Condition.visible).isDisplayed();
    }


}

package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {
    private final SelenideElement LOGOUT = $x("//a[@href='logout.htm']");


    public boolean isEnabledHrefLogout() {
        return LOGOUT.isEnabled();
    }

    public MainPage logout() {
        LOGOUT.shouldBe(Condition.enabled).click();
        return new MainPage();
    }

}

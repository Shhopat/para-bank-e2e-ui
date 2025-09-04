package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import config.AutomationConfig;
import io.qameta.allure.Step;
import model.UserLogin;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement REGISTER = $x("//a[contains(text(),'Register')]");
    private final SelenideElement PARA_BANK = $x("//img[@title='ParaBank']");
    private final SelenideElement FORM_LOGIN = $x("//form[@name='login' and @method='POST']");
    private final SelenideElement BUTTON_LOGIN = $x("//input[@type='submit' and @class='button']");
    private final SelenideElement FORGOT_LOGIN_INFO = $x("//a[@href and contains(text(),'Forgot')]");
    private final SelenideElement INPUT_USERNAME = $x("//input[@class='input' and contains(@name,'username')]");
    private final SelenideElement INPUT_PASSWORD = $x("//input[@class='input' and contains(@name,'password')]");

    public MainPage() {
        Selenide.open(AutomationConfig.URL);
    }

    public RegisterPage openRegisterPage() {
        REGISTER.click();
        return new RegisterPage();
    }

    public boolean isEnabledHrefRegister() {
        return REGISTER.isEnabled();
    }

    public String getNameBankFromMainPage() {
        PARA_BANK.shouldBe(Condition.exist);
        return PARA_BANK.getAttribute("title");
    }

    public boolean isLoginFormVisible() {
        return FORM_LOGIN.isDisplayed();
    }

    public boolean isEnabledButtonLogin() {
        return BUTTON_LOGIN.isEnabled();
    }

    public boolean isEnabledHrefForgotLoginInfo() {
        return FORGOT_LOGIN_INFO.isEnabled();
    }

    @Step("Выполняем вход под пользователем {userLogin.username}")
    public AccountPage login(UserLogin userLogin) {
        INPUT_USERNAME.shouldBe(Condition.visible).setValue(userLogin.getUsername());
        INPUT_PASSWORD.shouldBe(Condition.visible).setValue(userLogin.getPassword());
        BUTTON_LOGIN.shouldBe(Condition.enabled).click();
        return new AccountPage();
    }


}

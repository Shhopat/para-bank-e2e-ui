package page;

import annotation.UserRandom;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import model.UserRegistration;

import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {
    private final SelenideElement MESSAGE_fORM_REGISTER = $x("//h1[@class='title' and text()='Signing up is easy!']");
    private final SelenideElement FORM_REGISTER = $x("//table[@class='form2']");
    private final SelenideElement BUTTON_REGISTER = $x("//input[@type='submit' and @value='Register']");
    private final SelenideElement MESSAGE_AFTER_REGISTER = $x("//h1[@class='title' and contains(text(),'Welcome')]");
    private final SelenideElement FIRST_NAME = $x("//input[@id='customer.firstName']");
    private final SelenideElement LAST_NAME = $x("//input[@id='customer.lastName']");
    private final SelenideElement ADDRESS = $x("//input[@id='customer.address.street']");
    private final SelenideElement CITY = $x("//input[@id='customer.address.city']");
    private final SelenideElement STATE = $x("//input[@id='customer.address.state']");
    private final SelenideElement ZIP_CODE = $x("//input[@id='customer.address.zipCode']");
    private final SelenideElement PHONE_NUMBER = $x("//input[@id='customer.phoneNumber']");
    private final SelenideElement SSN = $x("//input[@id='customer.ssn']");
    private final SelenideElement USERNAME = $x("//input[@id='customer.username']");
    private final SelenideElement PASSWORD = $x("//input[@id='customer.password']");
    private final SelenideElement REPEATED_PASSWORD = $x("//input[@id='repeatedPassword']");

    public String getTextRegisterForm() {
        MESSAGE_fORM_REGISTER.shouldBe(Condition.visible);
        return MESSAGE_fORM_REGISTER.text();
    }

    public boolean isVisibleFormRegister() {
        return FORM_REGISTER.isDisplayed();
    }

    public boolean isEnabledButtonRegister() {
        return BUTTON_REGISTER.isEnabled();
    }


    public boolean register(UserRegistration userRegistration) {
        FIRST_NAME.setValue(userRegistration.getFirstName());
        LAST_NAME.setValue(userRegistration.getLastName());
        ADDRESS.setValue(userRegistration.getAddress());
        CITY.setValue(userRegistration.getCity());
        STATE.setValue(userRegistration.getState());
        ZIP_CODE.setValue(userRegistration.getZipCode());
        PHONE_NUMBER.setValue(userRegistration.getPhone());
        SSN.setValue(userRegistration.getSsn());
        USERNAME.setValue(userRegistration.getUsername());
        PASSWORD.setValue(userRegistration.getPassword());
        REPEATED_PASSWORD.setValue(userRegistration.getConfirmPassword());
        BUTTON_REGISTER.shouldBe(Condition.visible).click();
        return MESSAGE_AFTER_REGISTER.shouldBe(Condition.visible).getText().contains(userRegistration.getUsername());


    }


}

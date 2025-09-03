package ui;

import config.AutomationConfig;
import config.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.MainPage;

@Tag("smoke")
public class RegisterPageUITest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    public void shouldOpenRegisterPage() {
        Assertions.assertEquals(AutomationConfig.TEXT_REGISTER_FORM, mainPage.openRegisterPage().getTextRegisterForm());
    }

    @Test
    public void shouldOpenRegisterForm() {
        Assertions.assertTrue(mainPage.openRegisterPage().isVisibleFormRegister());
    }

   @Test
   public void shouldEnabledAllInputFields(){
        Assertions.assertTrue(mainPage.openRegisterPage().isFirstNameEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isLastNameEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isAddressEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isSsnEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isStateEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isCityEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isZipCodeEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isUsernameEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isPasswordEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isRepeatedPasswordEnabled());
        Assertions.assertTrue(mainPage.openRegisterPage().isPhoneNumberEnabled());
   }

    @Test
    public void shouldEnabledButtonRegister() {
        Assertions.assertTrue(mainPage.openRegisterPage().isEnabledButtonRegister());
    }


}

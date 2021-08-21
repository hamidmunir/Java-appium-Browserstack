package Pages;

import Base.BasePage;
import Base.common;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import java.util.List;


public class Loginpage extends BasePage {

    common c = new common();
    String device = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform").toLowerCase();

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up/Log in']")
    @iOSXCUITFindBy(accessibility = "Sign up/Log in")
    MobileElement signUpButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up now']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign up now']")
    MobileElement signUpNowLink;

    @AndroidFindBy(xpath = "//android.view.View[@text='Month']")
    @iOSXCUITFindBy(accessibility = "Month")
    MobileElement month;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"1990\"))")
    MobileElement androidYearPicker;

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    List<MobileElement> pickerWheel;

    @iOSXCUITFindBy(id = "Done")
    MobileElement doneButton;

    @AndroidFindBy(xpath = "//android.view.View[@text='Day']")
    @iOSXCUITFindBy(id = "Day")
    MobileElement day;

    @AndroidFindBy(xpath = "//android.view.View[@text='Year']")
    @iOSXCUITFindBy(id = "Year")
    MobileElement year;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    @iOSXCUITFindBy(id = "Continue")
    MobileElement continueButton;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='AgreeToTermsOfUseConsentYes_option']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch")
    MobileElement privacySwitch;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='email']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='Email Address']")
    MobileElement emailAddressfield;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Send Code']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Send Code']")
    MobileElement sendCodeButton;


    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='verificationCode']")
    @iOSXCUITFindBy(id = "Verification Code")
    MobileElement verificationCodeField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Verify Code']")
    @iOSXCUITFindBy(id = "Verify Code")
    MobileElement verifyCodeButton;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='emailControl_error_message']")
    MobileElement verificationFailedMessage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='number']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Phone number']")
    MobileElement phoneNumberField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='verificationCode']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    MobileElement mobileCodeText;

    @iOSXCUITFindBy(accessibility = "Skip for now")
    MobileElement skipForNowLink;

    @AndroidFindBy(accessibility = "Close tab")
    @iOSXCUITFindBy(id = "Cancel")
    MobileElement cancelSignupButton;

    public Loginpage() throws Exception {
    }


    public Loginpage clickSignUpButton() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();
        return this;
    }

    public Loginpage clickSignUpLink() {
        wait.until(ExpectedConditions.visibilityOf(signUpNowLink));
        signUpNowLink.click();
        return this;
    }

    public Loginpage clickMonth() {
        wait.until(ExpectedConditions.visibilityOf(month));
        month.click();
        return this;
    }

    public Loginpage chooseMonth() {

        if (device.equals("ios")) {
            pickerWheel.get(0).sendKeys("March");
            doneButton.click();


        } else if (device.equals("android")) {
            pickerWheel.get(3).click();


        }
        return this;
    }

    public Loginpage clickDay() {
        wait.until(ExpectedConditions.visibilityOf(day));
        day.click();
        return this;
    }

    public Loginpage chooseDay() {
        if (device.equals("ios")) {
            pickerWheel.get(0).sendKeys("24");
            doneButton.click();
        } else if (device.equals("android")) {
            pickerWheel.get(3).click();

        }

        return this;
    }

    public Loginpage clickYear() {
        wait.until(ExpectedConditions.visibilityOf(year));
        year.click();
        return this;

    }

    public Loginpage chooseYear() {
        if (device.equals("ios")) {
            pickerWheel.get(0).sendKeys("1990");
            doneButton.click();
        } else if (device.equals("android")) {
            androidYearPicker.click();

        }

        return this;
    }

    public Loginpage clickContinueButton() {
        continueButton.click();
        return this;
    }

    public Loginpage clickOnPrivacySwitch() {
        wait.until(ExpectedConditions.visibilityOf(privacySwitch));
        privacySwitch.click();
        return this;
    }



    public Loginpage clickSendCodeButton() {
        wait.until(ExpectedConditions.visibilityOf(sendCodeButton));
        sendCodeButton.click();
        return this;
    }

    public Loginpage enterVerificationCode(String code) {
        wait.until(ExpectedConditions.visibilityOf(verificationCodeField));
        verificationCodeField.click();
        verificationCodeField.clear();
        verificationCodeField.sendKeys(code);
        return this;
    }

    public Loginpage clickVerifyCodeButton() {
        verifyCodeButton.click();
        return this;
    }

    public Boolean getVerificationFailedMessage() {
        boolean errordisplayed = false;
        try {

            errordisplayed = wait.until(ExpectedConditions.visibilityOf(verificationFailedMessage)).isDisplayed();


        } catch (Exception message) {
            System.out.println("Email was verified successfully");

        }

        return errordisplayed;
    }

    public Loginpage enterPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        phoneNumberField.sendKeys("216546312");
        return this;
    }

    public Loginpage enterPhoneCode() {
        wait.until(ExpectedConditions.visibilityOf(mobileCodeText));
        mobileCodeText.sendKeys("123156");
        return this;
    }

    public Loginpage clickCancelSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelSignupButton));
        cancelSignupButton.click();
        return this;
    }


}

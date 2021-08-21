package Base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Random;


public class common {

    public void scrollToIos(String text) {
        final HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("predicateString", "value =='" + text + "'");
        scrollObject.put("toVisible", "true");
        DriverManager.getDriver().executeScript("mobile: scroll", scrollObject);

    }

    public void scrollToEndAndroid() {
        try {
            DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
    }

    public void scrollTillTextAndClick(String text) {
        try {
            ((AndroidDriver<MobileElement>) DriverManager.getDriver()).findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0))").click();
        } catch (InvalidSelectorException e) {
            // ignore
        }

    }

    public void scrollBackward() {
        try {
            DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
        } catch (InvalidSelectorException e) {
            // ignore
        }

    }


}



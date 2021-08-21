package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.JsonParser;

import java.net.URL;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();


    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver driver1) {
        driver.set(driver1);
    }

    public static void initializeDriver(String platform, String name) throws Exception {

        AppiumDriver driver;
        String userName = ""; //Enter browserstack credentials here
        String accessKey = "";
        JSONObject deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject(platform).toString());
        DesiredCapabilities caps = new DesiredCapabilities();
        // Specify device and os_version for testing
        caps.setCapability("device", deviceObj.getString("device"));
        caps.setCapability("os_version", deviceObj.getString("os_version"));
        caps.setCapability("app", deviceObj.getString("app_url"));

        // Set other BrowserStack capabilities
        caps.setCapability("project", "SummitHealth Mobile Apps Automation");
        caps.setCapability("name", name);
        URL url = new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub");

        switch (platform) {
            case "android":
                driver = new AndroidDriver<AndroidElement>(url, caps);
                break;
            case "ios":
                driver = new IOSDriver<IOSElement>(url, caps);
                break;
            default:
                throw new IllegalStateException("invalid device platform" + platform);
        }
        setDriver(driver);
    }
}

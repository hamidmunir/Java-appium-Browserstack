package Base;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.JsonParser;
import utils.StringParser;

import java.util.HashMap;

public class BaseTest {
    public HashMap<String, String> strings = new HashMap<>();
    public JSONObject loginUsers;


    @Parameters({"platform"})
    @BeforeMethod
    public void beforeTest(String platform, ITestContext testContext) throws Exception {
        String name = testContext.getName();
        DriverManager.initializeDriver(platform, name);
        strings = StringParser.parseStringXML("strings.xml");
        loginUsers = JsonParser.parse("loginUsers.json");
    }

    @AfterMethod(alwaysRun = true)
    public void quit() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}

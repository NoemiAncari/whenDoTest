package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidCloud implements IDevice {
    @Override
    public AppiumDriver create() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "noemirosarioanca_nYtHL8");
        caps.setCapability("browserstack.key", "fzAwpSKnyJNGppgdn6Ps");

        // Set URL of the application under test
        caps.setCapability("app", "bs://1c1f0df49f290b9b9a2090989d59c62709148677");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Catolica");
        caps.setCapability("build", "1.0");
        caps.setCapability("name", "WhenDo");

        AndroidDriver<AndroidElement> driver;
        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }
}
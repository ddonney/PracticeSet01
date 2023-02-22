import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Author: dinudonney
 * Date: 22/02/23
 */
public class InitDriver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browser, String url) throws Exception {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;
            default:
                throw new Exception("Unsupported browser: " + browser);
        }
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Opening " + browser + " browser..!");
        driver.get().manage().window().maximize();
        driver.get().get(url);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void closeBrowser() {
        System.out.println("Closing Browser..!");
        driver.get().close();
        driver.remove();
    }
}

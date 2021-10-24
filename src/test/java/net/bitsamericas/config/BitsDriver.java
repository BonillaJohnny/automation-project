package net.bitsamericas.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class BitsDriver {

    private WebDriver driver;

    private static final Map<String, WebDriver> driverMap;

    private static Supplier<WebDriver> fireforxSupplier = () -> {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    };

    private static Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "/Users/jhonnybonilla/Development/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    };


    static {
        driverMap = new HashMap<>();
        //driverMap.put("firefox", fireforxSupplier.get());
        driverMap.put("chrome", chromeSupplier.get());
    }


    public BitsDriver(String driverName) {
        driver = driverMap.get(driverName);
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}

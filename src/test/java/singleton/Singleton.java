package singleton;

import org.openqa.selenium.WebDriver;

public class Singleton {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver){
        webDriver.set(driver);
    }

}

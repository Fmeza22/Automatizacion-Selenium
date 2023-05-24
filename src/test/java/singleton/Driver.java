package singleton;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

public class Driver implements IInvokedMethodListener{


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = Singleton.getDriver();
            if (driver ==null){
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            driver = LocalDriver.createInstance(browserName);
            // set the singleton instance
            Singleton.setWebDriver(driver);
        }
        }
    }
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = Singleton.getDriver();
            if (driver != null) {
                //driver.quit();
            }
        }
    }
}

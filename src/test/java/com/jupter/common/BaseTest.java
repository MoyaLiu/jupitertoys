package com.jupter.common;

import com.jupter.mock.DataProvider;
import com.jupter.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver webDriver;
    protected JupterPageFactory jupterPageFactory;
    protected DataProvider dataProvider;

    private static final int DEFAULT_TIMEOUT = 2;
    private static final String WEB_DRIVER_VERSION = "96.0";

    @Before
    public void setup() {
        WebDriverManager.chromedriver().version(WEB_DRIVER_VERSION).setup();
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().to(HomePage.HOME_URL);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        jupterPageFactory = new JupterPageFactory(webDriver);
        dataProvider = new DataProvider();
    }

    @After
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
    }
}

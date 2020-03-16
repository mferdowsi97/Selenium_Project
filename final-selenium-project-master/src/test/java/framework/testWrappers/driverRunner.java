package framework.testWrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class driverRunner {

    private static WebDriver driver;
    private static String facebookURL = "https://www.facebook.com/";
    private static String hotelsURL = "https://www.hotels.com/";
    private static String youtubeURL = "https://www.youtube.com/";
    private static String darkSkyURL = "https://darksky.net/forecast/40.7127,-74.0059/us12/en";


    @BeforeClass
    public void beforeClass() {
        //setChromedriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //init webdriver object
        driver = new ChromeDriver();
        //navigate to the url
        driver.navigate().to(facebookURL);
    }

    @AfterClass
    public void afterClass() {
        //quit the browser
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getUrl() {
        return facebookURL;
    }
}

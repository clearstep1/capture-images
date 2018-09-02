package test;

import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;
import page.PlanList;
import page.SeeThePlans;

import java.nio.file.Path;
import java.nio.file.Paths;


public class ResponsiveDesignTest {

    WebDriver driver;

    @Test
    public void test() throws InterruptedException {

        HomePage home = new HomePage(driver);

        //verify home page
        Assert.assertTrue(home.compare().isEqualsImages());

        SeeThePlans seeThePlans = home.clickOnJoinButton();

        //verify 'Choose your Plan' message page
        Assert.assertTrue(seeThePlans.compare().isEqualsImages());

        PlanList planList = seeThePlans.clickToSeeThePlans();

        //verify Plans List page
        Assert.assertTrue(planList.compare().isEqualsImages());
    }


    @BeforeTest
    @Parameters({"dimension", "browser"})
    public void beforeTest(String dimension, String browser) {


        String browserScreenshotPath = "./src/test/java/resource/" + browser;
        Path snapShotPath = Paths.get(browserScreenshotPath, dimension);
        System.out.println("browserScreenshotPath: " + browserScreenshotPath);

        //http://www.testautomationguru.com/ocular-automated-visual-validation-for-selenium-webdriver-test-automation-frameworks/#comment-8156
        //Ocular config - Ocular should look for the baseline image depends on the dimension or device
        Ocular.config()
                .snapshotPath(snapShotPath)
                .resultPath(Paths.get(browserScreenshotPath + "/result"))
                .saveSnapshot(true);

        //Launch Browser with the dimension or use appium driver to test on mobile devices
        if (browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else
            driver = new ChromeDriver();


        driver.get("https://www.netflix.com");

        int width = Integer.parseInt(dimension.split("x")[0]);
        int height = Integer.parseInt(dimension.split("x")[1]);

        driver.manage().window().setSize(new Dimension(width, height));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
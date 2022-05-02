import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.nio.file.Paths;
import java.time.Duration;

public class InventorySearchAdidas {
    private WebDriver driver;
    private HomePage homePage;
    private String path;

    @BeforeSuite
    public void beforeSuite(){
        path = Paths.get(System.getProperty("user.dir"), "src/main/resources/drivers/chromedriver.exe").toString();
        System.setProperty("webdriver.chrome.driver", path.toString());
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void afterMethod() throws Exception {
        try {
            driver.manage().deleteAllCookies();
           // driver.quit();
        } catch (Exception err) {
            Reporter.log(err.getMessage());
        }
    }

    @Test
    public void inventoryGreaterThan2000() throws Exception {
        homePage.inputTextSearch("shoes");
        homePage.filterByBrand();
        String quantify =  homePage.getInventoryQuantify();
       System.out.println(Integer.parseInt(quantify.replaceAll("\\p{Punct}", "")));
       Assert.assertTrue((Integer.parseInt(quantify.replaceAll("\\p{Punct}", "")))>2000);

    }

}

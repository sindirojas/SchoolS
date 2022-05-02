package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.Paths;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }
   // public static void main(String[] args){
     //   String path = Paths.get(System.getProperty("user.dir"), "src/main/resources/drivers/chromedriver.exe").toString();
       // System.setProperty("webdriver.chrome.driver", path.toString());
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.ebay.com");
        //Thread.sleep(5000);
    //}
}

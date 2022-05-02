package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="gh-ac")
    private WebElement labelSearch;

    @FindBy(id="gh-btn")
    private WebElement buttonSearch;

    @FindBy(xpath = "//input[@aria-label='adidas']")
    private WebElement checkboxAdidas;

    @FindBy(css = "div[class='srp-controls__row-cells'] span:nth-child(1)")
    private WebElement inventory;

    public void inputTextSearch(String text) throws Exception {
        labelSearch.sendKeys(text);
        buttonSearch.click();
    }

    public void filterByBrand(){
        scrollToElement(checkboxAdidas);
        checkboxAdidas.click();
    }

    public String getInventoryQuantify(){
        return inventory.getText();
    }
}

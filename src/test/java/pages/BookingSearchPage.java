package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingSearchPage extends BasePage {

    @FindBy(id = "ss")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(@class,'sb-searchbox__title-text')]")
    private WebElement simpleClick;

    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword){
        searchField.click();
        searchField.sendKeys(keyword);
        simpleClick.click();
        searchButton.click();
    }
}

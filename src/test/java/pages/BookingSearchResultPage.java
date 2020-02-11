package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class BookingSearchResultPage extends BasePage {

    private By HOTEL_NAMES_LOCATOR = By.xpath("//span[contains(@class,'sr-hotel__name')]");
    String raitingLocator = "//span[contains(text(),'%s')]/../../../../..//div[contains(@class,'bui-review-score__badge')]";


    public BookingSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultLinks() {
        List<WebElement> resultsHotelNames = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(HOTEL_NAMES_LOCATOR, 0));
        return resultsHotelNames.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }

    public By findHotelRaitingLocator(String hotelName){
        By hotelRaiting = By.xpath(String.format(raitingLocator, hotelName));
        return hotelRaiting;
    }

}

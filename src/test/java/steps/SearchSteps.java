package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.SearchHotelName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import pages.BookingSearchPage;
import pages.BookingSearchResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.testng.AssertJUnit.assertEquals;

public class SearchSteps{
    private static final String BOOKING_SEARCH_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingSearchResultPage searchPage;
    private WebDriver driver;
    private BookingSearchPage bookingSearchPage;
    private SearchHotelName searchHotelName;
    
    @cucumber.api.java.en.Given("Hotel for search is {string}")
    public void searchKeywordIsString(String keyword) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        searchHotelName = new SearchHotelName(keyword);
    }

    @Then("Hotel name {string} is on the first page")
    public void assertSearchResult(String result) {
        result = result + " ";
        assertThat(String.format("There are no results for search string '%s' on first search page", result),
                searchPage.getResultLinks(), 
                hasItem(result));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    }

    @When("User opens booking search page")
    public void userOpensBookingPage() {
        driver = new ChromeDriver();
        driver.get(BOOKING_SEARCH_URL);
        bookingSearchPage = new BookingSearchPage(driver);

    }

    @And("Does search")
    public void doesSearch() {
        bookingSearchPage.searchByKeyword(searchHotelName.getSearchString());
        searchPage = new BookingSearchResultPage(driver);
    }

    @And("Hotel {string} raiting is {string}")
    public void hotelRaitingIsTrue(String result, String raiting) {
        String hotelRaiting = driver.findElement(searchPage.findHotelRaitingLocator(result)).getText();
        assertEquals("Рейтинг отеля не соответствует ожидаемому", raiting, hotelRaiting);
        driver.findElement(searchPage.findHotelRaitingLocator(result));
        driver.quit();
    }
}


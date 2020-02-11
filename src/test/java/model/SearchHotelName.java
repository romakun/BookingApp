package model;

public class SearchHotelName {
    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    private String searchString;

    public SearchHotelName(String searchString) {
        this.searchString = searchString;
    }

    
}

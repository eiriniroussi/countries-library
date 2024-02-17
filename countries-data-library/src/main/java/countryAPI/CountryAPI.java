package countryAPI;

//A class made to pass the domain to the deserializeData class to build the URL
public class CountryAPI {
	private static final String API_URL = "https://restcountries.com";


    public static String getApiUrl() {
        return API_URL;
    }

}

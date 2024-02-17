import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Test;

import exception.countriesAPIException;
import model.countryInfo;
import service.deserializeData;

public class searchByCurrencyTest {

	//A Junit test for ensuring the method getCountryByCurrency is fetching and showing correctly data
	@Test
	public void testSearchByCurrency() throws URISyntaxException {
		deserializeData deserializer = new deserializeData("https://restcountries.com");
    try {
        countryInfo[] countries = null;
		countries = deserializer.getCountryByCurrency("currency","euro");
        assertNotNull("Countries list should not be null", countries);
    } catch (countriesAPIException e) {
        fail("Exception should not be thrown: " + e.getMessage());
    } catch (RuntimeException e) {
        fail("Runtime exception should not be thrown: " + e.getMessage());
    }

}}
package model;

import com.fasterxml.jackson.annotation.JsonProperty;

//import model.countryClass.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)

public class countryInfo {
    private String name;
    private List<String> capital;
    private Long population;
    private List<String> continents;
    private List<Currency> currencies;

    //When Jackson encounters the "name" property in the JSON (coming from the API), it will invoke this method, passing the value of the "name" property as a Map<String, Object>.
	@JsonProperty("name")
    public void unpackNestedName(Map<String, Object> name) {
        this.name = (String)name.get("common");//extracts the value associated with "common" from the map and assigning it to the name field of this class.
    }

	//currenciesMap is expected to be a map where each key is a currency code, and its value is another map containing details about the currency.
    @JsonProperty("currencies")
    public void unpackNestedCurrencies(Map<String, Map<String, String>> currenciesMap) {
        this.currencies = new ArrayList<>();
        if (currenciesMap != null && !currenciesMap.isEmpty()) {
            for (Map.Entry<String, Map<String, String>> entry : currenciesMap.entrySet()) {
                Currency currency = new Currency();
                currency.setCode(entry.getKey());
                currency.setName(entry.getValue().get("name"));
                currency.setSymbol(entry.getValue().get("symbol"));
                this.currencies.add(currency);
            }
        }
    }
    
	//Getters and setters  
	public String getFormattedCurrencies() {
		return formatCurrencies();
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCapital() {
		return capital;
	}

	public void setCapital(List<String> capital) {
		this.capital = capital;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public List<String> getContinents() {
		return continents;
	}

	public void setContinents(List<String> continents) {
		this.continents = continents;
	}

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }


	// Inner class for Currency
    public static class Currency {
        private String code;
        private String name;
        private String symbol;
        
        
        //getters and setters
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSymbol() {
			return symbol;
		}
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
        
        
    }
    
	//Make Human - readable the JSON results coming from the API
	@Override
	public String toString() {
		return "CountriesInfo" + "\n" +
				"Country: " + name + "\n" +
				"Capital: " + listToString(capital) +"\n" +
				"Currency: " + formatCurrencies()+ "\n" + 
				"Continents: " + listToString(continents) + "\n" + 
				"Population: " + population + "\n" ;
	}
	
	
	

	//A method for formatting the currencies
	private String formatCurrencies() {
	        if (currencies == null || currencies.isEmpty()) {
	            return "Not available";
	        }
	        StringBuilder sb = new StringBuilder();
	        for (Currency currency : currencies) {
	            if (sb.length() > 0) sb.append(", ");
	            sb.append(currency.getName());
	        }
	        return sb.toString();
	    }
	   
	//A method for returning strings from a list of strings separated by a comma | used for the continents and the capitals
	   private String listToString(List<String> list) {
	        if (list == null || list.isEmpty()) {
	            return "Not available";
	        }

	        StringBuilder sb = new StringBuilder();
	        for (String item : list) {
	            if (sb.length() > 0) {
	                sb.append(", "); // Add a comma separator between items
	            }
	            sb.append(item);
	        }
	        return sb.toString();
	    }
	   

	   




	

}

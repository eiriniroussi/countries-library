import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CountryInfoTest {

    private model.countryInfo countryInfo;

    @Before
    public void setUp() {
        countryInfo = new model.countryInfo();
    }

    @Test
    public void testNameGetterSetter() {
        String testName = "Greece";
        countryInfo.setName(testName);
        assertEquals(testName, countryInfo.getName());
    }


}

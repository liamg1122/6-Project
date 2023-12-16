
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice() {
        // Test cases for calcPrice() method
        Alcohol alcohol1 = new Alcohol("FireWhiskey", Size.SMALL, false);
        Alcohol alcohol2 = new Alcohol("RussianVodka", Size.MEDIUM, true);
        Alcohol alcohol3 = new Alcohol("CarribeanRum", Size.LARGE, true);

        assertEquals(2.0, alcohol1.calcPrice(), 0.001); 
        assertEquals(3.60, alcohol2.calcPrice(), 0.001); 
        assertEquals(4.60, alcohol3.calcPrice(), 0.001); 
    }

    @Test
    public void testEquals() {
        // Test cases for equals() method
        Alcohol alcohol1 = new Alcohol("Vodka", Size.SMALL, false);
        Alcohol alcohol2 = new Alcohol("Vodka", Size.SMALL, false);
        Alcohol alcohol3 = new Alcohol("Rum", Size.MEDIUM, true);

        assertTrue(alcohol1.equals(alcohol2)); 
        assertFalse(alcohol1.equals(alcohol3)); 
    }


}

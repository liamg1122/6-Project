import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmoothieTestStudent {



    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);

        String expectedString = "Smoothie: Berry Blast \nSize: MEDIUM \nProtein Added: true \nFruits: 3 \nPrice: $" + smoothie.calcPrice();
        assertEquals(expectedString, smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        Smoothie smoothie2 = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        Smoothie smoothie3 = new Smoothie("Strawberry Delight", Size.SMALL, 2, false);

        assertEquals(true, smoothie2.equals(smoothie1));
        assertNotEquals(smoothie1, smoothie3); 
    }

 
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	@Test
    public void testCoffeeCalcPrice() {
        Coffee coffeeSmall = new Coffee("Test Coffee", Size.SMALL, true, false);
        Coffee coffeeMedium = new Coffee("Test Coffee", Size.MEDIUM, true, true);
        Coffee coffeeLarge = new Coffee("Test Coffee", Size.LARGE, false, true);

        assertEquals(2.5, coffeeSmall.calcPrice());
        assertEquals(4.0, coffeeMedium.calcPrice());
        assertEquals(4.5, coffeeLarge.calcPrice());
    }

    @Test
    public void testCoffeeEquals() {
        Coffee coffee1 = new Coffee("Test Coffee", Size.SMALL, true, false);
        Coffee coffee2 = new Coffee("Test Coffee", Size.SMALL, true, false);
        Coffee otherCoffee = new Coffee("Other Coffee", Size.LARGE, false, true);

        assertTrue(coffee1.equals(coffee2));
        assertFalse(coffee1.equals(otherCoffee));
    }

    @Test
    public void testCoffeeToString() {
        Coffee coffee = new Coffee("Test Coffee", Size.MEDIUM, false, true);

        assertEquals("Coffee: Test Coffee \nSize: MEDIUM \nHas Extra Shot: false \nHas Extra Syrup: true \nPrice: $3.5", coffee.toString());
    }
	}

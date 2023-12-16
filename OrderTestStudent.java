import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTestStudent {

    @Test
    public void testWeekendValid() {
        assertFalse(new Order(10, Day.MONDAY, new Customer("Liam", 25)).isWeekend());
        assertFalse(new Order(10, Day.TUESDAY, new Customer("Liam", 30)).isWeekend());
       
        assertTrue(new Order(10, Day.SATURDAY, new Customer("Liam", 35)).isWeekend());
        assertTrue(new Order(10, Day.SUNDAY, new Customer("Liam", 19)).isWeekend());
    }

    @Test
    public void testCoffee() {
        Order order = new Order(10, Day.MONDAY, new Customer("Liam", 25));
        order.addNewBeverage("FrappeMochaTripleShot", Size.LARGE, false, true);
        assertEquals(1, order.getTotalItems());
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
    }

    @Test
    public void testAlcohol() {
        Order order = new Order(10, Day.MONDAY, new Customer("Liam", 30));
        order.addNewBeverage("Whiskey W/ Dragon Fire", Size.MEDIUM);
        assertEquals(1, order.getTotalItems());
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testSmoothie() {
        Order order = new Order(10, Day.MONDAY, new Customer("Liam", 30));
        order.addNewBeverage("CherryBerries", Size.SMALL, 4, true);
        assertEquals(1, order.getTotalItems());
     
    }

    @Test
    public void testPriceCalc() {
        Order order = new Order(10, Day.MONDAY, new Customer("Liam", 32));
        order.addNewBeverage("Caramel Macchiato $80000 At Starbucks", Size.LARGE, true, true);
        order.addNewBeverage("Mocha", Size.MEDIUM, false, false);
        assertEquals(8.0, order.calcOrderTotal());
    }

    @Test
    public void testBevCount() {
        Order order = new Order(10, Day.MONDAY, new Customer("Liam", 28));
        order.addNewBeverage("Espresso Mocha With Cherries", Size.SMALL, true, true);
        order.addNewBeverage("Espresso With Shaved Chocolate and Gelato", Size.SMALL, true, true);
        assertEquals(2, order.findNumOfBeveType(Type.COFFEE));
    }

}

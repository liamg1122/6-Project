import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BevShopTestStudent {

    private BevShop bevShop;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertTrue(bevShop.isValidTime(20));
        assertFalse(bevShop.isValidTime(7));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testGetMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }


}

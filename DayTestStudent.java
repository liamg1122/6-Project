import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DayTestStudent {

    @Test
    public void testDay() {
        assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
        assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
        assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
    }

    @Test
    public void testDaysOrder() {
        Day[] days = Day.values();
        assertEquals(Day.MONDAY, days[0]);
        assertEquals(Day.TUESDAY, days[1]);
        assertEquals(Day.SATURDAY, days[5]);
        assertEquals(Day.SUNDAY, days[6]);
    }
}

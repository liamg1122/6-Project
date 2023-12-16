import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TypeTestStudent {

    @Test
    public void testEnumValues() {
        Type[] types = Type.values();

        assertEquals(3, types.length); 
        assertTrue(containsEnumType(types, Type.COFFEE));
        assertTrue(containsEnumType(types, Type.SMOOTHIE));
        assertTrue(containsEnumType(types, Type.ALCOHOL));
    }

    private boolean containsEnumType(Type[] types, Type type) {
        for (Type t : types) {
            if (t == type) {
                return true;
            }
        }
        return false;
    }
}

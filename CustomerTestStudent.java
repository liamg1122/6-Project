import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class CustomerTestStudent {

		@Test
	    public void testCustomerConstructorAndGetters() {
	        Customer customer = new Customer("Liam", 28);
	        
	        assertEquals("Liam", customer.getName());
	        assertEquals(28, customer.getAge());
	    }

	    @Test
	    public void testCustomerCopyConstructor() {
	        Customer customer = new Customer("Liam", 25);
	        Customer copyC = new Customer(customer);

	        assertEquals(customer.getName(), copyC.getName());
	        assertEquals(customer.getAge(), copyC.getAge());
	    }

	    @Test
	    public void testCustomerSetName() {
	        Customer customer = new Customer("John Doe", 25);
	        customer.setName("Liam");

	        assertEquals("Liam", customer.getName());
	    }

	    @Test
	    public void testCustomerSetAge() {
	        Customer customer = new Customer("Liam", 25);
	        customer.setAge(30);

	        assertEquals(30, customer.getAge());
	    }

	    @Test
	    public void testCustomerToString() {
	        Customer customer = new Customer("Liam", 25);

	        assertEquals("\nName: Liam \nAge: 25", customer.toString());
	        
	    }

}

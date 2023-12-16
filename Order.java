

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Order Class for processing and handling beverages
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
   
	private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private List<Beverage> beverages;
    
    public Order(int orderTime, Day orderDay, Customer customer) {
    	
    	this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); 
        this.beverages = new ArrayList<>();
    }
    
    private int generateOrderNumber() {
    	
        Random r = new Random();
        return r.nextInt(80000) + 10000;
    }
    
	@Override
	public boolean isWeekend() {
		
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;

	}

	@Override
	public Beverage getBeverage(int itemNo) {
		if(itemNo>= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}
		else {
		return null;
	}}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
      Beverage newCoffee = new Coffee(bevName, size, extraShot, extraSyrup);
      
      beverages.add(newCoffee);
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size) {
		
		boolean wknd = true;
		if(!isWeekend()) {
			wknd = false;
		}
		Beverage newAlcohol = new Alcohol(bevName,size,wknd);
		beverages.add(newAlcohol);
	}
	


	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage newSmoothie = new Smoothie(bevName,size,numOfFruits,addProtein);
		beverages.add(newSmoothie);
	}

	@Override
	public double calcOrderTotal() {
		
		double total =0;
		
		for(Beverage bev: beverages) {
			total += bev.calcPrice();
		}
		
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count =0;
		for (Beverage bevs: beverages) {
			if(bevs.getType()== type) {
				count++;
			}
		}
		return count;
	}
	
	public int getTotalItems() {
		int total = 0;
		for (Beverage bev: beverages) {
			total +=1;
		}
		return total;
	}

	@Override
	public int compareTo(Order o) {
		
		return Integer.compare(this.orderNumber, o.orderNumber);
	}
	
	
	public int getOrderNumber() {
		return this.orderNumber;
	}
	
	 @Override
	   public String toString() {
	     StringBuilder orderDetails = new StringBuilder();
	      orderDetails.append("Order Number: ").append(orderNumber).append("\n");
	      orderDetails.append("Order Time: ").append(orderTime).append("\n");
	      orderDetails.append("Order Day: ").append(orderDay).append("\n");
	      orderDetails.append("Customer: ").append(customer).append("\n\n");
	      orderDetails.append("Beverages: ").append("\n");

	      for (Beverage beverage : beverages) {
	            orderDetails.append(beverage).append("\n");
	        }

	        orderDetails.append("Total Order Price: $").append(calcOrderTotal()).append("\n");

	        return orderDetails.toString();
	    }


}

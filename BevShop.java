
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Bev Shop Class for processing and handling orders
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BevShop implements BevShopInterface {
	
	 private List<Order> orders = new ArrayList<>(); 

	@Override
	public boolean isValidTime(int time) {
		
		 return (time >= 8 && time <= 23);
	}

	@Override
	public int getMaxNumOfFruits() {
		return 5;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return 21;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		
		 return numOfFruits >= getMaxNumOfFruits();
	}

	@Override
	public int getMaxOrderForAlcohol() {
		
		return 3;
	}

	@Override
	public boolean isEligibleForMore() {
		
		Order currentOrder = getCurrentOrder();
	       if (currentOrder != null) {
	        return currentOrder.findNumOfBeveType(Type.ALCOHOL) < getMaxOrderForAlcohol();
	        }
	        return false;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		int numOfAlcohol = 0;
		Order thisOrder = getCurrentOrder();
		if(thisOrder != null)
		{ numOfAlcohol = thisOrder.findNumOfBeveType(Type.ALCOHOL);}
		return numOfAlcohol;
	}

	@Override
	public boolean isValidAge(int age) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		
        Customer newCustomer = new Customer(customerName, customerAge);
        Order newOrder = new Order(time, day, newCustomer);
        
        orders.add(newOrder);
		
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		 
		if (getCurrentOrder() != null) {
	            getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	        }
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		
		if (getCurrentOrder() != null) {
            getCurrentOrder().addNewBeverage(bevName, size);
        }
		
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		if (getCurrentOrder() != null) {
            getCurrentOrder().addNewBeverage(bevName, size,numOfFruits,addProtein);
        }
		
	}

	@Override
	public int findOrder(int orderNo) {
		 int foundOrderNum = 0;
		 for (Order ord : orders) {
		        if (ord.getOrderNumber() == orderNo) {
		             foundOrderNum = ord.getOrderNumber();
		        }}
		   return foundOrderNum;
		
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		
		double d = 0.0;
		for (Order ord : orders) {
	        if (ord.getOrderNumber() == orderNo) {
	             d = ord.calcOrderTotal();
	        }}
		return d;
		
	}

	@Override
	public double totalMonthlySale() {
		   double totalSale = 0;
		    for (Order order : orders) {
		        totalSale += order.calcOrderTotal();
		    }
		    return totalSale;
		
	
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		
		   if (!orders.isEmpty()) {
	            return orders.get(orders.size() - 1);
	        }
	        return null;		
	}

	@Override
	public Order getOrderAtIndex(int index) {
	    
		if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
	}

	@Override
	public void sortOrders() {
		
	    Collections.sort(orders, Comparator.comparingInt(Order::getOrderNumber));
		
	}
	
	

}

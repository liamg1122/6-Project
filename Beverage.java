
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Beverage SuperClass
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/


public abstract class Beverage {
	
	private String bev_name;
	private Type bev_type;
	private Size bev_size;
	private final double BASE_PRICE = 2.00;
	private final double UP_COST = 1.00;
	
	
	//CONSTRUCTOR
	
	public Beverage (String name, Type type, Size size) {
		bev_name = name;
		bev_type = type;
		bev_size = size;
	}
	
	
	
	//EQUALS METHOD - GOING TO BE OVERRIDEN LATER
	public boolean equals(Beverage other) {
		
		if(this == other) {
			return true;
		}
		
		return this.bev_size.equals(other.bev_size) && this.bev_type.equals(other.bev_type)
		&& this.bev_name.equals(other.bev_name);
	}
	
	
	//ABSTRACT CALC PRICE METHOD
	public abstract double calcPrice();
	
	
	//BASIC TO STRING METHOD - OVERRIDE LATER
	public String toString() {
		
		return "Beverage: " + bev_name + " Size: " + bev_size;
	}
		
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	
	public Size getSize() {
		return bev_size;
	}

	
	public double getSizePrice() {
		return UP_COST;
	}
	
	
	public String getBeverageName() {
		return bev_name;
	}
	
	
	public Type getType() {
		return this.bev_type;
	}
}

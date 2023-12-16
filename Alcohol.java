
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Coffee Subclass of Beverage
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/

public class Alcohol extends Beverage{
	
	private boolean isOfferedOnWeekend;
	private final double WEEKEND_PRICE=0.60;
	
	
	// Parameterized constructor
	
	public Alcohol(String name, Size size, boolean isOfferedOnWeekend) {
		super(name, Type.ALCOHOL, size);
		this.isOfferedOnWeekend = isOfferedOnWeekend;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
    @Override
    public double calcPrice() {
       
    	double price = getBasePrice();

        // Additional cost for a larger size
        if (getSize() == Size.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == Size.LARGE) {
            price += 2 * getSizePrice(); // Additional $1 for each size up
        }

        // Additional cost for drinks offered in the weekend
        if (isOfferedOnWeekend) {
            price += WEEKEND_PRICE;
        }

        return price;
    }
    
    
    
    
    @Override
    public boolean equals(Beverage other) {
    	if(this == other) {
    		return true;
    	}
    	if(!super.equals(other)) {
    		return false;
    	}
    	
    	Alcohol otherAlcohol = (Alcohol) other;
    	
    	return this.isOfferedOnWeekend == otherAlcohol.isOfferedOnWeekend;
    }
    
    
    
  
    @Override
    public String toString() {
    	return "Coffee: " + this.getBeverageName() + " \nSize: " + this.getSize() + "\nWeekend Pricing: "
    		+ isOfferedOnWeekend +
			" \nPrice: $" + calcPrice();
}

}

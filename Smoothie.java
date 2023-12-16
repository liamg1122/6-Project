
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Smoothie Sub- Class of Beverage
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/



public class Smoothie extends Beverage{

	private int numberOfFruits;
	private boolean hasProtein;
	private final double PROTEIN_PRICE = 1.50;
	private final double FRUITS_PRICE = 0.50;
	
	
	public Smoothie(String name, Size size, int numberOfFruits, boolean hasProtein) {
		
		super(name, Type.SMOOTHIE, size);
		
		this.numberOfFruits = numberOfFruits;
		this.hasProtein = hasProtein;
		
	
	}

	@Override
	public double calcPrice() {
		
		double price = super.getBasePrice();
		// TODO Auto-generated method stub
		if(this.getSize() == Size.MEDIUM) {
			price += getSizePrice();
		}
		if(this.getSize() == Size.LARGE) {
			price += 2* getSizePrice();
		}
		if(this.hasProtein) {
			price+= PROTEIN_PRICE;
		}
		
		price += this.numberOfFruits * FRUITS_PRICE;
		
		return price;
		
	}
	
	 @Override
	    public String toString() {
	        return "Smoothie: " + getBeverageName() + " \nSize: " + getSize() +
	                " \nProtein Added: " + hasProtein + " \nFruits: " + numberOfFruits +
	                " \nPrice: $" + calcPrice();
	 }
	 
	 
	@Override
	public boolean equals(Beverage other) {
		
		if(this == other) {
			return true;
		}
		if(!super.equals(other)) {
			return false;
		}
		
		Smoothie otherSmoothie = (Smoothie) other;
		
		return this.numberOfFruits == otherSmoothie.numberOfFruits &&
		this.hasProtein == otherSmoothie.hasProtein;
	}
	
	
	

}

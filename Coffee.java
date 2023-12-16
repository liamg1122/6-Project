

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Coffee subclass of beverage
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Liam Ghershony
*/


public class Coffee extends Beverage {
	
	private final boolean extraShot;
	private final boolean extraSyrup;
    private final double EXTRA_SHOT_PRICE = 0.5;
    private final double EXTRA_SYRUP_PRICE = 0.5;



	
    public Coffee(String beverageName, Size beverageSize, boolean hasExtraShot, boolean hasExtraSyrup) {
        super(beverageName, Type.COFFEE, beverageSize);
        this.extraShot = hasExtraShot;
        this.extraSyrup = hasExtraSyrup;
    }

	@Override
	public double calcPrice() {
		double price = super.getBasePrice();
		
		if(extraShot) {
			price += EXTRA_SHOT_PRICE;
		}
		if(extraSyrup) {
			price+= EXTRA_SYRUP_PRICE;
		}
		if(this.getSize() == Size.MEDIUM) {
			price += getSizePrice();
		}
		if(this.getSize() == Size.LARGE) {
			price += 2* getSizePrice();
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
		
		Coffee otherCoffee = (Coffee) other;
		
		return this.extraShot == otherCoffee.extraShot && this.extraSyrup == otherCoffee.extraSyrup;
	}
	
	
	public String toString() {
		return "Coffee: " + this.getBeverageName() + " \nSize: " + this.getSize() + 
				" \nHas Extra Shot: " + this.extraShot + " \nHas Extra Syrup: " + this.extraSyrup +
				" \nPrice: $" + calcPrice();
	}
	


}

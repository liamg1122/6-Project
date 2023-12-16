public class Customer {
	
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(Customer otherCustomer) {
        this.name = otherCustomer.getName();
        this.age = otherCustomer.getAge();
    }

    @Override
    public String toString() {
        return "\nName: " + name + " \nAge: " + age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
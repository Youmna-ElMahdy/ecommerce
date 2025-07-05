
public class Main {
	
	    public static void main(String[] args) {
	        Cheese cheese = new Cheese("Cheese", 100, 5, 0.2, false);
	        TV tv = new TV("TV", 500, 3, 5.0);
	        Biscuits biscuits = new Biscuits("Biscuits", 150, 2, 0.7, false);
	        
	        Customer customer = new Customer("Ali", 1000);
	        Cart cart = new Cart();

	        cart.add(cheese, 2);
	        cart.add(biscuits, 1);
	        

	        Checkout.checkout(customer, cart);
	    }
	}



import java.util.ArrayList;


public class Checkout {
	
	    private static final double SHIPPING_RATE = 20;

	    public static void checkout(Customer customer, Cart cart) {
	        if (cart.isEmpty()) throw new RuntimeException("Cart is empty.");

	        ArrayList shippables = new ArrayList();
	        ArrayList cartItems = cart.getItems();

	        for (int i = 0; i < cartItems.size(); i++) {
	            CartItem item = (CartItem) cartItems.get(i);
	            Product p = item.product;

	            if (p instanceof Expire&& ((Expire) p).isExpired()) {
	                throw new RuntimeException(p.getName() + " is expired.");
	            }
	            if (item.quantity > p.getQuantity()) {
	                throw new RuntimeException(p.getName() + " is out of stock.");
	            }

	            if (p instanceof Canship) {
	                for (int j = 0; j < item.quantity; j++) {
	                    shippables.add((Canship) p);
	                }
	            }
	        }

	        double subtotal = cart.getSubtotal();
	        double shipping = shippables.isEmpty() ? 0 : SHIPPING_RATE;
	        double total = subtotal + shipping;

	        if (!customer.pay(total)) {
	            throw new RuntimeException("Insufficient balance.");
	        }

	        for (int i = 0; i < cartItems.size(); i++) {
	            CartItem item = (CartItem) cartItems.get(i);
	            item.product.reduceQuantity(item.quantity);
	        }

	        if (!shippables.isEmpty()) {
	            Shipping.ship(shippables);
	        }

	        System.out.println("** Checkout receipt **");
	        for (int i = 0; i < cartItems.size(); i++) {
	            CartItem item = (CartItem) cartItems.get(i);
	            System.out.printf("%dx %-10s %.0f\n", item.quantity, item.product.getName(), item.getTotalPrice());
	        }

	        System.out.println("----");
	        System.out.printf("Subtotal", subtotal);
	        System.out.printf("Shipping", shipping);
	        System.out.printf("Amount", total);
	        System.out.printf("Balance left", customer.getBalance());
	    }
	}




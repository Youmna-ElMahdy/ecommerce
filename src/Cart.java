import java.util.ArrayList;


public class Cart {


	    private ArrayList items = new ArrayList();

	    public void add(Product product, int quantity) {
	        if (quantity > product.getQuantity()) {
	            throw new IllegalArgumentException("Not enough stock for " + product.getName());
	        }
	        items.add(new CartItem(product, quantity));
	    }

	    public ArrayList getItems() {
	        return items;
	    }

	    public boolean isEmpty() {
	        return items.isEmpty();
	    }

	    public double getSubtotal() {
	        double subtotal = 0;
	        for (int i = 0; i < items.size(); i++) {
	            CartItem item = (CartItem) items.get(i);
	            subtotal += item.getTotalPrice();
	        }
	        return subtotal;
	    }
	}




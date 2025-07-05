import java.util.ArrayList;


public class Shipping {
	
	    public static void ship(ArrayList shippables) {
	        System.out.println("** Shipment notice **");
	        double totalWeight = 0;

	        for (int i = 0; i < shippables.size(); i++) {
	            Canship item = (Canship) shippables.get(i);
	            System.out.printf("Name:", item.getName(), item.getWeight() * 1000);
	            totalWeight += item.getWeight();
	        }

	        System.out.printf("Total package weight", totalWeight);
	    }
	}




package designPattern.flyweightPattern.coffeeFlavour;

import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

// CoffeeFlavour will be the Flyweight
class CoffeeFlavour {
	private final String name;

	public CoffeeFlavour(String newFlavour) {
		this.name = newFlavour;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Menu {
	private Map<String, CoffeeFlavour> flavours = new ConcurrentHashMap<String, CoffeeFlavour>();

	CoffeeFlavour lookup(String flavourName) {
		if (!flavours.containsKey(flavourName))
			flavours.put(flavourName, new CoffeeFlavour(flavourName));
		return flavours.get(flavourName);
	}

	int totalCoffeeFlavoursMade() {
		return flavours.size();
	}
}

class Order {
	private final int tableNumber;
	private final CoffeeFlavour flavour;

	Order(int tableNumber, CoffeeFlavour flavor) {
		this.tableNumber = tableNumber;
		this.flavour = flavor;
	}

	void serve() {
		System.out.println("Serving " + flavour + " to table " + tableNumber);
	}
}

public class CoffeeShop {

	private final List<Order> orders = new Vector<Order>();
	private final Menu menu = new Menu();

	void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menu.lookup(flavourName);
		Order order = new Order(table, flavour);
		orders.add(order);
	}

	void service() {
		for (Order order : orders) {
			order.serve();
			orders.remove(order);
		}
	}

	String report() {
		return "\ntotal CoffeeFlavour objects made: "
				+ menu.totalCoffeeFlavoursMade();
	}

	public static void main(String[] args) {
		CoffeeShop shop = new CoffeeShop();

		shop.takeOrder("Cappuccino", 2);
		shop.takeOrder("Frappe", 1);
		shop.takeOrder("Espresso", 1);
		shop.takeOrder("Frappe", 897);
		shop.takeOrder("Cappuccino", 97);
		shop.takeOrder("Frappe", 3);
		shop.takeOrder("Espresso", 3);
		shop.takeOrder("Cappuccino", 3);
		shop.takeOrder("Espresso", 96);
		shop.takeOrder("Frappe", 552);
		shop.takeOrder("Cappuccino", 121);
		shop.takeOrder("Espresso", 121);

		shop.service();
		System.out.println(shop.report());
	}
}

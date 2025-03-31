import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FoodMenu {
	public static void main(String[] args) {

		System.out.println("Welcome to Maiora food center!");
		Scanner sc = new Scanner(System.in);

		FoodItem[] menu = {
				new FoodItem("Chicken Fries", 100.00),
				new FoodItem("Chicken Wings", 200.00),
				new FoodItem("Hot soup", 50.00),
				new FoodItem("Shawarma", 75.00),
				new FoodItem("All in one combo!", 400.00),
		};
		
		ArrayList<FoodItem> allOrders = new ArrayList<FoodItem>();

		while (true) {
			display(menu);
			System.out.println("Press E to exit. else press any key");
			String res = sc.nextLine();
			if (res.equalsIgnoreCase("E")) {
				break;
			}
			else {
				System.out.println("Please enter your item number you need to add to cart:");
				int choice = sc.nextInt();
				orderFood(choice, menu, allOrders);
				System.out.println("Done with orders? Enter 0 to make payments or press any key.");
				int res1 = sc.nextInt();

				if (res1 == 0) {
					orderSummary(allOrders);
					break;
				}
			}
		}
	}

	private static void orderSummary(ArrayList<FoodItem> allOrders) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Your order summary:");
		double total = 0;
		double tax = 0.8;
		double deliveryCharges = 10;
		
		for (Iterator iterator = allOrders.iterator(); iterator.hasNext();) {
			FoodItem foodItem = (FoodItem) iterator.next();
			System.out.println(foodItem.name+" -> $ "+foodItem.price);		
			total += foodItem.price;
		}
		
		total = (total + (total/tax)) + deliveryCharges;
		System.out.println("You have any instuctions?");
		String instruction = sc.nextLine();
		
		System.out.println("Your total order value :"+ total);

	}

	private static void orderFood(int choice, FoodItem[] menu, ArrayList<FoodItem> allOrders) {
		allOrders.add(menu[choice-1]);
		System.out.println(menu[choice-1].name+ " is added to your cart!");
	}

	private static void display(FoodItem[] menu) {
		for (int i = 0; i < menu.length; i++) {
			System.out.println(i+1+". "+menu[i].name+" -> $ "+menu[i].price);			
		}
	}
}


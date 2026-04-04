public class Customer2 {
	public static void main(String[] args) {
		String customerType = "Guest";
		int quantity = 2;
		int unitPrice = 10;
		int totalCost = 0;
		int discount = 5;
		int deliveryCharge = 5;
		totalCost = (unitPrice * quantity);
		if (customerType == "Regular") {
			totalCost = totalCost - (totalCost * discount / 100);
			System.out.println("You are a regular customer and have got 5% discount");
			System.out.println("The total cost to be paid is " + totalCost);
			if (totalCost >= 20) {
				System.out.println("You have got a gift voucher!!!!");
			}
		} else if (customerType == "Guest") {
			totalCost = totalCost + deliveryCharge;
			System.out.println("You need to pay an additional delivery charge of $5");
			System.out.println("The total cost to be paid is " + totalCost);
		} else {
			System.out.println("Invalid selection");
		}
	}
}

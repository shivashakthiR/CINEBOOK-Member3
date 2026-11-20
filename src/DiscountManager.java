
import java.util.Scanner;

public class DiscountManager {

    Scanner sc = new Scanner(System.in);

    // Display available offers
    public void displayOffers() {

        System.out.println("----- CINEBOOK OFFERS -----");
        System.out.println("1. Student Discount - 10%");
        System.out.println("2. Festival Discount - 15%");
        System.out.println("3. Coupon MOVIE10 - 10%");
    }

    // Check coupon validity
    public boolean checkCoupon(String coupon) {

        return coupon.equalsIgnoreCase("MOVIE10");
    }

    // Calculate final bill
    public double calculateFinalBill(double bill) {

        System.out.println("Original Bill: Rs." + bill);

        System.out.println("Choose discount:");
        System.out.println("1. Student Discount");
        System.out.println("2. Festival Discount");
        System.out.println("3. Coupon");
        System.out.println("4. No Discount");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        double discount = 0;

        if (choice == 1) {

            Discount d = new StudentDiscount();
            discount = d.calculateDiscount(bill);

        } else if (choice == 2) {

            Discount d = new FestivalDiscount();
            discount = d.calculateDiscount(bill);

        } else if (choice == 3) {

            System.out.print("Enter coupon code: ");
            String coupon = sc.nextLine();

            if (checkCoupon(coupon)) {
                discount = bill * 0.10;
            } else {
                System.out.println("Invalid coupon!");
            }

        } else if (choice != 4) {

            System.out.println("Invalid choice!");
        }

        System.out.println("Discount Amount: Rs." + discount);

        double finalBill = bill - discount;

        System.out.println("Final Bill: Rs." + finalBill);

        return finalBill;
    }

    // Apply discount
    public void applyDiscount(double bill) {

        calculateFinalBill(bill);
    }
}

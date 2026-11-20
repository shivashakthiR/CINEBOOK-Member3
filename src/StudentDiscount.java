public class StudentDiscount extends Discount {

    @Override
    public double calculateDiscount(double bill) {

        return bill * 0.10;
    }
}
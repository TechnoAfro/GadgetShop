public class Mobile extends Gadget {
    // declaring the field required for this class
    private int credit;

    // create the constructor
    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size); // calling the superclass constructor
        this.credit = credit; // Setting the credit property
    }   

    // This method overrides the display method in Gadget superclass
    @Override
    public void display() {
        System.out.println("Credit: " + credit + " mins");
        super.display();
    }

    // This is a getter method for the credit
    public int getCredit() {
        return credit;
    }
}

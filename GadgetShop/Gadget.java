public class Gadget {
    // declaring the fields required for this class
    private String model;
    private double price;
    private int weight;
    private String size;

    // create the constructor
    public Gadget(String model, double price, int weight, String size) {
        // assign values to the correct fields
        this.size = size;
        this.model = model;
        this.price = price;
        this.weight = weight;
    }

    // This method displays the details of the gadget in the console
    public void display() {
        System.out.println("model: " + model);
        System.out.println("price: " + " £" + price);
        System.out.println("weight: " + weight + " g");
        System.out.println("size: " + size);
    }

    // Getter methods to return the Gadget's properties
    public String getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

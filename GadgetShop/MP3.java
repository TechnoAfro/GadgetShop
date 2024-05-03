public class MP3 extends Gadget {
    // declaring the field required for this class
    private int memory;

    // create the constructor
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size); // calling the superclass constructor
        this.memory = memory; // Setting the memory
    }

    // This method overrides the display method in Gadget superclass
    @Override 
    public void display() {
        System.out.println("Memory: " + memory + "MB"); 
        super.display();
    }

    // This method simulates deleting music and freeing up some memory
    public void deleteMusic(int size) {
        memory += size;
        System.out.println(size + "mb of music has been deleted.");
    }

    // This is a getter method for the memory
    public int getMemory() {
        return memory;
    }

    // This method simulates downloading music if enough memory is available
    public void downloadMusic(int size) {
        if (memory >= size) { // Conditional to check if there's enough memory
            memory -= size; // This reduces the size of the download from available memory
            System.out.println(size + "mb of music has been downloaded.");
        } else {
            System.out.println("There is not enough memory available to download.");
        }
    }
}

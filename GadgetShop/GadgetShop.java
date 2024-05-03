import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame implements ActionListener {
    // declaring the fields required for this class
    private JTextField priceInput, modelInput, weightInput, creditInput, sizeInput, memoryInput;
    private JButton clearButton, displayAllButton, addMobileButton, addMP3Button;
    private ArrayList<Gadget> gadgets;

    // main method to launch the app from CMD
    public static void main(String[] args) {
        new GadgetShop();
    }

    // create the constructor
    public GadgetShop() {
        setTitle("Gadget Shop"); // Setting the window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the close operation
        setSize(600, 360); // Setting the window size
        setLayout(new GridLayout(0, 2, 10, 10)); // Setting layout of the window

        // Initializing the gadgets list
        gadgets = new ArrayList<>();
        
        // Initializing the interface components
        initializeComponents();

        // Making the window visible
        setVisible(true); 
    }

    private void initializeComponents() {
        // Initializing text fields in the GUI
        memoryInput = new JTextField(15);
        modelInput = new JTextField(15);
        priceInput = new JTextField(15);
        weightInput = new JTextField(15);
        sizeInput = new JTextField(15);
        creditInput = new JTextField(15);
        
        // Initializing the buttons/ adding action listeners to the GUI 
        addMP3Button = createButton("Add MP3 Gadget");
        addMobileButton = createButton("Add Mobile Gadget");
        displayAllButton = createButton("Display All Gadgets");
        clearButton = createButton("Clear Fields");
        
        // Adding the components to the frame of the GUI
        add(createLabeledField("Model:", modelInput));
        add(createLabeledField("Price:", priceInput));
        add(createLabeledField("Weight:", weightInput));
        add(createLabeledField("Size:", sizeInput));
        add(createLabeledField("Memory (only mp3):", memoryInput));
        add(createLabeledField("Credit (only mobile):", creditInput));
        add(addMP3Button);
        add(addMobileButton);
        add(displayAllButton);
        add(clearButton);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text); 
        button.setBackground(new Color(200, 220, 220)); // Set button color
        button.setForeground(Color.DARK_GRAY); // Set text color
        button.addActionListener(this); // Add action listener
        return button;
    }

    private JPanel createLabeledField(String labelText, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(labelText)); // Add label
        panel.add(textField); // Add text field
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This conditional checks which button was pressed
        // in order to call the correct method
        if (e.getSource() == addMobileButton) {
            addMobile();
        } else if (e.getSource() == addMP3Button) {
            addMP3();
        } else if (e.getSource() == displayAllButton) {
            displayAll();
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    private void addMobile() {
        // try/catch to create/add a new gadget for the mobile
        try {
            String model = modelInput.getText();
            double price = Double.parseDouble(priceInput.getText());
            int weight = Integer.parseInt(weightInput.getText());
            String size = sizeInput.getText();
            int credit = Integer.parseInt(creditInput.getText());
            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);
            JOptionPane.showMessageDialog(this, "Mobile added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid number for price, weight, and credit.");
        }
    }

    private void addMP3() {
        // try/catch to create/add a new gadget for the mp3
        try {
            String model = modelInput.getText();
            double price = Double.parseDouble(priceInput.getText());
            int weight = Integer.parseInt(weightInput.getText());
            String size = sizeInput.getText();
            int memory = Integer.parseInt(memoryInput.getText());
            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);
            JOptionPane.showMessageDialog(this, "MP3 added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid number for price, weight, and memory.");
        }
    }

    private void displayAll() {
        // loop to get the details for all gadgets
        for (int i = 0; i < gadgets.size(); i++) {
            Gadget gadget = gadgets.get(i);
            gadget.display();
        }
    }

    private void clearFields() {
        // clearing all of the input fields
        modelInput.setText("");
        priceInput.setText("");
        weightInput.setText("");
        sizeInput.setText("");
        creditInput.setText("");
        memoryInput.setText("");
    }
}

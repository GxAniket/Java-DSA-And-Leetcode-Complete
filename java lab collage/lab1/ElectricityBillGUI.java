import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElectricityBillGUI extends JFrame {

    private JTextField consumerNoField, nameField, prevReadingField, currReadingField;
    private JComboBox<String> connectionTypeBox;
    private JTextArea resultArea;

    public ElectricityBillGUI() {
        setTitle("Electricity Bill Generator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the window
        setLayout(new BorderLayout(10, 10));

        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        formPanel.add(new JLabel("Consumer Number:"));
        consumerNoField = new JTextField();
        formPanel.add(consumerNoField);

        formPanel.add(new JLabel("Consumer Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Previous Reading:"));
        prevReadingField = new JTextField();
        formPanel.add(prevReadingField);

        formPanel.add(new JLabel("Current Reading:"));
        currReadingField = new JTextField();
        formPanel.add(currReadingField);

        formPanel.add(new JLabel("Connection Type:"));
        connectionTypeBox = new JComboBox<>(new String[]{"domestic", "commercial"});
        formPanel.add(connectionTypeBox);

        JButton calcButton = new JButton("Calculate Bill");
        formPanel.add(calcButton);

        add(formPanel, BorderLayout.NORTH);

        // Output area
        resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Bill Details:"), BorderLayout.NORTH);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        add(outputPanel, BorderLayout.CENTER);

        // Button functionality
        calcButton.addActionListener(e -> calculateBill());

        setVisible(true);
    }

    private void calculateBill() {
        try {
            int consumerNo = Integer.parseInt(consumerNoField.getText());
            String name = nameField.getText();
            double prev = Double.parseDouble(prevReadingField.getText());
            double curr = Double.parseDouble(currReadingField.getText());
            String type = (String) connectionTypeBox.getSelectedItem();

            if (curr <= prev) {
                resultArea.setText("Error: Current reading must be greater than previous reading.");
                return;
            }

            double units = curr - prev;
            double amount = 0;

            if (type.equalsIgnoreCase("domestic")) {
                if (units <= 100)
                    amount = units * 1;
                else if (units <= 200)
                    amount = 100 * 1 + (units - 100) * 2.5;
                else if (units <= 500)
                    amount = 100 * 1 + 100 * 2.5 + (units - 200) * 4;
                else
                    amount = 100 * 1 + 100 * 2.5 + 300 * 4 + (units - 500) * 6;
            } else if (type.equalsIgnoreCase("commercial")) {
                if (units <= 100)
                    amount = units * 2;
                else if (units <= 200)
                    amount = 100 * 2 + (units - 100) * 4.5;
                else if (units <= 500)
                    amount = 100 * 2 + 100 * 4.5 + (units - 200) * 6;
                else
                    amount = 100 * 2 + 100 * 4.5 + 300 * 6 + (units - 500) * 7;
            }

            // Output
            resultArea.setText(String.format(
                "------------------------------\n" +
                "        Electricity Bill\n" +
                "------------------------------\n" +
                "Consumer No    : %d\n" +
                "Consumer Name  : %s\n" +
                "Connection Type: %s\n" +
                "Units Consumed : %.2f\n" +
                "Total Amount   : ₹%.2f\n" +
                "------------------------------\n" +
                "Programmer Name: Aniket Sundriyal\n",
                consumerNo, name, type, units, amount
            ));

        } catch (NumberFormatException e) {
            resultArea.setText("Error: Please enter valid numeric input in all fields.");
        } catch (Exception e) {
            resultArea.setText("Unexpected Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ElectricityBillGUI::new);
    }
}

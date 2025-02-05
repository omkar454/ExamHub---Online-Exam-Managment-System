import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExamHubRegistrationForm1 {

    // Class-level variable to store the roll number
    public static String savedRollNumber;

    // Method to display the registration form
    public void displayRegistrationForm() {
        // Create the main frame
        JFrame frame = new JFrame("User Registration - ExamHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(new BorderLayout());

        // Background color for the entire frame
        frame.getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        // Create a panel for the main content area
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(230, 240, 255)); // Keep background consistent with frame
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.insets = new Insets(20, 20, 20, 20); // Padding for the main panel

        // Create a panel with black border around registration form content
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE); // White background for content panel
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Black border around content panel

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 20, 10, 20); // Padding for form elements

        // Add "EXAM HUB" text
        JLabel examHubLabel = new JLabel("EXAM HUB", JLabel.CENTER);
        examHubLabel.setFont(new Font("Serif", Font.BOLD, 30));
        examHubLabel.setForeground(new Color(0, 70, 160)); // Dark blue color for heading
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        contentPanel.add(examHubLabel, constraints);

        // Add space between "EXAM HUB" and "REGISTRATION FORM"
        constraints.gridy = 1;
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)), constraints);

        // Add "REGISTRATION FORM" text
        JLabel registrationFormLabel = new JLabel("REGISTRATION FORM", JLabel.CENTER);
        registrationFormLabel.setFont(new Font("Serif", Font.BOLD, 20));
        registrationFormLabel.setForeground(new Color(0, 70, 160)); // Dark blue color for heading
        constraints.gridy = 2;
        contentPanel.add(registrationFormLabel, constraints);

        // Name field
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        contentPanel.add(nameLabel, constraints);

        JTextField nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(nameField, constraints);

        // Roll number field
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 4;
        constraints.gridx = 0;
        contentPanel.add(rollNumberLabel, constraints);

        JTextField rollNumberField = new JTextField(20);
        rollNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(rollNumberField, constraints);

        // Number field
        JLabel numberLabel = new JLabel("Mobile Number:");
        numberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 5;
        constraints.gridx = 0;
        contentPanel.add(numberLabel, constraints);

        JTextField numberField = new JTextField(20);
        numberField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(numberField, constraints);

        // Username field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 6;
        constraints.gridx = 0;
        contentPanel.add(usernameLabel, constraints);

        JTextField usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(usernameField, constraints);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 7;
        constraints.gridx = 0;
        contentPanel.add(passwordLabel, constraints);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(passwordField, constraints);

        // Register button
        JButton registerButton = createActionButton("Register");
        constraints.gridx = 0;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        constraints.ipadx = 60;
        constraints.ipady = 15;
        contentPanel.add(registerButton, constraints);

        // Add content panel to main panel
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainPanel.add(contentPanel, mainConstraints);

        // Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String rollNumber = rollNumberField.getText();
                String number = numberField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Basic validation
                if (name.isEmpty() || rollNumber.isEmpty() || number.isEmpty() ||
                        username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Insert into database
                try {
                    insertUserIntoDatabase(name, rollNumber, number, username, password);
                    JOptionPane.showMessageDialog(frame, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    saveRollNumber(rollNumber);

                    // Print the saved roll number
                    System.out.println("Registered Roll Number: " + getSavedRollNumber());

                    frame.dispose();
                    ExamHubLoginForm.main(new String[]{});
                    clearForm(nameField, rollNumberField, numberField, usernameField, passwordField);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Registration Failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    clearForm(nameField, rollNumberField, numberField, usernameField, passwordField);
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    // Method to save roll number
    public static void saveRollNumber(String rollNumber) {
        savedRollNumber = rollNumber;
    }

    // Method to get saved roll number
    public static String getSavedRollNumber() {
        System.out.println(savedRollNumber);
        return savedRollNumber;
    }

    // Helper method to create action buttons (Register)
    public static JButton createActionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204)); // Attractive blue background
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(250, 60));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Remove border
        return button;
    }

    // Method to insert user data into database
    public void insertUserIntoDatabase(String name, String rollNumber, String number, String username, String password) throws SQLException {

        // Establish database connection
        DataBase_Credentials db = new DataBase_Credentials();
        String url = db.JDBC_url;
        String user = db.username;
        String pass = db.username;

        Connection connection = DriverManager.getConnection(url, user, pass);

        // Prepare SQL statement
        String sql = "INSERT INTO users (name, roll_number, phone_number, username, password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, rollNumber);
        preparedStatement.setString(3, number);
        preparedStatement.setString(4, username);
        preparedStatement.setString(5, password); // Note: Password should be hashed in production

        // Execute update
        preparedStatement.executeUpdate();

        // Close resources
        preparedStatement.close();
        connection.close();
    }

    // Method to clear the form fields
    public static void clearForm(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        new ExamHubRegistrationForm1().displayRegistrationForm();
    }
}

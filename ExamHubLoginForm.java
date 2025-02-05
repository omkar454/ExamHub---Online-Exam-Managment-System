import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class ExamHubLoginForm {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("User Login - ExamHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(new BorderLayout());

        // Background color for the entire frame
        frame.getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        // Create a panel for the main content area
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(230, 240, 255)); // Keep background consistent with frame
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.insets = new Insets(20, 20, 20, 20); // Padding for the main panel

        // Create a panel with black border around login form content
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

        // Add space between "EXAM HUB" and "LOGIN FORM"
        constraints.gridy = 1;
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)), constraints);

        // Add "LOGIN FORM" text
        JLabel loginFormLabel = new JLabel("LOGIN FORM", JLabel.CENTER);
        loginFormLabel.setFont(new Font("Serif", Font.BOLD, 20));
        loginFormLabel.setForeground(new Color(0, 70, 160)); // Dark blue color for heading
        constraints.gridy = 2;
        contentPanel.add(loginFormLabel, constraints);

        // Username field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        contentPanel.add(usernameLabel, constraints);

        JTextField usernameField = new JTextField(20);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(usernameField, constraints);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridx = 0;
        constraints.gridy = 4;
        contentPanel.add(passwordLabel, constraints);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(passwordField, constraints);

        // Roll Number field (moved below the password field)
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridx = 0;
        constraints.gridy = 5;
        contentPanel.add(rollNumberLabel, constraints);

        JTextField rollNumberField = new JTextField(20);
        rollNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(rollNumberField, constraints);

        // Create Login button
        JButton studentLoginButton = createActionButton("Login");

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.ipadx = 0;
        constraints.ipady = 10;
        contentPanel.add(studentLoginButton, constraints);

        // Create Registration link-style button
        JButton registerLinkButton = createLinkButton("First Time Here? Register");
        constraints.gridy = 7;
        constraints.ipady = 0;
        contentPanel.add(registerLinkButton, constraints);
// Directly add contentPanel to main panel without a scroll pane
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainPanel.add(contentPanel, mainConstraints); // Add content panel directly

// Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);

// Action listener for Student Login button
        studentLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginHandler.handleLogin( usernameField, passwordField, rollNumberField, frame);
            }
        });

// Action listener for Registration link button
        registerLinkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Redirecting to Registration Page...", "Register", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();

                // Open the registration form
                ExamHubRegistrationForm1 registrationForm = new ExamHubRegistrationForm1();
                registrationForm.displayRegistrationForm();
            }
        });

// Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Helper method to create action buttons (Login)
    private static JButton createActionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(new Color(0, 153, 204)); // Attractive blue background
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(250, 70)); // Increased button size
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Remove border
        return button;
    }

    // Helper method to create link-style buttons
    private static JButton createLinkButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.ITALIC, 16));
        button.setForeground(new Color(0, 0, 255)); // Blue color for link
        button.setBackground(Color.WHITE); // Transparent background
        button.setBorderPainted(false); // Remove border
        button.setFocusPainted(false); // Remove focus border
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
        return button;
    }

    public class LoginHandler {
        // Class variable to store the logged-in username
        private static String loggedInUsername;
        // Class variable to store the roll_number of loged_in_username
        private static String roll_number_user;

        // Helper method to handle login logic and role-based redirection
        public static void handleLogin( JTextField usernameField, JPasswordField passwordField,  JTextField rollNumberField, JFrame frame) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String roll_number = rollNumberField.getText();


            // Basic validation
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill out all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Validate user against the database
                if (validateUser(username, password,roll_number)) {
                    // Store the logged-in username
                    loggedInUsername = username;
//                    Store the roll number of user
                    roll_number_user = roll_number;


                        JOptionPane.showMessageDialog(frame, "Student Login Successful!\nWelcome, " + username + "!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        frame.dispose(); // Close the login form

                        StudentDashboard studentDashboard = new StudentDashboard();
                        studentDashboard.displaySTUDENTdashboard(); // Navigate to Student Dashboard


                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password or roll number!", "Error", JOptionPane.ERROR_MESSAGE);
                    ExamHubRegistrationForm1.clearForm(rollNumberField,usernameField,passwordField);
                }
            }
        }

        // Method to return the logged-in username
        public static String getLoggedInUsername() {
            return loggedInUsername;
        }

        public static String getRoll_number_user(){
            return roll_number_user;
        }

        public static boolean validateUser(String username, String password , String roll_number) {
            boolean isValid = false;
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                // Establish database connection
                DataBase_Credentials db = new DataBase_Credentials();
                String url = db.JDBC_url;
                String user = db.username;
                String pass = db.password;

                connection = DriverManager.getConnection(url, user, pass);

                // Prepare SQL query to check for valid user
                String sql = "SELECT * FROM Users WHERE username = ? AND password = ? AND roll_number=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3,roll_number);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    isValid = true;

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return isValid;
        }
    }
}

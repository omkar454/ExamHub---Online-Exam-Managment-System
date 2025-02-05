import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Change_Password {
    private static String old_password;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Change Password - ExamHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLayout(new BorderLayout());

        // Background color for the entire frame
        frame.getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        // Create a panel for the main content area
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(230, 240, 255)); // Keep background consistent with frame
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.insets = new Insets(20, 20, 20, 20); // Padding for the main panel

        // Create a panel with black border around change password content
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

        // Add space between "EXAM HUB" and "CHANGE PASSWORD"
        constraints.gridy = 1;
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)), constraints);

        // Add "CHANGE PASSWORD" text
        JLabel changePasswordLabel = new JLabel("CHANGE PASSWORD", JLabel.CENTER);
        changePasswordLabel.setFont(new Font("Serif", Font.BOLD, 20));
        changePasswordLabel.setForeground(new Color(0, 70, 160)); // Dark blue color for heading
        constraints.gridy = 2;
        contentPanel.add(changePasswordLabel, constraints);

        // Old Password field
        JLabel oldPasswordLabel = new JLabel("Old Password:");
        oldPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        contentPanel.add(oldPasswordLabel, constraints);

        JPasswordField oldPasswordField = new JPasswordField(20);
        old_password = oldPasswordField.getText();
        oldPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(oldPasswordField, constraints);

        // New Password field
        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridx = 0;
        constraints.gridy = 4;
        contentPanel.add(newPasswordLabel, constraints);

        JPasswordField newPasswordField = new JPasswordField(20);
        newPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(newPasswordField, constraints);

        // Confirm New Password field
        JLabel confirmPasswordLabel = new JLabel("Confirm New Password:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        constraints.gridx = 0;
        constraints.gridy = 5;
        contentPanel.add(confirmPasswordLabel, constraints);

        JPasswordField confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        constraints.gridx = 1;
        contentPanel.add(confirmPasswordField, constraints);

        // Create Change Password button
        JButton changePasswordButton = createActionButton("Change Password");
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.ipady = 0;
        contentPanel.add(changePasswordButton, constraints);

        // Add content panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Prevent horizontal scroll on content panel

        // Add scroll pane to main panel
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainPanel.add(scrollPane, mainConstraints);

        // Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);

        // Action listener for Change Password button
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(oldPasswordField.getPassword());
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Basic validation
                if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill out all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "New Password and Confirm Password do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // TODO: Add logic to change password
                    // For example, check if the old password is correct and then update it to the new password.
                    changePassword(oldPassword,newPassword);

                    // Clear fields after successful change
                    oldPasswordField.setText("");
                    newPasswordField.setText("");
                    confirmPasswordField.setText("");
                    frame.dispose();
                }
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Helper method to create action buttons (Change Password)
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


    public static void changePassword(String oldPassword, String newPassword) {
        DataBase_Credentials db = new DataBase_Credentials();
        try (Connection connection = DriverManager.getConnection(db.JDBC_url, db.username, db.password);
             PreparedStatement checkStmt = connection.prepareStatement("SELECT password FROM Users WHERE roll_number=?");
             PreparedStatement updateStmt = connection.prepareStatement("UPDATE Users SET password=? WHERE roll_number=?")) {

            // Set roll number for the query
            checkStmt.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user());

            // Check if user exists and retrieve current password
            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                // Validate the old password
                if (storedPassword.equals(oldPassword)) {
                    // Update the password
                    updateStmt.setString(1, newPassword);
                    updateStmt.setString(2, ExamHubLoginForm.LoginHandler.getRoll_number_user());

                    int rowsUpdated = updateStmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(null, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to change password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Old password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No user found with the given roll number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

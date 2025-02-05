import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;

public class StudentsProfilePage {

    private static JLabel profilePhotoLabel; // To display profile photo

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Profile Page- ExamHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // Adjusted frame size for better fit on Dell laptops
        frame.setLayout(new BorderLayout());

        // Background color for the entire frame
        frame.getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        // Create a panel for the sidebar
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(0, 102, 153)); // Teal color for sidebar
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Create buttons for sidebar options
        JButton profileButton = createSidebarButton("Profile");
        JButton resultsButton = createSidebarButton("View Results");
        JButton departmentsButton = createSidebarButton("DASHBOARD");
        JButton logOutButton = createSidebarButton("Log-Out");

        // Add buttons to sidebar
        sidebar.add(profileButton);
        sidebar.add(Box.createVerticalStrut(20)); // Space between buttons
        sidebar.add(departmentsButton);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(resultsButton);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(logOutButton);

        // Action listeners for sidebar buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StudentsProfilePage.main(new String[]{});
                loadProfilePhotoFromDatabase();

            }
        });

        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                newresult.main(new String[]{});

            }
        });

        departmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StudentDashboard dasher = new StudentDashboard();
                dasher.displaySTUDENTdashboard();
            }
        });

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Log Out", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    frame.dispose(); // Close the window
                }
            }
        });

        // Create a panel for the main content area
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE); // White background for content panel
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 102, 102), 3),
                BorderFactory.createEmptyBorder(20, 20, 20, 20))); // Teal border with padding

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 20, 10, 20); // Padding for form elements

        // Add heading to the content area
        JLabel heading = new JLabel("Student Profile Page", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 36)); // Increased font size for heading
        heading.setForeground(new Color(0, 70, 160)); // Attractive dark blue color
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 0, 10, 0); // Adjusted space above heading
        contentPanel.add(heading, constraints);
// Profile photo section panel
        JPanel photoPanel = new JPanel(new GridBagLayout()); // Using GridBagLayout for flexible placement
        photoPanel.setBackground(Color.WHITE); // Match background with content panel

// GridBag constraints for the layout
        GridBagConstraints photoConstraints = new GridBagConstraints();
        photoConstraints.fill = GridBagConstraints.HORIZONTAL;
        photoConstraints.insets = new Insets(10, 10, 10, 10); // Padding

// Create and style the label "STUDENT PROFILE PHOTO"
        JLabel photoHeading = new JLabel("Student Profile Photo:");
        photoHeading.setFont(new Font("Arial", Font.BOLD, 22)); // Match font with other labels

// Create an empty box for the profile photo placeholder
        profilePhotoLabel = new JLabel();
        profilePhotoLabel.setPreferredSize(new Dimension(150, 150)); // Set size for photo box
        profilePhotoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Add border around photo box
        profilePhotoLabel.setHorizontalAlignment(JLabel.CENTER); // Center photo horizontally
        profilePhotoLabel.setVerticalAlignment(JLabel.CENTER); // Center photo vertically
        profilePhotoLabel.setText("No Photo"); // Placeholder text for photo box
        profilePhotoLabel.setFont(new Font("Arial", Font.ITALIC, 16)); // Italic font for placeholder text
        profilePhotoLabel.setForeground(Color.GRAY); // Gray color for placeholder text

// Create a bigger "Upload Profile Photo" button
        JButton uploadButton = new JButton("Upload Profile Photo");
        uploadButton.setPreferredSize(new Dimension(200, 40)); // Button size
        uploadButton.setFont(new Font("Arial", Font.BOLD, 18)); // Font size

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        BufferedImage img = ImageIO.read(selectedFile);
                        Image resizedImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        profilePhotoLabel.setIcon(new ImageIcon(resizedImg));
                        profilePhotoLabel.setText(""); // Remove placeholder text

                        // Save the profile photo to the database
                        saveProfilePhotoToDatabase(selectedFile);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error loading image", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


// Add the "STUDENT PROFILE PHOTO" label aligned in the same column as other labels
        photoConstraints.gridx = 0;
        photoConstraints.gridy = 0;
        photoConstraints.anchor = GridBagConstraints.WEST; // Align to the left
        photoPanel.add(photoHeading, photoConstraints);

// Add the photo placeholder in the next column (to the right of the label)
        photoConstraints.gridx = 1;
        photoPanel.add(profilePhotoLabel, photoConstraints);

// Add the "Upload Profile Photo" button in the same column as the "STUDENT PROFILE PHOTO" label (align left)
        photoConstraints.gridx = 0;
        photoConstraints.gridy++; // Move to the next row
        photoPanel.add(uploadButton, photoConstraints);

// Add the photo panel to the main content panel, place it at the top of the content area
        constraints.gridy++; // Move to the next row for other profile details
        contentPanel.add(photoPanel, constraints);

// Define labels and text fields for other profile features
        String[] labels = {"Student Name:", "Mobile Number:", "Department:", "Year & Semester:", "Roll No.:", "Username:"};
        JTextField[] textFields = new JTextField[7];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField(20);
            if (i == 0) {
                textFields[i].setText(getName()); // Set student name
            }
            if (i == 1) {
                textFields[i].setText(get_phone_Number()); // Set phone number
            }

            if (i == 2) {
                textFields[i].setText("Information Technology"); // Set department
            }
            if (i == 3) {
                textFields[i].setText("2nd Year & Sem 3"); // Set year & semester
            }
            if (i == 4) {
                textFields[i].setText(ExamHubLoginForm.LoginHandler.getRoll_number_user()); // Set roll number
            }
            if (i == 5) {
                textFields[i].setText(get_Username()); // Set username
            }
            textFields[i].setEditable(false); // Make fields non-editable by default
            textFields[i].setFont(new Font("Arial", Font.PLAIN, 20)); // Set font for text fields
        }

// Add profile fields and corresponding text fields
        constraints.gridx = 0;
        constraints.gridy++; // Move to the next row after the photo panel
        constraints.gridwidth = 1;
        for (int i = 0; i < labels.length; i++) { // Loop for all profile fields (including username now)
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Arial", Font.BOLD, 22));

            contentPanel.add(label, constraints);

            constraints.gridx = 1;
            contentPanel.add(textFields[i], constraints);
            constraints.gridx = 0;
            constraints.gridy++;
        }

        // Add "Edit" and "Save" buttons at the bottom
        JButton editButton = createActionButton("Change Password");


// Constraints for buttons
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.fill = GridBagConstraints.NONE; // Buttons will not stretch
        buttonConstraints.insets = new Insets(10, 20, 20, 20); // Padding for buttons

// Add "Change Password" button to the extreme left
        buttonConstraints.gridx = 0; // Column 0
        buttonConstraints.gridy = GridBagConstraints.RELATIVE; // Automatically place in the next row
        buttonConstraints.anchor = GridBagConstraints.WEST; // Align to the left
        buttonConstraints.gridwidth = 1; // Only take one column
        contentPanel.add(editButton, buttonConstraints);
//        mainPanel.add(contentPanel, BorderLayout.CENTER);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Change_Password.main(new String[]{});
            }
        });


        // Create a JScrollPane to make the content scrollable
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Smooth scrolling speed

        // Add sidebar to the left of the frame and scrollable content panel to the center
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }


    // Helper method to create sidebar buttons
    private static JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18)); // Larger font size for sidebar buttons
        button.setBackground(new Color(255, 255, 255)); // White background
        button.setForeground(new Color(0, 102, 153)); // Teal text
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(220, 50)); // Adjusted button size
        button.setMaximumSize(button.getPreferredSize()); // Set maximum size for consistency
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 2, true)); // Rounded border
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment in sidebar
        return button;
    }


    // Helper method to create action buttons with consistent styling
    private static JButton createActionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setBackground(new Color(0, 153, 204)); // Button color
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(260, 60)); // Set button size
        button.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left (if needed)
        return button;
    }


    public static String getName() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ExamHub"; // Database URL
        String username = "root"; // DB username
        String password = "OmRaut@04"; // DB password

        String name = "";

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "select name FROM Users WHERE roll_number=?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                name = rs.getString("name");
            }

            rs.close();
            pstm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return name;
    }


    public static String get_phone_Number() {
        DataBase_Credentials db = new DataBase_Credentials();
        String jdbcURL = db.JDBC_url; // Database URL
        String username = db.username; // DB username
        String password = db.password; // DB password

        String phone_number = "";

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "select phone_number FROM Users WHERE roll_number=?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                phone_number = rs.getString("phone_number");
            }

            rs.close();
            pstm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return phone_number;
    }


    public static String get_Username() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ExamHub"; // Database URL
        String username = "root"; // DB username
        String password = "OmRaut@04"; // DB password

        String username_user = "";

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "select username FROM Users WHERE roll_number=?;";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                username_user = rs.getString("username");
            }

            rs.close();
            pstm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return username_user;
    }

    public static void saveProfilePhotoToDatabase(File imageFile) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish database connection
            DataBase_Credentials db =  new DataBase_Credentials();
            String url = db.JDBC_url;  // Replace with your database details
            String user = db.username;
            String password = db.password;
            connection = DriverManager.getConnection(url, user, password);



                // Prepare SQL query to update the profile photo (as BLOB)
                String sql = "UPDATE Users SET profile_image = ? WHERE roll_number = ?";
                preparedStatement = connection.prepareStatement(sql);

                // Convert the image file into a FileInputStream
                InputStream inputStream = new FileInputStream(imageFile);
                preparedStatement.setBlob(1, inputStream);
                preparedStatement.setString(2, ExamHubLoginForm.LoginHandler.getRoll_number_user()); // Assuming roll_number is stored in session

                // Execute the update
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Profile photo updated successfully.");


            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



  public static void loadProfilePhotoFromDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            String url = "jdbc:mysql://localhost:3306/ExamHub";
            String user = "root";
            String password = "OmRaut@04";  // Use your MySQL root password
            connection = DriverManager.getConnection(url, user, password);

            // Prepare SQL query to retrieve the profile photo
            String sql = "SELECT profile_image FROM Users WHERE roll_number = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user()); // Assuming roll_number is stored in session
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Blob photoBlob = resultSet.getBlob("profile_image");
                if (photoBlob != null) {
                    InputStream inputStream = photoBlob.getBinaryStream();
                    BufferedImage img = ImageIO.read(inputStream);
                    Image resizedImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                    profilePhotoLabel.setIcon(new ImageIcon(resizedImg));
                    profilePhotoLabel.setText(""); // Remove placeholder text


                } else {
                    profilePhotoLabel.setText("No Photo"); // Handle case where no photo is available

                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}

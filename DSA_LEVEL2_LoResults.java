import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

public class DSA_LEVEL2_LoResults {

    public void showResultsPage() {
        // Create the main frame
        JFrame frame = new JFrame("DSA L.O. RESULTS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        // Create a panel for the sidebar with shadow
        JPanel sidebar = new RoundedPanel(20);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(0, 102, 153)); // Teal color for sidebar
        sidebar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createMatteBorder(0, 0, 10, 0, Color.BLACK)
        ));

        // Create buttons for sidebar options
        JButton profileButton = createSidebarButton("Profile");
        JButton dashboardButton = createSidebarButton("Dashboard");
        JButton resultsButton = createSidebarButton("View Results");
        JButton logOutButton = createSidebarButton("Log Out");

        // Add buttons to sidebar
        sidebar.add(profileButton);
        sidebar.add(Box.createVerticalStrut(20)); // Space between buttons
        sidebar.add(dashboardButton);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(resultsButton);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(logOutButton);


        // Action listeners for sidebar buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StudentsProfilePage.main(new String[]{}); // Navigate to Profile Page
                StudentsProfilePage.loadProfilePhotoFromDatabase();
            }
        });

        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                newresult.main(new String[]{});
            }
        });

        dashboardButton.addActionListener(new ActionListener() {
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
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to log out?", "Confirm Log Out", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    frame.dispose();
                    ExamHubLoginForm.main(new String[]{}); // Navigate to Login Page
                }
            }
        });

        // Create a content panel with a box layout (vertical) and padding for better layout management
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Title section
        JLabel titleLabel = new JLabel("DSA L.O. RESULTS", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36)); // Larger font size for heading
        titleLabel.setForeground(new Color(0, 70, 160)); // Attractive dark blue color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 0, 10, 0),
                BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0, 153, 204)) // Bottom shadow effect
        ));
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createVerticalStrut(20));

        // Exam Name and Level section with consistent font and padding
        JPanel examPanel = new JPanel();
        examPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        examPanel.setBackground(new Color(230, 240, 255));

        JLabel examNameLabel = new JLabel("EXAM NAME: ");
        examNameLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField examNameField = new JTextField("DSA PRACTICAL EXAM", 15); // Fixed exam name field
        examNameField.setFont(new Font("Arial", Font.BOLD, 18));
        examNameField.setEditable(false); // Make it non-editable

        JLabel examLevelLabel = new JLabel("EXAM LEVEL: ");
        examLevelLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField examLevelField = new JTextField("LEVEL 2", 15); // Fixed exam level field
        examLevelField.setFont(new Font("Arial", Font.PLAIN, 18));
        examLevelField.setEditable(false); // Make it non-editable

        examPanel.add(examNameLabel);
        examPanel.add(examNameField);
        examPanel.add(examLevelLabel);
        examPanel.add(examLevelField);
        contentPanel.add(examPanel);
        contentPanel.add(Box.createVerticalStrut(10));

        // Retrieve data from the database as 2D arrays
        String[][] rollNumbers = getRollnumber();  // 2D array for roll numbers
        String[][] names = getName();              // 2D array for student names
        String[][] scores = getScore();            // 2D array for total scores

        JLabel[][] rollNumberLabels = new JLabel[6][];
        JLabel[][] nameLabels = new JLabel[6][];
        JLabel[][] scoreLabels = new JLabel[6][];

// Loop to create L.O. sections from L.O. 1 to L.O. 6
        for (int i = 1; i <= 6; i++) {
            contentPanel.add(Box.createVerticalStrut(10));

            // L.O. Mapping section with uniform design
            JPanel loPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            loPanel.setBackground(Color.WHITE);
            JLabel loLabel = new JLabel("L.O. MAPPING:");
            loLabel.setFont(new Font("Arial", Font.BOLD, 18));
            JTextField loField = new JTextField("L.O. " + i, 10);
            loField.setEditable(false);
            loField.setFont(new Font("Arial", Font.PLAIN, 16));
            loField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

            loPanel.add(loLabel);
            loPanel.add(loField);
            contentPanel.add(loPanel);

            // Roll Number and Search section
            JPanel inputPanel = new JPanel(new BorderLayout());
            inputPanel.setBackground(new Color(230, 240, 255));

            // Left-aligned roll number label and text field
            JPanel leftPanel = new JPanel();
            leftPanel.setBackground(new Color(230, 240, 255));
            leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel rollNumberLabel = new JLabel("ENTER YOUR ROLL NUMBER: ");
            rollNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));

            JTextField rollNumberField = new JTextField(10);
            rollNumberField.setFont(new Font("Arial", Font.PLAIN, 18));

            leftPanel.add(rollNumberLabel);
            leftPanel.add(rollNumberField);

            // Right-aligned search button
            JPanel rightPanel = new JPanel();
            rightPanel.setBackground(new Color(230, 240, 255));
            rightPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton searchButton = new JButton("SEARCH");
            searchButton.setFont(new Font("Arial", Font.BOLD, 18));
            searchButton.setBackground(new Color(0, 153, 204)); // Blue button
            searchButton.setForeground(Color.WHITE);
            searchButton.setFocusPainted(false); // Remove focus border

            rightPanel.add(searchButton);

            // Add both panels to the input panel
            inputPanel.add(leftPanel, BorderLayout.WEST);
            inputPanel.add(rightPanel, BorderLayout.EAST);

            contentPanel.add(inputPanel);
            contentPanel.add(Box.createVerticalStrut(20)); // Space below input

            // Student leaderboard
            JPanel tablePanel = new JPanel(new GridLayout(0, 3, 10, 10));
            tablePanel.setBackground(Color.WHITE);
            tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Headers
            tablePanel.add(createTableHeaderLabel("ROLL NUMBER"));
            tablePanel.add(createTableHeaderLabel("STUDENT NAME"));
            tablePanel.add(createTableHeaderLabel("TOTAL SCORE"));

            // Initialize arrays for labels in the current LO section
            rollNumberLabels[i - 1] = new JLabel[rollNumbers[i - 1].length];
            nameLabels[i - 1] = new JLabel[rollNumbers[i - 1].length];
            scoreLabels[i - 1] = new JLabel[rollNumbers[i - 1].length];

            // Loop through the records for the current LO (i-1 for 0-based index)
            for (int j = 0; j < rollNumbers[i - 1].length; j++) {
                rollNumberLabels[i - 1][j] = createTableCellLabel(rollNumbers[i - 1][j]);  // Roll number for LO-i
                nameLabels[i - 1][j] = createTableCellLabel(names[i - 1][j]);              // Name for LO-i
                scoreLabels[i - 1][j] = createTableCellLabel(scores[i - 1][j]);            // Score for LO-i

                tablePanel.add(rollNumberLabels[i - 1][j]);
                tablePanel.add(nameLabels[i - 1][j]);
                tablePanel.add(scoreLabels[i - 1][j]);
            }

            contentPanel.add(tablePanel);

            // Capture the current value of 'i' in a final local variable
            final int currentIndex = i - 1;

            // Add action listener to the search button
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String rollNumber = rollNumberField.getText().trim();
                    boolean isValidNumber = rollNumber.matches("\\d*"); // Check if input is numeric

                    if (isValidNumber) {
                        if (rollNumber.isEmpty()) {
                            // Show all students if roll number is empty
                            for (int x = 0; x < rollNumberLabels[currentIndex].length; x++) {
                                rollNumberLabels[currentIndex][x].setVisible(true);
                                nameLabels[currentIndex][x].setVisible(true);
                                scoreLabels[currentIndex][x].setVisible(true);
                            }
                        } else {
                            boolean found = false;
                            for (int x = 0; x < rollNumberLabels[currentIndex].length; x++) {
                                if (rollNumberLabels[currentIndex][x].getText().equals(rollNumber)) {
                                    rollNumberLabels[currentIndex][x].setVisible(true);
                                    nameLabels[currentIndex][x].setVisible(true);
                                    scoreLabels[currentIndex][x].setVisible(true);
                                    found = true;
                                } else {
                                    rollNumberLabels[currentIndex][x].setVisible(false);
                                    nameLabels[currentIndex][x].setVisible(false);
                                    scoreLabels[currentIndex][x].setVisible(false);
                                }
                            }

                            if (!found) {
                                JOptionPane.showMessageDialog(frame,
                                        "Roll number " + rollNumber + " is not available.",
                                        "Search Result", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "Please enter a valid roll number.",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        // Scroll Pane for the content panel
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Add sidebar and scroll pane to the frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);



        // Set frame visibility
        frame.setVisible(true);
    }

    public static String[][] getRollnumber() {
        DataBase_Credentials db = new DataBase_Credentials();
        String jdbcURL = db.JDBC_url; // Database URL
        String username = db.username; // DB username
        String password = db.password; // DB password

        // Assuming a maximum of 6 LOs and a variable number of students (roll numbers)
        String[][] rollNumbers = new String[6][];

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            Statement stm = null;
            ResultSet rs = null;

            // Query for each LO roll number (from lo_1 to lo_6)
            for (int i = 1; i <= 6; i++) {
                String sql = "SELECT roll_number FROM student_result_dsa_level2_lo" + i + " ORDER BY roll_number ASC;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                // Use an ArrayList to dynamically store roll numbers before converting to an array
                ArrayList<String> loRollNumbers = new ArrayList<>();

                while (rs.next()) {
                    loRollNumbers.add(rs.getString("roll_number"));
                }

                // Convert ArrayList to String[] and store it in the 2D array
                rollNumbers[i - 1] = loRollNumbers.toArray(new String[0]);

                // Close result set for each query
                rs.close();
            }

            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rollNumbers; // Return the 2D array
    }
    public static String[][] getName() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ExamHub"; // Database URL
        String username = "root"; // DB username
        String password = "OmRaut@04"; // DB password

        // Assuming a maximum of 6 LOs and a variable number of students (roll numbers)
        String[][] names = new String[6][];

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            Statement stm = null;
            ResultSet rs = null;

            // Query for each LO name (from lo_1 to lo_6)
            for (int i = 1; i <= 6; i++) {
                String sql = "SELECT Users.name FROM Users " +
                        "INNER JOIN student_result_dsa_level2_lo" + i +
                        " ON Users.roll_number = student_result_dsa_level2_lo" + i + ".roll_number " +
                        "ORDER BY student_result_dsa_level2_lo" + i + ".roll_number ASC;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                // Use an ArrayList to dynamically store names before converting to an array
                ArrayList<String> loNames = new ArrayList<>();

                while (rs.next()) {
                    loNames.add(rs.getString("name"));
                }

                // Convert ArrayList to String[] and store it in the 2D array
                names[i - 1] = loNames.toArray(new String[0]);

                // Close result set for each query
                rs.close();
            }

            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return names; // Return the 2D array
    }

    public static String[][] getScore() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ExamHub"; // Database URL
        String username = "root"; // DB username
        String password = "OmRaut@04"; // DB password

        // Assuming a maximum of 6 LOs and a variable number of students (roll numbers)
        String[][] scores = new String[6][];

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            Statement stm = null;
            ResultSet rs = null;

            // Query for each LO score (from lo_1 to lo_6)
            for (int i = 1; i <= 6; i++) {
                String sql = "SELECT lo" + i + "_score FROM student_result_dsa_level2_lo" + i + " ORDER BY roll_number ASC;";
                stm = con.createStatement();
                rs = stm.executeQuery(sql);

                // Use an ArrayList to dynamically store scores before converting to an array
                ArrayList<String> loScores = new ArrayList<>();

                while (rs.next()) {
                    loScores.add(rs.getString("lo" + i + "_score") + "/5");
                }

                // Convert ArrayList to String[] and store it in the 2D array
                scores[i - 1] = loScores.toArray(new String[0]);

                // Close result set for each query
                rs.close();
            }

            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return scores; // Return the 2D array
    }


    // Utility method to create table headers with consistent design
    private static JLabel createTableHeaderLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(new Color(0, 102, 153)); // Teal color
        label.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 153), 2));
        return label;
    }

    private static JLabel createTableCellLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Light gray border
        return label;
    }

    // Utility method to create sidebar buttons with consistent design
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

    // Main method to run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DSA_LEVEL2_LoResults().showResultsPage());
    }

    // RoundedPanel class to create a panel with rounded corners
    class RoundedPanel extends JPanel {
        private int cornerRadius;

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(getBackground());
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
        }
    }
}


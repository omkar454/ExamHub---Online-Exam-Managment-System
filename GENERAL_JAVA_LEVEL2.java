import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class GENERAL_JAVA_LEVEL2 {


    public void STUDENT() {
        // Create the main frame
        JFrame frame = new JFrame( "RESULT Dashboard - ExamHub");  // Dynamic title based on role
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // Adjusted frame size
        frame.setLayout(new BorderLayout());

        // Background color for the entire frame
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

        // Main content (results)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Vertical layout
        contentPanel.setBackground(Color.WHITE); // White background for content panel
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Add title label with shadow effect
        JLabel titleLabel = new JLabel("STUDENTS RESULT", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36)); // Larger font size for heading
        titleLabel.setForeground(new Color(0, 70, 160)); // Attractive dark blue color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 0, 10, 0),
                BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(0, 153, 204)) // Bottom shadow effect
        ));
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createVerticalStrut(20)); // Space below title

        // Exam name section
        JPanel examPanel = new JPanel();
        examPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        examPanel.setBackground(new Color(230, 240, 255));

        JLabel examNameLabel = new JLabel("EXAM NAME: ");
        examNameLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField examNameField = new JTextField("JAVA PRACTICAL EXAMINATION", 20); // Fixed exam name field
        examNameField.setFont(new Font("Arial", Font.BOLD, 18));
        examNameField.setEditable(false); // Make it non-editable

        JLabel examlevellable = new JLabel("EXAM LEVEL: ");
        examlevellable.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField examlevelfields = new JTextField("LEVEL 2", 15); // Fixed exam name field
        examlevelfields.setFont(new Font("Arial", Font.PLAIN, 18));
        examlevelfields.setEditable(false); // Make it non-editable


        examPanel.add(examNameLabel);
        examPanel.add(examNameField);
        examPanel.add(examlevellable);
        examPanel.add(examlevelfields);
        contentPanel.add(examPanel);
        contentPanel.add(Box.createVerticalStrut(10)); // Space below exam name section

        // Add roll number input field with new layout
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color(230, 240, 255));

        // Left-aligned roll number label and text field
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(230, 240, 255));
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel rollNumberLabel = new JLabel("ENTER YOUR ROLL NUMBER: ");
        rollNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JTextField rollNumberField = new JTextField(10); // Reduced width
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

        // Create table for student results
        JPanel tablePanel = new JPanel(new GridLayout(0, 3, 10, 10)); // 3 columns, adjustable rows
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createLineBorder(new Color(230, 240, 255), 2)); // Add slight border around the table

        String[] rollNumbers = getRollnumber().split("\n");
        String[] names =getName().split("\n");

        String[] scores = getScore().split("\n");


        // Add table headers
        tablePanel.add(createTableHeaderLabel("ROLL NUMBER"));
        tablePanel.add(createTableHeaderLabel("STUDENT NAME"));
        tablePanel.add(createTableHeaderLabel("TOTAL SCORE"));

        // Add student result data
        JLabel[] rollNumberLabels = new JLabel[rollNumbers.length];
        JLabel[] nameLabels = new JLabel[names.length];
        JLabel[] scoreLabels = new JLabel[scores.length];

        for (int i = 0; i < rollNumbers.length; i++) {
            rollNumberLabels[i] = createTableCellLabel(rollNumbers[i]);
            nameLabels[i] = createTableCellLabel(names[i]);
            scoreLabels[i] = createTableCellLabel(scores[i]);

            tablePanel.add(rollNumberLabels[i]);
            tablePanel.add(nameLabels[i]);
            tablePanel.add(scoreLabels[i]);
        }

        contentPanel.add(tablePanel);

        // Add "Back" button with reverted design
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 240, 255));

        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton backButton = new JButton("View JAVA L.O. Results.");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBackground(new Color(0, 153, 204)); // Blue button
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        buttonPanel.add(backButton);

        contentPanel.add(Box.createVerticalStrut(20)); // Space before the button
        contentPanel.add(buttonPanel);

        // Create scroll pane for the content panel
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Add sidebar and scroll pane to the frame
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);

        // Add action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rollNumber = rollNumberField.getText().trim();
                boolean isValidNumber = rollNumber.matches("\\d*"); // Check if input is numeric

                if (isValidNumber) {
                    if (rollNumber.isEmpty()) {
                        // Show all students if roll number is empty
                        for (int i = 0; i < rollNumberLabels.length; i++) {
                            rollNumberLabels[i].setVisible(true);
                            nameLabels[i].setVisible(true);
                            scoreLabels[i].setVisible(true);
                        }
                    } else {
                        boolean found = false;
                        for (int i = 0; i < rollNumberLabels.length; i++) {
                            if (rollNumberLabels[i].getText().equals(rollNumber)) {
                                rollNumberLabels[i].setVisible(true);
                                nameLabels[i].setVisible(true);
                                scoreLabels[i].setVisible(true);
                                found = true;
                            } else {
                                rollNumberLabels[i].setVisible(false);
                                nameLabels[i].setVisible(false);
                                scoreLabels[i].setVisible(false);
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JAVA_LEVEL2_LoResults.main(new String[]{});
            }
        });
    }

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

    // Custom panel with rounded corners
    static class RoundedPanel extends JPanel {
        private int radius;

        public RoundedPanel(int radius) {
            super();
            this.radius = radius;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
        }
    }


    public static String getRollnumber() {
        DataBase_Credentials db = new DataBase_Credentials();
        String jdbcURL = db.JDBC_url; // Database URL
        String username = db.username; // DB username
        String password = db.password; // DB password
        StringBuilder rollNumbers = new StringBuilder(); // To store roll numbers

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "SELECT roll_number FROM student_result_java_level2 ORDER BY roll_number ASC;";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

//            int index = 1; // To track roll number index
            while (rs.next()) {
                rollNumbers.append(rs.getString("roll_number"))
                        .append("\n");
            }

            rs.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rollNumbers.toString();
    }

    public static String getName() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ExamHub"; // Database URL
        String username = "root"; // DB username
        String password = "OmRaut@04"; // DB password
        StringBuilder Names = new StringBuilder(); // To store names

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "select Users.name FROM Users \n" +
                    "INNER JOIN \n" +
                    "student_result_java_level2 ON Users.roll_number = student_result_java_level2.roll_number\n" +
                    " ORDER BY\n" +
                    " student_result_java_level2.roll_number ASC;";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

//            int index = 1; // To track roll number index
            while (rs.next()) {
                Names.append(rs.getString("name"))
                        .append("\n");
            }

            rs.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Names.toString();
    }

    public static String getScore() {
        String jdbcURL = "jdbc:mysql://localhost:3306/ExamHub"; // Database URL
        String username = "root"; // DB username
        String password = "OmRaut@04"; // DB password
        StringBuilder score = new StringBuilder(); // To store scores

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            String sql = "select score from student_result_java_level2 order by roll_number ASC;";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

//            int index = 1; // To track roll number index
            while (rs.next()) {
                score.append(rs.getString("score")).append("/30")
                        .append("\n");
            }

            rs.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return score.toString();
    }



    // Method to display the initial dialog box and start the page
    public static void main(String[] args) {
        // Display a dialog box to ask for the user role


        // Determine the role based on user response


        // Create and display the view results page based on the determined role
        GENERAL_JAVA_LEVEL2 studentsResultPage = new GENERAL_JAVA_LEVEL2();
        studentsResultPage.STUDENT();
    }


}


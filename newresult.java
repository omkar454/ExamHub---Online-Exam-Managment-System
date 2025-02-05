import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newresult {

    public void displayStudentResultsPage() {
        // Create the main frame
        JFrame frame = new JFrame("View Results - ExamHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // Adjusted frame size
        frame.setLayout(new BorderLayout());

        // Background color for the entire frame
        frame.getContentPane().setBackground(new Color(230, 240, 255)); // Light blue background

        // Create a panel for the sidebar (with buttons)
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(0, 102, 153)); // Teal color for sidebar
        sidebar.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

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


        // Create a panel for the main content area
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBackground(Color.WHITE); // White background for content panel
        contentPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3), // Black border
                BorderFactory.createEmptyBorder(20, 20, 20, 20))); // Padding inside the panel

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 20, 10, 20); // Padding for form elements

        // Add heading to the content area
        JLabel heading = new JLabel("View Your Exam Results", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 36)); // Increased font size for heading
        heading.setForeground(new Color(0, 70, 160)); // Attractive dark blue color
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(30, 0, 10, 0); // Adjusted space above heading
        contentPanel.add(heading, constraints);



        // "Select Subject" section
        JLabel subjectLabel = new JLabel("Select Subject:");
        subjectLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Bigger font size for label
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        contentPanel.add(subjectLabel, constraints);

        JComboBox<String> subjectComboBox = new JComboBox<>(new String[]{"JAVA", "DSA", "PCPF", "DBMS"});
        subjectComboBox.setFont(new Font("Arial", Font.PLAIN, 22)); // Larger font size for combo box
        constraints.gridy = 2;
        constraints.ipadx = 150; // Wider combo box
        constraints.ipady = 15;
        contentPanel.add(subjectComboBox, constraints);

        // "Select Level" section
        JLabel levelLabel = new JLabel("Select Exam Level:");
        levelLabel.setFont(new Font("Arial", Font.BOLD, 28)); // Bigger font size for label
        constraints.gridy = 3;
        contentPanel.add(levelLabel, constraints);

        JComboBox<String> levelComboBox = new JComboBox<>(new String[]{"LEVEL 1", "LEVEL 2", "LEVEL 3"});
        levelComboBox.setFont(new Font("Arial", Font.PLAIN, 22)); // Larger font size for combo box
        constraints.gridy = 4;
        constraints.ipadx = 150; // Wider combo box
        constraints.ipady = 15;
        contentPanel.add(levelComboBox, constraints);

        // "View Results" button
        JButton viewResultsButton = createActionButton("View Results");
        constraints.gridy = 5;
        contentPanel.add(viewResultsButton, constraints);

        // Add sidebar to the left of the frame and content panel to the center
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);

        // Action listeners for sidebar buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StudentsProfilePage.main(new String[]{}); // Navigate to Profile Page
                StudentsProfilePage.loadProfilePhotoFromDatabase();
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

        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                newresult.main(new String[]{});
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
        // Action listener for "View Results" button
        viewResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSubject = (String) subjectComboBox.getSelectedItem();
                String selectedLevel = (String) levelComboBox.getSelectedItem();
                // Display the selected subject and level (for now, until real result fetching is added)
                JOptionPane.showMessageDialog(frame, "Selected Subject: " + selectedSubject + "\nSelected Level: " + selectedLevel, "Exam Result", JOptionPane.INFORMATION_MESSAGE);

                // Show different pages based on subject and level combination
                if (selectedSubject.equals("JAVA") && selectedLevel.equals("LEVEL 1")) {
                    frame.dispose();

                    GENERAL_JAVA_LEVEL1.main(new String[]{});
                } else if (selectedSubject.equals("JAVA") && selectedLevel.equals("LEVEL 2")) {
                    frame.dispose();
                    GENERAL_JAVA_LEVEL2.main(new String[]{});
                } else if (selectedSubject.equals("JAVA") && selectedLevel.equals("LEVEL 3")) {
                    frame.dispose();
                    GENERAL_JAVA_LEVEL3.main(new String[]{});
                } else if (selectedSubject.equals("DSA") && selectedLevel.equals("LEVEL 1")) {
                  frame.dispose();
                  GENERAL_DSA_LEVEL1.main(new String[]{});
                } else if (selectedSubject.equals("DSA") && selectedLevel.equals("LEVEL 2")) {
                    frame.dispose();
                    GENERAL_DSA_LEVEL2.main(new String[]{});
                } else if (selectedSubject.equals("DSA") && selectedLevel.equals("LEVEL 3")) {
                    frame.dispose();
                    GENERAL_DSA_LEVEL3.main(new String[]{});
                } else if (selectedSubject.equals("PCPF") && selectedLevel.equals("LEVEL 1")) {
                    frame.dispose();
                    GENERAL_PCPF_LEVEL1.main(new String[]{});
                } else if (selectedSubject.equals("PCPF") && selectedLevel.equals("LEVEL 2")) {
                    frame.dispose();
                    GENERAL_PCPF_LEVEL2.main(new String[]{});
                } else if (selectedSubject.equals("PCPF") && selectedLevel.equals("LEVEL 3")) {
                    frame.dispose();
                    GENERAL_PCPF_LEVEL3.main(new String[]{});
                } else if (selectedSubject.equals("DBMS") && selectedLevel.equals("LEVEL 1")) {
                    frame.dispose();
                    GENERAL_DBMS_LEVEL1.main(new String[]{});
                } else if (selectedSubject.equals("DBMS") && selectedLevel.equals("LEVEL 2")) {
                    frame.dispose();
                    GENERAL_DBMS_LEVEL2.main(new String[]{});
                } else if (selectedSubject.equals("DBMS") && selectedLevel.equals("LEVEL 3")) {
                    frame.dispose();
                    GENERAL_DBMS_LEVEL3.main(new String[]{});
                } else {
                    JOptionPane.showMessageDialog(frame, "Results not available for this selection.", "No Results", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

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

    // Helper method to create action buttons (View Results)
    private static JButton createActionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 20)); // Slightly smaller font size for action buttons
        button.setBackground(new Color(0, 153, 204)); // Attractive blue background for buttons
        button.setForeground(Color.WHITE); // White text
        button.setFocusPainted(false); // Remove focus border
        button.setPreferredSize(new Dimension(250, 60)); // Slightly smaller button size
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Remove border
        return button;
    }


    public static void main(String[] args) {
        new newresult().displayStudentResultsPage();
    }
}

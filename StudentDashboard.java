import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentDashboard {

    public void displaySTUDENTdashboard() {
        // Create the main frame
        JFrame frame = new JFrame("Student Dashboard - ExamHub");
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
                BorderFactory.createLineBorder(new Color(0, 102, 102), 3),
                BorderFactory.createEmptyBorder(20, 20, 20, 20))); // Teal border with padding

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 20, 10, 20); // Padding for form elements

        // Add heading to the content area
        JLabel heading = new JLabel("Welcome to Your ExamHub Dashboard", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 36)); // Increased font size for heading
        heading.setForeground(new Color(0, 70, 160)); // Attractive dark blue color
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 0, 10, 0); // Adjusted space above heading
        contentPanel.add(heading, constraints);

        // Add description text in the content area
        JLabel description = new JLabel("<html><center>Choose a subject to take your online exam from the following:</center></html>", JLabel.CENTER);
        description.setFont(new Font("Arial", Font.PLAIN, 22));
        description.setForeground(new Color(51, 51, 51));
        constraints.gridy = 1;
        contentPanel.add(description, constraints);

        // Add buttons for each subject
        JButton javaButton = createActionButton("JAVA");
        JButton dbmsButton = createActionButton("DBMS");
        JButton dsaButton = createActionButton("DSA");
        JButton pcpfButton = createActionButton("PCPF");

        // Add subject buttons to the content panel
        constraints.gridy = 2;
        contentPanel.add(javaButton, constraints);
        constraints.gridy = 3;
        contentPanel.add(dbmsButton, constraints);
        constraints.gridy = 4;
        contentPanel.add(dsaButton, constraints);
        constraints.gridy = 5;
        contentPanel.add(pcpfButton, constraints);




        // Add Exam History Section
        // Add Exam History Section
        JLabel historyLabel = new JLabel("Your Exam History" , JLabel.CENTER);
        historyLabel.setFont(new Font("Arial", Font.BOLD, 28));
        constraints.gridy = 6;
        contentPanel.add(historyLabel, constraints);

// Create a panel for the exam history grid with GridBagLayout for better control
        JPanel historyPanel = new JPanel();
        historyPanel.setLayout(new GridBagLayout()); // Changed layout to GridBagLayout
        historyPanel.setBackground(Color.WHITE); // White background for history panel

// Array of subjects and exams (results)
        String[] subjects = {"JAVA", "DBMS", "DSA", "PCPF"};
        String[] certificatesubjects = {"Java Programming Lab", "SQL Lab", "DSA Lab", "CPPL Lab"};
       String[][] subject_levels = getLevel();

// Score of the exam's attempted by student
        // Assuming getScore() returns a 2D array of scores for different subjects and levels
        // Call the getScore() method to fetch the scores and assign them to subject_scores
        String[][] subject_scores = getScore();





        GridBagConstraints historyConstraints = new GridBagConstraints();
        historyConstraints.fill = GridBagConstraints.HORIZONTAL;
        historyConstraints.insets = new Insets(10, 0, 10, 0); // Padding between rows
        historyConstraints.gridx = 0; // Always align to the first column

        for (int i = 0; i < subjects.length; i++) {
            // Create a panel for each subject
            JPanel subjectPanel = new JPanel(new BorderLayout());
            subjectPanel.setBackground(Color.WHITE); // White background
            subjectPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Black border for subjects
            subjectPanel.setPreferredSize(new Dimension(750, 150)); // Set preferred width of the subject panel

            // Add subject label
            JLabel subjectLabel = new JLabel("SUBJECT: " + subjects[i]);
            subjectLabel.setFont(new Font("Arial", Font.BOLD, 20));
            subjectLabel.setForeground(Color.BLACK);
            subjectPanel.add(subjectLabel, BorderLayout.NORTH);

            // Create a panel for the exams within this subject
            JPanel examPanel = new JPanel();
            examPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10)); // Exams in horizontal row
            examPanel.setBackground(Color.WHITE);

            // Add each exam in a separate box with "View Certificate" button
            for (int j = 0; j < subject_levels[i].length; j++) {
                JPanel examBox = new JPanel();
                examBox.setLayout(new BorderLayout());
                examBox.setPreferredSize(new Dimension(225, 100)); // Increased width of exam boxes
                examBox.setBackground(new Color(230, 240, 255)); // Light blue background
                examBox.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, new Color(150, 150, 150))); // Shadow effect

                // Add exam details
                JLabel examName = new JLabel("Exam Level: " + subject_levels[i][j]);
                examName.setFont(new Font("Arial", Font.BOLD, 20));
                examName.setForeground(Color.BLACK);
                examBox.add(examName, BorderLayout.NORTH);

                // Add score label
                JLabel scoreLabel = new JLabel("Score: " + subject_scores[i][j]);
                examBox.add(scoreLabel, BorderLayout.CENTER); // Add it to the center of the panel

                // Add "View Certificate" button
                JButton viewCertificateButton = new JButton("View Certificate");
                viewCertificateButton.setFont(new Font("Arial", Font.BOLD, 14));
                viewCertificateButton.setBackground(new Color(0, 153, 204)); // Blue button
                viewCertificateButton.setForeground(Color.WHITE);

                // Add action listener for the button
                int finalJ = j;
                int finalI = i;
                viewCertificateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Check if the score qualifies for a certificate
                        String score = subject_scores[finalI][finalJ];
                        if ("Not Attempted".equals(score)) {
                            // Show dialog box if not attempted
                            JOptionPane.showMessageDialog(null,
                                    "You have not yet cleared this level.",
                                    "Level Not Cleared",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        int actualscore = Integer.parseInt(subject_scores[finalI][finalJ].split("/")[0]);
                       if (actualscore < 23 || subject_scores[finalI][finalJ]=="Not Attempted") {
                            // Show dialog box if score is below 23
                            JOptionPane.showMessageDialog(null,
                                    "You have not yet cleared this level.",
                                    "Level Not Cleared",
                                    JOptionPane.WARNING_MESSAGE);
                        } else {

                           String subjectName = certificatesubjects[finalI];
                           String levelName = subject_levels[finalI][finalJ];
                           int actualScore = Integer.parseInt(score.split("/")[0]);

                           // Store the values
                           CertificateData.setCertificateData(subjectName, levelName, actualScore);

                            // Open CertificatePage if score is 23 or above
                            CertificatePage.main(new String[]{});
                        }
                    }
                });

                examBox.add(viewCertificateButton, BorderLayout.SOUTH); // Add button to exam box
                examPanel.add(examBox); // Add exam box to the exam panel
            }

            subjectPanel.add(examPanel, BorderLayout.CENTER);
            historyConstraints.gridy = i; // Each subject panel occupies a new row
            historyPanel.add(subjectPanel, historyConstraints); // Add subject panel to history panel
        }

// Add history panel to the content
        constraints.gridy = 7;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0; // Allow expansion
        contentPanel.add(historyPanel, constraints);
        // Create a JScrollPane and add contentPanel to it
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar

        // Add sidebar to the left of the frame and scrollPane to the center
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(scrollPane, BorderLayout.CENTER);

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

        javaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JAVATakeExamPage.main(new String[]{});

            }
        });

        pcpfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                PCPFTakeExamPage.main(new String[]{});

            }
        });

        dbmsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DBMSTakeExamPage.main(new String[]{});
            }
        });


        dsaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DSATakeExamPage.main(new String[]{});
            }
        });


        // Set frame visibility
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

    private JButton createActionButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setBackground(new Color(0, 153, 204)); // Button color
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(300, 50)); // Set button size
        return button;
    }

    public static String[][] getLevel() {
        DataBase_Credentials db = new DataBase_Credentials();
        String jdbcURL = db.JDBC_url; // Database URL
        String username = db.username; // DB username
        String password = db.password; // DB password

        // Initialize a 2D array to store scores for each subject and level
        String[][] levels = new String[4][3]; // 4 subjects, 3 levels per subject

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);

            // Array of table names for each subject
            String[] subjects = {"student_result_java_level", "student_result_dbms_level", "student_result_dsa_level", "student_result_cppl_level"};

            // Loop through each subject and retrieve  for levels 1 to 3
            for (int i = 0; i < subjects.length; i++) {
                for (int level = 1; level <= 3; level++) {
                    String sql = "SELECT level FROM " + subjects[i] + level + " WHERE roll_number = ?;";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user());
                    ResultSet rs = pstm.executeQuery();

                    // Store score in the 2D array if found, otherwise store empty string
                    if (rs.next()) {
                        String levels_attempt = rs.getString("level"); // Retrieve the score as an int
                        System.out.println("Subject: " + subjects[i] + " Level: " + levels_attempt + " attempted"); // Debug statement
                        levels[i][level-1] = levels_attempt;

                    } else {
                        System.out.println("No score found for Subject: " + subjects[i] + " not attempted");
                        levels[i][level-1] = String.valueOf(level);
                    }
                    rs.close();
                    pstm.close();
                }
            }




            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return levels; // Return the 2D array of scores
    }


    public static String[][] getScore() {
        DataBase_Credentials db =  new DataBase_Credentials();
        String jdbcURL = db.JDBC_url; // Database URL
        String username = db.username; // DB username
        String password = db.password; // DB password

        // Initialize a 2D array to store scores for each subject and level
        String[][] scores = new String[4][3]; // 4 subjects, 3 levels per subject

        try {
            Connection con = DriverManager.getConnection(jdbcURL, username, password);

            // Array of table names for each subject
            String[] subjects = {"student_result_java_level", "student_result_dbms_level", "student_result_dsa_level", "student_result_cppl_level"};

            // Loop through each subject and retrieve scores for levels 1 to 3
            for (int i = 0; i < subjects.length; i++) {
                for (int level = 1; level <= 3; level++) {
                    String sql = "SELECT score FROM " + subjects[i] + level + " WHERE roll_number = ?;";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setString(1, ExamHubLoginForm.LoginHandler.getRoll_number_user());
                    ResultSet rs = pstm.executeQuery();

                    // Store score in the 2D array if found, otherwise store empty string
                    if (rs.next()) {
                        int score = rs.getInt("score"); // Retrieve the score as an int
                        System.out.println("Subject: " + subjects[i] + " Level: " + level + " Score: " + score); // Debug statement
                        scores[i][level - 1] = String.valueOf(score+"/30"); // Convert int to String
                    } else {
                        System.out.println("No score found for Subject: " + subjects[i] + " Level: " + level);

                        scores[i][level - 1] = "Not Attempted"; // Convert int to String
                    }
                    rs.close();
                    pstm.close();
                }
            }




            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return scores; // Return the 2D array of scores
    }

    public class CertificateData {
        private static String subjectName;
        private static String levelName;
        private static int score;

        // Method to set values
        public static void setCertificateData(String subject, String level, int scoreValue) {
            subjectName = subject;
            levelName = level;
            score = scoreValue;
        }

        // Methods to get values
        public static String getSubjectName() {
            return subjectName;
        }

        public static String getLevelName() {
            return levelName;
        }

        public static int getScore() {
            return score;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentDashboard().displaySTUDENTdashboard();
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DSATakeExamPage {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Dashboard - ExamHub");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // Adjusted frame size
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

        // Action listeners for sidebar buttons
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                StudentsProfilePage.main(new String[]{});
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
                StudentDashboard dashers = new StudentDashboard();
                dashers.displaySTUDENTdashboard();
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

        // Create a scrollable panel for the main content area (Exam list)
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Vertical layout
        contentPanel.setBackground(Color.WHITE); // White background for content panel
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Add heading for the exam section
        JLabel heading = new JLabel("LIST OF AVAILABLE EXAMS", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 32)); // Large font size for heading
        heading.setForeground(new Color(0, 70, 160)); // Attractive dark blue color
        heading.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(heading);
        contentPanel.add(Box.createVerticalStrut(20)); // Space below heading

        // Add instructions section
        JPanel instructionsPanel = new JPanel();
        instructionsPanel.setLayout(new BoxLayout(instructionsPanel, BoxLayout.Y_AXIS)); // Vertical layout
        instructionsPanel.setBackground(new Color(240, 255, 255)); // Light cyan background
        instructionsPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 153), 3)); // Teal border

        JLabel instructionsHeading = new JLabel("EXAM INSTRUCTIONS", JLabel.CENTER);
        instructionsHeading.setFont(new Font("Serif", Font.BOLD, 28)); // Font for heading
        instructionsHeading.setForeground(new Color(0, 102, 153));
        instructionsPanel.add(instructionsHeading);
        instructionsPanel.add(Box.createVerticalStrut(10));

        String[] instructions = {
                "1) This is an online MCQ practical exam based on the Mumbai University syllabus.",
                "2) Questions will be grouped by learning outcomes (LO) from LO-1 to LO-6.",
                "3) Each level has 30 questions.",
                "4) Each question is worth 1 mark.",
                "5) The time limit is 1 hour.",
                "6) There are three levels: Level 1, Level 2, and Level 3.",
                "7) You must pass Level 1 to attempt Level 2, and pass Level 2 to attempt Level 3.",
                "8) A minimum of 75% is needed to pass any level.",
                "9) Coordinator for this exam: Dr. Kumkum Saxena."
        };

        for (String instruction : instructions) {
            JLabel instructionLabel = new JLabel(instruction);
            instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            instructionLabel.setForeground(Color.BLACK);
            instructionsPanel.add(instructionLabel);
            instructionsPanel.add(Box.createVerticalStrut(5)); // Space between instructions
        }

        // Center the instructions panel
        instructionsPanel.setPreferredSize(new Dimension(600, instructionsPanel.getPreferredSize().height));
        instructionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPanel.add(instructionsPanel);
        contentPanel.add(Box.createVerticalStrut(20)); // Space between instructions and available exams

        // Add available exams dynamically (subject name, exam names, start buttons)

        String[] subjects = {"DSA"};
        String[][] exams = {
                {"Exam 1", "Exam 2", "Exam 3"},
        };

        for (int i = 0; i < subjects.length; i++) {
            // Create a panel for each subject
            JPanel subjectPanel = new JPanel(new BorderLayout());
            subjectPanel.setBackground(Color.WHITE); // White background
            subjectPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Black border for subjects

            // Add subject label
            JLabel subjectLabel = new JLabel("SUBJECT-NAME: " + subjects[i]);
            subjectLabel.setFont(new Font("Arial", Font.BOLD, 20));


            subjectLabel.setForeground(Color.BLACK);
            subjectPanel.add(subjectLabel, BorderLayout.NORTH);

            // Create a syllabus panel similar to the instructions panel
            JPanel syllabusPanel = new JPanel();
            syllabusPanel.setLayout(new BoxLayout(syllabusPanel, BoxLayout.Y_AXIS)); // Vertical layout
            syllabusPanel.setBackground(new Color(240, 255, 255)); // Light cyan background
            syllabusPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(20, 20, 20, 20), // Padding around the inside of the border
                    BorderFactory.createLineBorder(new Color(0, 102, 153), 3) // Teal border
            ));

            JLabel syllabusHeading = new JLabel("SYLLABUS FOR ALL THE THREE LEVELS OF EXAM", JLabel.CENTER);
            syllabusHeading.setFont(new Font("Serif", Font.BOLD, 28)); // Font for heading
            syllabusHeading.setForeground(new Color(0, 102, 153));
            syllabusPanel.add(syllabusHeading);
            syllabusPanel.add(Box.createVerticalStrut(10));

            // Add subheadings and content for each learning outcome
            String[] loHeadings = {"LO1 SYLLABUS:", "LO2 SYLLABUS:", "LO3 SYLLABUS:", "LO4 SYLLABUS:", "LO5 SYLLABUS:", "LO6 SYLLABUS:"};
            String[][] loContent = {
                    {"- Stack and Queues.", "- Linked List."},
                    {"- Binary Search Tree.", "- Hashing."},
                    {"- Circular Linked List.", "- Priority Queues."},
                    {"- Adjacency List and Adjacency Matrix.", "- BFS & DFS Algorithms."},
                    {"- Sorting algorithms.", "- Searching algorithms."},
                    {"- Dijkstra's Algorithm.", "- Evaluation of PostFix Expression."}
            };

            for (int j = 0; j < loHeadings.length; j++) {
                JLabel loHeadingLabel = new JLabel(loHeadings[j]);
                loHeadingLabel.setFont(new Font("Arial", Font.BOLD, 18));
                loHeadingLabel.setForeground(new Color(0, 102, 153));
                syllabusPanel.add(loHeadingLabel);
                syllabusPanel.add(Box.createVerticalStrut(5)); // Space below heading

                for (String line : loContent[j]) {
                    JLabel contentLabel = new JLabel(line);
                    contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                    contentLabel.setForeground(Color.BLACK);
                    syllabusPanel.add(contentLabel);
                    syllabusPanel.add(Box.createVerticalStrut(5)); // Space between lines
                }
            }

            // Add syllabus panel between the subject label and exam boxes
            subjectPanel.add(syllabusPanel, BorderLayout.CENTER);

            // Create a panel for the exams within this subject
            JPanel examPanel = new JPanel();
            examPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10)); // Exams in horizontal row
            examPanel.setBackground(Color.WHITE);

            // Use the original design for each exam box with level-specific labels
            String[] levels = {"LEVEL-1", "LEVEL-2", "LEVEL-3"};
            boolean[] isLevelCleared = {false, false}; // Mutable flags using array

            for (int level = 0; level < levels.length; level++) {
                JPanel examBox = new JPanel();
                examBox.setLayout(new BorderLayout());
                examBox.setPreferredSize(new Dimension(200, 100)); // Box size
                examBox.setBackground(new Color(230, 240, 255)); // Light blue background
                examBox.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, new Color(150, 150, 150))); // Shadow effect

                // Add the heading "SUBJECT PRACTICAL EXAM" to the top of the box
                JLabel examTitle = new JLabel("DSA PRACTICAL EXAM", JLabel.CENTER);
                examTitle.setFont(new Font("Serif", Font.BOLD, 14)); // Font for heading
//                examTitle.setFont(new Font("Serif", Font.BOLD, 12)); // Font for heading
//                examTitle.setFont(new Font("Arial", Font.PLAIN, 14));
                examTitle.setForeground(new Color(0, 102, 153));
                examBox.add(examTitle, BorderLayout.NORTH);

                // Add the level label (LEVEL-1, LEVEL-2, LEVEL-3) to the center of the box
                JLabel levelLabel = new JLabel(levels[level], JLabel.CENTER);
                levelLabel.setFont(new Font("Arial", Font.PLAIN, 16));
                examBox.add(levelLabel, BorderLayout.CENTER);

                // Create the "Start" button and add it to the bottom of the box
                JButton startButton = new JButton("START");
                startButton.setFont(new Font("Arial", Font.BOLD, 16));
                startButton.setBackground(new Color(0, 102, 153)); // Teal background
                startButton.setForeground(Color.WHITE); // White text
                startButton.setFocusPainted(false);

                // Add action listeners to handle level restrictions
                int currentLevel = level; // Capture the current level
                startButton.addActionListener(e -> {
                    Connection connection = null;
                    PreparedStatement preparedStatement = null;
                    ResultSet resultSet = null;

                    try {
                        // Establish database connection
                        DataBase_Credentials db =  new DataBase_Credentials();
                        String url = db.JDBC_url;  // Replace with your database details
                        String user = db.username;
                        String pass = db.password;

                        connection = DriverManager.getConnection(url, user, pass); // Replace with correct credentials

                        // Get the username from AnotherClass
                        String currentUsername =ExamHubLoginForm.LoginHandler.getLoggedInUsername(); // Assuming this method gets the logged-in username

                        if (currentLevel == 0) {
                            // Starting Level 1
                            JOptionPane.showMessageDialog(frame, "Starting Level 1 Exam");
                            isLevelCleared[0] = true;
                            String instruction = "Instructions:\n" +
                                    "1. Carefully read each question and all options.\n" +
                                    "2. Select the correct answer by clicking the radio button next to it.\n" +
                                    "3. Use 'Save & Next' to move to the next question.\n" +
                                    "4. Use 'Previous Question' to return to the last question.\n" +
                                    "5. Click 'Mark for Review' to flag questions you want to revisit later.\n" +
                                    "6. Once all questions are attempted, click 'Submit' to finalize your exam.\n\n" +
                                    "Color Coding:\n" +
                                    "- Yellow: Current question\n" +
                                    "- Green: Attempted questions\n" +
                                    "- Orange: Marked for review questions\n" +
                                    "- Light Gray: Unvisited questions\n" +
                                    "- Red: Unanswered questions";

                            JOptionPane.showMessageDialog(frame, instruction, "Exam Instructions", JOptionPane.INFORMATION_MESSAGE);

                            // Start Level 1 Exam
                            DSA_LEVEL1_EXAM_PAGE.main(new String[]{}); // Start Level 1 Exam
                        } else if (currentLevel == 1) {
                            // Check eligibility for Level 2
                            String sql = "SELECT * FROM student_result_dsa_level1 " +
                                    "INNER JOIN Users ON Users.roll_number = student_result_dsa_level1.roll_number " +
                                    "WHERE student_result_dsa_level1.score >= 23 AND Users.roll_number = ?;"; // Check if user is eligible to attempt Level 2
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1,ExamHubLoginForm.LoginHandler.getRoll_number_user());
                            resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                // If a record is found, user is eligible to attempt Level 2
                                JOptionPane.showMessageDialog(frame, "Starting Level 2 Exam");
                                isLevelCleared[1] = true;
                                String instruction = "Instructions:\n" +
                                        "1. Carefully read each question and all options.\n" +
                                        "2. Select the correct answer by clicking the radio button next to it.\n" +
                                        "3. Use 'Save & Next' to move to the next question.\n" +
                                        "4. Use 'Previous Question' to return to the last question.\n" +
                                        "5. Click 'Mark for Review' to flag questions you want to revisit later.\n" +
                                        "6. Once all questions are attempted, click 'Submit' to finalize your exam.\n\n" +
                                        "Color Coding:\n" +
                                        "- Yellow: Current question\n" +
                                        "- Green: Attempted questions\n" +
                                        "- Orange: Marked for review questions\n" +
                                        "- Light Gray: Unvisited questions\n" +
                                        "- Red: Unanswered questions";

                                JOptionPane.showMessageDialog(frame, instruction, "Exam Instructions", JOptionPane.INFORMATION_MESSAGE);

                                // Start Level 2 Exam
                                DSA_LEVEL2_EXAM_PAGE.main(new String[]{}); // Add Level 2 starting logic here
                            } else {
                                // User is not eligible
                                JOptionPane.showMessageDialog(frame, "You must complete Level 1 before attempting Level 2.");
                            }
                        } else if (currentLevel == 2) {
                            // Check eligibility for Level 3
                            String sql = "SELECT * FROM student_result_dsa_level2 " +
                                    "INNER JOIN Users ON Users.roll_number = student_result_dsa_level2.roll_number " +
                                    "WHERE student_result_dsa_level2.score >= 23 AND Users.roll_number = ?;"; // Check if user is eligible to attempt Level 3
                            preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1,ExamHubLoginForm.LoginHandler.getRoll_number_user());
                            resultSet = preparedStatement.executeQuery();

                            if (resultSet.next()) {
                                // If a record is found, user is eligible to attempt Level 3
                                JOptionPane.showMessageDialog(frame, "Starting Level 3 Exam");
                                String instruction = "Instructions:\n" +
                                        "1. Carefully read each question and all options.\n" +
                                        "2. Select the correct answer by clicking the radio button next to it.\n" +
                                        "3. Use 'Save & Next' to move to the next question.\n" +
                                        "4. Use 'Previous Question' to return to the last question.\n" +
                                        "5. Click 'Mark for Review' to flag questions you want to revisit later.\n" +
                                        "6. Once all questions are attempted, click 'Submit' to finalize your exam.\n\n" +
                                        "Color Coding:\n" +
                                        "- Yellow: Current question\n" +
                                        "- Green: Attempted questions\n" +
                                        "- Orange: Marked for review questions\n" +
                                        "- Light Gray: Unvisited questions\n" +
                                        "- Red: Unanswered questions";

                                JOptionPane.showMessageDialog(frame, instruction, "Exam Instructions", JOptionPane.INFORMATION_MESSAGE);

                                // Add Level 3 starting logic here
                                DSA_LEVEL3_EXAM_PAGE.main(new String[]{}); // Start Level 3 Exam
                            } else {
                                // User is not eligible
                                JOptionPane.showMessageDialog(frame, "You must complete Level 2 before attempting Level 3.");
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace(); // Handle SQL exceptions
                    } finally {
                        try {
                            // Clean up database resources
                            if (resultSet != null) resultSet.close();
                            if (preparedStatement != null) preparedStatement.close();
                            if (connection != null) connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                });


                examBox.add(startButton, BorderLayout.SOUTH);
                examPanel.add(examBox);
            }

            // Add the exam panel to the subject panel
            subjectPanel.add(examPanel, BorderLayout.SOUTH);
            contentPanel.add(subjectPanel);
            contentPanel.add(Box.createVerticalStrut(20)); // Space between subjects
        }


        // Create scroll pane for the content panel (so user can scroll through subjects)
        JScrollPane scrollPane = new JScrollPane(contentPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Add sidebar and scroll pane to the frame
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

    // Helper method to create an exam box (with "Start" button)
    private static JPanel createExamBox(String examName, JFrame currentFrame) {
        JPanel examBox = new JPanel();
        examBox.setLayout(new BorderLayout());
        examBox.setPreferredSize(new Dimension(200, 100)); // Increased width of exam boxes
        examBox.setBackground(new Color(230, 240, 255)); // Light blue background

        // Apply box-shadow effect using MatteBorder
        examBox.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, new Color(150, 150, 150))); // Shadow effect

        // Add exam name label to box
        JLabel examLabel = new JLabel(examName, JLabel.CENTER);
        examLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        examBox.add(examLabel, BorderLayout.CENTER);

        // Add "Start" button at the bottom of the box
        JButton startButton = new JButton("START");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(0, 102, 153)); // Teal background for button
        startButton.setForeground(Color.WHITE); // White text
        startButton.setFocusPainted(false); // Remove focus border

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle starting the exam (add your functionality here)
                currentFrame.dispose(); // Close current frame
                // Call your exam starting logic here
                // For example:
                // ExamPage.main(new String[]{examName});
            }
        });

        examBox.add(startButton, BorderLayout.SOUTH); // Add button to box

        return examBox;
    }
}

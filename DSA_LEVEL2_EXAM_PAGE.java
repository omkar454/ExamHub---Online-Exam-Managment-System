import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;

public class DSA_LEVEL2_EXAM_PAGE {

    public  static final int TOTAL_QUESTIONS = 30;
    public static int currentQuestionIndex = 0;
    public  static JLabel timerLabel;
    public  static Timer timer;
    public  static int timeRemaining = 60 * 60; // 60 minutes in seconds
    public  static JButton[] navigationButtons = new JButton[TOTAL_QUESTIONS];
    public  static boolean[] questionsAttempted = new boolean[TOTAL_QUESTIONS];
    public static boolean[] questionsMarkedForReview = new boolean[TOTAL_QUESTIONS];
    public  static JTextArea instructionsArea;
    public  static JTextArea summaryArea;
    public  static ButtonGroup optionsGroup;
    public static int[] selectedOptions = new int[TOTAL_QUESTIONS]; // Store the selected option for each question (0-3)
    public  static JRadioButton[] optionButtons;
    // L.O. Label
    public  static JLabel loLabel;

    // Array of correct answers for score calculation (assuming 1-indexed answers, modify as needed)
    private static final int[] correctAnswers = {2, 2, 1, 1, 2, 2, 1, 4, 1, 1, 3, 3, 2, 1, 3, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1};



    public static void main(String[] args) {

        // Initialize selectedOptions array with -1 (no option selected)
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            selectedOptions[i] = -1;
        }



        // Create the main frame
        JFrame frame = new JFrame("ExamHub - Exam Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(null);

        // Create "EXAMHUB" title label at the top
        JLabel titleLabel = new JLabel("DSA PRACTICAL EXAM", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(0, 20, 1200, 50);
        frame.add(titleLabel);

        // Create Exam Title label
        JTextField examTitleField = new JTextField("LEVEL 2");
        examTitleField.setFont(new Font("Arial", Font.PLAIN, 20));
        examTitleField.setHorizontalAlignment(JTextField.CENTER);
        examTitleField.setEditable(false);
        examTitleField.setBounds(50, 80, 400, 40);
        frame.add(examTitleField);
        // Create Instructions Section
        instructionsArea = new JTextArea(
                "Color Coding:\n" +
                        "- Yellow: Current question\n" +
                        "- Green: Attempted questions\n" +
                        "- Purple: Marked for review questions\n" +
                        "- Light Gray: Unvisited questions\n" +
                        "- Red: Unanswered questions"
        );

        instructionsArea.setFont(new Font("Arial", Font.PLAIN, 15));
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        instructionsArea.setBounds(50, 125, 800, 110);
        instructionsArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        instructionsArea.setEditable(false);
        frame.add(instructionsArea);


        // Create Timer label
        timerLabel = new JLabel("TIMER: 1:00:00");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        timerLabel.setForeground(Color.RED);
        timerLabel.setBounds(1050, 80, 150, 40);
        frame.add(timerLabel);

        // Method to update the L.O. label based on the current question
        loLabel = new JLabel();
        loLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loLabel.setForeground(new Color(0, 102, 153));
        loLabel.setBounds(50, 235, 600, 40); // Position just below instructions
        frame.add(loLabel);

        // Create Question number label
        JLabel questionNumberLabel = new JLabel("QUESTION 1 OF " + TOTAL_QUESTIONS + ":");
        questionNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionNumberLabel.setBounds(50, 270, 600, 40);
        frame.add(questionNumberLabel);

        // Create TextArea for the question
        JTextArea questionTextArea = new JTextArea("What is the size of an int variable in Java?");
        questionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);
        questionTextArea.setBounds(50, 310, 800, 100);
        questionTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        questionTextArea.setEditable(false);
        frame.add(questionTextArea);

        // Create RadioButtons for options
        optionButtons = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton((i + 1) + ". Option " + (i + 1));
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            optionButtons[i].setBackground(Color.WHITE);
            optionButtons[i].setBounds(50, 410 + (50 * i), 800, 40);
            frame.add(optionButtons[i]);
            optionsGroup.add(optionButtons[i]);
        }

        // Create Panel for Action Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4, 10, 10)); // 1 row, 4 columns
        buttonPanel.setBounds(50, 620, 800, 65); // Adjusted position
        frame.add(buttonPanel);

        JButton prevButton = new JButton("Previous Question");
        JButton saveNextButton = new JButton("Save & Next");
        JButton markForReviewButton = new JButton("Mark for Review");
        JButton submitButton = new JButton("Submit");

        // Set button properties
        JButton[] buttons = {prevButton, saveNextButton, markForReviewButton , submitButton};
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.setPreferredSize(new Dimension(200, 50)); // Set size
            button.setForeground(Color.WHITE);
            button.setBackground(Color.LIGHT_GRAY); // Default color
            buttonPanel.add(button);
        }

        submitButton.setBackground(Color.BLUE); // Submit button color
        prevButton.setBackground(Color.CYAN); // Previous button color
        saveNextButton.setBackground(Color.GREEN); // Save & Next button color
        markForReviewButton.setBackground(Color.MAGENTA); // Mark for Review button color

        // Create Panel for Navigation Buttons (5 buttons per row)
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridLayout(6, 5, 10, 10)); // 6 rows, 5 columns
        navigationPanel.setBorder(BorderFactory.createTitledBorder("Questions"));
        navigationPanel.setBounds(880, 240, 300, 320); // Adjusted position
        frame.add(navigationPanel);

        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            JButton button = new JButton(String.valueOf(i + 1));
            button.setFont(new Font("Arial", Font.PLAIN, 14));
            button.setBackground(Color.LIGHT_GRAY); // Default color for unvisited
            button.setForeground(Color.BLACK);
            navigationButtons[i] = button;
            int index = i; // Final variable for use in lambda
            button.addActionListener(e -> {
                navigationButtons[currentQuestionIndex].setBackground(Color.YELLOW);
                saveSelectedOption();  // in button action listener

                // If the current question hasn't been attempted or marked for review, set its button color to red
                if (!questionsAttempted[currentQuestionIndex] && !questionsMarkedForReview[currentQuestionIndex]) {
                    navigationButtons[currentQuestionIndex].setBackground(Color.RED); // Unanswered question turns red
                    updateSummary();

                }

                if(questionsAttempted[currentQuestionIndex]){
                    navigationButtons[currentQuestionIndex].setBackground(Color.GREEN);
                    updateSummary();

                }


                // Now, update to the newly selected question
                currentQuestionIndex = index;
                updateQuestion(questionTextArea, questionNumberLabel, optionsGroup);
                updateLOLabel(); // Update L.O. label when the question changes
            });

            navigationPanel.add(button);
        }

        // Create Summary Section
        summaryArea = new JTextArea(String.format("Summary:\n- Total Questions: %d\n- Questions Attempted: 0\n- Questions Marked for Review: 0\n- Questions Not Attempted: %d",
                TOTAL_QUESTIONS, TOTAL_QUESTIONS));
        summaryArea.setFont(new Font("Arial", Font.PLAIN, 16));
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        summaryArea.setBounds(880, 570, 280, 150); // Adjusted position
        summaryArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        summaryArea.setEditable(false);
        frame.add(summaryArea);

        // Set the background color of the main frame to white
        frame.getContentPane().setBackground(Color.WHITE);

        // Start the timer
        startTimer();

        // Action listeners for buttons
        prevButton.addActionListener(e -> {
            saveSelectedOption(); // Save the current option in every action listener apart from submit
            if (optionsGroup.getSelection() != null) {
                questionsAttempted[currentQuestionIndex] = true;
                navigationButtons[currentQuestionIndex].setBackground(Color.GREEN); // Attempted
            } else {
                navigationButtons[currentQuestionIndex].setBackground(Color.RED); // No option selected
            }
            if (currentQuestionIndex < TOTAL_QUESTIONS - 1) {
                currentQuestionIndex--;
                updateQuestion(questionTextArea, questionNumberLabel, optionsGroup);
            }
            updateSummary();
            updateLOLabel();
        });

        saveNextButton.addActionListener(e -> {
            saveSelectedOption(); // Save the current option in every action listener apart from submit
            if (optionsGroup.getSelection() != null) {
                questionsAttempted[currentQuestionIndex] = true;
                navigationButtons[currentQuestionIndex].setBackground(Color.GREEN); // Attempted
            } else {
                navigationButtons[currentQuestionIndex].setBackground(Color.RED); // No option selected
            }
            if (currentQuestionIndex < TOTAL_QUESTIONS - 1) {
                currentQuestionIndex++;
                updateQuestion(questionTextArea, questionNumberLabel, optionsGroup);
            }
            updateSummary();
            updateLOLabel();
        });

        submitButton.addActionListener(e -> {
            int score = calculateScore(); // Calculate the final score
            JOptionPane.showMessageDialog(frame, "Exam submitted! Your score: " + score + "/" + TOTAL_QUESTIONS);
            int Lo_1Score = calculateScore_LO1();
            int Lo_2Score = calculateScore_LO2();
            int Lo_3Score = calculateScore_LO3();
            int Lo_4Score = calculateScore_LO4();
            int Lo_5Score = calculateScore_LO5();
            int Lo_6Score = calculateScore_LO6();
            JOptionPane.showMessageDialog(frame, "TOTAL SCORE: " + score + "/" + TOTAL_QUESTIONS
                    +"\n L.O-1 SCORE: "+ Lo_1Score+"/"+5
                    +"\n L.O-2 SCORE: "+ Lo_2Score+"/"+5
                    +"\n L.O-3 SCORE: "+ Lo_3Score+"/"+5
                    +"\n L.O-4 SCORE: "+ Lo_4Score+"/"+5
                    +"\n L.O-5 SCORE: "+ Lo_5Score+"/"+5
                    +"\n L.O-6 SCORE: "+ Lo_6Score+"/"+5);


            try {
                ExamHubRegistrationForm1.getSavedRollNumber();
                insertScoreIntoTable(calculateScore());
                insertScoreIntoTable_Lo_1Scores(calculateScore_LO1());
                insertScoreIntoTable_Lo_2Scores(calculateScore_LO2());
                insertScoreIntoTable_Lo_3Scores(calculateScore_LO3());
                insertScoreIntoTable_Lo_4Scores(calculateScore_LO4());
                insertScoreIntoTable_Lo_5Scores(calculateScore_LO5());
                insertScoreIntoTable_Lo_6Scores(calculateScore_LO6());
                System.out.println("SCORE STORED IN DATA-BASE");
                frame.dispose(); // Close the application
                newresult.main(new String[]{});
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });



        markForReviewButton.addActionListener(e -> {
            saveSelectedOption(); // Save the current option in every action listener apart from submit
            questionsMarkedForReview[currentQuestionIndex] = true;
            navigationButtons[currentQuestionIndex].setBackground(Color.MAGENTA); // Purple for marked for review
            if (currentQuestionIndex < TOTAL_QUESTIONS - 1) {
                currentQuestionIndex++;
                updateQuestion(questionTextArea, questionNumberLabel, optionsGroup);
            }
            updateSummary();
            updateLOLabel();
        });

        updateLOLabel();

        // Set the frame visible
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    // Array of questions
    private static final String[] questions = {
            "Which data structure is used for implementing recursion?",
            "What is the time complexity of accessing an element in an array by index?",
            "Which algorithm is used to find the minimum spanning tree in a graph?",
            "What is the primary advantage of using a linked list over an array?",
            "Which sorting algorithm is the best in terms of time complexity for large datasets?",
            "What is a deque (double-ended queue)?",
            "In a binary search tree, what is the property of a node’s left child?",
            "Which of the following algorithms uses divide-and-conquer to solve a problem?",
            "What is the worst-case time complexity of selection sort?",
            "Which data structure is most suitable for implementing backtracking algorithms?",
            "What is the purpose of a sentinel node in a linked list?",
            "Which traversal technique visits the root node first in a binary tree?",
            "What is the space complexity of iterative depth-first search (DFS)?",
            "In a max-heap, what property does the root node always have?",
            "What is the amortized time complexity for inserting an element in a dynamic array?",
            "What is the minimum number of edges required to form a cycle in a graph?",
            "Which data structure can be used to implement a LRU (Least Recently Used) cache?",
            "What is the worst-case time complexity for inserting a node in a red-black tree?",
            "Which algorithm is used to find all pairs shortest paths in a graph?",
            "What is the maximum number of nodes in a binary tree of height 'h'?",
            "What is the time complexity of Floyd-Warshall algorithm?",
            "Which data structure is used for solving the Tower of Hanoi problem?",
            "Which data structure uses a hierarchical organization?",
            "What is the key difference between BFS and DFS in terms of node processing order?",
            "Which sorting algorithm is stable by default?",
            "What is the best-case time complexity of bubble sort?",
            "Which algorithm is most suitable for finding the topological sort of a directed acyclic graph?",
            "What is the time complexity of binary search in a sorted array?",
            "What is a degenerate (or pathological) tree in binary trees?",
            "Which data structure is ideal for solving the knapsack problem?"
    };

    // Array of options for each question
    private static final String[][] options = {
            {"Stack", "Queue", "Array", "Hash Table"},
            {"O(1)", "O(n)", "O(log n)", "O(n^2)"},
            {"Kruskal's Algorithm", "Dijkstra's Algorithm", "A* Algorithm", "Bellman-Ford Algorithm"},
            {"Efficient memory usage", "Constant time access", "Faster sorting", "Faster searching"},
            {"Merge Sort", "Insertion Sort", "Bubble Sort", "Heap Sort"},
            {"A queue that allows insertion and deletion from both ends", "A queue with dynamic resizing", "A priority queue with dual priorities", "None of the above"},
            {"It is greater than the node", "It is smaller than the node", "It is equal to the node", "It is a random value"},
            {"Merge Sort", "Bubble Sort", "Insertion Sort", "Selection Sort"},
            {"O(n^2)", "O(n log n)", "O(log n)", "O(n)"},
            {"Stack", "Queue", "Array", "Hash Table"},
            {"To mark the beginning or end of the list", "To store the value of the last node", "To prevent memory leaks", "None of the above"},
            {"Preorder", "Inorder", "Postorder", "Level-order"},
            {"O(V+E)", "O(V)", "O(E log V)", "O(log V)"},
            {"It has the smallest value", "It has the largest value", "It is smaller than its children", "It is larger than its children"},
            {"O(1)", "O(log n)", "O(n)", "O(n^2)"},
            {"1", "2", "3", "Depends on the graph", "0"},
            {"Hash Map", "Linked List", "Stack", "Queue"},
            {"O(log n)", "O(n log n)", "O(1)", "O(n)"},
            {"Dijkstra's Algorithm", "Floyd-Warshall Algorithm", "Bellman-Ford Algorithm", "Kruskal's Algorithm"},
            {"2^h", "h^2", "2^(h+1) - 1", "h + 1"},
            {"O(n^3)", "O(n log n)", "O(n^2)", "O(n)"},
            {"Stack", "Queue", "Heap", "Priority Queue"},
            {"Heap", "Graph", "Tree", "Linked List"},
            {"DFS explores as deep as possible before backtracking; BFS explores all nodes level by level", "BFS explores as deep as possible before backtracking; DFS explores all nodes level by level", "BFS explores paths randomly; DFS explores level by level", "None of the above"},
            {"Merge Sort", "Quick Sort", "Heap Sort", "Selection Sort"},
            {"O(n)", "O(n log n)", "O(n^2)", "O(1)"},
            {"Kruskal's Algorithm", "Prim's Algorithm", "Topological Sort", "Tarjan's Algorithm"},
            {"O(log n)", "O(n)", "O(n^2)", "O(1)"},
            {"A tree where each node has only one child", "A tree with nodes arranged in random order", "A tree that is fully balanced", "A tree with no children"},
            {"Dynamic Programming", "Greedy Algorithm", "Backtracking", "Divide and Conquer"}
    };


    // Save the currently selected option for the current question
    private static void saveSelectedOption() {
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selectedOptions[currentQuestionIndex] = i;
                questionsAttempted[currentQuestionIndex] = true; // Mark question as attempted
                break;
            }
        }
    }






    // Update the selected option when navigating back to a question
    private static void updateQuestion(JTextArea questionTextArea, JLabel questionNumberLabel, ButtonGroup optionsGroup) {
        questionTextArea.setText(questions[currentQuestionIndex]);
        questionNumberLabel.setText("QUESTION " + (currentQuestionIndex + 1) + " OF " + TOTAL_QUESTIONS + ":");
        optionsGroup.clearSelection(); // Clear previous selection

        // Update radio buttons with current options
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(options[currentQuestionIndex][i]);
        }

        // Restore the previously selected option if one was chosen
        if (selectedOptions[currentQuestionIndex] != -1) {  // -1 means no option was selected before
            optionButtons[selectedOptions[currentQuestionIndex]].setSelected(true); // Set the previously selected option
        }

        navigationButtons[currentQuestionIndex].setBackground(Color.YELLOW); // Current question in Yellow
    }



    private static void updateSummary() {
        int attemptedCount = 0;
        int reviewCount = 0;
        for (boolean attempted : questionsAttempted) {
            if (attempted) {
                attemptedCount++;
            }
        }
        for (boolean review : questionsMarkedForReview) {
            if (review) {
                reviewCount++;
            }
        }
        summaryArea.setText(String.format("Summary:\n- Total Questions: %d\n- Questions Attempted: %d\n- Questions Marked for Review: %d\n- Questions Not Attempted: %d",
                TOTAL_QUESTIONS, attemptedCount, reviewCount, TOTAL_QUESTIONS - attemptedCount));
    }



    private static void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeRemaining--;
                int minutes = timeRemaining / 60;
                int seconds = timeRemaining % 60;
                timerLabel.setText(String.format("TIMER: %d:%02d", minutes, seconds));

                if (timeRemaining <= 0) {
                    timer.cancel();
                    timerLabel.setText("TIMER: 0:00");
                    JOptionPane.showMessageDialog(null, "Time's up! The exam will now be submitted.");
                    int score = calculateScore(); // Calculate the final score
                    JOptionPane.showMessageDialog(null, "Exam submitted! Your score: " + score + "/" + TOTAL_QUESTIONS);

                    // Automatically close the application or proceed to result page
                    // Add your result processing or navigation logic here
                    newresult.main(new String[]{}); // Assuming newresult is the class for result page
                }
            }
        }, 1000, 1000); // Runs every 1 second
    }





    // Calculate the final score based on correct answers
    private static int calculateScore() {
        int score = 0;
        for (int i = 0; i < TOTAL_QUESTIONS; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                score++;
            }
        }
        return score;
    }

    // Calculate the final Lo_1score based on correct answers
    private static int calculateScore_LO1() {
        int LO1_score = 0;
        for (int i = 0; i < 5; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                LO1_score++;
            }
        }
        return LO1_score;
    }

    private static int calculateScore_LO2() {
        int LO2_score = 0;
        for (int i = 5; i < 9; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                LO2_score++;
            }
        }
        return LO2_score;
    }

    private static int calculateScore_LO3() {
        int LO3_score = 0;
        for (int i = 9; i < 14; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                LO3_score++;
            }
        }
        return LO3_score;
    }

    private static int calculateScore_LO4() {
        int LO4_score = 0;
        for (int i = 14; i < 19; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                LO4_score++;
            }
        }
        return LO4_score;
    }

    private static int calculateScore_LO5() {
        int LO5_score = 0;
        for (int i = 19; i < 24; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                LO5_score++;
            }
        }
        return LO5_score;
    }

    private static int calculateScore_LO6() {
        int LO6_score = 0;
        for (int i = 24; i < 29; i++) {
            if (selectedOptions[i] == correctAnswers[i] - 1) { // Correct if selected option matches the correct answer
                LO6_score++;
            }
        }
        return LO6_score;
    }



    // Method to insert user data into database
    public static void insertScoreIntoTable(int score) throws SQLException {


        //   Establish database connection
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2 (Roll_number,score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }


    // Method to update the L.O. label based on the current question
    public static void updateLOLabel(){
        if (currentQuestionIndex >= 0 && currentQuestionIndex <= 4) {
            loLabel.setText("L.O.-1 QUESTIONS:");
        } else if (currentQuestionIndex >= 5 && currentQuestionIndex <= 9) {
            loLabel.setText("L.O.-2 QUESTIONS:");
        } else if (currentQuestionIndex >= 10 && currentQuestionIndex <= 14) {
            loLabel.setText("L.O.-3 QUESTIONS:");
        } else if (currentQuestionIndex >= 15 && currentQuestionIndex <= 19) {
            loLabel.setText("L.O.-4 QUESTIONS:");
        } else if (currentQuestionIndex >= 20 && currentQuestionIndex <= 24) {
            loLabel.setText("L.O.-5 QUESTIONS:");
        } else if (currentQuestionIndex >= 25 && currentQuestionIndex <= 29) {
            loLabel.setText("L.O.-6 QUESTIONS:");
        } else {
            loLabel.setText("");
        }

    }


    // Method to insert user data into database
    public static void insertScoreIntoTable_Lo_1Scores(int score) throws SQLException {


        //   Establish database connection
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2_lo1 (Roll_number,lo1_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }

    public static void insertScoreIntoTable_Lo_2Scores(int score) throws SQLException {


        //   Establish database connection
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2_lo2 (Roll_number,lo2_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }

    public static void insertScoreIntoTable_Lo_3Scores(int score) throws SQLException {


        //   Establish database connection
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2_lo3 (Roll_number,lo3_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }

    public static void insertScoreIntoTable_Lo_4Scores(int score) throws SQLException {


        //   Establish database connection
        DataBase_Credentials db = new DataBase_Credentials();
        String url = db.JDBC_url;
        String user = db.username;
        String pass = db.password;

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2_lo4 (Roll_number,lo4_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }

    public static void insertScoreIntoTable_Lo_5Scores(int score) throws SQLException {


        //   Establish database connection
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2_lo5 (Roll_number,lo5_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }

    public static void insertScoreIntoTable_Lo_6Scores(int score) throws SQLException {


        //   Establish database connection
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_dsa_level2_lo6 (Roll_number,lo6_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "dsa");
            preparedStatement.setInt(4, 2);

            // Execute update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            connection.close();
        }
        else {
            // Handle the case where the roll number is null
            System.out.println("Roll number is not set. Please register first.");
        }
    }




}

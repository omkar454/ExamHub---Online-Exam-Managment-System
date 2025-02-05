import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;

public class JAVA_LEVEL3_EXAM_PAGE {

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
    public  static JRadioButton[] optionButtons;
    public static int[] selectedOptions = new int[TOTAL_QUESTIONS]; // Store the selected option for each question (0-3)
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
        JLabel titleLabel = new JLabel("JAVA PRACTICAL EXAM", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setBounds(0, 20, 1200, 50);
        frame.add(titleLabel);

        // Create Exam Title label
        JTextField examTitleField = new JTextField("LEVEL 3");
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


    // Array of questions
    private static final String[] questions = {
            "What is the difference between an interface and an abstract class in Java?",
            "What is the purpose of the 'synchronized' keyword in Java?",
            "How do you define a constant in Java?",
            "What is the purpose of the 'transient' keyword in Java?",
            "What is a lambda expression in Java?",
            "What is the difference between the '== operator' and the 'compareTo()' method in Java?",
            "What is the significance of the 'main()' method in Java?",
            "Which method is called when an object is garbage collected in Java?",
            "What is the difference between 'throw' and 'throws' in Java?",
            "What is the purpose of the 'enum' keyword in Java?",
            "What are wrapper classes in Java?",
            "What is the difference between 'List' and 'Set' in Java?",
            "What does the 'extends' keyword mean in Java?",
            "What is the purpose of the 'instanceof' keyword in Java?",
            "How do you create a singleton class in Java?",
            "What is autoboxing and unboxing in Java?",
            "What is the 'native' keyword used for in Java?",
            "What is the 'volatile' keyword used for in Java?",
            "What is method overriding in Java?",
            "What are annotations in Java?",
            "What is the purpose of a 'package' in Java?",
            "What is a marker interface in Java?",
            "What is a checked exception in Java?",
            "What is a thread pool in Java?",
            "What is the difference between 'process' and 'thread' in Java?",
            "Which of the following is not a valid access modifier in Java?",
            "What is the use of the 'this' keyword in Java?",
            "Which of the following is the root class of all Java classes?",
            "How do you handle multiple exceptions in a single catch block in Java?",
            "Which of these is used to create a new thread in Java?"
    };


    // Array of options for each question
    private static final String[][] options = {
            {"An interface can have default methods, an abstract class cannot", "An abstract class can have instance variables, an interface cannot", "Both can be instantiated", "None of the above"},
            {"To make a method synchronized", "To prevent multiple threads from accessing a block of code simultaneously", "To stop a thread", "None of the above"},
            {"Using 'const' keyword", "Using 'final' keyword", "Using 'static' keyword", "None of the above"},
            {"To prevent serialization of a field", "To make a field static", "To make a field final", "None of the above"},
            {"An anonymous function", "A way to create threads", "A new data type", "None of the above"},
            {"'==' compares object references, 'compareTo()' compares values", "'==' compares values, 'compareTo()' compares object references", "Both do the same", "None of the above"},
            {"It is the entry point of any Java program", "It is the exit point of a Java program", "It initializes all objects", "None of the above"},
            {"finalize()", "dispose()", "cleanUp()", "None of the above"},
            {"'throw' is used to throw an exception, 'throws' is used to declare exceptions", "'throws' is used to throw an exception, 'throw' is used to declare exceptions", "Both do the same", "None of the above"},
            {"To define a set of constants", "To create multiple threads", "To manage exceptions", "None of the above"},
            {"Classes that encapsulate primitive data types", "Classes that wrap objects", "Classes used for inheritance", "None of the above"},
            {"List allows duplicates, Set does not", "Set allows duplicates, List does not", "Both allow duplicates", "None of the above"},
            {"Indicates inheritance", "Indicates composition", "Indicates polymorphism", "None of the above"},
            {"Checks if an object is an instance of a class", "Creates a new instance of a class", "Deletes an instance", "None of the above"},
            {"By making the constructor private", "By using the 'synchronized' keyword", "By using 'final' keyword", "None of the above"},
            {"Automatic conversion between primitive types and wrapper classes", "Automatic conversion between strings and objects", "Both A and B", "None of the above"},
            {"To call native (non-Java) methods", "To make a method static", "To make a method synchronized", "None of the above"},
            {"To ensure visibility of changes across threads", "To make a method synchronized", "To prevent deadlock", "None of the above"},
            {"When a subclass provides a specific implementation of a method in its superclass", "When a class has multiple methods with the same name", "Both A and B", "None of the above"},
            {"Metadata about the code", "Used to override methods", "Used to define constants", "None of the above"},
            {"To group related classes and interfaces", "To manage memory", "To handle exceptions", "None of the above"},
            {"An interface with no methods", "An interface with only one method", "An abstract class", "None of the above"},
            {"An exception that is checked at runtime", "An exception that must be declared or handled", "An exception that is ignored by the compiler", "None of the above"},
            {"A collection of threads", "A pool of processes", "A set of tasks", "None of the above"},
            {"A process is a single thread of execution, a thread is a subprocess", "A process is an instance of a program, a thread is a smaller unit of a process", "Both are the same", "None of the above"},
            {"public", "private", "protected", "internal"},
            {"To refer to the current object", "To create a new object", "To call the superclass constructor", "To terminate the program"},
            {"java.util.Class", "java.lang.Object", "java.lang.Class", "java.util.Object"},
            {"By using multiple catch blocks", "By using | (pipe) symbol", "By using multiple try blocks", "Java doesn’t support multiple exception handling"},
            {"Runnable interface", "Callable interface", "Both a and b", "Cloneable interface"}

    };



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


    // Method to insert user data into database
    public static void insertScoreIntoTable(int score) throws SQLException {


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
            String sql = "INSERT INTO student_result_java_level3 (Roll_number,score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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
            String sql = "INSERT INTO student_result_java_level3_lo1 (Roll_number,lo1_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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
            String sql = "INSERT INTO student_result_java_level3_lo2 (Roll_number,lo2_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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
            String sql = "INSERT INTO student_result_java_level3_lo3 (Roll_number,lo3_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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
        String url = "jdbc:mysql://localhost:3306/ExamHub";
        String user = "root";
        String pass = "OmRaut@04";

        Connection connection = DriverManager.getConnection(url, user, pass);

        String rollNumber = ExamHubLoginForm.LoginHandler.getRoll_number_user();

        if (rollNumber != null) {
            // Proceed with using the roll number
            System.out.println("Roll Number: " + rollNumber);

            // Prepare SQL statement
            String sql = "INSERT INTO student_result_java_level3_lo4 (Roll_number,lo4_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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
            String sql = "INSERT INTO student_result_java_level3_lo5 (Roll_number,lo5_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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
            String sql = "INSERT INTO student_result_java_level3_lo6 (Roll_number,lo6_score, exam_name, level) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rollNumber);
            preparedStatement.setInt(2, score);
            preparedStatement.setString(3, "JAVA");
            preparedStatement.setInt(4, 3);

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

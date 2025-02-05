import javax.swing.*;
import java.awt.*;

public class CertificatePage {

    private String studentName;
    private String rollNumber;
    private String subject;
    private String levelCleared;
    private String year;
    private String department;
    private int score; // Change this to int if you want to keep score as an integer

    // Constructor
    public CertificatePage(String studentName, String rollNumber, String subject, String levelCleared, String year, String department, int score) {
        // Assign constructor parameters to instance variables
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.subject = subject;
        this.levelCleared = levelCleared;
        this.year = year;
        this.department = department;
        this.score = score; // Assign the integer score
    }

    public void displayCertificate() {
        // Create frame for certificate
        JFrame frame = new JFrame("Certificate of Achievement");
        frame.setSize(1300, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Outer panel (sky blue background)
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(new Color(135, 206, 235));
        outerPanel.setLayout(new GridBagLayout());
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Inner panel (white background) for certificate content
        JPanel certificatePanel = new JPanel();
        certificatePanel.setPreferredSize(new Dimension(1200, 700));
        certificatePanel.setBackground(Color.WHITE);
        certificatePanel.setLayout(new GridBagLayout());
        certificatePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);

        // College name header
        JLabel collegeLabel = new JLabel("Thadomal Shahani Engineering College", JLabel.CENTER);
        collegeLabel.setFont(new Font("Serif", Font.BOLD, 40));
        collegeLabel.setForeground(new Color(0, 102, 204)); // Dark blue color
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        certificatePanel.add(collegeLabel, gbc);

        // Certificate Title (Heading)
        JLabel titleLabel = new JLabel("Certificate of Achievement", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        titleLabel.setForeground(new Color(0, 102, 204));
        gbc.gridy = 1;
        certificatePanel.add(titleLabel, gbc);

        // "This is to certify that"
        JLabel certifyLabel = new JLabel("This is to certify that", JLabel.CENTER);
        certifyLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        gbc.gridy = 2;
        certificatePanel.add(certifyLabel, gbc);

        // Student Name
        JLabel studentNameLabel = new JLabel(studentName, JLabel.CENTER);
        studentNameLabel.setFont(new Font("Serif", Font.BOLD, 36));
        gbc.gridy = 3;
        certificatePanel.add(studentNameLabel, gbc);

        // Paragraph content
        String paragraph = String.format(
                "<html><div style='text-align: center;'>" +
                        "with Roll Number: <b>%s</b>, and studying in <b>%s</b>  of <b>%s</b>,<br><br>" +
                        "has successfully cleared the <b>level %s</b>  in the Subject: <b>%s</b> with Score: <b>%d/30</b>.<br><br>" +
                        "We hereby recognize the effort and success achieved.<br><br>" +
                        "<b>Congratulations!!!<b>" +
                        "</div></html>", rollNumber, year, department, levelCleared, subject, score); // Use %d for int

        JLabel contentLabel = new JLabel(paragraph, JLabel.CENTER);
        contentLabel.setFont(new Font("Serif", Font.PLAIN, 28));
        gbc.gridy = 4;
        certificatePanel.add(contentLabel, gbc);

        // Randomized signatures at the bottom
        String[] signatures = {"Dr. G.T. Thampi", "Dr. Mukesh Israni"};
        JLabel signatureLabel1 = new JLabel("<html>______________________<br>" + signatures[0] + "</html>");
        JLabel signatureLabel2 = new JLabel("<html>______________________<br>" + signatures[1] + "</html>");
        signatureLabel1.setFont(new Font("Serif", Font.PLAIN, 20));
        signatureLabel2.setFont(new Font("Serif", Font.PLAIN, 20));

        // Set positions for signatures
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        certificatePanel.add(signatureLabel1, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.SOUTHEAST;
        certificatePanel.add(signatureLabel2, gbc);

        // Add the white certificate panel to the sky blue outer panel
        outerPanel.add(certificatePanel);

        // Add the outer panel to the frame
        frame.add(outerPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        String subjectName = StudentDashboard.CertificateData.getSubjectName();
        String levelName = StudentDashboard.CertificateData.getLevelName();
        int score = StudentDashboard.CertificateData.getScore(); // Ensure this returns an integer

        String year = "Second Year";
        String department = "Information Technology";

        // Pass the score as an integer
        CertificatePage certificate = new CertificatePage(
                ExamHubLoginForm.LoginHandler.getLoggedInUsername(),
                ExamHubLoginForm.LoginHandler.getRoll_number_user(),
                subjectName,
                levelName,
                year,
                department,
                score // Pass score as an integer
        );
        certificate.displayCertificate();
    }
}

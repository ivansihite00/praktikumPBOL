import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthApp extends JFrame {
    private JPanel mainPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField nameField;
    
    public AuthApp() {
        setTitle("Login and Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);
        
        showLoginForm();
    }

    private void showLoginForm() {
        mainPanel.removeAll();
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);
        
        // Email field
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Email:"), gbc);
        
        emailField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);
        
        // Password field
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Password:"), gbc);
        
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);
        
        // Login button
        JButton loginButton = new JButton("Submit Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginButton.addActionListener(e -> handleLogin());
        formPanel.add(loginButton, gbc);
        
        // Switch to Register button
        JButton registerSwitchButton = new JButton("Register");
        registerSwitchButton.addActionListener(e -> showRegisterForm());
        gbc.gridy = 4;
        formPanel.add(registerSwitchButton, gbc);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void showRegisterForm() {
        mainPanel.removeAll();
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JLabel titleLabel = new JLabel("Register");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(titleLabel, gbc);
        
        // Name field
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Nama:"), gbc);
        
        nameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);
        
        // Email field
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Email:"), gbc);
        
        emailField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);
        
        // Password field
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Password:"), gbc);
        
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);
        
        // Register button
        JButton registerButton = new JButton("Submit Register");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        registerButton.addActionListener(e -> handleRegister());
        formPanel.add(registerButton, gbc);
        
        // Switch to Login button
        JButton loginSwitchButton = new JButton("Login");
        loginSwitchButton.addActionListener(e -> showLoginForm());
        gbc.gridy = 5;
        formPanel.add(loginSwitchButton, gbc);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void handleLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        // Implement login validation here
        JOptionPane.showMessageDialog(this, "Login successful for " + email);
    }

    private void handleRegister() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        // Implement register logic here
        JOptionPane.showMessageDialog(this, "Registration successful for " + name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AuthApp app = new AuthApp();
            app.setVisible(true);
        });
    }
}

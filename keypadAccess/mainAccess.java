import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeypadAccessSystem extends JFrame implements ActionListener {
    private static final String CORRECT_PASSWORD = "1234"; // Default password
    private StringBuilder enteredPassword;
    private JTextField displayField;
    private JLabel statusLabel;
    private JButton[] numberButtons;
    private JButton clearButton, enterButton;
    
    public KeypadAccessSystem() {
        enteredPassword = new StringBuilder();
        initializeComponents();
        setupLayout();
        setFrameProperties();
    }
    
    private void initializeComponents() {
        
        displayField = new JTextField(10);
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 18));
        displayField.setHorizontalAlignment(JTextField.CENTER);
        
      
        statusLabel = new JLabel("Enter Password", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setForeground(Color.BLUE);
        
       
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setPreferredSize(new Dimension(60, 50));
        }
        
       
        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.addActionListener(this);
        clearButton.setBackground(Color.ORANGE);
        
        enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Arial", Font.BOLD, 14));
        enterButton.addActionListener(this);
        enterButton.setBackground(Color.GREEN);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(displayField, BorderLayout.CENTER);
        topPanel.add(statusLabel, BorderLayout.SOUTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
       
        JPanel keypadPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        
       
        keypadPanel.add(numberButtons[1]);
        keypadPanel.add(numberButtons[2]);
        keypadPanel.add(numberButtons[3]);
        keypadPanel.add(numberButtons[4]);
        keypadPanel.add(numberButtons[5]);
        keypadPanel.add(numberButtons[6]);
        keypadPanel.add(numberButtons[7]);
        keypadPanel.add(numberButtons[8]);
        keypadPanel.add(numberButtons[9]);
        keypadPanel.add(clearButton);
        keypadPanel.add(numberButtons[0]);
        keypadPanel.add(enterButton);
        
        keypadPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        add(topPanel, BorderLayout.NORTH);
        add(keypadPanel, BorderLayout.CENTER);
    }
    
    private void setFrameProperties() {
        setTitle("Keypad Access System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null); 
    }
    
































    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.matches("[0-9]")) {
            if (enteredPassword.length() < 8) { // Limit password length
                enteredPassword.append(command);
                updateDisplay();
            }
        } else if (command.equals("Clear")) {
            enteredPassword.setLength(0);
            updateDisplay();
            resetStatus();
        } else if (command.equals("Enter")) {
            checkPassword();
        }
    }
    
    private void updateDisplay() {
        StringBuilder display = new StringBuilder();
        for (int i = 0; i < enteredPassword.length(); i++) {
            display.append("*");
        }
        displayField.setText(display.toString());
    }
    
    private void checkPassword() {
        String password = enteredPassword.toString();
        
        if (password.equals(CORRECT_PASSWORD)) {
            statusLabel.setText("ACCESS GRANTED!");
            statusLabel.setForeground(Color.GREEN);
            
            JOptionPane.showMessageDialog(this, 
                "Welcome! Access Granted.", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
                
        } else {
            statusLabel.setText("ACCESS DENIED!");
            statusLabel.setForeground(Color.RED);
            
            JOptionPane.showMessageDialog(this, 
                "Incorrect password. Access denied.", 
                "Access Denied", 
                JOptionPane.ERROR_MESSAGE);
        }
        
        enteredPassword.setLength(0);
        updateDisplay();
        
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetStatus();
                ((Timer)e.getSource()).stop();
            }
        });
        timer.start();
    }
    
    private void resetStatus() {
        statusLabel.setText("Enter Password");
        statusLabel.setForeground(Color.BLUE);
    }
    

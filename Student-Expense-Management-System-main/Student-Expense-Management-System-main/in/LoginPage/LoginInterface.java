package in.LoginPage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import in.UserInterface.MainInterface;
import in.UserInterface.SignUp;
import in.Utility.Utility;


public class LoginInterface extends JFrame implements ActionListener, MouseListener{
    
    // These are the Global Variable Declearations 

    JLabel backgroundImage;     // this is the background Image
    JLabel _forgotPassword;
    JButton _exit, _login, _createAccount;
    JTextField _nameField, _passwordField;
    
    




    // This is the constructor
    public LoginInterface() {
        setBackground();
        

        // adding the components inside the Frame
        addButtons();
        addLabels();
        addTextFields();
        addBoxes();

        Utility.setFrame(this, 800, 1000, "Login Interface");
        
        

    }

    // These are the textFields 
    public void addTextFields() {
        _nameField = new JTextField("Enter Your EMAIL");
        _nameField.setForeground(Color.BLACK);
        _nameField.setFont(new Font("System", Font.BOLD, 18));
        _nameField.setHorizontalAlignment(JTextField.CENTER);
        _nameField.setBounds(180, 340, 450, 50);
        _nameField.setOpaque(false);

        Border customBorder = new LineBorder(Color.darkGray, 5, true);
        _nameField.setBorder(customBorder);
        backgroundImage.add(_nameField);

        Utility.addFocusListernerOnField(_nameField, "Enter Your EMAIL");


        _passwordField = new JTextField("Enter Your Password");
        _passwordField.setForeground(Color.BLACK);
        _passwordField.setFont(new Font("System", Font.BOLD, 18));
        _passwordField.setHorizontalAlignment(JTextField.CENTER);
        _passwordField.setBounds(180, 420, 450, 50);
        _passwordField.setOpaque(false);    // this prevent default opauque rendering

        Border customBorderPassword = new LineBorder(Color.DARK_GRAY, 5, true);
        _passwordField.setBorder(customBorderPassword);
        backgroundImage.add(_passwordField);

        Utility.addFocusListernerOnField(_passwordField, "Enter Your Password");

    }

    // This is the invisible label  --> To loose the focus from the textFields
    public void addInvisibleLabel() {
        JLabel invisbleLabel = new JLabel();
        invisbleLabel.setBounds(0, 0, 0, 0);
        invisbleLabel.setFocusable(true);
        backgroundImage.add(invisbleLabel);
    }

    // this is the method that is making the tranparent box in the frame
    public void addBoxes() {
        JPanel frameBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f)); // 0.7f for 50% opacity
                g2d.setColor(Color.white); // Background color
                // Enable anti-aliasing for smoother corners
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a rounded rectangle
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 150, 150); // 50 is the arc width and height

            }
        };
        frameBox.setBounds(125, 250, 550, 450);
        frameBox.setOpaque(false); // Prevents default opaque rendering
        backgroundImage.add(frameBox);
    }
    

    public void addLabels() {
        addInvisibleLabel();    // This is for diverging the foucus of the mouse


        JLabel pageInfo = new JLabel("STUDENT EXPENSE MANAGEMENT SYSTEM");
        pageInfo.setFont(new Font("System", Font.BOLD, 27));
        pageInfo.setForeground(Color.decode("#0c1160"));
        pageInfo.setBounds(80, 130, 700, 50);
        backgroundImage.add(pageInfo);

        _forgotPassword = new JLabel("Forgotten Passoword");
        _forgotPassword.setFont(new Font("System", Font.PLAIN, 18));
        _forgotPassword.setForeground(Color.BLACK);
        _forgotPassword.setBounds(300, 580, 220, 25);
        backgroundImage.add(_forgotPassword);
        
        _forgotPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Redirecting to password reset page");
            }
        });
    }





    // This is for the definition of the Buttons on the JLabel
    public void addButtons() {

        // JButton --> Exit
        _exit = Utility.createRoundedButton("EXIT", 600, 900, 150, 50);
        _exit.addActionListener(this);
        Utility.addMouseColorChange(_exit, Color.black, Color.white);
        backgroundImage.add(_exit);


        // JButton --> Loginn
        _login = new JButton("Login");
        _login.setBounds(180, 500, 450, 50);
        _login.setFont(new Font("System", Font.BOLD, 20));
        _login.setForeground(Color.white);
        _login.setBackground(Color.decode("#464bf7"));
        _login.addActionListener(this);
        _login.setFocusable(false);
        backgroundImage.add(_login);


        // JButton --> createAccount
        _createAccount = new JButton("Create Account");
        _createAccount.setFont(new Font("System", Font.BOLD, 20));
        _createAccount.setForeground(Color.white);
        _createAccount.setBackground(Color.decode("#00c812"));
        _createAccount.setBounds(225, 630, 350, 50);
        _createAccount.addActionListener(this);
        _createAccount.setFocusable(false);
        backgroundImage.add(_createAccount);

    }


    // This is for the image of the background
    public void setBackground() {

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("in/Images/bgImage.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(800, 1400, Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(image);

        backgroundImage = new JLabel(finalImage);
        backgroundImage.setBounds(0, 0, 800, 1400);
        this.add(backgroundImage);
    }



    // This is the ActionPerforemend method for the different actions on the page
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _exit) {
            System.exit(0);
        } else if(e.getSource() == _login) {
            setVisible(false);
            // new MainInterface();
            SwingUtilities.invokeLater(() -> new MainInterface());

        } else if(e.getSource() == _createAccount) {
            setVisible(false);
            new SignUp();
        }
       
    }


    
    // These are the abstract methods of the MouseListener Interface
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    
    @Override
    public void mouseEntered(MouseEvent e) {
      
    }
    
    
    @Override
    public void mouseExited(MouseEvent e) {

    }


    
    // this is the main method
    public static void main(String... args) {
        // new LoginInterface();
        SwingUtilities.invokeLater(() -> new LoginInterface());

    }



}

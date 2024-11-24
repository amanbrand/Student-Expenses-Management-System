package in.UserInterface;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.awt.event.*;

import in.LoginPage.LoginInterface;
import in.Utility.Utility;
import javax.swing.border.*;



public class SignUp extends JFrame implements ActionListener, MouseListener {

    // Global Variable Declaration
    JLabel backgroundImage;     
    JTextField _firstName, _lastName, _mobileNumber, _emailID, _newPassword, _retypePassword;
    JButton _submit, _back;
    JLabel _imageLabel;
    JPanel translucentPanel;


    // Constructor
    public SignUp() {

        backgroundImage = Utility.setImage("in/Images/signUp.jpg", 1920, 1130);
        add(backgroundImage);
        addLabels();
        addButton();
        addTextFields();
        
        translucentPanel = Utility.addTranslucentPanel(Color.darkGray, 0.7f, 360, 50, 1200, 1020);
        backgroundImage.add(translucentPanel);
        Utility.setFrame(this, 1920, 1130, "SingUp Details");

    }

    // Adding TextFields
    public void addTextFields() {

        // This is the FirstName TextField
        _firstName = new JTextField("ENTER YOUR FIRST NAME");
        _firstName.setFont(new Font("SansSerif", Font.BOLD, 18));
        _firstName.setForeground(Color.white);
        _firstName.setHorizontalAlignment(JTextField.CENTER);
        _firstName.setOpaque(false);
        _firstName.setBounds(800, 270, 400, 50);
        
        Border nameBorder = new LineBorder(Color.darkGray, 3, true);
        _firstName.setBorder(nameBorder);
        backgroundImage.add(_firstName);
        
        Utility.addFocusListernerOnField(_firstName, "ENTER YOUR FIRST NAME");


        // This is the lastName TextField
        _lastName = new JTextField("ENTER YOUR LAST NAME");
        _lastName.setFont(new Font("SansSerif", Font.BOLD, 18));
        _lastName.setForeground(Color.white);
        _lastName.setHorizontalAlignment(JTextField.CENTER);
        _lastName.setOpaque(false);
        _lastName.setBounds(800, 340, 400, 50);
        
        Border lastNameBorder = new LineBorder(Color.DARK_GRAY, 3, true);
        _lastName.setBorder(lastNameBorder);
        
        backgroundImage.add(_lastName);
        Utility.addFocusListernerOnField(_lastName, "ENTER YOUR LAST NAME" );


        // This is the MobileNumber TextField
        _mobileNumber = new JTextField("ENTER YOUR MOBILE NUMBER");
        _mobileNumber.setFont(new Font("SansSerif", Font.BOLD, 18));
        _mobileNumber.setForeground(Color.white);
        _mobileNumber.setHorizontalAlignment(JTextField.CENTER);
        _mobileNumber.setOpaque(false);
        _mobileNumber.setBounds(800, 410, 400, 50);
        
        Border mobileNumber = new LineBorder(Color.DARK_GRAY, 3,true);
        _mobileNumber.setBorder(mobileNumber);

        backgroundImage.add(_mobileNumber);
        Utility.addFocusListernerOnField(_mobileNumber, "ENTER YOUR MOBILE NUMBER");
        
        
        // This is the EmailID TextField
        _emailID = new JTextField("ENTER YOUR EMAIL ID");
        _emailID.setFont(new Font("SansSerif", Font.BOLD, 18));
        _emailID.setForeground(Color.white);
        _emailID.setHorizontalAlignment(JTextField.CENTER);
        _emailID.setOpaque(false);
        _emailID.setBounds(800, 480, 400, 50);
        
        Border emailBorder = new LineBorder(Color.DARK_GRAY, 3,true);
        _emailID.setBorder(emailBorder);

        backgroundImage.add(_emailID);
        Utility.addFocusListernerOnField(_emailID, "ENTER YOUR EMAIL ID");

        
        // This is the NewPassword TextField
        _newPassword = new JTextField("ENTER NEW PASSWORD");
        _newPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
        _newPassword.setForeground(Color.white);
        _newPassword.setHorizontalAlignment(JTextField.CENTER);
        _newPassword.setOpaque(false);
        _newPassword.setBounds(800, 550, 400, 50);
        
        Border passwordBorder = new LineBorder(Color.DARK_GRAY, 3,true);
        _newPassword.setBorder(passwordBorder);

        backgroundImage.add(_newPassword);
        Utility.addFocusListernerOnField(_newPassword, "ENTER NEW PASSWORD");
        
        
        // This is Retype password textField
        _retypePassword = new JTextField("RE-ENTER YOUR PASSWORD");
        _retypePassword.setFont(new Font("SansSerif", Font.BOLD, 18));
        _retypePassword.setForeground(Color.white);
        _retypePassword.setHorizontalAlignment(JTextField.CENTER);
        _retypePassword.setOpaque(false);
        _retypePassword.setBounds(800, 630, 400, 50);
        
        Border passwordRetypeBorder = new LineBorder(Color.DARK_GRAY, 3,true);
        _retypePassword.setBorder(passwordRetypeBorder);

        backgroundImage.add(_retypePassword);
        Utility.addFocusListernerOnField(_retypePassword, "RE-ENTER YOUR PASSWORD");



        Utility.refresh(backgroundImage);

    }

    
    // Adding JLabels
    public void addLabels() {

        Utility.invisbleLabel(this);

        // This is the heading
        JLabel pageInfo = new JLabel("User Credentials");
        pageInfo.setFont(new Font("System", Font.BOLD, 50));
        pageInfo.setBounds(700, 80, 600, 50);
        pageInfo.setForeground(Color.white);
        backgroundImage.add(pageInfo);



        // These are the credentials
        JLabel firstName = new JLabel("First Name:");
        firstName.setFont(new Font("System", Font.BOLD, 25));
        firstName.setBounds(500, 270, 200, 50);
        firstName.setForeground(Color.black);
        backgroundImage.add(firstName);


        JLabel lastName = new JLabel("Second Name:");
        lastName.setFont(new Font("System", Font.BOLD, 25));
        lastName.setBounds(500, 340, 230, 50);
        lastName.setForeground(Color.black);
        backgroundImage.add(lastName);


        JLabel mobileNumber = new JLabel("Mobile Number:");
        mobileNumber.setFont(new Font("System", Font.BOLD, 25));
        mobileNumber.setBounds(500, 410, 230, 50);
        mobileNumber.setForeground(Color.black);
        backgroundImage.add(mobileNumber);


        JLabel emailAddress = new JLabel("Email Address:");
        emailAddress.setFont(new Font("System", Font.BOLD, 25));
        emailAddress.setBounds(500, 480, 230, 50);
        emailAddress.setForeground(Color.black);
        backgroundImage.add(emailAddress);


        JLabel newPassword = new JLabel("New Password:");
        newPassword.setFont(new Font("System", Font.BOLD, 25));
        newPassword.setBounds(500, 550, 250, 50);
        newPassword.setForeground(Color.black);
        backgroundImage.add(newPassword);


        JLabel retypePassword = new JLabel("Re-Enter Password:");
        retypePassword.setFont(new Font("System", Font.BOLD, 25));
        retypePassword.setBounds(500, 630, 280, 50);
        retypePassword.setForeground(Color.black);
        backgroundImage.add(retypePassword);



        JLabel uploadImage = new JLabel("UPLOAD IMAGE");
        uploadImage.setFont(new Font("System", Font.BOLD, 20));
        uploadImage.setForeground(Color.green);
        uploadImage.setBounds(1270, 490, 200, 40);
        backgroundImage.add(uploadImage);

        uploadImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showOpenDialog(uploadImage);

                if(result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image scaledImage = imageIcon.getImage().getScaledInstance(_imageLabel.getWidth(), _imageLabel.getHeight(), Image.SCALE_SMOOTH);
                    _imageLabel.setIcon(new ImageIcon(scaledImage));
                    _imageLabel.setText("");
                    uploadImage.setText("Edit Image");

                } else {
                    JOptionPane.showMessageDialog(null, "No File Selected", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        // This is the Label that show the image into the frame
        _imageLabel = new JLabel("Select Image", SwingConstants.CENTER);
        _imageLabel.setFont(new Font("Arial", Font.BOLD, 15));
        _imageLabel.setForeground(Color.white);
        _imageLabel.setBounds(1270, 270, 175, 200);
        

        Border customBorder = new LineBorder(Color.DARK_GRAY, 7, true);
        _imageLabel.setBorder(customBorder);
        backgroundImage.add(_imageLabel);

    }


    
    public void addButton() {
        // Custom method to create rounded buttons
        _submit = Utility.createRoundedButton("SUBMIT", 1000, 900, 200, 40);
        _submit.addActionListener(this);
        Utility.addMouseColorChange(_submit, Color.BLACK, Color.WHITE); // Add your color change utility
        backgroundImage.add(_submit);
    
        _back = Utility.createRoundedButton("BACK", 1250, 900, 200, 40);
        _back.addActionListener(this);
        Utility.addMouseColorChange(_back, Color.BLACK, Color.WHITE); // Add your color change utility
        backgroundImage.add(_back);
    }
    

    // Abstract methods --> MouseListener
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
    
    
    // Abstract method --> ActionListener   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _back) {
            setVisible(false);
            new LoginInterface();
        } else if(e.getSource() == _submit) {
            JOptionPane.showMessageDialog(null, "Your Details has been Stored \n Your Password is 'SOME_PASSWORD'");
        }
    }
    
    
    
    
    // This is the Main Class
    public static void main(String[] args) {
        new SignUp();
    }

}    


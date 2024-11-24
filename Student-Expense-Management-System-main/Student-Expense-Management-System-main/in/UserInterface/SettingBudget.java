package in.UserInterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import in.Utility.Utility;
import javax.swing.border.*;



public class SettingBudget extends JFrame implements ActionListener, MouseListener {

    // Global Variable Declarations
    JLabel backgroundImage;
    JTextField _amountField;
    JButton _sumbit, _back;
    MainInterface homeInterface;
    // String USER_ID, PASSWORD;
    
    
    ;
    
    

    // Constructor 
    public SettingBudget() {
        // this.homeInterface = homeInterface;
        // this.USER_ID = USER_ID;
        // this.PASSWORD = PASSWORD;
        /////////////////////////////////////////////////////////
        
        backgroundImage = Utility.setImage("in/Images/budget.jpg", 1920, 1130);
        this.add(backgroundImage);  // --> this is the image for the frame's background
        addLabels();
        addButtons();
        addTextFields();
        trasnlucentBox();
        Utility.setFrame(this, 1920, 1080, "Monthly Budget");    // --> This is the frame desciption
        
    }


    // JTextFields
    public void addTextFields() {
        _amountField = new JTextField("Enter the Amount");
        _amountField.setFont(new Font("System", Font.BOLD, 25));
        _amountField.setBounds(1080, 750, 600, 50);
        _amountField.setForeground(Color.white);
        _amountField.setHorizontalAlignment(JTextField.CENTER);
        _amountField.setOpaque(false);

        Border customBorder = new LineBorder(Color.BLACK, 5, true);
        _amountField.setBorder(customBorder);
        backgroundImage.add(_amountField);

        // These are necessary here
        Utility.refresh(backgroundImage);

        Utility.addFocusListernerOnField(_amountField, "Enter the Amount");
        
        
        
    }
    
    
    
    public void addLabels() {
        JLabel budget = new JLabel("Monthly Budget");
        budget.setFont(new Font("L M Roman10", Font.BOLD, 60));
        budget.setForeground(Color.CYAN);
        budget.setBounds(250, 150, 600, 70);
        backgroundImage.add(budget);
        
        Utility.invisbleLabel(this);    // This is the invisible Label

        JLabel amount = new JLabel("Amount");
        amount.setFont(new Font("Quicksand", Font.BOLD, 30));
        amount.setForeground(Color.blue);
        amount.setBounds(930, 750, 200, 50);
        backgroundImage.add(amount);

        Utility.refresh(backgroundImage);
    }
    

    // JButtons
    public void addButtons() {
        _back = Utility.createRoundedButton("BACK", 1700, 1000, 150, 50);
        _back.addActionListener(this);
        Utility.addMouseColorChange(_back, Color.BLACK, Color.WHITE);
        backgroundImage.add(_back);
        
        
        _sumbit = Utility.createRoundedButton("SUBMIT", 1450, 1000, 150, 50);
        _sumbit.addActionListener(this);
        Utility.addMouseColorChange(_sumbit, Color.BLACK, Color.white);
        backgroundImage.add(_sumbit);


        Utility.refresh(backgroundImage);
    }


    // This is the invisible Box
    public void trasnlucentBox() {

        // this is the transulcent box on the heading label
        JPanel headingBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2d.setColor(new Color(255, 255, 255, 128));    // Transparent white
                // Enable anti-aliasing for smoother corners
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a rounded rectangle
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 150, 150); // 50 is the arc width and height
 
            }
        };
        headingBox.setBounds(120, 100, 800, 200);
        headingBox.setOpaque(false);
        backgroundImage.add(headingBox);
        
        // This is the other transulcent box
        JPanel frameBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)); // 0.7f for 50% opacity
                g2d.setColor(Color.white); // Background color
                // Enable anti-aliasing for smoother corners
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a rounded rectangle
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 150, 150); // 50 is the arc width and height

            }
        };
        frameBox.setBounds(875, 675, 900, 200);
        frameBox.setOpaque(false); // Prevents default opaque rendering
        
        backgroundImage.add(frameBox);

        Utility.refresh(backgroundImage);
        
    }


    // MouseListener interface abstract method description
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
    


    // This is the Action Perforemed method
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _back) {
            setVisible(false);
            new MainInterface();
        } else if(e.getSource() == _sumbit) {
            JOptionPane.showMessageDialog(null, "Your Amount has been added.");
            
        }
    }
    

    


    // This is the main method
    public static void main(String[] args) {
        new SettingBudget();
    }
    
}

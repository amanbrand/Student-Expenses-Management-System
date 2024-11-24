package in.UserInterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import in.Utility.Utility;
import javax.swing.border.*;




public class ExpenseDetails extends JFrame implements ActionListener, MouseListener{


    // These are the global variable declarations
    JLabel backgroundImage;
    JTextField _expenseField, _amountField, _dateField, _otherDayField;
    JRadioButton _today, _otherDay;
    JButton _submit, _back;



    // this is the constructor
    public ExpenseDetails() {

        setBackground();
        addTextFields();
        addRadioButtons();
        addButtons();
        addLabels();
        
        defineFrame();
    }


    public void addTextFields() {

        // Expense TextField
        _expenseField = new JTextField("Item");
        _expenseField.setFont(new Font("System", Font.BOLD, 20));
        _expenseField.setForeground(Color.DARK_GRAY);
        _expenseField.setOpaque(false);
        _expenseField.setHorizontalAlignment(JTextField.CENTER);
        _expenseField.setBounds(270, 430, 500, 60);
        
        Border expenseBorder = new LineBorder(Color.white, 5, true);
        _expenseField.setBorder(expenseBorder);
        backgroundImage.add(_expenseField);

        Utility.addFocusListernerOnField(_expenseField, "Item");


        // Price TextField
        _amountField = new JTextField("Amount");
        _amountField.setFont(new Font("System", Font.BOLD, 20));
        _amountField.setForeground(Color.DARK_GRAY);
        _amountField.setOpaque(false);
        _amountField.setHorizontalAlignment(JTextField.CENTER);
        _amountField.setBounds(270, 580, 500, 60);
        
        Border amountBoder = new LineBorder(Color.white, 5, true);
        _amountField.setBorder(amountBoder);
        backgroundImage.add(_amountField);

        Utility.addFocusListernerOnField(_amountField, "Amount");


    }


    public void addLabels() {
        addInvisbleLabel();  // --> This is the invisble label


        JLabel expenseDetails = new JLabel("Spent On:");
        expenseDetails.setFont(new Font("System", Font.BOLD, 28));
        expenseDetails.setForeground(Color.BLACK);
        expenseDetails.setBounds(230, 370, 700, 40);
        backgroundImage.add(expenseDetails);
        
        JLabel expenseAmount = new JLabel("Expense Amount:");
        expenseAmount.setFont(new Font("System", Font.BOLD, 28));
        expenseAmount.setForeground(Color.BLACK);
        expenseAmount.setBounds(230, 520, 700, 40);
        backgroundImage.add(expenseAmount);

        JLabel pageInfo = new JLabel("Expense Details");
        pageInfo.setFont(new Font("System", Font.BOLD, 50));
        pageInfo.setForeground(Color.BLACK);
        pageInfo.setBounds(150, 250, 700, 60);
        backgroundImage.add(pageInfo);


    }

    // Adding the Button
    public void addButtons() {

        _submit = Utility.createRoundedButton("SUBMIT", 1000, 1000, 200, 40);
        _submit.addActionListener(this);
        Utility.addMouseColorChange(_submit, Color.black, Color.white);
        backgroundImage.add(_submit);
        
        
        _back = Utility.createRoundedButton("BACK", 700, 1000, 200, 40);
        _back.addActionListener(this);
        Utility.addMouseColorChange(_back, Color.black, Color.white);
        backgroundImage.add(_back);

        

    }



    // Adding the radio buttons
    public void addRadioButtons() {
        _today = new JRadioButton("Today");
        _today.setFont(new Font("System", Font.BOLD, 20));
        _today.setForeground(Color.BLACK);
        _today.setOpaque(false);
        _today.setBounds(270, 680, 95, 20);
        _today.setFocusable(false);
        backgroundImage.add(_today);

        _otherDay = new JRadioButton("Other Day");
        _otherDay.setFont(new Font("System", Font.BOLD, 20));
        _otherDay.setForeground(Color.BLACK);
        _otherDay.setOpaque(false);
        _otherDay.setFocusable(false);
        _otherDay.setBounds(420, 680, 145, 20);
        backgroundImage.add(_otherDay);

        ButtonGroup day = new ButtonGroup();
        day.add(_today);
        day.add(_otherDay);

    }




    public void addInvisbleLabel() {
        JLabel invisibleLabel = new JLabel();
        invisibleLabel.setOpaque(false);
        invisibleLabel.setBounds(0, 0, 0, 0);
        invisibleLabel.setFocusable(true);
        backgroundImage.add(invisibleLabel);
    }



    // This is the background for the frame
    public void setBackground() {

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("in/Images/expenseDetails.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1920, 1130, Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(image);

        backgroundImage = new JLabel(finalImage);
        backgroundImage.setBounds(0, 0, 1920, 1130);
        this.add(backgroundImage);
    }


    // This is the frame description
    public void defineFrame() {
        this.setTitle("Expense Details");
        this.setSize(1900, 1080);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setUndecorated(true);
        this.setVisible(true);

    }
    

    // This is the action performed method
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _back) {
            setVisible(false);
            new MainInterface();
        } else if(e.getSource() == _submit) {
            JOptionPane.showMessageDialog(null, "Your Expenses has been updated");
        } else if(e.getSource() == _otherDay) {
            _otherDayField = new JTextField("DD-MM-YYYY");

        }
    }
    
    
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
    

    

    // This is the main method
    public static void main(String[] args) {
        new ExpenseDetails();
    }
        
}

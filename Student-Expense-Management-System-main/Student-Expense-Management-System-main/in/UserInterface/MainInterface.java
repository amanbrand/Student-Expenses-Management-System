package in.UserInterface;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;
import in.Utility.Utility;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.border.*;
import java.time.format.TextStyle;
import in.LoginPage.LoginInterface;
import java.time.format.DateTimeFormatter;







public class MainInterface extends JFrame implements ActionListener, MouseListener{
 
    // Global Variables
    
    JPanel _leftHalf, _rightHalf;           // These are the partitions
    JPanel _expenseEntry, _budget, _weekExpense, _monthExpense, _totalExpense, _yesterdayExpense;   // --> right partition
    JPanel _translucentPanel;   
    JButton _logout, _reLogin; // --> Buttons
    JPanel _setBudget, _addExpenses, _expenseReport, _studentDashBoard; // --> left Parition
    JPanel endTitle;


    String USER_ID, PASSWORD;
    

    
    // Constructor
    public MainInterface() {
        startMainInterface();
        
    }
    
    
    public void startMainInterface() {
        
        
        // this.USER_ID = USER_ID;
        // this.PASSWORD = PASSWORD;
        ////////////////////////////////////////////////////////////
        defineFrame();
        
        // Utility.setFrame(this, 1920, 1130, "Student Expense Management System");
        this.getContentPane().setBackground(Color.gray);
        
        addLeftPanel();
        addRightPanel();
        
        addCardLabels();
        addTextOnLabels();
        
        addButtons();
        addPanelsOnLeftPartition();
        
        addTextOnLeftPartition();
        addIntro();
        addLogoOnLeftPartition();
        
        addDateAndDays();
        addLogoOnLastLabels();
        addTranslucentLabelOnDate();

        
        this.revalidate();
        this.repaint();
        
        
        
    }
    

    public void addLeftPanel() {
        _leftHalf = new JPanel();
        _leftHalf.setBounds(0, 0, 400, 1130);
        _leftHalf.setBackground(Color.DARK_GRAY);
        _leftHalf.setLayout(null);
        this.add(_leftHalf);
    }
    
    
    public void addRightPanel() {
        _rightHalf = new JPanel();
        _rightHalf.setBounds(400, 0, 1520, 1130);
        _rightHalf.setBackground(Color.decode("#1B1B1B"));
        _rightHalf.setLayout(null);
        this.add(_rightHalf);
    }


    public void addCardLabels() {

        // Expense
        _expenseEntry = new RoundedPanel(50, Color.red);
        _expenseEntry.setBounds(100, 100, 400, 200);
        _expenseEntry.setLayout(null);
        _rightHalf.add(_expenseEntry);
        
        // adding the mouseListener
        _expenseEntry.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Enter the Expense Amount.");
            }
        });
        
        
        
        // Budget
        _budget = new RoundedPanel(50, Color.pink);
        _budget.setBounds(550, 100, 400, 200);
        _budget.setLayout(null);
        _rightHalf.add(_budget);


        // week's expense
        _weekExpense = new RoundedPanel(50, Color.CYAN);
        _weekExpense.setBounds(1000, 100, 400, 200);
        _weekExpense.setLayout(null);
        _rightHalf.add(_weekExpense);


        // Total Expense
        _totalExpense = new RoundedPanel(50, Color.magenta);
        _totalExpense.setBounds(100, 400, 400, 200);
        _totalExpense.setLayout(null);
        _rightHalf.add(_totalExpense);


        // Months Expense
        _monthExpense = new RoundedPanel(50, Color.blue);
        _monthExpense.setBounds(550, 400, 400, 200);
        _monthExpense.setLayout(null);
        _rightHalf.add(_monthExpense);


        //  Yesterday expense
        _yesterdayExpense = new RoundedPanel(50, Color.green);
        _yesterdayExpense.setBounds(1000, 400, 400, 200);
        _yesterdayExpense.setLayout(null);
        _rightHalf.add(_yesterdayExpense);

        

        _translucentPanel = Utility.addTranslucentPanel(Color.decode("#9457EB"), 0.7f, 50, 50, 1400, 610);
        _rightHalf.add(_translucentPanel);

        refresh(_rightHalf);

    }



    public void addTextOnLabels() {
        JLabel expenseLabel = new JLabel("Expense Entry");
        expenseLabel.setFont(new Font("System", Font.BOLD, 20));
        expenseLabel.setForeground(Color.black);
        expenseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        expenseLabel.setBounds(0, 35, _expenseEntry.getWidth(), _expenseEntry.getHeight());
        _expenseEntry.add(expenseLabel);
        refresh(_expenseEntry);
        
        JLabel rupeeSign = Utility.setImage("in/Images/rupeeSign.png", 100, 100);
        rupeeSign.setBounds(0, -30, _expenseEntry.getWidth(), _expenseEntry.getHeight());
        _expenseEntry.add(rupeeSign);
        _expenseEntry.revalidate();
        _expenseEntry.repaint();



        JLabel totolAmountLabel = new JLabel("Total Expense");
        totolAmountLabel.setFont(new Font("System", Font.BOLD, 20));
        totolAmountLabel.setForeground(Color.black);
        totolAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totolAmountLabel.setBounds(0, 35, _totalExpense.getWidth(), _totalExpense.getHeight());
        _totalExpense.add(totolAmountLabel);
        refresh(_totalExpense);

        JLabel saveIcon = Utility.setImage("in/Images/save1.png", 100, 100);
        saveIcon.setBounds(0, -30, _totalExpense.getWidth(), _totalExpense.getHeight());
        _totalExpense.add(saveIcon);
        _totalExpense.revalidate();
        _totalExpense.repaint();




        JLabel monthlyAvailAmount = new JLabel("Monthly Avaialable Amount");
        monthlyAvailAmount.setFont(new Font("System", Font.BOLD, 20));
        monthlyAvailAmount.setForeground(Color.black);
        monthlyAvailAmount.setHorizontalAlignment(SwingConstants.CENTER);
        monthlyAvailAmount.setBounds(0, 35, _monthExpense.getWidth(), _monthExpense.getHeight());
        _monthExpense.add(monthlyAvailAmount);
        refresh(_monthExpense);


        JLabel monthlyExpense = Utility.setImage("in/Images/calender.png", 100, 100);
        monthlyExpense.setBounds(0, -20, _monthExpense.getWidth(), _monthExpense.getHeight());
        _monthExpense.add(monthlyExpense);
        refresh(_monthExpense);


        JLabel weekExpense = new JLabel("Last 7 Days Eexpense");
        weekExpense.setFont(new Font("System", Font.BOLD, 20));
        weekExpense.setForeground(Color.black);
        weekExpense.setHorizontalAlignment(SwingConstants.CENTER);
        weekExpense.setBounds(0, 35, _weekExpense.getWidth(), _weekExpense.getHeight());
        _weekExpense.add(weekExpense);
        refresh(_weekExpense);

        JLabel weekLogo = Utility.setImage("in/Images/colorCalander.png", 80, 80);
        weekLogo.setBounds(0, -20, _weekExpense.getWidth(), _weekExpense.getHeight());
        _weekExpense.add(weekLogo);
        refresh(_weekExpense);



        JLabel budgetLabel = new JLabel("Montly Budget");
        budgetLabel.setFont(new Font("System", Font.BOLD, 20));
        budgetLabel.setForeground(Color.black);
        budgetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        budgetLabel.setBounds(0, 35, _budget.getWidth(), _budget.getHeight());
        _budget.add(budgetLabel);
        refresh(_budget);

        JLabel rupeesign_1 = Utility.setImage("in/Images/rupeeSign1.png", 100, 100);
        rupeesign_1.setBounds(0, -30, _budget.getWidth(), _budget.getHeight());
        _budget.add(rupeesign_1);
        refresh(_budget);


        JLabel yesterdayExpense = new JLabel("Yesterday Expense");
        yesterdayExpense.setFont(new Font("System", Font.BOLD, 25));
        yesterdayExpense.setForeground(Color.black);
        yesterdayExpense.setHorizontalAlignment(SwingConstants.CENTER);
        yesterdayExpense.setBounds(0, 35, _yesterdayExpense.getWidth(), _yesterdayExpense.getHeight());
        _yesterdayExpense.add(yesterdayExpense);
        refresh(_yesterdayExpense);

        JLabel restartLogo = Utility.setImage("in/Images/restart.png", 60, 60);
        restartLogo.setBounds(0, -30, _yesterdayExpense.getWidth(), _yesterdayExpense.getHeight());
        _yesterdayExpense.add(restartLogo);
        refresh(_yesterdayExpense);

        
    }



    public void addButtons() {
        _logout = Utility.createRoundedButton("LOG-OUT", 1100, 1000, 300, 50);
        _logout.addActionListener(this);
        Utility.addMouseColorChange(_logout, Color.black, Color.white);
        _rightHalf.add(_logout);
        _rightHalf.revalidate();
        _rightHalf.repaint();
        
        _reLogin = Utility.createRoundedButton("SWITCH-ACCOUNT", 750, 1000, 300, 50);
        _reLogin.addActionListener(this);
        Utility.addMouseColorChange(_reLogin, Color.black, Color.white);
        _rightHalf.add(_reLogin);
        _rightHalf.revalidate();
        _rightHalf.repaint();
    }

    public void addIntro() {
        
        JLabel intro = new JLabel("STUDENT EXPENSE");
        intro.setFont(new Font("System", Font.BOLD, 28));
        intro.setForeground(Color.cyan);
        intro.setBounds(35, 130, 400, 40); // Adjusted position to fit inside introBox
        _leftHalf.add(intro);
        refresh(_leftHalf);
        
        JLabel introLast = new JLabel("Management System");
        introLast.setFont(new Font("System", Font.BOLD, 30));
        introLast.setForeground(Color.cyan);
        introLast.setBounds(15, 100, 400, 200);
        _leftHalf.add(introLast);
        refresh(_leftHalf);
        
        JPanel introBox = Utility.addTranslucentPanel(Color.black, 0.9f, 0, 80, 400, 200);
        _leftHalf.add(introBox);

    }




    public void addPanelsOnLeftPartition() {
        _studentDashBoard = new JPanel();
        _studentDashBoard.setBackground(Color.gray);
        _studentDashBoard.setBounds(0, 300, 400, 80);
        _studentDashBoard.setLayout(null);
        _leftHalf.add(_studentDashBoard);
        LineBorder studentDashBoardBorder = new LineBorder(Color.BLACK, 2, false);
        _studentDashBoard.setBorder(studentDashBoardBorder);
        refresh(_leftHalf);

        _studentDashBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Redirecting to Student DashBoard");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                _studentDashBoard.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                _studentDashBoard.setBackground(Color.gray);
            }
        });
        
        _setBudget = new JPanel();
        _setBudget.setBackground(Color.gray);
        _setBudget.setBounds(0, 377, 400, 80);
        _setBudget.setLayout(null);
        _leftHalf.add(_setBudget);
        LineBorder setBudgetBorder = new LineBorder(Color.BLACK, 2, false);
        _setBudget.setBorder(setBudgetBorder);
        refresh(_leftHalf);

        _setBudget.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // new SettingBudget(homeInterface, USER_ID, PASSWORD);
                setVisible(false);
                new SettingBudget();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                _setBudget.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                _setBudget.setBackground(Color.gray);
            }
        });




        
        _addExpenses = new JPanel();
        _addExpenses.setBackground(Color.gray);
        _addExpenses.setBounds(0, 454, 400, 80);
        _addExpenses.setLayout(null);
        _leftHalf.add(_addExpenses);
        LineBorder addExpenseBorder = new LineBorder(Color.BLACK, 2, false);
        _addExpenses.setBorder(addExpenseBorder);
        refresh(_leftHalf);

        _addExpenses.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ExpenseDetails();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                _addExpenses.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                _addExpenses.setBackground(Color.gray);
            }
        });
        
        _expenseReport = new JPanel();
        _expenseReport.setBackground(Color.gray);
        _expenseReport.setBounds(0, 531, 400, 80);
        _expenseReport.setLayout(null);
        _leftHalf.add(_expenseReport);
        LineBorder expenseReportBorder = new LineBorder(Color.BLACK, 2, false);
        _expenseReport.setBorder(expenseReportBorder);
        refresh(_leftHalf);

        _expenseReport.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Redirecting to the Expense Report Page");
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                _expenseReport.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                _expenseReport.setBackground(Color.gray);
            }
        });

    }


    public void addTextOnLeftPartition() {
        
        JLabel studentDashBoard = new JLabel("Student DashBoard");
        studentDashBoard.setFont(new Font("Arial", Font.BOLD, 20));
        studentDashBoard.setForeground(Color.white);
        studentDashBoard.setHorizontalAlignment(SwingConstants.CENTER);
        studentDashBoard.setBounds(0, 0, _studentDashBoard.getWidth(), _studentDashBoard.getHeight());
        _studentDashBoard.add(studentDashBoard);
        refresh(_studentDashBoard);
        
        JLabel setBudget = new JLabel("Set Budget");
        setBudget.setFont(new Font("Arial", Font.BOLD, 20));
        setBudget.setForeground(Color.white);
        setBudget.setHorizontalAlignment(SwingConstants.CENTER);
        setBudget.setBounds(0, 0, _setBudget.getWidth(), _setBudget.getHeight());
        _setBudget.add(setBudget);
        refresh(_setBudget);

        JLabel expenseReport = new JLabel("Expense Report");
        expenseReport.setFont(new Font("Arial", Font.BOLD, 20));
        expenseReport.setForeground(Color.white);
        expenseReport.setHorizontalAlignment(SwingConstants.CENTER);
        expenseReport.setBounds(0, 0, _expenseReport.getWidth(), _expenseReport.getHeight());
        _expenseReport.add(expenseReport);
        refresh(_expenseReport);

        JLabel addExpense = new JLabel("Add Expense");
        addExpense.setFont(new Font("Arial", Font.BOLD, 20));
        addExpense.setForeground(Color.white);
        addExpense.setHorizontalAlignment(SwingConstants.CENTER);
        addExpense.setBounds(0, 0, _addExpenses.getWidth(), _addExpenses.getHeight());
        _addExpenses.add(addExpense);
        refresh(_addExpenses);



        refresh(_leftHalf);


    }


    public void addLogoOnLeftPartition() {
        JLabel restartLogo = Utility.setImage("in/Images/coinStack.png", 50, 50);
        restartLogo.setBounds(-150, 0, _studentDashBoard.getWidth(), _studentDashBoard.getHeight());
        _studentDashBoard.add(restartLogo);
        refresh(_studentDashBoard);
        
        
        JLabel plusLogo = Utility.setImage("in/Images/plus.png", 50, 50);
        plusLogo.setBounds(-150, 0, _addExpenses.getWidth(), _addExpenses.getHeight());
        _addExpenses.add(plusLogo);
        refresh(_addExpenses);
        
        JLabel dollerLogo = Utility.setImage("in/Images/doller.png", 50, 50);
        dollerLogo.setBounds(-150, 0, _setBudget.getWidth(), _setBudget.getHeight());
        _setBudget.add(dollerLogo);
        refresh(_setBudget);
        
        JLabel reportLogo = Utility.setImage("in/Images/report.png", 55, 55);
        reportLogo.setBounds(-150, 0, _expenseReport.getWidth(), _expenseReport.getHeight());
        _expenseReport.add(reportLogo);
        refresh(_expenseReport);
    }


    /**
     * @apiNote Adds the Data and time components of the page
     */
    public void addDateAndDays() {
        
        
        endTitle = new JPanel();
        endTitle.setBackground(Color.black);
        endTitle.setBounds(0, 1050, 400, 80);
        endTitle.setLayout(null);
        _leftHalf.add(endTitle);
        LineBorder endTitleBorder = new LineBorder(Color.BLACK, 2, false);
        endTitle.setBorder(endTitleBorder);
        refresh(_leftHalf);
        
        endTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                endTitle.setBackground(Color.darkGray);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                endTitle.setBackground(Color.black);
            }
        });
        

        JLabel currentDate = new JLabel("Date: " + LocalDate.now());
        currentDate.setFont(new Font("Arial", Font.BOLD, 23));
        currentDate.setHorizontalAlignment(SwingConstants.CENTER);
        currentDate.setBounds(0, 0, endTitle.getWidth(), endTitle.getHeight());
        
        currentDate.setForeground(Color.cyan);
        endTitle.add(currentDate);
        
        ///////////////////////////////
        
        JLabel currentMonth = new JLabel("Month: " + LocalDate.now().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + "-" + LocalDate.now().getYear());
        currentMonth.setFont(new Font("System", Font.BOLD, 23));
        currentMonth.setForeground(Color.cyan);
        currentMonth.setBounds(200, 750, 400, 100);
        _rightHalf.add(currentMonth);
        refresh(_rightHalf);
        
        
        JLabel currentDay = new JLabel("Day: " + LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        currentDay.setFont(new Font("System", Font.BOLD, 23));
        currentDay.setForeground(Color.cyan);
        currentDay.setBounds(200, 830, 400, 100);
        _rightHalf.add(currentDay);
        refresh(_rightHalf);


    }


    public void addLogoOnLastLabels() {
        JLabel restartLogo = Utility.setImage("in/Images/dateCalander.png", 110, 110);
        restartLogo.setBounds(-150, 7, endTitle.getWidth(), endTitle.getHeight());
        endTitle.add(restartLogo);
        refresh(endTitle);
        
        JLabel monthLogo = Utility.setImage("in/Images/monthCalander.png", 60, 60);
        monthLogo.setBounds(100, 775, 60, 60);
        _rightHalf.add(monthLogo);
        refresh(_rightHalf);
        
        JLabel dayLogo = Utility.setImage("in/Images/dayLogo.png", 60, 45);
        dayLogo.setBounds(105, 850, 60, 60);
        _rightHalf.add(dayLogo);
        refresh(_rightHalf);


        JLabel invisClock = Utility.setImage("in/Images/invisClock.png", 150, 150);
        invisClock.setBounds(450, 890, 200, 200);
        _rightHalf.add(invisClock);
        refresh(_rightHalf);
        
        JLabel tableClock = Utility.setImage("in/Images/tableClock.png", 500, 500);
        tableClock.setBounds(750, 600, 500, 500);
        _rightHalf.add(tableClock);
        refresh(_rightHalf);

        tableClock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"); // this is the time formater
                String formattedDateTime = currentDateTime.format(formatter);
                
                JOptionPane.showMessageDialog(null, "Current Date and Time: " + formattedDateTime);
            }
        });

        
        


    }

    public void addTranslucentLabelOnDate() {
        JPanel invisPanel = Utility.addTranslucentPanel(Color.BLACK, 0.9f, 50, 700, 600, 400);
        _rightHalf.add(invisPanel);
        refresh(_rightHalf);
    }



    public void defineFrame() {
        setTitle("Student Expense Management System");
        setSize(1920, 1130);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setUndecorated(true);
        setVisible(true);
    }





    // ActionPerformed method
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _logout) {
            JOptionPane.showMessageDialog(null, "THANKS FOR VISITING");
            System.exit(0);
        } else if(e.getSource() == _reLogin) {
            setVisible(false);
            new LoginInterface();
        }

    }


    // MouserListener
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

    // Refreshing labels
    public void refresh(JLabel label) {
        label.revalidate();
        label.repaint();
    }

    public void refresh(JPanel panel) {
        panel.revalidate();
        panel.repaint();
    }


    // Main method
    public static void main(String[] args) {
        // new MainInterface(homeInterface, "admin", "password");
        new MainInterface();
    }


}



// Custom RoundedPanel class
/**
 * @apiNote --> Gives a rounded JPanel
 * @param --> angle of the radius to bend
 * @param --> Color of the back ground
 */
class RoundedPanel extends JPanel {
    private int cornerRadius;
    private Color backgroundColor;

    public RoundedPanel(int cornerRadius, Color backgroundColor) {
        this.cornerRadius = cornerRadius;
        this.backgroundColor = backgroundColor;
        setOpaque(false); // Allows the rounded corners to be visible
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Anti-aliasing for smooth corners
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the panel with a rounded rectangle
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        setLayout(null);
     
    }


}
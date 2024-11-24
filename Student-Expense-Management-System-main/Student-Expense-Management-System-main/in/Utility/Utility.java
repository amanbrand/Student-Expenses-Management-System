package in.Utility;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import javax.swing.border.*;


public class Utility extends JLabel {
 

    /**
     * @apiNote helps to set the image on the JFrame
     * @param imageAddress
     * @param width
     * @param height
     * @return
     */
    public static JLabel setImage(String imageAddress, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource(imageAddress));
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon finalImage = new ImageIcon(image);

        JLabel backgroundImage = new JLabel(finalImage);
        backgroundImage.setBounds(0, 0, width, height);

        return backgroundImage;

    }


    /**
     * @apiNote helps to set the frame size
     * @param frame
     * @param width
     * @param height
     * @param frameTitle
     */
    public static void setFrame(JFrame frame, int width, int height, String frameTitle) {
        frame.setTitle(frameTitle);
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setUndecorated(true);
        frame.setVisible(true);
    }
    

    /**
     * @apiNote This adds a invisble JLabel on the frame
     * @param frame
     */
    public static void invisbleLabel(JFrame frame) {
        JLabel invisibleLabel = new JLabel();
        invisibleLabel.setFocusable(true);
        invisibleLabel.setOpaque(false);
        invisibleLabel.setBounds(0, 0, 0, 0);
        frame.add(invisibleLabel);
    }


    /**
     * @apiNote Makes the textBox get Empty when clicked
     * @param textBox
     * @param boxMessage -> Previous Message of the Box
     */
    public static void addFocusListernerOnField(JTextField textBox, String boxMessage) {
        textBox.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(textBox.getText().equals(boxMessage)) {
                    textBox.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(textBox.getText().isEmpty()) {
                    textBox.setText(boxMessage);
                }
            }
        });

    }


    /**
     * @apiNote This Refreshes the Image of the Background 
     * @param imageLabel
     */
    public static void refresh(JLabel imageLabel) {
        imageLabel.revalidate();
        imageLabel.repaint();
    }


    /**
     * @apiNote CHANGES THE COLOR OF THE BUTTON WHILE ENTERING AND LEAVING
     * @param button
     * @param foreGroundColor   --> Color you want your foreground to change into
     * @param backGroundColor   --> Color you want your background to change into
     */
    public static void addMouseColorChange(JButton button, Color foreGroundColor, Color backGroundColor) {
        button.addMouseListener(new MouseListener() {

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
                changeButtonEntering(button, foreGroundColor, backGroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                changeButtonLeaving(button, foreGroundColor, backGroundColor);
            }
            
        });

    } 
        
        
    private static void changeButtonEntering(JButton button, Color foreGroundColor, Color backGroundColor) {
        button.setForeground(foreGroundColor);
        button.setBackground(backGroundColor);
    }


    private static void changeButtonLeaving(JButton button, Color foregroundColor, Color backgroundColor) {
        button.setForeground(backgroundColor);
        button.setBackground(foregroundColor);
    }


    
    /**
     * @see this method Create the round edged JButtons
     * @param text
     * @param x
     * @param y
     * @param width
     * @param height
     * @return  rounded JButtons
     */
    public static JButton createRoundedButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Use the button's current background color
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, width - 1, height - 1, 20, 20);
                
                // Add subtle border
                g2.setColor(new Color(100, 100, 100));
                g2.drawRoundRect(0, 0, width - 1, height - 1, 20, 20);
                
                // Use the button's current foreground color for text
                g2.setColor(getForeground());
                FontMetrics metrics = g2.getFontMetrics(getFont());
                int textX = (width - metrics.stringWidth(text)) / 2;
                int textY = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.drawString(text, textX, textY);
                
                g2.dispose();
            }
            
            // Override isOpaque to ensure proper rendering
            @Override
            public boolean isOpaque() {
                return false;
            }
        };

        
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBounds(x, y, width, height);
        
        
        return button;
    }



    /**
     * @apiNote This function of That gives a translucent JPanel
     * @param bgColor
     * @param tranparentValue
     * @param x --> X cordinate
     * @param y --> Y cordinate
     * @param width --> width of the frame
     * @param height --> height of the frame
     * @return Returns a Translucent JPanel that is curved
     */
    public static JPanel addTranslucentPanel(Color bgColor, float tranparentValue, int x, int y, int width, int height) {
        JPanel frameBox = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, tranparentValue));
                g2d.setColor(bgColor); // Background color
                // Enable anti-aliasing for smoother corners
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a rounded rectangle
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 150, 150); // this is the amount of the turn
            }
        };
        frameBox.setBounds(x, y, width, height);
        frameBox.setOpaque(false); // Prevents default opaque rendering
        return frameBox;
    }

    

}

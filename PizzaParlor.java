
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PizzaParlor{

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public PizzaParlor() {
        mainFrame = new JFrame("Pizza Parlor");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);        
        statusLabel.setSize(350,100);
      
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });    
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        PizzaParlor b = new PizzaParlor();
        b.showEvent();
    }

    private void showEvent() {
        headerLabel.setText("Create your order!"); 

        JButton pizzaButton = new JButton("Pizza");
        JButton drinkButton = new JButton("Drink");
        JButton toppingsButton = new JButton("Toppings");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");

        pizzaButton.setActionCommand("pizza order");
        drinkButton.setActionCommand("drink order");
        toppingsButton.setActionCommand("toppings order");
        submitButton.setActionCommand("submit order");
        cancelButton.setActionCommand("Cancel");

        pizzaButton.addActionListener(new ButtonClickListener()); 
        drinkButton.addActionListener(new ButtonClickListener()); 
        toppingsButton.addActionListener(new ButtonClickListener()); 
        submitButton.addActionListener(new ButtonClickListener()); 
        cancelButton.addActionListener(new ButtonClickListener()); 

        controlPanel.add(pizzaButton);
        controlPanel.add(drinkButton);
        controlPanel.add(toppingsButton);  
        controlPanel.add(submitButton);   
        controlPanel.add(cancelButton);         

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("pizza order"))  {
                statusLabel.setText("pizza ordered.");
            } else if(command.equals("drink order"))  {
                statusLabel.setText("drink ordered."); 
            } else if(command.equals("toppings order")) {
                statusLabel.setText("toppings ordered");
            } else if(command.equals("submit order")) {
                statusLabel.setText("order submitted");
            } else {
                statusLabel.setText("Cancel Button clicked.");
            }    
        }      
   }
}
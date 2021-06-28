//Juan McGee
//ACO 102
//10:30am- 11:45am
//Fall2019
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
/**
 This frame contains components for shipping program control panel 
 to compute shipping calculation.
 */
    public class ShippingCalculator extends JFrame 
    {
    private JButton calculationButton; 
    private JComboBox shippingMethodcomboBox;
    private JCheckBox surchargeCheckBox;
    private JLabel shippingMethodLabel;
    private JLabel categoryLabel;
    private JLabel shippingCostLabel;
    private JRadioButton radioButtonItems;
    private JRadioButton radioButtonWeight;
    private JTextField amountTextField;
    private double cost;

      
    private static final double STANDARD_ITEM_A = 3.00;
    private static final double STANDARD_ITEM_B = 1.45;
    
    private static final double EXPRESS_ITEM_A = 4.00;
    private static final double EXPRESS_ITEM_B = 2.50;
    
    private static final double SAMEDAY_ITEM_A = 5.50;
    private static final double SAMEDAY_ITEM_B = 3.00;
    
    private static final double STANDARD_HAWAII_AND_ALASKA = 2.50;
    private static final double EXPRESS_HAWAII_AND_ALASKA = 5.00;
    private static final double SAMEDAY_HAWAII_AND_ALASKA = 8.00;


    
    private static final int FRAME_WIDTH = 330;
    private static final int FRAME_HEIGHT = 320;
    
    
    /**
     Constructs the frame
     */
    public ShippingCalculator()
            {
                JPanel panel = new JPanel();
                JPanel  shippingMethodPanel = topPanel();
                JPanel radioButtonChoiceAndTextEntry = middlePanel();
                JPanel calculationButtonPanel = bottomPanel();
                setSize(FRAME_WIDTH, FRAME_HEIGHT);
                radioButtonChoiceAndTextEntry.setBorder(new TitledBorder(new EtchedBorder(), "Shipping Category"));

                
                 panel.setLayout(new GridLayout(3,1));
                 panel.add(shippingMethodPanel);
                 panel.add(radioButtonChoiceAndTextEntry);
                 panel.add(calculationButtonPanel);
                add(panel);
            }
    /**
     Creates The shipping Label and the ComboBox for different Shipping methods
     @return the panel containing label and comboBox
     */
    public JPanel topPanel()
    {
        JPanel panel = new JPanel();
         shippingMethodLabel = new JLabel(" Shipping Method");
         shippingMethodcomboBox = new JComboBox();
         shippingMethodcomboBox.addItem("Standard Shipping (3-5 days)");
         shippingMethodcomboBox.addItem("Express Shipping (2 days)");
         shippingMethodcomboBox.addItem("Same Day Shipping");

        panel.add(shippingMethodLabel);
        panel.add(shippingMethodcomboBox);
        return panel;
    }
    /**
     Creates radio button Item and Weight, Category Label, Amount Text Field
     @return the panel containing radio button, label and text field
     */
    public JPanel middlePanel()//rename to be more descriptive
    {
         final int FIELD_WIDTH = 10 ; 
        JPanel panel = new JPanel();
        JPanel panelOneA = new JPanel();
        JPanel panelTwoB = new JPanel();
        radioButtonItems = new JRadioButton("Items");
        radioButtonWeight = new JRadioButton("Weight");
        categoryLabel = new JLabel("Enter Category Info:");
       amountTextField = new JTextField(FIELD_WIDTH);
        
        ButtonGroup group = new ButtonGroup();
        group.add(radioButtonItems);
        group.add(radioButtonWeight);
        
        radioButtonItems.setSelected(true);
        
        panelTwoB.setLayout(new GridLayout(1,2));
        panelOneA.setLayout(new GridLayout(1,2));
        panel.setLayout(new GridLayout(2, 2));
        panelOneA.add(radioButtonItems);
        panelOneA.add(radioButtonWeight);
        panelTwoB.add(categoryLabel);
        panelTwoB.add(amountTextField);
        panel.add(panelOneA);
        panel.add(panelTwoB);
        
        return panel;
    }

     class calculateListener implements ActionListener
     {
        public void actionPerformed(ActionEvent event)
        {
            calculations();
        }
     }
    /**
     Creates the Shipping Cost label, calculation button for calculating the shipping, 
     and the surcharge check box 
     @return the panel containing the Cost label, calculation button, and the surcharge check box
     */
    public JPanel bottomPanel()
    {
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();
        JPanel panelThree = new JPanel();
        shippingCostLabel = new JLabel("Shipping Cost: $" + cost);
        calculationButton = new JButton("Calculate Shipping:");
       surchargeCheckBox = new JCheckBox("Surcharge for Hawaii/Alaska");
       
       ActionListener listener = new calculateListener();
       calculationButton.addActionListener(listener);
       
        panelTwo.setLayout(new GridLayout(1, 2));

        panelOne.add(surchargeCheckBox);
        panelTwo.add(calculationButton);
        panelTwo.add(shippingCostLabel);
        

        panelThree.add(panelOne);
        panelThree.add(panelTwo);
        return panelThree;
    }
    /**
     Gets user choice for Shipping method selected, items or weight, and surcharge or not
      and calculates the total and updates the cost label
     */
    public void calculations()
    {
        String selectedString = (String) shippingMethodcomboBox.getSelectedItem();
        double amount = Double.parseDouble(amountTextField.getText());
           if(selectedString.equals("Standard Shipping (3-5 days)"))
            { 
                if(radioButtonWeight.isSelected())      
                { 
                    cost = amount *STANDARD_ITEM_B ;
                }            
                else if(radioButtonItems.isSelected())
                { 
                  cost = amount * STANDARD_ITEM_A;
                }
                if(surchargeCheckBox.isSelected())
                {
                    cost = cost + STANDARD_HAWAII_AND_ALASKA;
                }
            }
           else if (selectedString.equals("Express Shipping (2 days)"))
            { 
               if(radioButtonWeight.isSelected())  
                 {
                    cost = amount *EXPRESS_ITEM_B;
                 }
               else if(radioButtonItems.isSelected())
                 {
                 cost = amount *EXPRESS_ITEM_A;
                 }
                if(surchargeCheckBox.isSelected())
                {
                    cost = cost + EXPRESS_HAWAII_AND_ALASKA;
                }
            }     
           else
            {
                if(radioButtonWeight.isSelected())  
                    {
                      cost = amount *SAMEDAY_ITEM_B;
                    }
                else if(radioButtonItems.isSelected())
                    {
                      cost = amount *SAMEDAY_ITEM_A;
                    }
                if(surchargeCheckBox.isSelected())
                    {
                        cost = cost + SAMEDAY_HAWAII_AND_ALASKA;
                    }  
             }
            shippingCostLabel.setText("Shipping Cost:" + "$" + cost);
    } 
    }


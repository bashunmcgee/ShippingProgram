//Juan McGee
//ACO102
//Fall2019
import javax.swing.JFrame;
/**
 This program allows the user to use different shipping methods 
 and calculates the price.
 */
public class ShippingViewer 
{
    public static void main(String[] args) {
       
        JFrame frame = new ShippingCalculator();
        frame.setTitle("Shipping Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
    }
    
}

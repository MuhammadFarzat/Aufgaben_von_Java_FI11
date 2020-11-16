import javax.swing.*;
import javax.swing.JTextField;
public class SimpleCalc 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Bruh");
        JTextField textfield;  
        textfield = new JTextField("Text Field W3Adda Tutorial");
        textfield.setBounds(50, 150, 200, 30);
        frame.add(textfield);
    
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setVisible(true);
	}

}

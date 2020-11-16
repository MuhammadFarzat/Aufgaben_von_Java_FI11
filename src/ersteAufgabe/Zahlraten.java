package ersteAufgabe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Zahlraten {

	private JFrame frame;
	private JTextField Zahleingabe;
	private JLabel Labeleingabesatz;
	private JButton btnNewButton;
	private JLabel LabelErgebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zahlraten window = new Zahlraten();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Zahlraten() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Zahl Raten");
		frame.setBounds(100, 100, 534, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getZahleingabe());
		frame.getContentPane().add(getLabeleingabesatz());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLabelErgebnis());
	}
	private JTextField getZahleingabe() {
		if (Zahleingabe == null) {
			Zahleingabe = new JTextField();
			Zahleingabe.setBounds(10, 53, 96, 44);
			Zahleingabe.setText("Zahl");
			Zahleingabe.setBackground(Color.WHITE);
			Zahleingabe.setColumns(10);
			Zahleingabe.addMouseListener(new MouseListener()
			{
				public void mouseClicked(MouseEvent e)
				{
					if(Zahleingabe.getText().equals("Zahl")==true)
					{
						Zahleingabe.setText("");
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
		}
		return Zahleingabe;
	}
	private JLabel getLabeleingabesatz() {
		if (Labeleingabesatz == null) {
			Labeleingabesatz = new JLabel("Bitte eine Zahl zwischen 1 und 1000000001 eingeben!");
			Labeleingabesatz.setBounds(10, 20, 460, 22);
			Labeleingabesatz.setFont(new Font("Tahoma", Font.PLAIN, 18));
			Labeleingabesatz.setLabelFor(getZahleingabe());
		}
		return Labeleingabesatz;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("raten");
			btnNewButton.setBounds(127, 53, 118, 44);
			btnNewButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					ueberpruefen();
					Zahleingabe.requestFocus();
				}
			}
			);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
		return btnNewButton;
	}
	public void ueberpruefen()
	{
		int i;
		Random zufallszahl = new Random();
		int zahl = 1 + zufallszahl.nextInt(1000000000);
		try
		{
			i = Integer.parseInt(Zahleingabe.getText());
			if(i >= 1000000000 || i <= 0)
			{
				LabelErgebnis.setText("Bitte nur eine Zahl zwischen 0 und 10 eingeben");
			}
			else if(i == zahl)
			{
				LabelErgebnis.setText("Nicht schlecht, das war richtig! Die richtige Zahl war " + zahl);
				frame.getContentPane().setBackground(Color.GREEN);
			}
			else
			{
				LabelErgebnis.setText("Schade, das war falsch. Die richtige Zahl ist: " + zahl);
				frame.getContentPane().setBackground(Color.RED);
			}
		}
		catch(NumberFormatException e1)
		{
			LabelErgebnis.setText("Geben Sie bitte nur eine Ganze Zahl ein!");
		}
		catch(ArithmeticException e1)
		{
			LabelErgebnis.setText("Geben Sie bitte nur eine Ganze Zahl ein!");
		}
		catch(Exception e1)
		{
			LabelErgebnis.setText("Etwas ist schief gelaufen!");
		}
	}
	private JLabel getLabelErgebnis() {
		if (LabelErgebnis == null) {
			LabelErgebnis = new JLabel(" ");
			LabelErgebnis.setBounds(20, 118, 384, 35);
			LabelErgebnis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return LabelErgebnis;
	}
}

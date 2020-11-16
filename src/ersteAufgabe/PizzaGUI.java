package ersteAufgabe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

import javax.swing.JComboBox;
import java.awt.TextField;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JList;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Scrollbar;

public class PizzaGUI {

	private JFrame frame;
	private JLabel lblNewLabelPizza;
	private JComboBox comboBoxPizza;
	private JLabel lblNewLabelGroesse;
	private JComboBox comboBoxGroesse;
	private JLabel lblNewLabelExtras;
	private TextField textFieldExtras;
	private TextField textFieldPreis;
	private Button buttonEntfernen;
	private JLabel lblNewLabelGesamtPreis;
	private TextField textFieldGesamtPreis;
	private Button buttonHinzufuegen;
	private Button buttonDrucken;
	private Button buttonHardcopy;
	private JList BestellListe;
	private Button buttonAllesEntfernen;
	private Button buttonDoppeln;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public PizzaGUI() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabelPizza());
		frame.getContentPane().add(getComboBoxPizza());
		frame.getContentPane().add(getLblNewLabelGroesse());
		frame.getContentPane().add(getComboBoxGroesse());
		frame.getContentPane().add(getLblNewLabelExtras());
		frame.getContentPane().add(getTextFieldExtras());
		frame.getContentPane().add(getTextFieldPreis());
		frame.getContentPane().add(getButtonEntfernen());
		frame.getContentPane().add(getLblNewLabelGesamtPreis());
		frame.getContentPane().add(getTextFieldGesamtPreis());
		frame.getContentPane().add(getButtonHinzufuegen());
		frame.getContentPane().add(getButtonDrucken());
		frame.getContentPane().add(getButtonHardcopy());
		frame.getContentPane().add(getBestellListe());
		frame.getContentPane().add(getButtonAllesEntfernen());
		frame.getContentPane().add(getButtonDoppeln());
		frame.setVisible(true);
		
		
	}
	private JLabel getLblNewLabelPizza() {
		if (lblNewLabelPizza == null) {
			lblNewLabelPizza = new JLabel("Pizza:");
			lblNewLabelPizza.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabelPizza.setBounds(10, 11, 49, 26);
		}
		return lblNewLabelPizza;
	}
	protected JComboBox getComboBoxPizza() {
		if (comboBoxPizza == null) {
			comboBoxPizza = new JComboBox();
			
			comboBoxPizza.setBounds(69, 15, 155, 22);
		}
		return comboBoxPizza;
	}
	private JLabel getLblNewLabelGroesse() {
		if (lblNewLabelGroesse == null) {
			lblNewLabelGroesse = new JLabel("Gr\u00F6\u00DFe:");
			lblNewLabelGroesse.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabelGroesse.setBounds(254, 17, 68, 20);
		}
		return lblNewLabelGroesse;
	}
	protected JComboBox getComboBoxGroesse() {
		if (comboBoxGroesse == null) {
			comboBoxGroesse = new JComboBox();
			comboBoxGroesse.setBounds(315, 16, 111, 22);
		}
		return comboBoxGroesse;
	}
	private JLabel getLblNewLabelExtras() {
		if (lblNewLabelExtras == null) {
			lblNewLabelExtras = new JLabel("Extras:");
			lblNewLabelExtras.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabelExtras.setBounds(10, 67, 54, 26);
		}
		return lblNewLabelExtras;
	}
	protected TextField getTextFieldExtras() {
		if (textFieldExtras == null) {
			textFieldExtras = new TextField();
			textFieldExtras.setBounds(69, 67, 237, 26);
		}
		return textFieldExtras;
	}
	protected TextField getTextFieldPreis() {
		if (textFieldPreis == null) {
			textFieldPreis = new TextField();
			textFieldPreis.setBounds(315, 67, 111, 26);
		}
		return textFieldPreis;
	}
	protected Button getButtonEntfernen() {
		if (buttonEntfernen == null) {
			buttonEntfernen = new Button("Entfernen");
			buttonEntfernen.setBounds(315, 184, 111, 35);
		}
		return buttonEntfernen;
	}
	
	
	private JLabel getLblNewLabelGesamtPreis() {
		if (lblNewLabelGesamtPreis == null) {
			lblNewLabelGesamtPreis = new JLabel("Gesamtpreis:");
			lblNewLabelGesamtPreis.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabelGesamtPreis.setBounds(10, 462, 93, 35);
		}
		return lblNewLabelGesamtPreis;
	}
	protected TextField getTextFieldGesamtPreis() {
		if (textFieldGesamtPreis == null) {
			textFieldGesamtPreis = new TextField();
			textFieldGesamtPreis.setBounds(109, 462, 197, 35);
		}
		return textFieldGesamtPreis;
	}
	protected Button getButtonHinzufuegen() {
		if (buttonHinzufuegen == null) {
			buttonHinzufuegen = new Button("Hinzufuegen");
			buttonHinzufuegen.setBounds(315, 122, 111, 35);
		}
		return buttonHinzufuegen;
	}
	private Button getButtonDrucken() {
		if (buttonDrucken == null) {
			buttonDrucken = new Button("Drucken");
			buttonDrucken.setBounds(315, 462, 93, 35);
		}
		return buttonDrucken;
	}
	private Button getButtonHardcopy() {
		if (buttonHardcopy == null) {
			buttonHardcopy = new Button("Hardcopy");
			buttonHardcopy.setBounds(437, 462, 102, 35);
		}
		return buttonHardcopy;
	}
	protected JList getBestellListe() {
		if (BestellListe == null) {
			BestellListe = new JList();	
		}
		return BestellListe;
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	protected Button getButtonAllesEntfernen() {
		if (buttonAllesEntfernen == null) {
			buttonAllesEntfernen = new Button("Alles Entfernen");
			buttonAllesEntfernen.setBounds(315, 253, 111, 35);
		}
		return buttonAllesEntfernen;
	}
	protected Button getButtonDoppeln() {
		if (buttonDoppeln == null) {
			buttonDoppeln = new Button("Bestellungen kopieren");
			buttonDoppeln.setBounds(315, 315, 128, 35);
		}
		return buttonDoppeln;
	}
}

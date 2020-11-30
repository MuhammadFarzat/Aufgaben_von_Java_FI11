package WarenkorbAufgabe;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Warenkorb extends JFrame {

	private JPanel contentPane;
	private JList listAngebote;
	private JButton btnNewButtonKaufen;
	private JButton btnNewButtonZurueck;
	private JList listEinkaufe;
	private JLabel lblNewLabelKundenname;
	private JTextField textFieldKundenname;
	private JButton btnNewButtonBestellen;
	private JLabel lblNewLabelWarenkorb;
	private JLabel lblNewLabelGesamtpreis;
	private JTextField textFieldGesamtpreis;
	private JLabel lblNewLabelEinzelPreis;
	private JTextField textFieldEinzelPreis;
	private JLabel lblNewLabelIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Warenkorb frame = new Warenkorb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Warenkorb() 
	{
		initialize();
	}
	private void initialize() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getListAngebote());
		contentPane.add(getBtnNewButtonKaufen());
		contentPane.add(getBtnNewButtonZurueck());
		contentPane.add(getListEinkaufe());
		contentPane.add(getLblNewLabelKundenname());
		contentPane.add(getTextFieldKundenname());
		contentPane.add(getBtnNewButtonBestellen());
		contentPane.add(getLblNewLabelWarenkorb());
		contentPane.add(getLblNewLabelGesamtpreis());
		contentPane.add(getTextFieldGesamtpreis());
		contentPane.add(getLblNewLabelEinzelPreis());
		contentPane.add(getTextFieldEinzelPreis());
		contentPane.add(getLblNewLabelIcon());
	}
	protected JList getListAngebote() 
	{
		if (listAngebote == null) 
		{
			listAngebote = new JList();
			listAngebote.setBounds(30, 148, 193, 195);
		}
		return listAngebote;
	}
	protected JButton getBtnNewButtonKaufen() 
	{
		if (btnNewButtonKaufen == null) 
		{
			btnNewButtonKaufen = new JButton(">");
			btnNewButtonKaufen.setBounds(257, 201, 109, 23);
		}
		return btnNewButtonKaufen;
	}
	protected JButton getBtnNewButtonZurueck() 
	{
		if (btnNewButtonZurueck == null) 
		{
			btnNewButtonZurueck = new JButton("<");
			btnNewButtonZurueck.setBounds(257, 290, 109, 23);
		}
		return btnNewButtonZurueck;
	}
	protected JList getListEinkaufe() 
	{
		if (listEinkaufe == null) 
		{
			listEinkaufe = new JList();
			listEinkaufe.setBounds(404, 148, 193, 195);
		}
		return listEinkaufe;
	}
	protected JLabel getLblNewLabelKundenname() 
	{
		if (lblNewLabelKundenname == null) 
		{
			lblNewLabelKundenname = new JLabel("Kundenname:");
			lblNewLabelKundenname.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelKundenname.setBounds(30, 441, 109, 23);
		}
		return lblNewLabelKundenname;
	}
	protected JTextField getTextFieldKundenname() 
	{
		if (textFieldKundenname == null) 
		{
			textFieldKundenname = new JTextField();
			textFieldKundenname.setBounds(149, 444, 165, 20);
			textFieldKundenname.setColumns(10);
		}
		return textFieldKundenname;
	}
	protected JButton getBtnNewButtonBestellen() 
	{
		if (btnNewButtonBestellen == null) 
		{
			btnNewButtonBestellen = new JButton("Bestellung abschicken");
			btnNewButtonBestellen.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButtonBestellen.setBounds(404, 428, 193, 23);
		}
		return btnNewButtonBestellen;
	}
	protected JLabel getLblNewLabelWarenkorb() 
	{
		if (lblNewLabelWarenkorb == null) 
		{
			lblNewLabelWarenkorb = new JLabel("Warenkorb");
			lblNewLabelWarenkorb.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelWarenkorb.setBounds(404, 117, 96, 20);
		}
		return lblNewLabelWarenkorb;
	}
	protected JLabel getLblNewLabelGesamtpreis() 
	{
		if (lblNewLabelGesamtpreis == null) 
		{
			lblNewLabelGesamtpreis = new JLabel("Gesamtpreis:");
			lblNewLabelGesamtpreis.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelGesamtpreis.setBounds(30, 408, 96, 22);
		}
		return lblNewLabelGesamtpreis;
	}
	protected JTextField getTextFieldGesamtpreis() 
	{
		if (textFieldGesamtpreis == null) 
		{
			textFieldGesamtpreis = new JTextField();
			textFieldGesamtpreis.setBounds(149, 413, 165, 20);
			textFieldGesamtpreis.setColumns(10);
		}
		return textFieldGesamtpreis;
	}
	protected JLabel getLblNewLabelEinzelPreis() 
	{
		if (lblNewLabelEinzelPreis == null) 
		{
			lblNewLabelEinzelPreis = new JLabel("Preis des angeklickten:");
			lblNewLabelEinzelPreis.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabelEinzelPreis.setBounds(30, 505, 171, 26);
		}
		return lblNewLabelEinzelPreis;
	}
	protected JTextField getTextFieldEinzelPreis() 
	{
		if (textFieldEinzelPreis == null) 
		{
			textFieldEinzelPreis = new JTextField();
			textFieldEinzelPreis.setBounds(211, 510, 155, 20);
			textFieldEinzelPreis.setColumns(10);
		}
		return textFieldEinzelPreis;
	}
	protected JLabel getLblNewLabelIcon() 
	{
		if (lblNewLabelIcon == null) 
		{
			ImageIcon ico = new ImageIcon("C:\\\\\\\\Users\\\\\\\\49157\\\\\\\\Schule\\\\\\\\Java_Schule\\\\\\\\Eclipse Aufgaben\\\\\\\\Eclipse 2020-09\\\\\\\\Dateiverarbeitung\\\\\\\\Markenname.jpg");
	        ico.setImage(ico.getImage().getScaledInstance(428,80,Image.SCALE_DEFAULT));
			lblNewLabelIcon = new JLabel(ico);
			lblNewLabelIcon.setBounds(30, 11, 428, 80);
		}
		return lblNewLabelIcon;
	}
}

package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Zapfsaule extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxTreibstoff;
	private JLabel lblNewLabelSuperPlus;
	private JLabel lblNewLabelDiesel;
	private JLabel lblNewLabelSuper;
	private JLabel lblNewLabel_3;
	private JTextField textFieldDiesel;
	private JTextField textFieldSuperplus;
	private JTextField textFieldSuper;
	private JTextField textFieldBenzin;
	private JLabel lblNewLabelBenzin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zapfsaule frame = new Zapfsaule();
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
	public Zapfsaule() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComboBoxTreibstoff());
		contentPane.add(getLblNewLabelSuperPlus());
		contentPane.add(getLblNewLabelDiesel());
		contentPane.add(getLblNewLabelSuper());
		contentPane.add(getTextFieldDiesel());
		contentPane.add(getTextFieldSuperplus());
		contentPane.add(getTextFieldSuper());
		contentPane.add(getTextFieldBenzin());
		contentPane.add(getLblNewLabelBenzin());
	}

	protected JComboBox getComboBoxTreibstoff() {
		if (comboBoxTreibstoff == null) {
			comboBoxTreibstoff = new JComboBox();
			comboBoxTreibstoff.setBounds(20, 11, 328, 22);
		}
		return comboBoxTreibstoff;
	}
	private JLabel getLblNewLabelSuperPlus() {
		if (lblNewLabelSuperPlus == null) {
			lblNewLabelSuperPlus = new JLabel("SuperPlus");
			lblNewLabelSuperPlus.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelSuperPlus.setBounds(20, 138, 101, 14);
		}
		return lblNewLabelSuperPlus;
	}
	private JLabel getLblNewLabelDiesel() {
		if (lblNewLabelDiesel == null) {
			lblNewLabelDiesel = new JLabel("Diesel");
			lblNewLabelDiesel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelDiesel.setBounds(20, 176, 76, 31);
		}
		return lblNewLabelDiesel;
	}
	private JLabel getLblNewLabelSuper() {
		if (lblNewLabelSuper == null) {
			lblNewLabelSuper = new JLabel("Super");
			lblNewLabelSuper.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelSuper.setBounds(20, 86, 76, 31);
		}
		return lblNewLabelSuper;
	}
	protected JTextField getTextFieldDiesel() {
		if (textFieldDiesel == null) {
			textFieldDiesel = new JTextField();
			textFieldDiesel.setBounds(106, 183, 96, 20);
			textFieldDiesel.setColumns(10);
		}
		return textFieldDiesel;
	}
	protected JTextField getTextFieldSuperplus() {
		if (textFieldSuperplus == null) {
			textFieldSuperplus = new JTextField();
			textFieldSuperplus.setBounds(131, 137, 96, 20);
			textFieldSuperplus.setColumns(10);
		}
		return textFieldSuperplus;
	}
	protected JTextField getTextFieldSuper() {
		if (textFieldSuper == null) {
			textFieldSuper = new JTextField();
			textFieldSuper.setBounds(106, 93, 96, 20);
			textFieldSuper.setColumns(10);
		}
		return textFieldSuper;
	}
	protected JTextField getTextFieldBenzin() {
		if (textFieldBenzin == null) {
			textFieldBenzin = new JTextField();
			textFieldBenzin.setBounds(106, 51, 96, 20);
			textFieldBenzin.setColumns(10);
		}
		return textFieldBenzin;
	}
	private JLabel getLblNewLabelBenzin() {
		if (lblNewLabelBenzin == null) {
			lblNewLabelBenzin = new JLabel("Benzin");
			lblNewLabelBenzin.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelBenzin.setBounds(20, 44, 76, 31);
		}
		return lblNewLabelBenzin;
	}
}

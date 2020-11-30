package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Eingaben extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabelBenzin;
	private JLabel lblNewLabelSuperPlus;
	private JLabel lblNewLabelDiesel;
	private JLabel lblNewLabelSuper;
	private JTextField textFieldBenzin;
	private JTextField textFieldDiesel;
	private JTextField textFieldSuper;
	private JTextField textFieldSuperPlus;
	private JButton btnNewButtonAktivieren;
	private JSlider sliderBenzin;
	private JSlider sliderSuper;
	private JSlider sliderSuperPlus;
	private JSlider sliderDiesel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eingaben frame = new Eingaben();
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
	public Eingaben() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabelBenzin());
		contentPane.add(getLblNewLabelSuperPlus());
		contentPane.add(getLblNewLabelDiesel());
		contentPane.add(getLblNewLabelSuper());
		contentPane.add(getTextFieldBenzin());
		contentPane.add(getTextFieldDiesel());
		contentPane.add(getTextFieldSuper());
		contentPane.add(getTextFieldSuperPlus());
		contentPane.add(getBtnNewButtonAktivieren());
		contentPane.add(getSliderBenzin());
		contentPane.add(getSliderSuper());
		contentPane.add(getSliderSuperPlus());
		contentPane.add(getSliderDiesel());
	}

	protected JLabel getLblNewLabelBenzin() {
		if (lblNewLabelBenzin == null) {
			lblNewLabelBenzin = new JLabel("Benzin");
			lblNewLabelBenzin.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelBenzin.setBounds(22, 11, 67, 23);
		}
		return lblNewLabelBenzin;
	}
	protected JLabel getLblNewLabelSuperPlus() {
		if (lblNewLabelSuperPlus == null) {
			lblNewLabelSuperPlus = new JLabel("SuperPlus");
			lblNewLabelSuperPlus.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelSuperPlus.setBounds(22, 121, 89, 32);
		}
		return lblNewLabelSuperPlus;
	}
	protected JLabel getLblNewLabelDiesel() {
		if (lblNewLabelDiesel == null) {
			lblNewLabelDiesel = new JLabel("Diesel");
			lblNewLabelDiesel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelDiesel.setBounds(22, 179, 60, 32);
		}
		return lblNewLabelDiesel;
	}
	protected JLabel getLblNewLabelSuper() {
		if (lblNewLabelSuper == null) {
			lblNewLabelSuper = new JLabel("Super");
			lblNewLabelSuper.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabelSuper.setBounds(22, 59, 66, 31);
		}
		return lblNewLabelSuper;
	}
	protected JTextField getTextFieldBenzin() {
		if (textFieldBenzin == null) {
			textFieldBenzin = new JTextField();
			textFieldBenzin.setBounds(99, 14, 96, 20);
			textFieldBenzin.setColumns(10);
		}
		return textFieldBenzin;
	}
	protected JTextField getTextFieldDiesel() {
		if (textFieldDiesel == null) {
			textFieldDiesel = new JTextField();
			textFieldDiesel.setBounds(99, 187, 96, 20);
			textFieldDiesel.setColumns(10);
		}
		return textFieldDiesel;
	}
	protected JTextField getTextFieldSuper() {
		if (textFieldSuper == null) {
			textFieldSuper = new JTextField();
			textFieldSuper.setBounds(99, 66, 96, 20);
			textFieldSuper.setColumns(10);
		}
		return textFieldSuper;
	}
	protected JTextField getTextFieldSuperPlus() {
		if (textFieldSuperPlus == null) {
			textFieldSuperPlus = new JTextField();
			textFieldSuperPlus.setBounds(121, 129, 96, 20);
			textFieldSuperPlus.setColumns(10);
		}
		return textFieldSuperPlus;
	}
	protected JButton getBtnNewButtonAktivieren() {
		if (btnNewButtonAktivieren == null) {
			btnNewButtonAktivieren = new JButton("Aktivieren");
			btnNewButtonAktivieren.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButtonAktivieren.setBounds(22, 234, 458, 56);
		}
		return btnNewButtonAktivieren;
	}
	protected JSlider getSliderBenzin() {
		if (sliderBenzin == null) {
			sliderBenzin = new JSlider();
			sliderBenzin.setMaximum(500);
			sliderBenzin.setBounds(205, 15, 200, 19);
		}
		return sliderBenzin;
	}
	protected JSlider getSliderSuper() {
		if (sliderSuper == null) {
			sliderSuper = new JSlider();
			sliderSuper.setMaximum(500);
			sliderSuper.setBounds(205, 71, 200, 19);
		}
		return sliderSuper;
	}
	protected JSlider getSliderSuperPlus() {
		if (sliderSuperPlus == null) {
			sliderSuperPlus = new JSlider();
			sliderSuperPlus.setMaximum(500);
			sliderSuperPlus.setBounds(227, 134, 200, 19);
		}
		return sliderSuperPlus;
	}
	protected JSlider getSliderDiesel() {
		if (sliderDiesel == null) {
			sliderDiesel = new JSlider();
			sliderDiesel.setMaximum(500);
			sliderDiesel.setBounds(205, 192, 200, 19);
		}
		return sliderDiesel;
	}
}

package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Anzeige extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabelSuper;
	private JLabel lblNewLabelBenzin;
	private JLabel lblNewLabelDiesel;
	private JLabel lblNewLabelSuperPlus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anzeige frame = new Anzeige();
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
	public Anzeige() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabelSuper());
		contentPane.add(getLblNewLabelBenzin());
		contentPane.add(getLblNewLabelDiesel());
		contentPane.add(getLblNewLabelSuperPlus());
	}

	protected JLabel getLblNewLabelSuper() {
		if (lblNewLabelSuper == null) {
			lblNewLabelSuper = new JLabel(" ");
			lblNewLabelSuper.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabelSuper.setBounds(10, 77, 246, 22);
		}
		return lblNewLabelSuper;
	}
	protected JLabel getLblNewLabelBenzin() {
		if (lblNewLabelBenzin == null) {
			lblNewLabelBenzin = new JLabel(" ");
			lblNewLabelBenzin.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabelBenzin.setBounds(10, 25, 246, 22);
		}
		return lblNewLabelBenzin;
	}
	protected JLabel getLblNewLabelDiesel() {
		if (lblNewLabelDiesel == null) {
			lblNewLabelDiesel = new JLabel(" ");
			lblNewLabelDiesel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabelDiesel.setBounds(10, 186, 246, 22);
		}
		return lblNewLabelDiesel;
	}
	protected JLabel getLblNewLabelSuperPlus() {
		if (lblNewLabelSuperPlus == null) {
			lblNewLabelSuperPlus = new JLabel(" ");
			lblNewLabelSuperPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabelSuperPlus.setBounds(10, 129, 246, 22);
		}
		return lblNewLabelSuperPlus;
	}
}

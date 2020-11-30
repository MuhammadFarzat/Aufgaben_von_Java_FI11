package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Font;

public class Handy_App extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox comboBoxTreibstoff;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Handy_App frame = new Handy_App();
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
	public Handy_App() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getComboBoxTreibstoff());
		contentPane.add(getList());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tanki");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(10, 11, 72, 30);
		}
		return lblNewLabel;
	}
	protected JComboBox getComboBoxTreibstoff() {
		if (comboBoxTreibstoff == null) {
			comboBoxTreibstoff = new JComboBox();
			comboBoxTreibstoff.setBounds(10, 52, 340, 22);
		}
		return comboBoxTreibstoff;
	}
	protected JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(10, 85, 340, 167);
		}
		return list;
	}
}

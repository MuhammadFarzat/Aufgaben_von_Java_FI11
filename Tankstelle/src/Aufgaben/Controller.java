package Aufgaben;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Controller 
{
	private Zapfsaule zapf;
	private Handy_App handy;
	private Anzeige anzeige;
	private Eingaben eingaben;
	private DefaultComboBoxModel<Treibstoff> treibstoffCombobox;
	private DefaultListModel<Treibstoff> treibstofflist;
	private MouseAdapter aktivieren;
	private ChangeListener change;
	public Controller()
	{ 
		treibstoffCombobox = new DefaultComboBoxModel<Treibstoff>();
		treibstofflist = new DefaultListModel<Treibstoff>();
		zapf = new Zapfsaule();
		handy = new Handy_App();
		anzeige = new Anzeige();
		eingaben = new Eingaben();
		eingaben.setVisible(true);
		change = new ChangeListener() 
		{
			public void stateChanged(ChangeEvent e) 
			{
				aendereWerte();
			}
		};
		eingaben.getSliderBenzin().addChangeListener(change);
		eingaben.getSliderSuper().addChangeListener(change);
		eingaben.getSliderSuperPlus().addChangeListener(change);
		eingaben.getSliderDiesel().addChangeListener(change);
		aktivieren = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
		
				//JOptionPane.showMessageDialog(null,"Sie haben noch keine Bestellungen hinzugefügt","Hinweis", JOptionPane.PLAIN_MESSAGE);
				if(eingaben.getTextFieldBenzin().getText() == "" || eingaben.getTextFieldDiesel().getText() == "" || eingaben.getTextFieldSuper().getText() == "" || eingaben.getTextFieldSuperPlus().getText() == "")
				{
					JOptionPane.showMessageDialog(null,"Sie müssen alle Felder ausfüllen","Hinweis", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					
					anzeige.getLblNewLabelBenzin().setText("Benzin: "+eingaben.getTextFieldBenzin().getText());
					anzeige.getLblNewLabelSuper().setText("Super: "+eingaben.getTextFieldSuper().getText());
					anzeige.getLblNewLabelSuperPlus().setText("Super Plus: " + eingaben.getTextFieldSuperPlus().getText());
					anzeige.getLblNewLabelDiesel().setText("Diesel: "+eingaben.getTextFieldDiesel().getText());
					try
					{
						Treibstoff tr = new Treibstoff(eingaben.getLblNewLabelBenzin().getText(), Double.parseDouble(eingaben.getTextFieldBenzin().getText().replace(',', '.')));
						treibstoffCombobox.addElement(tr);		
						treibstofflist.addElement(tr);
						Treibstoff tr2 = new Treibstoff(eingaben.getLblNewLabelSuper().getText(), Double.parseDouble(eingaben.getTextFieldSuper().getText().replace(',', '.')));
						treibstoffCombobox.addElement(tr2);		
						treibstofflist.addElement(tr2);
						Treibstoff tr3 = new Treibstoff(eingaben.getLblNewLabelSuperPlus().getText(), Double.parseDouble(eingaben.getTextFieldSuperPlus().getText().replace(',', '.')));
						treibstoffCombobox.addElement(tr3);		
						treibstofflist.addElement(tr3);
						Treibstoff tr4 = new Treibstoff(eingaben.getLblNewLabelDiesel().getText(), Double.parseDouble(eingaben.getTextFieldDiesel().getText().replace(',', '.')));
						treibstoffCombobox.addElement(tr4);		
						treibstofflist.addElement(tr4);
						zapf.getComboBoxTreibstoff().setModel(treibstoffCombobox);
						handy.getComboBoxTreibstoff().setModel(treibstoffCombobox);
						handy.getList().setModel(treibstofflist);
						zapf.getTextFieldBenzin().setText(eingaben.getTextFieldBenzin().getText());
						zapf.getTextFieldDiesel().setText(eingaben.getTextFieldDiesel().getText());
						zapf.getTextFieldSuper().setText(eingaben.getTextFieldSuper().getText());
						zapf.getTextFieldSuperplus().setText(eingaben.getTextFieldSuperPlus().getText());
						
						aktivieren();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,"Geben Sie bitte nur Zahlen ein","Hinweis", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			
		};
		
		eingaben.getBtnNewButtonAktivieren().addMouseListener(aktivieren);
	}
	public void aktivieren()
	{
		anzeige.setVisible(true);
		handy.setVisible(true);
		zapf.setVisible(true);
	}
	public void aendereWerte()
	{
		eingaben.getTextFieldBenzin().setText(""+((eingaben.getSliderBenzin().getValue())/(double)100)); 
		eingaben.getTextFieldSuperPlus().setText(""+((eingaben.getSliderSuperPlus().getValue())/100.00)); 
		eingaben.getTextFieldSuper().setText(""+((eingaben.getSliderSuper().getValue())/100.00)); 
		eingaben.getTextFieldDiesel().setText(""+((eingaben.getSliderDiesel().getValue())/100.00)); 
	}
}

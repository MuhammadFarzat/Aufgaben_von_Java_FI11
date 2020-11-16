package ersteAufgabe;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.List;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class Controller
{
	private PizzaGUI view;
	private DefaultComboBoxModel<Pizzen> pizzaCombobox;
	private DefaultComboBoxModel<Groesse> groesseCombobox;
	private DefaultListModel<gesamtpizza> bestellliste;
	private DefaultListModel<gesamtpizza> bestelllistekopie;
	private ActionListener hinzu;
	private ActionListener allesweg;
	private ActionListener entferne;
	private ActionListener doppeln;
	private ItemListener change;
	private double gesamtpreis;
	private double preis;
	
	public Controller()
	{
		
		view = new PizzaGUI();
		JScrollPane s = new JScrollPane(view.getBestellListe());
	    s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    view.getFrame().add(s);
	    s.setBounds(69, 122, 237, 226);
	    s.setVisible(true);
		pizzaCombobox = new DefaultComboBoxModel<Pizzen>();
		groesseCombobox = new DefaultComboBoxModel<Groesse>();
		bestellliste = new DefaultListModel<gesamtpizza>();
		pizzaCombobox.addElement(new Pizzen("Salami", 10)); 
		pizzaCombobox.addElement(new Pizzen("Käse", 9)); 
		view.getComboBoxPizza().setModel(pizzaCombobox);
		groesseCombobox.addElement(new Groesse("Groß", 3));
		groesseCombobox.addElement(new Groesse("Mittel", 1.5));
		groesseCombobox.addElement(new Groesse("Klein", 0));
		view.getComboBoxGroesse().setModel(groesseCombobox);
		preisvonpizza();
		gesamtpreis = 0;
		view.getTextFieldGesamtPreis().setText(gesamtpreis + "");
		change = new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				preisvonpizza();
			}
		};
		hinzu = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				hinzufuegen(view.getComboBoxPizza().getSelectedItem(), view.getComboBoxGroesse().getSelectedItem(), view.getTextFieldExtras().getText());
			}
			
		};
		entferne = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				entfernen(view.getBestellListe().getSelectedValuesList());
			}
			
		};
		allesweg = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(bestellliste.getSize() == 0)
				{
					JOptionPane.showMessageDialog(null,"Es gibt keine Bestellungen zum Löschen.","Hinweis!", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					bestellliste.removeAllElements();
					gesamtpreis = 0;
					view.getTextFieldGesamtPreis().setText(gesamtpreis + "");
				}
			}
			
		};
		doppeln = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				kopieren();
			}
			
		};
		view.getButtonHinzufuegen().addActionListener(hinzu);
		view.getButtonEntfernen().addActionListener(entferne);
		view.getComboBoxPizza().addItemListener(change);
		view.getComboBoxGroesse().addItemListener(change);
		view.getButtonAllesEntfernen().addActionListener(allesweg);
		view.getButtonDoppeln().addActionListener(doppeln);;
	}
	public void hinzufuegen(Object p, Object g, String e)
	{
		try
		{
			Pizzen pizza = (Pizzen) p;
			Groesse groesse = (Groesse) g;
			Extras extras = new Extras();
			extras.setExtra(e);
			gesamtpizza gesamt = new gesamtpizza(pizza, groesse, extras);
			bestellliste.addElement(gesamt);
			view.getBestellListe().setModel(bestellliste);
			gesamtpreis += pizza.getPreis() + groesse.getZusatz();
			view.getTextFieldGesamtPreis().setText(gesamtpreis + "");
		}
		catch(Exception ex)
		{
			
		}
	}
	public void entfernen(List list)
	{
		try
		{
			if(bestellliste.getSize() == 0)
				JOptionPane.showMessageDialog(null,"Sie haben noch keine Bestellungen hinzugefügt","Hinweis", JOptionPane.PLAIN_MESSAGE);
			else if(list.size() == 0)
				JOptionPane.showMessageDialog(null,"Wählen Sie mindestens eine Zeile aus.","Hinweis", JOptionPane.PLAIN_MESSAGE);
			for (Object gesamt : list) 
			{
				bestellliste.removeElement((gesamtpizza)gesamt);
				gesamtpreis -= ((gesamtpizza)gesamt).getPizza().getPreis() + ((gesamtpizza)gesamt).getGroesse().getZusatz();
			}
			view.getTextFieldGesamtPreis().setText(gesamtpreis + "");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Es ist ein Fehler aufgetreten","Fehler", JOptionPane.PLAIN_MESSAGE);
		}
	}
	public void preisvonpizza()
	{
		Pizzen pizza = (Pizzen) view.getComboBoxPizza().getSelectedItem();
		Groesse groesse = (Groesse) view.getComboBoxGroesse().getSelectedItem();
		preis = groesse.getZusatz() + pizza.getPreis();
		view.getTextFieldPreis().setText(preis + "");
	}
	public void kopieren()
	{
		if(bestellliste.getSize() != 0)
		{
			bestelllistekopie = new DefaultListModel<gesamtpizza>();
			Object pizzen[] = new Object[bestellliste.getSize()];
			bestellliste.copyInto(pizzen);
			for(Object pizza : pizzen)
			{
				bestellliste.addElement((gesamtpizza) pizza);
				
			}
			gesamtpreis = gesamtpreis * 2;
			view.getTextFieldGesamtPreis().setText(gesamtpreis + "");
		}
		else
			JOptionPane.showMessageDialog(null,"Es gibt keine Bestellungen zum kopieren","Fehler", JOptionPane.PLAIN_MESSAGE);
	}
	
}





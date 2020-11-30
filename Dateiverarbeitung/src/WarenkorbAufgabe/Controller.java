//Die Kommentare sind immer über oder neben dem gemeinten Syntax
package WarenkorbAufgabe;

import java.util.List;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.multi.MultiOptionPaneUI;

public class Controller 
{
	//Deklarierung der Variablen, Models und Listeners, die wir brauchen
	private DefaultListModel<Artikel> artikelliste;
	private DefaultListModel<Artikel> einkaufeliste;
	private MouseAdapter itemclicked;
	private MouseAdapter itemclicked2;
	private ActionListener hinzufuegen;
	private ActionListener entfernen;
	private ActionListener bestellen;
	private static double gesamtsumme = 0.00;
	private static int versuche = 1;
	private DecimalFormat bruh = new DecimalFormat("#0.00");
	Warenkorb warenkorb;
	private JFileChooser chooser;
	//Konstruktor
	public Controller()
	{
		String zeile = null;
		String[] values;
		//Initialisieren von dem Warenkorb Fenster
		warenkorb = new Warenkorb();
		warenkorb.setVisible(true);
		chooser = new JFileChooser("C:\\Users\\49157\\Schule\\Java_Schule\\Eclipse Aufgaben\\Eclipse 2020-09\\Dateiverarbeitung");
		//chooser.getComponent(0).setVisible(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.showOpenDialog(null);
		artikelliste = new DefaultListModel<Artikel>();
		einkaufeliste = new DefaultListModel<Artikel>();
		DHNIO dhio = new DHNIO();
		//Lesen der Datei
		artikelliste = dhio.leseDatei(chooser.getSelectedFile().getPath(), artikelliste);
			
		itemclicked = new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Ermittlepreis();
			}
		};
		itemclicked2 = new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Ermittlepreis2();
			}
		};
		hinzufuegen = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Hinzufuegen(warenkorb.getListAngebote().getSelectedValuesList());
			}
		};
		entfernen = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Entferne(warenkorb.getListEinkaufe().getSelectedValuesList());
			}
		};
		bestellen = new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(einkaufeliste.getSize() == 0)
				{
					JOptionPane.showMessageDialog(null,"Sie haben noch keine Artikeln ausgewählt","Hinweis", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					Ueberpruefe(warenkorb.getTextFieldKundenname().getText(), versuche);
				}
			}
		};
		//Fügt dem jeweiligen die jeweiligen Listener hinzu
		warenkorb.getListAngebote().addMouseListener(itemclicked);
		warenkorb.getListEinkaufe().addMouseListener(itemclicked2);
		warenkorb.getBtnNewButtonKaufen().addActionListener(hinzufuegen);
		warenkorb.getBtnNewButtonZurueck().addActionListener(entfernen);
		warenkorb.getBtnNewButtonBestellen().addActionListener(bestellen);
		warenkorb.getListEinkaufe().setModel(einkaufeliste);
		warenkorb.getListAngebote().setModel(artikelliste);
		
	}
	public static int getVersuche() {
		return versuche;
	}
	public static void setVersuche(int versuche) {
		Controller.versuche = versuche;
	}
	public void Ermittlepreis()
	{
			//Schreibt den Preis des gewählten Objektes von der Angebotsliste in den Textbox
			Artikel artikel = (Artikel)warenkorb.getListAngebote().getSelectedValue();
			warenkorb.getTextFieldEinzelPreis().setText("" + artikel.getPreis() + "€");
	}
	public void Ermittlepreis2()
	{
		//Schreibt den Preis des gewählten Objektes von der Einkäufeliste in den Textbox
			Artikel artikel = (Artikel)warenkorb.getListEinkaufe().getSelectedValue();
			warenkorb.getTextFieldEinzelPreis().setText("" + artikel.getPreis() + "€");
	}
	public void Hinzufuegen(List liste)
	{
		if(liste.size() == 0)
		{
			JOptionPane.showMessageDialog(null,"Sie haben keine Artikeln gewählt","Hinweis", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			for(Object artikel : liste)
			{
				Artikel arti = (Artikel)artikel;
				einkaufeliste.addElement(arti);
				gesamtsumme += arti.getPreis();
				
			}
			warenkorb.getTextFieldGesamtpreis().setText("" + (Math.round(gesamtsumme * 100.0) / 100.0) + "€");
		}
	}
	public void Entferne(List list)
	{
		if(list.size() == 0)
		{
			JOptionPane.showMessageDialog(null,"Sie haben keine Artikeln gewählt","Hinweis", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			for(Object artikel : list)
			{
				Artikel arti = (Artikel)artikel;
				einkaufeliste.removeElement(arti);
				gesamtsumme -= arti.getPreis();
				
			}
			warenkorb.getTextFieldGesamtpreis().setText("" + (Math.round(gesamtsumme * 100.0) / 100.0) + "€");
		}
	}
	public void Ueberpruefe(String kundenname, int zahl)
	{
		//Falls keine Namen eingegeben dann Messagebox ausgeben
		if(kundenname.length() == 0)
		{
			JOptionPane.showMessageDialog(null,"Sie müssen einen Namen eingeben","Hinweis", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			try
			{
				//Datei Auslesen
				FileSystem fs = FileSystems.getDefault();
				Path p = fs.getPath(kundenname+ zahl + ".txt");
				BufferedReader in = Files.newBufferedReader(p);
				//Wenn die datei existiert dann zahl hochzählen und die gleiche Funktion nochmal mit anderen Werten aufrufen
				try
				{
					zahl++;
					Ueberpruefe(kundenname, zahl);
				}
				catch(Exception ex)
				{
				}
				finally
				{
					in.close();
				}
			}
			//Wenn die Datei nicht existiert dann die Funktion Schreibe aufrufen
			catch(Exception ex)
			{
				//System.out.println(ex);
				Schreibe(kundenname, zahl);
			}
		}
	}
	public void Schreibe(String kundenname, int zahl)
	{
		try
		{
			//Datei mit dem Namen von den Parametern erstellen
			Path path = Path.of("C:\\Users\\49157\\Schule\\Java_Schule\\Eclipse Aufgaben\\Eclipse 2020-09\\Dateiverarbeitung"+"/"+kundenname+ zahl +".txt");
			DHNIO dhio = new DHNIO();
			einkaufeliste = dhio.schreibeDatei(path.toString(), einkaufeliste);
			JOptionPane.showMessageDialog(null, "Ihre Bestellung wurde uns erfolgreich gesendet","Erfolgreich erstellt :)", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex,"Hinweis", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

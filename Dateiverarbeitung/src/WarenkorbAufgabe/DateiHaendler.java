package WarenkorbAufgabe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public abstract class DateiHaendler 
{
	protected BufferedReader lesen;
	protected BufferedWriter schreiben;
	public DateiHaendler()
	{
		
	}
	public abstract DefaultListModel<Artikel> leseDatei(String name, DefaultListModel<Artikel> speicherliste);
	public abstract DefaultListModel<Artikel> schreibeDatei(String name, DefaultListModel<Artikel> eingaben);
	
	public DefaultListModel<Artikel> lese(String zeile, String[] values, DefaultListModel<Artikel> speicherliste)
	{
		try
		{
			zeile = lesen.readLine();
			while((zeile = lesen.readLine()) != null)
			{
				values = zeile.split(";");
				speicherliste.addElement(new Artikel(Integer.parseInt(values[0]), values[1], Double.parseDouble(values[2].replace(',', '.').replace('€', ' '))));
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
		finally
		{
			try 
			{
				lesen.close();	
			} 
			catch (IOException e) 
			{
				System.out.println(e);
				return null;
			}
		}
		return speicherliste;
	}
	public DefaultListModel<Artikel> schreibe(DefaultListModel<Artikel> eingaben)
	{
		try
		{
			//Die Werte von Einkäfeliste in die Datei schreiben
			int i;
			for(i = 0; i < eingaben.size(); i++)
			{
				schreiben.write(eingaben.get(i).toString()+"\n");
			}
			//versuche auf 1 gesetzt, damit der Vorgang nochmal neu richtig gemacht werden kann
			Controller.setVersuche(1);
			return eingaben;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex,"Hinweis", JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		finally
		{
			try 
			{
				schreiben.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
	}
}

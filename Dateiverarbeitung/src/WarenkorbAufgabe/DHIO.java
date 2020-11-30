package WarenkorbAufgabe;

import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class DHIO extends DateiHaendler
{
	@Override
	public DefaultListModel<Artikel> leseDatei(String name, DefaultListModel<Artikel> speicherliste)
	{
		String zeile = null;
		String[] values = null;
		try
		{
			lesen = new BufferedReader(new FileReader(name,  StandardCharsets.UTF_8));
			speicherliste = super.lese(zeile, values, speicherliste);
			return speicherliste;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
		
	}

	public DHIO() 
	{
		
	}

	@Override
	public DefaultListModel<Artikel> schreibeDatei(String name, DefaultListModel<Artikel> eingaben) 
	{
		if(eingaben.size() == 0)
		{
			return null;
		}
		else
		{
			try 
			{
				schreiben = new BufferedWriter(new FileWriter(name, true));
				eingaben = super.schreibe(eingaben);
				return eingaben;
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			
		}
	}

}

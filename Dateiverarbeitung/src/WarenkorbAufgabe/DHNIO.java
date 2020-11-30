package WarenkorbAufgabe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import com.sun.nio.file.ExtendedOpenOption;

public class DHNIO extends DateiHaendler
{

	@Override
	public DefaultListModel<Artikel> leseDatei(String name, DefaultListModel<Artikel> speicherliste) 
	{
		String zeile = null;
		String[] values = null;
		try
		{
			Path p = Paths.get(name);
			lesen = Files.newBufferedReader(p,  StandardCharsets.UTF_8);
			speicherliste = super.lese(zeile, values, speicherliste);
			return speicherliste;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return null;
		}
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
				FileSystem fs = FileSystems.getDefault();
				Path p = fs.getPath(name);
				schreiben = Files.newBufferedWriter(p, StandardCharsets.UTF_8);
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

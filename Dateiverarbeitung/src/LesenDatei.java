import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JOptionPane;

public class LesenDatei 
{
	public static void main(String[] args)
	{
		try
		{
			String zeile = null;
			FileSystem fs = FileSystems.getDefault();
			Path p = fs.getPath("Test.txt");
			BufferedReader in = Files.newBufferedReader(p);
			
			try
			{
				while((zeile = in.readLine()) != null)//Lesen einer Zeile bin \n
				{
					JOptionPane.showMessageDialog(null,zeile,"Ihre Eingabe", JOptionPane.PLAIN_MESSAGE);
				}
			}
			catch(IOException ex)
			{
				JOptionPane.showMessageDialog(null,ex,"Fehler", JOptionPane.PLAIN_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null,ex,"Fehler", JOptionPane.PLAIN_MESSAGE);
			}
			finally
			{
				in.close();
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex,"Fehler", JOptionPane.PLAIN_MESSAGE);
		}
	}
}

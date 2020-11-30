import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;


public class SchreibenDatei
{

	public static void main(String[] args) 
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			//Alternative wäre dann (Scanner in = new Scanner(System.in))
			FileSystem fs = FileSystems.getDefault();
			Path p = fs.getPath("Test.txt");
			BufferedWriter out = Files.newBufferedWriter(p);
			try
			{
				out.write(in.readLine() + "\n");
				//Oder eine Alternative zu \n ist das daunten
				//out.newLine();
			}
			catch(IOException ex)
			{
				JOptionPane.showMessageDialog(null,ex,"Fehler", JOptionPane.PLAIN_MESSAGE);
			}
			finally
			{
				out.close();
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,ex,"Fehler", JOptionPane.PLAIN_MESSAGE);
		}
	}

}

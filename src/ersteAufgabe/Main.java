package ersteAufgabe;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
public class Main {

	public static void main(String[] args) {

		    String subject[] = { "Math", " English", "SQL", "   java", "  c ", " c++ ",
		        " cobol ", "this is a test" };
		    JFrame f = new JFrame();
	
		    JList<String> list = new JList<String>(subject);
		    JScrollPane s = new JScrollPane(list);
		    s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		    f.add(s);
		    f.setSize(300, 300);
		    f.setVisible(true);
		  }
		
	}



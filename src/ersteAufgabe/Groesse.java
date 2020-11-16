package ersteAufgabe;

public class Groesse 
{
	private String groesse;
	private double zusatz = 0;
	public double getZusatz() {
		return zusatz;
	}
	public void setZusatz(double zusatz) {
		this.zusatz = zusatz;
	}
	public Groesse(String g, double zusatz)
	{
		this.groesse = g;
		this.zusatz = zusatz;
	}
	public Groesse(String g)
	{
		this.groesse = g;
	}
	public String toString()
	{
		return groesse;
	}
}

package ersteAufgabe;

public class Pizzen 
{
	private String bezeichnung;
	private double preis;
	
	public Pizzen(String bezeichnung, double preis)
	{
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}
	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung = bezeichnung;
	}
	public String getBezeichnung()
	{
		return bezeichnung;
	}
	public void setPreis(double preis)
	{
		this.preis = preis;
	}
	public double getPreis()
	{
		return preis;
	}
	public String toString()
	{
		return bezeichnung;
	}
	public String toString(Groesse groesse)
	{
		return "Pizza " + bezeichnung + " Groesse: " + groesse;
	}
}

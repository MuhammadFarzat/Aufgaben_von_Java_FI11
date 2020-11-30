package WarenkorbAufgabe;

public class Artikel 
{
	private int artnummer;
	private String artname;
	private double preis;
	public Artikel(int artnummer, String artname, double preis) 
	{
		this.artnummer = artnummer;
		this.artname = artname;
		this.preis = preis;
	}
	public Artikel(String artname, double preis) 
	{
		this.artname = artname;
		this.preis = preis;
	}
	public Artikel(int artnummer, double preis) 
	{
		this.artnummer = artnummer;
		this.preis = preis;
	}
	public Artikel(int artnummer, String artname) 
	{
		this.artnummer = artnummer;
		this.artname = artname;
	}
	public Artikel(double preis) 
	{
		this.preis = preis;
	}
	public Artikel(int artnummer) 
	{
		this.artnummer = artnummer;
	}
	public Artikel(String artname) 
	{
		
		this.artname = artname;
	}
	public int getArtnummer() {
		return artnummer;
	}
	public void setArtnummer(int artnummer) {
		this.artnummer = artnummer;
	}
	public String getArtname() {
		return artname;
	}
	public void setArtname(String artname) {
		this.artname = artname;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String toString()
	{
		return artnummer + " " + artname;
	}
}

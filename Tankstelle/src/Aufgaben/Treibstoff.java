package Aufgaben;

public class Treibstoff {
	private String name;
	private double preis;
	public Treibstoff(String name, double preis)
	{
		this.name = name;
		this.preis = preis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String toString()
	{
		return name + " " + preis;
	}
}

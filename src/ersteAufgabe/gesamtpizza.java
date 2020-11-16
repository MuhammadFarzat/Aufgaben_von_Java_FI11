package ersteAufgabe;

public class gesamtpizza 
{
	private Pizzen pizza;
	public Pizzen getPizza() {
		return pizza;
	}
	private Groesse groesse;
	
	public Groesse getGroesse() {
		return groesse;
	}
	public gesamtpizza(Pizzen pizza, Groesse groesse)
	{
		this.pizza = pizza;
		this.groesse = groesse;
	}
	public gesamtpizza(Pizzen pizza, Groesse groesse, Extras extras)
	{
		this.pizza = pizza;
		this.groesse = groesse;
		this.extras = extras;
	}
	private Extras extras;
	public Extras getExtras() {
		return extras;
	}
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
	public gesamtpizza()
	{
		
	}
	public String toString()
	{
		return "Pizza: " + pizza + ", Groesse: " + groesse + ", Extra: " + extras;
	}
}

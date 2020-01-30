package ticketshop;

public abstract class Veranstaltung {
	
	protected String name;
	protected int verfuegbareTickets;
	protected String ort;
	protected String datum;
	
	public Veranstaltung(String name,int vervuegbareTickets,String ort,String datum) {
		this.name = name;
		this.verfuegbareTickets = vervuegbareTickets;
		this.ort = ort;
		this.datum = datum;
	}
	
	protected abstract void ausgabe();
	protected void ausgabeName() {
		System.out.println(name);
	}
	protected abstract void berechnung();
}

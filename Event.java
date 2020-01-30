package ticketshop;

import java.util.Scanner;

public class Event extends Veranstaltung implements Platz {
	
	protected String enddatum;
	
	public Event(String name,int vervuegbareTickets,String ort,String datum,String enddatum) {
		super(name, vervuegbareTickets, ort, datum);
		this.enddatum = enddatum;
	}

	protected void ausgabe() {
		System.out.println(name);
		System.out.println("Es sind noch "+ verfuegbareTickets +" Tickets verfühgbar");
		System.out.println(ort);
		System.out.println(datum +" - "+ enddatum);
	}
	protected void berechnung() {
		double preis = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Zu welcher Altersklasse gehoeren Sie? Waehlen Sie zwischen Kind, Erwachsener und Senior");
		String eingabe = sc.nextLine();
		if(eingabe.equalsIgnoreCase("Kind")) preis = preis * preisKind;
		if(eingabe.equalsIgnoreCase("Erwachsener")) preis = preis * preisErwachsener;
		if(eingabe.equalsIgnoreCase("Senior")) preis = preis * preisSenior;
		System.out.println("Dies macht einen Gesamtwert von "+preis*1.20);
		sc.close();
	}
	
}

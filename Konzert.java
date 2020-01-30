package ticketshop;

import java.util.Scanner;

public class Konzert extends Veranstaltung implements Platz {
	
	protected String vorband;
	
	public Konzert(String name,int vervuegbareTickets,String ort,String datum,String vorband) {
		super(name, vervuegbareTickets, ort, datum);
		this.vorband = vorband;
	}

	protected void ausgabe() {
		System.out.println(name);
		System.out.println("Es sind noch "+ verfuegbareTickets +" Tickets verfühgbar");
		System.out.println(ort);
		System.out.println(datum);
		System.out.println("Auserdem:"+ vorband);
	}
	
	protected void berechnung() {
		double preis = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Wollen sie einen Steh- oder Sitzplatz.");
		String eingabe = sc.nextLine();	
		if(eingabe.equalsIgnoreCase("Stehplatz"))  preis = preis + konzertStehPlatz;
		if(eingabe.equalsIgnoreCase("Sitzplatz")) preis = preis + konzertSitzPlatz;
		System.out.println("Zu welcher Altersklasse gehoeren Sie? Waehlen Sie zwischen Kind, Erwachsener und Senior");
		eingabe = sc.nextLine();
		if(eingabe.equalsIgnoreCase("Kind")) preis = preis * preisKind;
		if(eingabe.equalsIgnoreCase("Erwachsener")) preis = preis * preisErwachsener;
		if(eingabe.equalsIgnoreCase("Senior")) preis = preis * preisSenior;
		System.out.println("Dies macht einen Gesamtwert von "+preis*1.20);
		}
}

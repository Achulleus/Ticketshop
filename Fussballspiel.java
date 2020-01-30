package ticketshop;

import java.util.Scanner;

public class Fussballspiel extends Veranstaltung implements Platz{
	
	protected double heimteam = 1;
	protected double gastteam = 1;
	protected double gesStimmen = 1;
	protected double unentschieden = 1;
	protected double heimquote = 1;
	protected double auswaertsquote = 1;
	protected double remiequote = 1;
	protected String heimteamname;
	protected String gastteamname;
	
	public Fussballspiel(String name,int vervuegbareTickets,String ort,String datum,String heimteamname,String gastteamname) {
		super(name, vervuegbareTickets, ort, datum);
		this.heimteamname = heimteamname;
		this.gastteamname = gastteamname;
	}

	public void ausgabe() {
		System.out.println(name);
		System.out.println("Es sind noch "+ verfuegbareTickets +" Tickets verfühgbar");
		System.out.println(ort);
		System.out.println(datum);
		System.out.println(heimquote +" x "+ remiequote +" x "+ auswaertsquote);
	}
	
	public void berechnen(){
		heimquote = 100/((heimteam/gesStimmen)*100);
		auswaertsquote = 100/((gastteam/gesStimmen)*100);
		remiequote = 100/((unentschieden/gesStimmen)*100);
	}
	
	protected void berechnung() {
		double preis = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Wollen sie einen Steh-, Sitz- oder VIP-Platz");
		String eingabe = sc.nextLine();
		if(eingabe.equalsIgnoreCase("Stehplatz"))  preis = preis + fussballStehPlatz;
		if(eingabe.equalsIgnoreCase("Sitzplatz")) preis = preis + fussballSitzPlatz;
		if(eingabe.equalsIgnoreCase("vipplatz")) preis = preis + fussballVipPlatz;
		System.out.println("Zu welcher Altersklasse gehoeren Sie? Waehlen Sie zwischen Kind, Erwachsener und Senior");
		eingabe = sc.nextLine();
		if(eingabe.equalsIgnoreCase("Kind")) preis = preis * preisKind;
		if(eingabe.equalsIgnoreCase("Erwachsener")) preis = preis * preisErwachsener;
		if(eingabe.equalsIgnoreCase("Senior")) preis = preis * preisSenior;
		System.out.println("Dies macht einen Gesamtwert von "+preis*1.20);
	}
}

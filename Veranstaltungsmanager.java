package ticketshop;

import java.util.ArrayList;

public class Veranstaltungsmanager implements Platz{
	
	protected static int heimteam;
	protected static int gastteam;
	protected static int gesStimmen;
	protected static int unentschieden;
	protected static int heimquote;
	protected static int auswaertsquote;
	protected static int remiequote;
	
	private ArrayList<Veranstaltung> veranstaltungsliste = new ArrayList<Veranstaltung>();
	
	public Veranstaltungsmanager() {
		veranstaltungsliste.add(new Konzert("ACDC",100000,"Ernst Happel Station","2020-12-03 18:00","Airbourn"));
		veranstaltungsliste.add(new Konzert("Metallica",100000,"Ernst Happel Station","2020-03-15 18:00","Gohst"));
		veranstaltungsliste.add(new Event("Nova Rock",500000,"Burgenland","2020-06-10","2020-06-13"));
		veranstaltungsliste.add(new Fussballspiel("FC Liverpool vs Manchaster City",60000,"Liverpool","2021-07-03","fc liverpool","manchaster city"));		
	}
	
	public void ausgeben() {
		
		for(Veranstaltung v : veranstaltungsliste) {
			System.out.println(v.name);
		}
	}
	
	public Veranstaltung getVeranstaltungByName(String name) {
		for(Veranstaltung v : veranstaltungsliste) {
			if(v.name.equalsIgnoreCase(name)) return v;
		}
		return null;
	}
	
	public void berechnen(){
		heimquote = 100/((heimteam/gesStimmen)*100);
		auswaertsquote = 100/((gastteam/gesStimmen)*100);
		remiequote = 100/((unentschieden/gesStimmen)*100);
	}
}
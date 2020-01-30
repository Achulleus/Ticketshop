package ticketshop;

import java.util.Scanner;

public class Ausführung{
	
	//public static Veranstaltungsmanager vm = new Veranstaltungsmanager();
	public static Veranstaltung[] arr = new Veranstaltung[4];
	public static Konzert acdc = new Konzert("ACDC",100000,"Ernst Happel Station","2020-12-03 18:00","Airbourn");
	public static Konzert metallica = new Konzert("Metallica",100000,"Ernst Happel Station","2020-03-15 18:00","Gohst");
	public static Event novarock = new Event("Nova Rock",500000,"Burgenland","2020-06-10","2020-06-13");
	public static Fussballspiel lfcmnc = new Fussballspiel("FC Liverpool vs Manchaster City",60000,"Liverpool","2021-07-03","FC Liverpool","Manchaster City");
	
	public static Kunde k = new Kunde();
	private static int zustandsnr = 1;
	private static boolean login = false;

	private static void arrayBefuellen() {
		arr[0] = acdc;
		arr[1] = metallica;
		arr[2] = novarock;
		arr[3] = lfcmnc;
	}
	
	public static void main(String[] args) {
		arrayBefuellen();
		System.out.println("Willkommen im Shop");
		while(true) {
			switch(zustandsnr){
				case 1: menue1();
				break;
				case 2: login2();
				break;
				case 3: kaufen3();
				break;
				case 4: tippen4();
				break;
				case 5: anzeigen5();
				break;
				case 6: logout6();
				break;
			}
		}
	}
	
	private static void menue1() {
		System.out.println("Sie sind jetzt im Menue. Moegliche Funktionen: anzeigen, tippen, kaufen, login, infoanzeigen");
		Scanner sc = new Scanner(System.in);
		String eingabe = sc.nextLine();
		sc.reset();
		if(eingabe.equalsIgnoreCase("anzeigen")) {
		zustandsnr = 5;
		}
		if(eingabe.equalsIgnoreCase("infoanzeigen")) {
			System.out.println("Zu welcher Veranstaltung wollen Sie alle Informationen?");
			eingabe = sc.nextLine();
			for(int i = 0; i < arr.length; i++){
				if(eingabe.equalsIgnoreCase(arr[i].name)) arr[i].ausgabe();
			}
		}
		if(eingabe.equalsIgnoreCase("login")) {
			zustandsnr = 2;
		}
		if(eingabe.equalsIgnoreCase("kaufen")) {
			zustandsnr = 3;
		}
		if(eingabe.equalsIgnoreCase("tippen")) {
			zustandsnr = 4;
		}
		if(eingabe.equalsIgnoreCase("logout")) {
			zustandsnr = 6;
		}
	} 
	
	private static void login2() {
		System.out.println("Bitte Vornamen, Nachnamen und Telefonnummer eingeben");
		k.vornameAusfuellen();
		k.nachnameAusfuellen();
		k.telNrAusfuellen();
		login = true;
		zustandsnr = 1;
	}
	
	private static void kaufen3() {
		if(login == true) {
			int anzahlTickets;
			Scanner scc = new Scanner(System.in);
			System.out.println("Welche Veranstaltung wollen Sie besuchen?");
			String stringEingabe = scc.nextLine();
			for(int i = 0; i < arr.length; i++){
				if(stringEingabe.equalsIgnoreCase(arr[i].name)) arr[i].berechnung();;
			}
			System.out.println("Wie viele Tickets wollen Sie kaufen?");
			int intEingabe = scc.nextInt();
			anzahlTickets = intEingabe;
			for(int i = 0; i < arr.length; i++){
				if(stringEingabe.equalsIgnoreCase(arr[i].name)) {
					if(arr[i].verfuegbareTickets >= anzahlTickets) {
						arr[i].verfuegbareTickets = arr[i].verfuegbareTickets - anzahlTickets;
					}else {
						System.out.println("So viele Tickets sind nicht mehr verfuegbar.");
					}
				}
			}	
		}else {
			System.out.println("Bitte loggen Sie sich zuvor ein.");
		}
		zustandsnr = 1;
	}
	
	private static void tippen4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welches Match wollen Sie tippen?" );
		String eingabe = sc.nextLine();
		for(int i = 0; i < arr.length; i++){
			if(eingabe.equalsIgnoreCase(arr[i].name)) {
				System.out.println("Für wen sind Sie");		
				eingabe = sc.nextLine();
				if(eingabe.equalsIgnoreCase("liverpool")) lfcmnc.heimteam++;
				if(eingabe.equalsIgnoreCase("remie")) lfcmnc.unentschieden++;
				if(eingabe.equalsIgnoreCase("manchaster city")) lfcmnc.gastteam++;
				lfcmnc.gesStimmen++;
				lfcmnc.berechnen();
				System.out.println(lfcmnc.heimquote +" x "+ lfcmnc.remiequote +" x "+ lfcmnc.auswaertsquote);
			}
		}
		zustandsnr = 1;
	}
	
	private static void anzeigen5(){
		for(int i = 0; i < arr.length; i++){
			System.out.println(arr[i].name);
		}
		System.out.println("Fuer genaueres anzeigen geben Sie bitte denn Namen der Veranstalltung ein.");
		zustandsnr = 1;
	}
	
	private static void logout6() {
		if(login == true) {
			login = false;
		}else {
			System.out.println("Sie sind nicht eingeloggt, bitte loggen Sie sich zuvor ein.");
		}
		zustandsnr = 1;
	}
}
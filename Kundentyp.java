package ticketshop;

import java.util.Scanner;

public abstract class Kundentyp {
	
	protected String vorname;
	protected String nachname;
	protected int telNr;
	
	Scanner eingabe = new Scanner(System.in);
	
	public Kundentyp() {
	}
	
	protected abstract String vornameAusfuellen();
	protected abstract String nachnameAusfuellen();
	protected abstract int telNrAusfuellen();
}

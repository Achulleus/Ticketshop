package ticketshop;

public class Kunde extends Kundentyp {
	
	public Kunde(){
	}

	public String vornameAusfuellen() {
		vorname = eingabe.next();
		return vorname;
	}

	public String nachnameAusfuellen() {
		nachname = eingabe.next();
		return nachname;
	}

	public int telNrAusfuellen() {
		telNr = eingabe.nextInt();
		return telNr;
	}
}

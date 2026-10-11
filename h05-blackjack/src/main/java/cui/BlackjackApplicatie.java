package cui;

import java.math.BigDecimal;
import java.util.List;

import domein.DomeinController;

public class BlackjackApplicatie {
	
	private DomeinController dc;

	public BlackjackApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startBlackjack() {
        IO.println("We spelen vandaag Blackjack!");

        double inzet = invoerInzet();

		// TODO: maak een nieuw spel aan met de ingegeven inzet.

		int antwoord;
		
		toonSpeelbord();
		toonPunten();

        antwoord = invoerAntwoord();

        while(antwoord != 0 && true) { // TODO: vervang true door "zolang DR_EINDE_BLACKJACK nog niet is bereikt"
            // TODO: neem een nieuwe kaart
            toonSpeelbord();
            toonPunten();

            if(true) // TODO: vervang true door "zolang DR_EINDE_BLACKJACK nog niet is bereikt"
                antwoord = invoerAntwoord();
        }

        BigDecimal winst = null;   // TODO vervang null, haal hier de effectieve winst op.
        IO.println(String.format("Je hebt %.2f euro gewonnen!", winst.doubleValue()));
	}

	private double invoerInzet() {
		double inzet;
		do {
            inzet = Double.parseDouble(IO.readln("Hoeveel bedraagt je inzet in euro? (>0): "));
		} while (inzet <= 0);
		return inzet;
	}

	private void toonSpeelbord() {
		// TODO: haal alle kaarten op het bord op en toon voor elke kaart de kleur en waarde. Vervang hiervoor "Aas" en "Harten" in onderstaand statement
            IO.println(String.format("Deze kaart is een %s %s", "Aas", "Harten"));
	}

	private void toonPunten() {
		int punten = 0; // TODO: vervang 0 door de punten
        IO.println(String.format("Je hebt tot nu toe %d punten", punten));
	}

	private int invoerAntwoord() {
		int antwoord;
		do {
            antwoord = Integer.parseInt(IO.readln("Wil je nog een kaart? Typ 0 voor nee en 1 voor ja: "));
		} while (antwoord < 0 || antwoord > 1);
		return antwoord;
	}
}

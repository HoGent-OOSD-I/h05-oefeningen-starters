package cui;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;

public class BlackjackApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc;

	private static final int JA = 1;
	
	public BlackjackApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startBlackjack() {
		System.out.println("We spelen vandaag Blackjack!");

		BigDecimal inzet = new BigDecimal(invoerInzet());

		// TODO: maak een nieuw spel aan met de ingegeven inzet.

		int antwoord;
		
		toonSpeelbord();
		toonPunten();
		
		do {
			antwoord = invoerAntwoord();

			if (antwoord == JA) {
				// TODO: neem een nieuwe kaart
				toonSpeelbord();
				toonPunten();
			}
		} while (antwoord == JA && true);   // TODO: vervang true door "zolang DR_EINDE_BLACKJACK nog niet is bereikt"

        BigDecimal winst = null;   // TODO vervang null, haal hier de effectieve winst op.
		System.out.printf("Je hebt %.2f euro gewonnen!", winst.doubleValue());
	}

	private double invoerInzet() {
		double inzet;
		do {
			System.out.print("Hoeveel bedraagt je inzet in euro? (>0)");
			inzet = invoer.nextDouble();
		} while (inzet <= 0);
		return inzet;
	}

	private void toonSpeelbord() {
		// TODO: haal alle kaarten op het bord op en toon voor elke kaart de kleur en waarde. Vervang hiervoor "Aas" en "Harten" in onderstaand statement
			System.out.printf("Deze kaart is een %s %s%n", "Aas", "Harten");
	}

	private void toonPunten() {
		int punten = 0; // TODO: vervang 0 door de punten
		System.out.printf("Je hebt tot nu toe %d punten%n", punten);
	}

	private int invoerAntwoord() {
		int antwoord;
		do {
			System.out.print("Wil je nog een kaart? Typ 0 voor nee en 1 voor ja: ");
			antwoord = invoer.nextInt();
		} while (antwoord < 0 || antwoord > 1);
		return antwoord;
	}
}

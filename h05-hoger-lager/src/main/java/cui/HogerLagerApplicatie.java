package cui;

import java.util.Scanner;

import domein.DomeinController;

public class HogerLagerApplicatie {
	
	private Scanner invoer = new Scanner(System.in);
	private DomeinController dc;
	private final int HOGER = 0;

	public HogerLagerApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startHogerLagerSpel() {
		boolean hoger, wilVerderSpelen = true;

		System.out.println("Welkom bij Hoger Lager");
        // TODO: start het spel

		// TODO: haal de huidige kaart op uit het domein en vervang 1 en "Harten" door de waarde en kleur van deze kaart
        System.out.printf("De huidige kaart is: %d van %s%n", 1,
                "Harten");

		do {
			hoger = (invoerKeuze() == HOGER);

			// TODO: raad & vervang in onderstaande printf "true" zodat de applicatie in de juiste gevallen toont of de speler correct is of niet.
            System.out.printf("Je hebt %S geraden%n", true ? "juist" : "fout");

            // TODO: haal de huidige kaart op uit het domein en vervang 1 en "Harten" door de waarde en kleur van deze kaart
			System.out.printf("%nWant de nieuwe kaart is: %d van %s%n", 1, "Harten");

            // TODO: vervang true door "als DR_EINDE_SPEL nog niet is bereikt"
            if(true)
                wilVerderSpelen = leesVerderSpelen() != -1;
		} while (wilVerderSpelen && true); // TODO: vervang true door "zolang DR_EINDE_SPEL nog niet is bereikt"

        // TODO: vervang 0 door de score en true door "gewonnen of niet" in onderstaande print statements.
		System.out.printf("%nJe score is %d%n", 0);
		System.out.printf("Je hebt dit spel %s%n", true ? "gewonnen" : "verloren");
	}

    private int leesVerderSpelen() {
        System.out.print("Wil je verder spelen? Geef -1 in om te stoppen en een willekeurig ander getal om verder te spelen. ");
        return invoer.nextInt();
    }

    private int invoerKeuze() {
		int keuze;
        boolean isJuist;

        do {
			System.out.print("Zal de volgende kaart hoger (0) of lager (1) zijn? ");
			keuze = invoer.nextInt();
            isJuist = keuze >= 0 && keuze <= 1;
        } while (!isJuist);
		return keuze;
	}

}

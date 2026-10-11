package cui;

import domein.DomeinController;

public class HogerLagerApplicatie {
	
	private DomeinController dc;
	private final int HOGER = 0;

	public HogerLagerApplicatie(DomeinController domeinController) {
		dc = domeinController;
	}

	public void startHogerLagerSpel() {
		boolean hoger, wilVerderSpelen = true;

        IO.println("Welkom bij Hoger Lager");
        // TODO: start het spel

		// TODO: haal de huidige kaart op uit het domein en vervang 1 en "Harten" door de waarde en kleur van deze kaart
        IO.println(String.format("De huidige kaart is: %d van %s", 1,
                "Harten"));

		do {
			hoger = (invoerKeuze() == HOGER);

			// TODO: raad & vervang in onderstaande printf "true" zodat de applicatie in de juiste gevallen toont of de speler correct is of niet.
            IO.println(String.format("Je hebt %S geraden", true ? "juist" : "fout"));

            // TODO: haal de huidige kaart op uit het domein en vervang 1 en "Harten" door de waarde en kleur van deze kaart
            IO.println(String.format("%nWant de nieuwe kaart is: %d van %s", 1,
                    "Harten"));

            // TODO: vervang true door "als DR_EINDE_SPEL nog niet is bereikt"
            if(true)
                wilVerderSpelen = leesVerderSpelen() != -1;
		} while (wilVerderSpelen && true); // TODO: vervang true door "zolang DR_EINDE_SPEL nog niet is bereikt"

        // TODO: vervang 0 door de score en true door "gewonnen of niet" in onderstaande print statements.
        IO.println(String.format("%nJe score is %d", 0));
        IO.println(String.format("Je hebt dit spel %s", true ? "gewonnen" : "verloren"));
	}

    private int leesVerderSpelen() {
        return Integer.parseInt(IO.readln("Wil je verder spelen? Geef -1 in om te stoppen en een willekeurig ander getal om verder te spelen. "));
    }

    private int invoerKeuze() {
		int keuze;
        boolean isJuist;

        do {
            keuze = Integer.parseInt(IO.readln("Zal de volgende kaart hoger (0) of lager (1) zijn? "));
            isJuist = keuze >= 0 && keuze <= 1;
        } while (!isJuist);
		return keuze;
	}

}

package cui;

import java.util.ArrayList;
import java.util.List;

public class JackpotApplicatie {

    // TODO voeg een attribuut toe voor de DomeinController

    // TODO voeg een constructor toe met 1 parameter: de DomeinController

	public void startJackpotspel() {
		// TODO zorg dat in het domein een nieuwe jackpot wordt aangemaakt

        // TODO vervang "new ArrayList<>()" door de effectieve waarden op de wielen uit het domein
        List<Integer> getallen = new ArrayList<>();
		uitvoerGetallen(getallen);

		int verderSpelen = invoerKeuze();

		while (verderSpelen != 0) {
			// TODO laat de wielen draaien (zie stap 4 in de use case)

            // TODO vervang "new ArrayList<>()" door de effectieve waarden op de wielen uit het domein
            getallen = new ArrayList<>();
			uitvoerGetallen(getallen);

            // TODO vervang 0 door het ophalen van de score uit het domein
			IO.println(String.format("De score is %d", 0));

			verderSpelen = invoerKeuze();
		}

	}

	private void uitvoerGetallen(List<Integer> getallen) {
		for(int getal: getallen)
			IO.print(String.format("%d ", getal));
		IO.println();		
	}
	
	private int invoerKeuze() {
		int keuze;
		do {
			keuze = Integer.parseInt(IO.readln("Wil je met de jackpot spelen (ja=1, nee=0)? "));
		} while (keuze < 0 || keuze > 1);
		return keuze;
	}
}

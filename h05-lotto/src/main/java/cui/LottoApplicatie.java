package cui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;

public class LottoApplicatie {

    private DomeinController dc;

    public LottoApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void startLotto() {
        String[] menuOpties = {"Stoppen", "Registreer een trekking", "Controleer je nummers"};

        int keuze = invoerKeuzeUitOpties("MENU", menuOpties);
        while (keuze != 0) {
            switch (keuze) {
                case 1 -> doeRegistreerTrekking();
                case 2 -> doeControleerNummers();
            }

            keuze = invoerKeuzeUitOpties("MENU",menuOpties);
        }
        IO.println("Tot volgende keer!");
    }

    private int invoerKeuzeUitOpties(String hoofding, String[] opties) {
        int keuze;
        do {
            IO.println(hoofding);
            for(int i = 0; i<opties.length; i++){
                IO.println(String.format("%d: %s", i, opties[i]));
            }

            keuze = invoerGetal("Maak je keuze > ");
        } while (keuze < 0 || keuze > opties.length);
        return keuze;
    }

    private String invoerTekst(String instructie) {
        return IO.readln(instructie);
    }

    private int invoerGetal(String instructie) {
        return Integer.parseInt(IO.readln(instructie));
    }

    private LocalDate invoerDatum() {
        int dag = invoerGetal("Geef de dag van de trekking in (1-31): ");
        int maand = invoerGetal("Geef de maand van de trekking in (1-12): ");
        int jaar = invoerGetal("Geef het jaar van de trekking in: ");
        return LocalDate.of(jaar, maand, dag);
    }

    private List<Integer> invoerNummers() {
        List<Integer> nummers = new ArrayList<>();
        for (int teller = 1; teller <= dc.geefAantalNummers(); teller++) {      // Best om het aantal nummers in een trekking in het domein bij te houden en hier op te vragen. (TODO: voorzie de nodige methode(s)/constante(n) in het domein die hiervoor nodig zijn)
            int nieuwNummer = invoerGetal(String.format("Geef %d%s nummer in > ", teller, teller == 1 ? "ste" : "de"));
            nummers.add(nieuwNummer);
        }
        return nummers;
    }

    private void doeRegistreerTrekking() {  // UC1
        String naam = invoerTekst("Registreer een nieuwe trekking.\nGeef de naam van de trekking > ");
        LocalDate datum = invoerDatum();
        List<Integer> nummers = invoerNummers();

        // TODO: registreer de trekking in het domein

        IO.println("De trekking werd geregistreerd!");
    }

    private void doeControleerNummers() {   // UC2
        String naam;
        List<Integer> nummers;
        int keuze;

        // TODO: toon de trekkingen uit het domein

        naam = invoerTekst("Geef de naam van de trekking waarvoor je je nummers wil controleren > ");
        // TODO: selecteer de trekking met deze naam in het domein

        // TODO: Toon naam en datum van de geselecteerde trekking

        do {
            IO.println(String.format("Geef jouw nummers in."));

            nummers = invoerNummers();
            // TODO: bereken de winst voor deze nummers
            int winst = 0;
            IO.println(String.format("Met deze nummers win je %d Euro.", winst));

            keuze = invoerKeuzeUitOpties("Wil je nog nummers invoeren?", new String[]{"neen", "ja"});
        } while (keuze == 1);

    }
}
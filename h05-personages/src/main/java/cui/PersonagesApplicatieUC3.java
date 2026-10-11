package cui;

import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import dto.CategorieDTO;

public class PersonagesApplicatieUC3 {
	private DomeinController dc;
	private static final int NIEUWE_CATEGORIE = 1;
	private static final int NIEUWE_PERSONAGE = 2;
	private static final int SELECTEER_PERSONAGE = 3;

	public PersonagesApplicatieUC3(DomeinController domeinController) {
		dc = domeinController;
	}

    public void start() {
        String[] menu =  {"Afsluiten", "Maak een nieuwe categorie", "Maak een nieuw personage", "Selecteer een personage"};
        int keuze = maakKeuze(menu);

        while (keuze != 0) {
            switch (keuze) {
                case NIEUWE_CATEGORIE -> maakCategorie();
                case NIEUWE_PERSONAGE -> maakPersonage();
                case SELECTEER_PERSONAGE -> selecteerPersonage();
            }

            keuze = maakKeuze(menu);
        }
    }

    private int maakKeuze(String[] menu) {
        IO.println("MENU\n====");
        int i = 0;
        for(String menuItem: menu){
            IO.println(String.format("%d. %s", i++, menuItem));
        }

        return leesGeheelGetalTussenGrenzen("Maak een keuze: ", 0, menu.length-1);
    }

    private int leesGeheelGetalTussenGrenzen(String instructie, int ondergrensIncl, int bovengrensIncl) {
        int keuze;
        boolean isJuist;

        do {
            keuze = Integer.parseInt(IO.readln(instructie));
            isJuist = keuze >= ondergrensIncl && keuze <= bovengrensIncl;
            if(!isJuist)
                IO.println("Ongeldige keuze! Probeer opnieuw!");
        }while (!isJuist);

        return keuze;
    }

    private void maakCategorie() {
        IO.println("\nGeef de informatie voor de nieuwe categorie:");

        String omschrijving = IO.readln("- omschrijving (verplicht, max 100 karakters): ");
        int kracht = Integer.parseInt(IO.readln("- kracht (in interval [1, 10]): "));
        int snelheid = Integer.parseInt(IO.readln("- snelheid (> 0): "));
        int lenigheid = Integer.parseInt(IO.readln("- leningheid (in interval [1, 5]): "));

        dc.maakCategorie(omschrijving, snelheid, kracht, lenigheid);

        IO.println("Categorie aangemaakt! \n");
    }

    private void maakPersonage() {
        List<CategorieDTO> categorieen = dc.geefCategorieen();

        if(categorieen.isEmpty()){
            IO.println("Er zijn geen categorieën momenteel, wil je eerst een categorie aanmaken?");
            boolean nieuwAanmaken = leesGeheelGetalTussenGrenzen("Ja (1) of nee (0)? ", 0, 1) == 1;
            if(nieuwAanmaken) {
                maakCategorie();
                categorieen = dc.geefCategorieen();
            }
            else return;        // methode eindigen zonder personage aan te maken
        }

        IO.println("\nCATEGORIEEN\n===========");
        IO.println(String.format("%15s %10s %10s %10s",  "Omschrijving", "Kracht", "Snelheid", "Lenigheid"));
        int i = 1;
        for (CategorieDTO categorie:categorieen)
            IO.println(String.format("%d. %12s %10s %10s %10s", i++ , categorie.omschrijving(), categorie.kracht(), categorie.snelheid(), categorie.lenigheid()));

        int categorieIndex = leesGeheelGetalTussenGrenzen("Kies een categorie: ", 1, categorieen.size());
        categorieIndex--; // omzetten naar index startend vanaf 0

        dc.selecteerCategorie(categorieen.get(categorieIndex).omschrijving());

        String naam = IO.readln("\nGeef een naam voor het personage (verplicht, tussen 3 en 50 tekens!): ");

        dc.registreerPersonage(naam);

        IO.println("Personage aangemaakt! \n");
    }
	
	private void selecteerPersonage() {
        // TODO: haal alle personages op en sla op in variabele "personages", pas indien nodig het datatype van personages aan
        List<String> personages = new ArrayList<>();

        if(personages.isEmpty()){
            IO.println("Er zijn geen personages momenteel, wil je eerst een personage aanmaken?");
            boolean nieuwAanmaken = leesGeheelGetalTussenGrenzen("Ja (1) of nee (0)? ", 0, 1) == 1;
            if(nieuwAanmaken) {
                maakPersonage();
                // TODO: haal opnieuw alle personages op en plaats deze opnieuw in "personages"
            }
            else return;        // methode eindigen zonder personage aan te maken
        }

        IO.println("\nPERSONAGES\n===========");

		int i = 1;
        // TODO: overloop alle personages
        // TODO: toon voor elke personages de naam door onderstaande String.format aan te vullen
//			IO.println(String.format("%d. %s", i++,  ));

        IO.println(String.format("%d. Maak een nieuw personage%n", personages.size() + 1));

		int personageIndex = leesGeheelGetalTussenGrenzen("Kies een Personage: ", 1, personages.size()+1);
        personageIndex--; // omzetten naar index startend vanaf 0

		if (personageIndex == personages.size())
			maakPersonage();
		else {
            String naamGekozenPersonage = "";   // TODO vervang "" door de naam van het gekozen personage.
            // TODO: gebruik naamGekozenPersonage om dit personage te selecteren
			printDetailsPersonage();
		}
	}
	
	private void printDetailsPersonage() {
        // TODO: haal het geselecteerde personage op en sla op in variabele "personage", pas indien nodig het datatype van personage aan
		String personage = null;
		if (personage == null)
            IO.println("\nGeen personage gevonden");
		else {
            // TODO: haal de categorie van het geselecteerde personage op en sla op in variabele "categorie", pas indien nodig het datatype aan
            String categorie = "";
            IO.println("\nJe selecteerde dit personage:");

            // TODO: gebruik personage en categorie om telkens de correcte waarde in te vullen ipv "" en 0.
            IO.println(String.format("- Naam: %s", ""));
            IO.println("- Categorie:");
            IO.println(String.format("\t - Omschrijving: %s", ""));
            IO.println(String.format("\t - Kracht: %s", 0));
            IO.println(String.format("\t - Snelheid: %s", 0));
            IO.println(String.format("\t - Lenigheid: %s%n", 0));
		}
	}
}

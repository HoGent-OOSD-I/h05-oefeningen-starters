package cui;

import domein.DomeinController;

import java.util.ArrayList;
import java.util.List;

public class PersonagesApplicatieUC2 {
	private DomeinController dc;
	private static final int NIEUWE_CATEGORIE = 1;
	private static final int NIEUWE_PERSONAGE = 2;
	private static final int SELECTEER_PERSONAGE = 3;

	public PersonagesApplicatieUC2(DomeinController domeinController) {
		dc = domeinController;
	}

    public void start() {
        String[] menu =  {"Afsluiten", "Maak een nieuwe categorie", "Maak een nieuw personage" /*, "Selecteer een personage"*/};
        int keuze = maakKeuze(menu);

        while (keuze != 0) {
            switch (keuze) {
                case NIEUWE_CATEGORIE -> maakCategorie();
                case NIEUWE_PERSONAGE -> maakPersonage();
//                case SELECTEER_PERSONAGE -> selecteerPersonage();
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
        // TODO: haal alle categorieën op en sla op in variabele "categorieen", pas indien nodig het datatype van categorieen aan
        List<String> categorieen = new ArrayList<>();

        if(categorieen.isEmpty()){
            IO.println("Er zijn geen categorieën momenteel, wil je eerst een categorie aanmaken?");
            boolean nieuwAanmaken = leesGeheelGetalTussenGrenzen("Ja (1) of nee (0)? ", 0, 1) == 1;
            if(nieuwAanmaken) {
                maakCategorie();
                // TODO: haal opnieuw alle categorieën op en plaats deze opnieuw in "categorieen"
            }
            else return;        // methode eindigen zonder personage aan te maken
        }

        IO.println("\nCATEGORIEEN\n===========");
        IO.println(String.format("%15s %10s %10s %10s",  "Omschrijving", "Kracht", "Snelheid", "Lenigheid"));
        int i = 1;
		// TODO: overloop alle categorieën
        // TODO: toon voor elke categorie de omschrijving, kracht, snelheid en lenigheid door onderstaande printf aan te vullen
            //IO.println(String.format("%d. %12s %10s %10s %10s", i++ , ));

        int categorieIndex = leesGeheelGetalTussenGrenzen("Kies een categorie: ", 1, categorieen.size());
        categorieIndex--; // omzetten naar index startend vanaf 0

        String omschrijvingGekozenCategorie = "";   // TODO vervang "" door de omschrijving van de gekozen categorie.
		// TODO: gebruik omschrijvingGekozenCategorie om deze categorie te selecteren

        String naam = IO.readln("\nGeef een naam voor het personage (verplicht, tussen 3 en 50 tekens!): ");

        //TODO: maak de categorie aan

        IO.println("Personage aangemaakt! \n");
	}
}

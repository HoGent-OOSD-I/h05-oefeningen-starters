package cui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import dto.CategorieDTO;

public class PersonagesApplicatieUC3
{
	private Scanner sc = new Scanner(System.in);
	private DomeinController dc;
	private static final int NIEUWE_CATEGORIE = 1;
	private static final int NIEUWE_PERSONAGE = 2;
	private static final int SELECTEER_PERSONAGE = 3;

	public PersonagesApplicatieUC3(DomeinController domeinController)
	{
		dc = domeinController;
	}

	public void start()
	{		
		int keuze = maakKeuze();
		
		while (keuze != 0)
		{
			switch (keuze)
			{
				case NIEUWE_CATEGORIE -> maakCategorie();
				case NIEUWE_PERSONAGE -> maakPersonage();
				case SELECTEER_PERSONAGE -> selecteerPersonage();
			}
			
			keuze = maakKeuze();
		}
	}
	
	private int maakKeuze()
	{
		System.out.println("MENU\n====");
		System.out.println("0. Afsluiten");
		System.out.println("1. Maak een nieuwe categorie");
		System.out.println("2. Maak een nieuw personage");
		System.out.println("3. Selecteer een personage");

        return leesGeheelGetalTussenGrenzen("Maak een keuze: ", 0, 3);
    }

    private int leesGeheelGetalTussenGrenzen(String instructie, int ondergrensIncl, int bovengrensIncl) {
        int keuze;
        boolean isJuist;

        do
        {
            System.out.print(instructie);
            keuze = sc.nextInt();
            isJuist = keuze >= ondergrensIncl && keuze <= bovengrensIncl;
            if(!isJuist)
                System.out.println("Ongeldige keuze! Probeer opnieuw!");
        }while (!isJuist);

        return keuze;
    }

    private void maakCategorie()
	{
		System.out.println("\nGeef de informatie voor de nieuwe categorie:");

		System.out.print("- omschrijving (alleen letters, geen spaties!): ");
		String omschrijving = sc.next();

		System.out.print("- kracht (in interval [1, 10]): ");
		int kracht = sc.nextInt();
		
		System.out.print("- snelheid (> 0): ");
		int snelheid = sc.nextInt();

		System.out.print("- leningheid (in interval [1, 5]): ");
		int lenigheid = sc.nextInt();
		
		dc.maakCategorie(omschrijving, snelheid, kracht, lenigheid);

        System.out.println("Categorie aangemaakt! \n");
	}
	
	private void maakPersonage()
	{
		List<CategorieDTO> categorieen = dc.geefCategorieen();

        if(categorieen.isEmpty()){
            System.out.println("Er zijn categorieën momenteel, wil je eerst een categorie aanmaken?");
            boolean nieuwAanmaken = leesGeheelGetalTussenGrenzen("Ja (1) of nee (0)? ", 0, 1) == 1;
            if(nieuwAanmaken) {
                maakCategorie();
                categorieen = dc.geefCategorieen();
            }
            else return;        // methode eindigen zonder personage aan te maken
        }

        System.out.println("\nCATEGORIEEN\n===========");
        System.out.printf("%15s %10s %10s %10s%n",  "Omschrijving", "Kracht", "Snelheid", "Lenigheid");
        int i = 1;
		for (CategorieDTO categorie:categorieen)
            System.out.printf("%d. %12s %10s %10s %10s%n", i++ , categorie.omschrijving(), categorie.kracht(), categorie.snelheid(), categorie.lenigheid());

        int categorieIndex = leesGeheelGetalTussenGrenzen("Kies een categorie: ", 1, categorieen.size());
        categorieIndex--; // omzetten naar index startend vanaf 0

		dc.selecteerCategorie(categorieen.get(categorieIndex).omschrijving());
		
		System.out.print("\nGeef een naam voor het personage (alleen letters, geen spaties!): ");
		String naam = sc.next();
		
		dc.registreerPersonage(naam);

        System.out.println("Personage aangemaakt! \n");
	}
	
	private void selecteerPersonage()
	{
        // TODO: haal alle personages op en sla op in variabele "personages", pas indien nodig het datatype van personages aan
        List<String> personages = new ArrayList<>();

        if(personages.isEmpty()){
            System.out.println("Er zijn personages momenteel, wil je eerst een personage aanmaken?");
            boolean nieuwAanmaken = leesGeheelGetalTussenGrenzen("Ja (1) of nee (0)? ", 0, 1) == 1;
            if(nieuwAanmaken) {
                maakPersonage();
                // TODO: haal opnieuw alle personages op en plaats deze opnieuw in "personages"
            }
            else return;        // methode eindigen zonder personage aan te maken
        }

        System.out.println("\nPERSONAGES\n===========");

		int i = 1;
        // TODO: overloop alle personages
        // TODO: toon voor elke personages de naam door onderstaande printf aan te vullen
//			System.out.printf("%d. %s %n", i++, );
		
		System.out.printf("%d. Maak een nieuw personage%n%n", personages.size() + 1);

		int personageIndex = leesGeheelGetalTussenGrenzen("Kies een Personage: ", 1, personages.size()+1);
        personageIndex--; // omzetten naar index startend vanaf 0

		if (personageIndex == personages.size())
			maakPersonage();
		else
		{
            String naamGekozenPersonage = "";   // TODO vervang "" door de naam van het gekozen personage.
            // TODO: gebruik naamGekozenPersonage om dit personage te selecteren
			printDetailsPersonage();
		}
	}
	
	private void printDetailsPersonage()
	{
        // TODO: haal het geselecteerde personage op en sla op in variabele "personage", pas indien nodig het datatype van personage aan
		String personage = null;
		if (personage == null)
			System.out.printf("%nGeen personage gevonden%n");
		else
		{
			System.out.println("\nJe selecteerde dit personage:");

            // TODO: gebruik personage om telkens de correcte waarde in te vullen ipv "" en 0.
			System.out.printf("- Naam: %s%n", "");
			System.out.println("- Categorie:");
			System.out.printf("    - Omschrijving: %s%n", "");
			System.out.printf("    - Kracht: %s%n", 0);
			System.out.printf("    - Snelheid: %s%n", 0);
			System.out.printf("    - Lenigheid: %s%n%n", 0);
		}
	}
}

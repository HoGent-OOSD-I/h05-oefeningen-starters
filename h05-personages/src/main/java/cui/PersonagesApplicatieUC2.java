package cui;

import domein.DomeinController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonagesApplicatieUC2
{
	private Scanner sc = new Scanner(System.in);
	private DomeinController dc;
	private static final int NIEUWE_CATEGORIE = 1;
	private static final int NIEUWE_PERSONAGE = 2;
	private static final int SELECTEER_PERSONAGE = 3;

	public PersonagesApplicatieUC2(DomeinController domeinController)
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
//				case SELECTEER_PERSONAGE -> selecteerPersonage();
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
//		System.out.println("3. Selecteer een personage");

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
        // TODO: haal alle categorieën op en sla op in variabele "categorieen", pas indien nodig het datatype van categorieen aan
        List<String> categorieen = new ArrayList<>();

        if(categorieen.isEmpty()){
            System.out.println("Er zijn categorieën momenteel, wil je eerst een categorie aanmaken?");
            boolean nieuwAanmaken = leesGeheelGetalTussenGrenzen("Ja (1) of nee (0)? ", 0, 1) == 1;
            if(nieuwAanmaken) {
                maakCategorie();
                // TODO: haal opnieuw alle categorieën op en plaats deze opnieuw in "categorieen"
            }
            else return;        // methode eindigen zonder personage aan te maken
        }

        System.out.println("\nCATEGORIEEN\n===========");
        System.out.printf("%15s %10s %10s %10s%n",  "Omschrijving", "Kracht", "Snelheid", "Lenigheid");
        int i = 1;
		// TODO: overloop alle categorieën
        // TODO: toon voor elke categorie de omschrijving, kracht, snelheid en lenigheid door onderstaande printf aan te vullen
            //System.out.printf("%d. %12s %10s %10s %10s%n", i++ , );

        int categorieIndex = leesGeheelGetalTussenGrenzen("Kies een categorie: ", 1, categorieen.size());
        categorieIndex--; // omzetten naar index startend vanaf 0

        String omschrijvingGekozenCategorie = "";   // TODO vervang "" door de omschrijving van de gekozen categorie.
		// TODO: gebruik omschrijvingGekozenCategorie om deze categorie te selecteren
		
		System.out.print("\nGeef een naam voor het personage (alleen letters, geen spaties!): ");
		String naam = sc.next();

        //TODO: maak de categorie aan

        System.out.println("Personage aangemaakt! \n");
	}
}

package cui;

import domein.DomeinController;

import java.util.Scanner;

public class PersonagesApplicatieUC1
{
	private Scanner sc = new Scanner(System.in);
	private DomeinController dc;
	private static final int NIEUWE_CATEGORIE = 1;
	private static final int NIEUWE_PERSONAGE = 2;
	private static final int SELECTEER_PERSONAGE = 3;

	public PersonagesApplicatieUC1(DomeinController domeinController)
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
//				case NIEUWE_PERSONAGE -> maakPersonage();
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
//		System.out.println("2. Maak een nieuw personage");
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

        //TODO: maak de categorie aan

        System.out.println("Categorie aangemaakt! \n");
	}
}

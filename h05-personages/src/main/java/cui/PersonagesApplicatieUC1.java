package cui;

import domein.DomeinController;

public class PersonagesApplicatieUC1 {
	private DomeinController dc;
	private static final int NIEUWE_CATEGORIE = 1;
	private static final int NIEUWE_PERSONAGE = 2;
	private static final int SELECTEER_PERSONAGE = 3;

	public PersonagesApplicatieUC1(DomeinController domeinController) {
		dc = domeinController;
	}

    public void start() {
        String[] menu =  {"Afsluiten", "Maak een nieuwe categorie" /*, "Maak een nieuw personage", "Selecteer een personage"*/};
        int keuze = maakKeuze(menu);

        while (keuze != 0) {
            switch (keuze) {
                case NIEUWE_CATEGORIE -> maakCategorie();
//                case NIEUWE_PERSONAGE -> maakPersonage();
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

        //TODO: maak de categorie aan

        IO.println("Categorie aangemaakt! \n");
	}
}

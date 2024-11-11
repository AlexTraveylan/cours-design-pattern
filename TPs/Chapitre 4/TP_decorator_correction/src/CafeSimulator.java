import beverage.Beverage;
import beverage.Espresso;
import beverage.FilterCoffee;
import beverage.Latte;
import decorator.Mocha;
import decorator.Milk;
import decorator.Soy;
import decorator.Whip;

import java.util.Scanner;

public class CafeSimulator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Bienvenue au Café Deluxe ===");
            Beverage beverage = commanderBoisson();
            if (beverage == null)
                break;

            beverage = ajouterExtras(beverage);

            System.out.printf("\nVotre commande: %s%n", beverage.getDescription());
            System.out.printf("Prix total: %.2f€%n", beverage.cost());
        }
        scanner.close();
    }

    private static Beverage commanderBoisson() {
        System.out.println("\nChoisissez votre boisson:");
        System.out.println("1. Espresso (1.99€)");
        System.out.println("2. Latte (2.99€)");
        System.out.println("3. Café Filtre (1.49€)");
        System.out.println("0. Quitter");

        int choix = scanner.nextInt();
        if (choix == 0)
            return null;

        Beverage beverage = null;
        switch (choix) {
            case 1:
                beverage = new Espresso();
                break;
            case 2:
                beverage = new Latte();
                break;
            case 3:
                beverage = new FilterCoffee();
                break;
        }

        if (beverage != null) {
            System.out.println("\nChoisissez la taille:");
            System.out.println("1. Petit (-0.30€)");
            System.out.println("2. Moyen (prix standard)");
            System.out.println("3. Grand (+0.30€)");

            int taille = scanner.nextInt();
            switch (taille) {
                case 1:
                    beverage.setSize(Beverage.Size.SMALL);
                    break;
                case 2:
                    beverage.setSize(Beverage.Size.MEDIUM);
                    break;
                case 3:
                    beverage.setSize(Beverage.Size.LARGE);
                    break;
            }
        }

        return beverage;
    }

    private static Beverage ajouterExtras(Beverage beverage) {
        boolean continuer = true;
        while (continuer) {
            System.out.println("\nAjouts disponibles:");
            System.out.println("1. Lait (+0.50€)");
            System.out.println("2. Lait de Soja (+0.65€)");
            System.out.println("3. Mocha (+0.75€)");
            System.out.println("4. Crème fouettée (+0.50€)");
            System.out.println("0. Terminer la commande");

            int choix = scanner.nextInt();
            switch (choix) {
                case 0:
                    continuer = false;
                    break;
                case 1:
                    beverage = new Milk(beverage);
                    break;
                case 2:
                    beverage = new Soy(beverage);
                    break;
                case 3:
                    beverage = new Mocha(beverage);
                    break;
                case 4:
                    beverage = new Whip(beverage);
                    break;
            }
        }
        return beverage;
    }
}
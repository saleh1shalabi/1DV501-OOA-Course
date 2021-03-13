package RecipApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheApp {

    private Scanner input;

    public List<Ingredient> ingredients;
    public List<Recip> recips;

    private Ingredient ing;

    private Recip recip;

    TheApp() {
        ingredients = new ArrayList<>();
        input = new Scanner(System.in);
        recips = new ArrayList<>();
    }

    private void addIngredient() {

        System.out.println("new ing: ");
        String ne = input.nextLine();

        System.out.println("new mått: ");

        String mg = input.nextLine();
        System.out.println("new pris: ");

        double pr = Double.parseDouble(input.nextLine());

        input.nextLine();

        ing = (new Ingredient(ne, mg, pr));
        ingredients.add(ing);
    }

    private void viewAllIngredients() {
        int x = 0;
        for (Ingredient c : ingredients) {
            x++;
            System.out.print(x + ". " + c.getName() + " : ");
        }
    }

    private void addRecip() {
        System.out.println("What is the name of the new Recip?");
        recip = new Recip(input.nextLine());
        addIngredientsToRecip();
        recips.add(recip);
    }

    private void addIngredientsToRecip() {
        System.out.println("ADD new ingredient!");
        String x = "";

        while (!(x.equals("n") || x.equals("N"))) {
            recip.addIngredient(ingredients.get(getIngredientPlace()), getHowMuch(), getIngredientReson());
            System.out.println("ADD new ingredient? (for no n)");

            x = input.nextLine();
        }
    }

    private int getIngredientPlace() {
        viewAllIngredients();
        System.out.println();
        int y = input.nextInt();
        input.nextLine();
        return y - 1;
    }

    private int getHowMuch() {
        System.out.println("How Much?");

        int x = input.nextInt();
        input.nextLine();
        return (x);
    }

    private String getIngredientReson() {
        System.out.println("What Reson?");
        return input.nextLine();
    }

    private void viewAllRecips() {
        int x = 1;
        for (Recip c : recips) {
            System.out.print(x + ". " + c.getName() + "\n");
            x++;
        }
    }

    public static void main(String[] args) {
        TheApp a = new TheApp();

        for (int x = 0; x < 4; x++)
            a.addIngredient();

        for (int x = 0; x < 2; x++)
            a.addRecip();

        a.viewAllRecips();

        for (Recip S : a.recips) {
            System.out.println(S.viewRecip());
        }
    }
}

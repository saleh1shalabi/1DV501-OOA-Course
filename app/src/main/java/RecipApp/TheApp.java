package RecipApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheApp {

    private FileManager file = new FileManager();
    private Scanner input;
    public ArrayList<Ingredient> ingredients;
    public ArrayList<Recip> recips;
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

        Ingredient ing = (new Ingredient(ne, mg, pr));
        ingredients.add(ing);
    }

    private void viewAllIngredients() {

        int x = 0;
        for (Ingredient c : ingredients) {
            x++;
            System.out.print(x + ". " + c.getName());
            System.out.println();
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
        System.out.println("Which ingredeient?\n");
        viewAllIngredients();
        System.out.println();
        int y = input.nextInt();
        input.nextLine();
        return y - 1;
    }

    private double getHowMuch() {
        System.out.println("How Much?");

        double x = Double.parseDouble(input.nextLine());
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

    private void addIngredientsFromFile() {
        ArrayList<ArrayList> g = file.reader();
        for (ArrayList<String> ings : g) {

            Ingredient ing = (new Ingredient(ings.get(0), ings.get(1), Double.parseDouble(ings.get(2))));
            ingredients.add(ing);
        }
    }

    private int getRecipPlace() {
        System.out.println("Which Recip?\n");
        viewAllRecips();
        System.out.println();
        int y = input.nextInt();
        input.nextLine();
        return y - 1;
    }

    public static void main(String[] args) {
        TheApp a = new TheApp();

        a.addIngredientsFromFile();
        a.addRecip();
        System.out.println(a.recips.get(a.getRecipPlace()).viewRecip());
    }
}

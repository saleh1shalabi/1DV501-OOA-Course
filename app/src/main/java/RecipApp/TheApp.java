package RecipApp;

import java.util.ArrayList;
import java.util.Scanner;

public class TheApp {

    private FileManager file = new FileManager();

    public ArrayList<Ingredient> ingredients;
    public ArrayList<Recip> recips;
    private Recip recip;
    private UiConsoleSc ui = new UiConsoleSc();

    TheApp() {
        ingredients = new ArrayList<>();
        recips = new ArrayList<>();
    }

    private void addIngredient() {

        System.out.println("new ing: ");
        String ne = ui.stringGetter();

        System.out.println("new mått: ");
        String mg = ui.stringGetter();

        System.out.println("new pris: ");
        int pr = ui.intGetter();

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
        recip = new Recip(ui.stringGetter());
        addIngredientsToRecip();
        recips.add(recip);
    }

    private void addIngredientsToRecip() {
        System.out.println("ADD new ingredient!");
        String x = "";

        while (!(x.equals("n") || x.equals("N"))) {
            recip.addIngredient(ingredients.get(getIngredientPlace()), getHowMuch(), getIngredientReson());
            System.out.println("ADD new ingredient? (for no n)");

            x = ui.stringGetter();
        }
    }

    private int getIngredientPlace() {
        System.out.println("Which ingredeient?\n");
        viewAllIngredients();
        System.out.println();
        int y = ui.intGetter();
        return y - 1;
    }

    private double getHowMuch() {
        System.out.println("How Much?");

        double x = ui.doubleGetter();
        return (x);
    }

    private String getIngredientReson() {
        System.out.println("What Reson?");
        return ui.stringGetter();
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
        a.ui.menu();
        a.addIngredientsFromFile();
        a.addRecip();
        System.out.println(a.recips.get(a.getRecipPlace()).viewRecip());
    }
}

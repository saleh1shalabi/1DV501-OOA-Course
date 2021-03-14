package RecipApp;

import java.util.ArrayList;

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

    public void viewAllIngredients() {

        int x = 0;
        for (Ingredient c : ingredients) {
            x++;
            System.out.print(x + ". " + c.getName());
            System.out.println();
        }
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

    private void editIngredient() {

        ui.ingredeientChoose();
        viewAllIngredients();
        int x = ui.intGetter() - 1;
        ui.ingredeientEditMenu();
        int y = ui.intGetter();
        if (y == 1) {
            System.out.println("what is the new name of " + ingredients.get(x).getName());
            String name = ui.stringGetter();
            ingredients.get(x).editName(name);
        } else if (y == 2) {
            System.out.println("The price is " + ingredients.get(x).getPrice());
            System.out.println("what is the new price");
            int price = ui.intGetter();
            ingredients.get(x).editPrice(price);
        } else if (y == 3) {
            System.out.println("The Unit is " + ingredients.get(x).getUnit());
            System.out.println("what is the new unit");
            String name = ui.stringGetter();
            ingredients.get(x).editUnit(name);
        }
    }

    private void addRecip() {
        System.out.println("What is the name of the new Recip?");
        recip = new Recip(ui.stringGetter());
        addIngredientsToRecip(recip);
        recip.makingWay();
        recips.add(recip);

    }

    public void addIngredientsToRecip(Recip recip) {
        System.out.println("ADD new ingredient!");
        String x = "";

        while (!(x.equals("n") || x.equals("N"))) {
            ui.ingredeientChoose();
            viewAllIngredients();
            recip.addIngredient(ingredients.get(ui.intGetter() - 1), getHowMuch(), getIngredientReson());
            System.out.println("ADD new ingredient? (for no n)");

            x = ui.stringGetter();
        }
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
        ArrayList<ArrayList<String>> g = file.ingredientReader();
        for (ArrayList<String> ings : g) {

            Ingredient ing = (new Ingredient(ings.get(0), ings.get(1), Double.parseDouble(ings.get(2))));
            ingredients.add(ing);
        }
    }

    private void addRecipsFromFile() {
        ArrayList<String> recipz = file.recipReader();
        for (String recp : recipz) {
            String[] rec = recp.split(",");
            String name = rec[0];
            Recip recip = new Recip(name);

            // ss
            String ingrediens = rec[1].replace("||", ",");

            String[] ingrediensFromRecip = ingrediens.split(",");

            for (String ing : ingrediensFromRecip) {
                String thisOne = ing.replace(":", ",");
                String[] shitdo = thisOne.split(",");
                String theIngredient = shitdo[0];
                for (Ingredient ingr : ingredients) {
                    if (ingr.getName().equals(theIngredient)) {
                        recip.addIngredient(ingr, Double.parseDouble(shitdo[1]), shitdo[2]);
                        break;
                    }
                }
            }
            recips.add(recip);
        }
    }

    private void editRecip() {
        System.out.println("All Recips");
        viewAllRecips();
        int recipIndex = ui.intGetter() - 1;
        ui.recipEditMenu();
        int w = ui.intGetter();
        while (w != 0) {
            ui.recipEditMenu();
            w = ui.intGetter();
            if (w == 1) {
                recips.get(recipIndex).editName();
            } else if (w == 2) {
                recipEditer(recipIndex);
            } else if (w == 3) {
                continue;
            } else {
                ui.wronger();
            }
        }
    }

    private void recipEditer(int recipIndex) {
        ui.recipEditIngredientMenu();
        int ww = ui.intGetter();
        while (ww != 0) {
            ui.recipEditIngredientMenu();
            ww = ui.intGetter();
            if (ww == 1) {
                addIngredientsToRecip(recips.get(recipIndex));
            } else if (ww == 2) {
                System.out.println("wich one ");
                recips.get(recipIndex).viewRecip();
                recips.get(recipIndex).editIngredientAmount(ui.intGetter() - 1);
            } else if (ww == 3) {
                System.out.println("wich one ");
                recips.get(recipIndex).viewRecip();
                recips.get(recipIndex).editIngredientComment(ui.intGetter() - 1);
            } else if (ww == 4) {
                recips.get(recipIndex).getIngredients();
                recips.get(recipIndex).removeIngredient(ui.intGetter() - 1);
            } else {
                ui.wronger();
            }
        }
    }

    private void removeIngredient() {
        System.out.println("Choose the Ingredient to remove");
        viewAllIngredients();
        int x = ui.intGetter();
        System.out.println("Are u sure? (y for yes)");
        String y = ui.stringGetter();
        if (y.equals("y") || y.equals("Y")) {
            ingredients.remove(x - 1);
            System.out.println("the ingredient have been removed");

        } else {
            System.out.println("avbryter");
        }
    }

    private void opening() {
        addIngredientsFromFile();
        addRecipsFromFile();
    }

    private void closing() {
        file.ingredientWriter(ingredients);
        file.recipWriter(recips);
    }

    private void run() {
        opening();
        int choose = 100;
        while (choose != 0) {
            ui.menu();
            choose = ui.intGetter();
            if (choose == 1) {
                viewAllIngredients();
            } else if (choose == 2) {
                addIngredient();
            } else if (choose == 3) {
                editIngredient();
            } else if (choose == 4) {
                removeIngredient();
            } else if (choose == 5) {
                ui.recipView();
                int ww = ui.intGetter();
                if (ww == 1) {
                    viewAllRecips();
                } else if (ww == 2) {
                    viewAllRecips();
                    System.out.println(recips.get(ui.intGetter() - 1).viewRecip());
                }
            } else if (choose == 6) {
                addRecip();
            } else if (choose == 7) {
                editRecip();
            } else {
                continue;
            }
        }

        closing();
    }

    public static void main(String[] args) {
        TheApp a = new TheApp();
        a.run();
    }
}

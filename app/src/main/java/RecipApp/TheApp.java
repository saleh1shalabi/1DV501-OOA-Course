package RecipApp;

import java.util.ArrayList;

public class TheApp {

    private FileManager file;

    public ArrayList<Ingredient> ingredients;
    public ArrayList<Recip> recips;
    private Recip recip;
    private UiConsoleSc ui;
    private SearchBehaivour sh;

    TheApp() {
        ingredients = new ArrayList<>();
        recips = new ArrayList<>();
        ui = new UiConsoleSc();
        file = new FileManager();

    }

    public void viewIngredients() {
        int x = 0;
        for (Ingredient c : ingredients) {
            x++;
            System.out.print(x + ". " + c.getName());
            System.out.println();
        }
        System.out.println("\n\n");
    }

    private void addIngredient() {

        System.out.println("new ing: ");
        String ne = ui.stringGetter();

        System.out.println("new mått: ");
        String mg = ui.stringGetter();

        System.out.println("new pris: ");
        double pr = ui.doubleGetter();

        Ingredient ing = (new Ingredient(ne, mg, pr));
        ingredients.add(ing);
    }

    private void addRecip() {
        System.out.println("What is the name of the new Recip?\n");
        recip = new Recip(ui.stringGetter());
        addIngredientsToRecip(recip);
        recip.makingWay();
        recips.add(recip);

    }

    public void addIngredientsToRecip(Recip recip) {
        System.out.println("ADD new ingredient!");
        String x = "";

        while (!(x.equalsIgnoreCase("n"))) {
            viewIngredients();
            int theIngredient = ui.intGetter() - 1;
            while (theIngredient >= ingredients.size() || theIngredient < 0) {
                ui.wronger();
                System.out.println("Please Try To Insert A Right Value");
                theIngredient = ui.intGetter();
            }
            recip.addIngredient(ingredients.get(theIngredient), getHowMuch(), getIngredientReson());
            System.out.println("ADD new ingredient? (for no n)");
            x = ui.stringGetter();
        }
    }

    private double getHowMuch() {
        System.out.println("How Much?");
        return ui.doubleGetter();
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
        System.out.println();
    }

    private void addIngredientsFromFile() {
        ArrayList<ArrayList<String>> fromFileIng = file.ingredientReader();
        for (ArrayList<String> ings : fromFileIng) {
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

            String ingrediens = rec[1].replace("||", ",");
            String[] ingrediensFromRecip = ingrediens.split(",");

            String makeWay = rec[2].replace("||", ",");
            String[] makeWayList = makeWay.split(",");

            for (String ing : ingrediensFromRecip) {
                String thisOne = ing.replace(":", ",");
                String[] theOtherOne = thisOne.split(",");
                String theIngredient = theOtherOne[0].replace(" ", "");
                for (Ingredient ingr : ingredients) {
                    if (theIngredient.equals(ingr.getName())) {

                        while (theOtherOne[2].startsWith(" ")) {
                            theOtherOne[2] = theOtherOne[2].substring(1, theOtherOne[2].length());
                        }

                        recip.addIngredient(ingr, Double.parseDouble(theOtherOne[1].replace(" ", "")), theOtherOne[2]);
                        break;
                    }
                }
            }
            for (String steg : makeWayList) {
                while (steg.startsWith(" ")) {
                    steg = steg.substring(1, steg.length());
                }
                recip.makeWayFromFile(steg);
            }
            recips.add(recip);
        }
    }

    private void removeIngredient() {
        ui.standard();
        viewIngredients();
        int x = ui.intGetter() - 1;
        while (x >= ingredients.size() || x > 0) {
            ui.wronger();
            System.out.println("Please Try To Insert A Right Value");
            x = ui.intGetter() - 1;
        }
        System.out.println("Are u sure? (y for yes)");
        String y = ui.stringGetter();
        if (y.equals("y") || y.equals("Y")) {
            ingredients.remove(x);
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

    private void ingredientMenu() {
        int ingVal = 100;
        while (true) {
            ui.ingredient();
            ingVal = ui.intGetter();
            if (ingVal == 0) {
                break;
            } else if (ingVal == 1) {
                // view ingredients
                ui.ingredientView();
                int choose2 = ui.intGetter();
                if (choose2 == 1) {
                    // all ingr
                    if (ingredients.isEmpty()) {
                        System.out.println("There Is No Ingredients To Show");
                    } else {
                        viewIngredients();
                    }
                } else if (choose2 == 2) {
                    // specieal one
                    if (ingredients.isEmpty()) {
                        System.out.println("There Is No Ingredients To Show");
                    } else {
                        ui.standard();
                        viewIngredients();
                        int ingredientIndex = ui.intGetter() - 1;
                        while (ingredientIndex >= ingredients.size() || ingredientIndex < 0) {
                            ui.wronger();
                            System.out.println("Please Try To Insert A Right Value");
                            ingredientIndex = ui.intGetter() - 1;
                        }
                        System.out.println("Name: " + ingredients.get(ingredientIndex).getName());
                        System.out.println("Price: " + ingredients.get(ingredientIndex).getPrice());
                        System.out.println("Unit: " + ingredients.get(ingredientIndex).getUnit());
                    }
                } else {
                    ui.wronger();
                }
            } else if (ingVal == 2) {
                // add one new
                addIngredient();

            } else if (ingVal == 3) {
                // edit ingredient
                ui.standard();
                viewIngredients();
                int ingIndex = ui.intGetter() - 1;
                while (ingIndex >= ingredients.size() || ingIndex < 0) {
                    ui.wronger();
                    System.out.println("Please Try To Insert A Right Value");
                    ingIndex = ui.intGetter() - 1;
                }

                int editVal = 100;
                while (true) {
                    ui.ingredeientEdit();
                    editVal = ui.intGetter();
                    if (editVal == 0) {
                        break;
                    } else if (editVal == 1) {
                        // name
                        System.out.println("New name Of " + ingredients.get(ingIndex).getName());
                        ingredients.get(ingIndex).editName(ui.stringGetter());
                    } else if (editVal == 2) {
                        // price
                        System.out.println("Price Of " + ingredients.get(ingIndex).getName() + "are "
                                + ingredients.get(ingIndex).getPrice());
                        System.out.println("New Price");
                        ingredients.get(ingIndex).editPrice(ui.doubleGetter());
                    } else if (editVal == 3) {
                        // unit
                        System.out.println("Unit Of " + ingredients.get(ingIndex).getName() + "are "
                                + ingredients.get(ingIndex).getUnit());
                        System.out.println("New Unit");
                        ingredients.get(ingIndex).editUnit(ui.stringGetter());
                    } else {
                        ui.wronger();
                    }
                }
            } else if (ingVal == 4) {
                // remove ingredient
                removeIngredient();
            } else {
                ui.wronger();
            }
        }

    }

    private void recipMenu() {
        // recips

        int choose2 = 100;
        while (true) {
            ui.recip();
            choose2 = ui.intGetter();
            if (choose2 == 0) {
                break;
            } else if (choose2 == 1) {
                // view recip
                ui.recipView();
                int viewVal = ui.intGetter();
                if (viewVal == 1) {
                    // all recips
                    if (recips.isEmpty()) {
                        System.out.println("There Is Now Recips Yet");
                    } else {
                        viewAllRecips();
                    }
                } else if (viewVal == 2) {
                    // specieal recip view
                    if (recips.isEmpty()) {
                        System.out.println("There Is Now Recips Yet");
                    } else {
                        ui.standard();
                        viewAllRecips();
                        int recipIndex = ui.intGetter() - 1;
                        while (recipIndex >= recips.size() || recipIndex < 0) {
                            ui.wronger();
                            System.out.println("Please Try To Insert A Right Value");
                            recipIndex = ui.intGetter() - 1;
                        }
                        System.out.println("\nIngredients:\n\n" + recips.get(recipIndex).getIngredients()
                                + "\n\n\nSteps:\n\n" + recips.get(recipIndex).viewWayMake() + "\n");
                    }
                } else {
                    ui.wronger();
                }
            } else if (choose2 == 2) {
                // add recip
                addRecip();
            } else if (choose2 == 3) {
                // edit recip
                recipEditer();
            } else if (choose2 == 4) {
                ui.standard();
                viewAllRecips();
                int recipIndex = ui.intGetter() - 1;
                while (recipIndex >= recips.size() || recipIndex < 0) {
                    ui.wronger();
                    System.out.println("Please Try To Insert A Right Value");
                    recipIndex = ui.intGetter() - 1;
                }
                System.out.println("Are You Sure To Delete Recip " + recips.get(recipIndex).getName() + " (y)");

                if (ui.stringGetter().equalsIgnoreCase("y")) {
                    System.out.println(recips.remove(recipIndex));
                } else {
                    System.out.println("Operation Aborted!");
                }
            } else {
                ui.wronger();
            }
        }
    }

    private void recipEditer() {
        ui.standard();
        viewAllRecips();

        int recipIndex = ui.intGetter() - 1;
        while (recipIndex >= recips.size() || recipIndex < 0) {
            ui.wronger();
            System.out.println("Please Try To Insert A Right Value");
            recipIndex = ui.intGetter() - 1;
        }
        int editVal = 100;
        while (true) {
            ui.recipEdit();
            editVal = ui.intGetter();
            if (editVal == 0) {
                break;
            } else if (editVal == 1) {
                // edit recip name
                recips.get(recipIndex).editName();
            } else if (editVal == 2) {
                recipIngredientEditor(recipIndex);
            } else if (editVal == 3) {
                recipStepsEditor(recipIndex);
            } else {
                ui.wronger();
            }
        }
    }

    private void recipStepsEditor(int recipIndex) {

        int editStepVal = 100;
        while (true) {
            ui.recipEditWay();
            editStepVal = ui.intGetter();
            if (editStepVal == 0) {
                break;
            } else if (editStepVal == 1) {
                recips.get(recipIndex).makingWay();
            } else if (editStepVal == 2) {
                recips.get(recipIndex).AddStepAtPlace();
            } else if (editStepVal == 3) {
                recips.get(recipIndex).removeStep();
            } else if (editStepVal == 4) {
                recips.get(recipIndex).editStep();
            } else {
                ui.wronger();
            }
        }
    }

    private void recipIngredientEditor(int recipIndex) {
        // recip ingredients
        int editIngVal = 100;
        while (true) {
            ui.recipEditIngredient();
            editIngVal = ui.intGetter();
            if (editIngVal == 0) {
                break;
            } else if (editIngVal == 1) {
                // add ingredient to recip
                addIngredientsToRecip(recips.get(recipIndex));
            } else if (editIngVal == 2) {
                // ingredient amount
                ui.standard();
                System.out.println(recips.get(recipIndex).getIngredients());
                int ingIndex = ui.intGetter() - 1;
                while (ingIndex >= recips.get(recipIndex).ingredientsSize() || ingIndex < 0) {
                    ui.wronger();
                    System.out.println("Please Try To Insert A Right Value");
                    ingIndex = ui.intGetter() - 1;
                }
                ui.newValue();
                recips.get(recipIndex).editIngredientAmount(ingIndex);
            } else if (editIngVal == 3) {
                // ingredient comment
                ui.standard();
                System.out.println(recips.get(recipIndex).getIngredients());
                int ingIndex = ui.intGetter() - 1;
                while (ingIndex >= recips.get(recipIndex).ingredientsSize() || ingIndex < 0) {
                    ui.wronger();
                    System.out.println("Please Try To Insert A Right Value");
                    ingIndex = ui.intGetter() - 1;
                }
                ui.newValue();
                recips.get(recipIndex).editIngredientComment(ingIndex);
            } else if (editIngVal == 4) {
                // remove ingredient
                ui.standard();
                System.out.println(recips.get(recipIndex).getIngredients());
                int ingIndex = ui.intGetter() - 1;
                while (ingIndex >= recips.get(recipIndex).ingredientsSize() || ingIndex < 0) {
                    ui.wronger();
                    System.out.println("Please Try To Insert A Right Value");
                    ingIndex = ui.intGetter() - 1;
                }
                recips.get(recipIndex).removeIngredientFromRecip(ingIndex);
            } else {
                ui.wronger();
            }
        }
    }

    private void run() {
        opening();
        int choose = 100;
        while (true) {
            ui.menu();
            choose = ui.intGetter();
            if (choose == 0) {
                System.out.println("Exiting.... Bye!");
                break;
            } else if (choose == 1) {
                // ingredients
                ingredientMenu();
            } else if (choose == 2) {
                recipMenu();
            } else if (choose == 3) {
                search();
            } else {
                ui.wronger();
            }
        }
        closing();
    }

    private void search() {
        int searchVal = 100;
        while (true) {
            ui.search();
            searchVal = ui.intGetter();
            if (searchVal == 0) {
                break;
            } else if (searchVal == 1) {
                sh = new ByPriceSearch();
                sh.search(recips);
            } else if (searchVal == 2) {
                sh = new ByIngredientsSearch();
                sh.chooseIngrediet(ingredients);
                sh.search(recips);
            } else {
                ui.wronger();
            }
        }
    }

    public static void main(String[] args) {
        TheApp a = new TheApp();
        a.run();
    }
}

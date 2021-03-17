package recipapp;

import java.util.ArrayList;

public class RecipApp {

  private FileManager file;

  private ArrayList<Ingredient> ingredients;
  private ArrayList<Recip> recips;
  private Recip recip;
  private UiConsoleSc ui;
  private SearchBehaivour sh;

  RecipApp() {
    ingredients = new ArrayList<>();
    recips = new ArrayList<>();
    ui = new UiConsoleSc();
    file = new FileManager();
  }

  /**
   * Creates the tiles.
   */
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

  /**
   * Creates the tiles.
   */
  private void viewIngredients() {
    int x = 0;
    for (Ingredient c : ingredients) {
      x++;
      System.out.print(x + ". " + c.getName());
      System.out.println();
    }
    System.out.println("\n\n");
  }

  /**
   * Creates the tiles.
   */
  private void addRecip() {
    System.out.println("What is the name of the new Recip?\n");
    recip = new Recip(ui.stringGetter());
    recip.addIngredient(ingredients);
    recip.makingWay();
    System.out.println("How Meny Portions Is This Recip For");
    recip.portionSetter(ui.intGetter());
    System.out.println("Number Of Portions " + recip.getPortions() + " Have Been Added!");
    recips.add(recip);
  }

  /**
   * Creates the tiles.
   */
  private void viewAllRecips() {
    int x = 1;
    for (Recip c : recips) {
      System.out.print(x + ". " + c.getName() + "\n");
      x++;
    }
    System.out.println();
  }

  /**
   * Creates the tiles.
   */
  private void removeIngredient() {
    ui.standard();
    viewIngredients();
    int x = ui.compare(ingredients.size());
    System.out.println("Are u sure? (y for yes)");
    String y = ui.stringGetter();
    if (y.equals("y") || y.equals("Y")) {
      ingredients.remove(x);
      System.out.println("the ingredient have been removed");
    } else {
      System.out.println("avbryter");
    }
  }

  /**
   * Creates the tiles.
   */
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
        int choose = ui.intGetter();
        if (choose == 1) {
          // all ingr
          if (ingredients.isEmpty()) {
            System.out.println("There Is No Ingredients To Show");
          } else {
            viewIngredients();
          }
        } else if (choose == 2) {
          // specieal one
          if (ingredients.isEmpty()) {
            System.out.println("There Is No Ingredients To Show");
          } else {
            ui.standard();
            viewIngredients();
            int ingredientIndex = ui.compare(ingredients.size());
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
        ingredientEditer();
      } else if (ingVal == 4) {
        // remove ingredient
        removeIngredient();
      } else {
        ui.wronger();
      }
    }
  }

  /**
   * Creates the tiles.
   */
  private void ingredientEditer() {
    ui.standard();
    viewIngredients();
    int ingIndex = ui.compare(ingredients.size());
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
        System.out.println("Price Of " + ingredients.get(ingIndex).getName() 
            + "are " + ingredients.get(ingIndex).getPrice());
        System.out.println("New Price");
        ingredients.get(ingIndex).editPrice(ui.doubleGetter());
      } else if (editVal == 3) {
        // unit
        System.out.println("Unit Of " + ingredients.get(ingIndex).getName() 
            + "are " + ingredients.get(ingIndex).getUnit());
        System.out.println("New Unit");
        ingredients.get(ingIndex).editUnit(ui.stringGetter());
      } else {
        ui.wronger();
      }
    }
  }

  /**
   * Creates the tiles.
   */
  private void recipMenu() {
    // recips

    int choose = 100;
    while (true) {
      ui.recip();
      choose = ui.intGetter();
      if (choose == 0) {
        break;
      } else if (choose == 1) {
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
            int recipIndex = ui.compare(recips.size());
            System.out.println("\nIngredients:\n\n" + recips.get(recipIndex).getIngredients() 
                + "\n\n\nPortions:\n(" + recips.get(recipIndex).getPortions() 
                + ")\n\n\nSteps:\n\n" + recips.get(recipIndex).viewWayMake()
                + "\n");
          }
        } else {
          ui.wronger();
        }
      } else if (choose == 2) {
        // add recip
        addRecip();
      } else if (choose == 3) {
        // edit recip
        recipEditer();
      } else if (choose == 4) {
        ui.standard();
        viewAllRecips();
        int recipIndex = ui.compare(recips.size());
        System.out.println("Are You Sure To Delete Recip " 
            + recips.get(recipIndex).getName() + " (y)");

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

  /**
   * Creates the tiles.
   */
  private void recipEditer() {
    ui.standard();
    viewAllRecips();
    int recipIndex = ui.compare(recips.size());
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

  /**
   * Creates the tiles.
   */
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
        recips.get(recipIndex).addStepAtPlace();
      } else if (editStepVal == 3) {
        recips.get(recipIndex).removeStep();
      } else if (editStepVal == 4) {
        recips.get(recipIndex).editStep();
      } else {
        ui.wronger();
      }
    }
  }

  /**
   * Creates the tiles.
   */
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
        recips.get(recipIndex).addIngredient(ingredients);
      } else if (editIngVal == 2) {
        // ingredient amount
        ui.standard();
        System.out.println(recips.get(recipIndex).getIngredients());
        int ingIndex = ui.compare(recips.get(recipIndex).ingredientsSize());
        ui.newValue();
        recips.get(recipIndex).editIngredientAmount(ingIndex);
      } else if (editIngVal == 3) {
        // ingredient comment
        ui.standard();
        System.out.println(recips.get(recipIndex).getIngredients());
        int ingIndex = ui.compare(recips.get(recipIndex).ingredientsSize());
        ui.newValue();
        recips.get(recipIndex).editIngredientComment(ingIndex);
      } else if (editIngVal == 4) {
        // remove ingredient
        ui.standard();
        System.out.println(recips.get(recipIndex).getIngredients());
        int ingIndex = ui.compare(recips.get(recipIndex).ingredientsSize());
        recips.get(recipIndex).removeIngredientFromRecip(ingIndex);
      } else {
        ui.wronger();
      }
    }
  }

  /**
   * Creates the tiles.
   */
  private void searcher() {
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
      } else if (searchVal == 3) {
        sh = new ByPortionsSearch();
        sh.search(recips);
      } else {
        ui.wronger();
      }
    }
  }

  /**
   * Creates the tiles.
   */
  private void run() {
    ingredients = file.ingredientAdder();
    recips = file.recipAdder();
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
        searcher();
      } else {
        ui.wronger();
      }
    }
    file.ingredientWriter(ingredients);
    file.recipWriter(recips);
  }

  public static void main(String[] args) {
    RecipApp a = new RecipApp();
    a.run();
  }
}

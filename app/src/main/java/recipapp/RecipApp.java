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
   * new ingredient from user.
   */
  private void addIngredient() {

    System.out.println("What is the ingredient's Name: ");
    String ne = ui.stringGetter();

    System.out.println("Which Unit to Use With (" + ne + "): ");
    String mg = ui.stringGetter();

    System.out.println("What Is the Price for (" + ne + "): ");
    double pr = ui.doubleGetter();
    while (pr <= 0) {
      ui.wronger();
      pr = ui.doubleGetter();
    }

    Ingredient ing = (new Ingredient(ne, mg, pr));
    ingredients.add(ing);
    
    System.out.println("The Ingredient" + ing.getName() + "Have Been Added!\n\n");
  }

  /**
   * shows the ingredients.
   */
  private void viewIngredients() {
    int x = 0;
    System.out.println("\n\nAll Available Ingredients are:\n");
    for (Ingredient c : ingredients) {
      x++;
      System.out.print(x + ". " + c.getName() + "\n");
    }
    System.out.println("\n\n");
  }

  /**
   * new recip from user.
   */
  private void addRecip() {
    System.out.println("What is the name of the new Recip?\n");
    recip = new Recip(ui.stringGetter());

    System.out.println("How Meny Portions Is This Recip For?\n");
    recip.portionSetter(ui.intGetter());
    
    recip.addIngredient(ingredients);
    recip.makingWay();

    recips.add(recip);
  }

  /**
   * view recips.
   */
  private void viewAllRecips() {
    int x = 1;
    System.out.println("\n\nAll Available Recips are:\n");
    for (Recip c : recips) {
      System.out.print(x + ". " + c.getName() + "\n");
      x++;
    }
    System.out.println("\n\n");
  }

  /**
   * remove an ingrdeient from this app.
   */
  private void removeIngredient() {
    ui.standard();
    viewIngredients();
    int x = ui.compare(ingredients.size());
    System.out.println("Are U Sure? (Y For Yes)");
    String y = ui.stringGetter();
    if (y.equalsIgnoreCase("y")) {
      ingredients.remove(x);
      System.out.println("The Ingredient Have Been Removed");
    } else {
      System.out.println("Operation Aborted!");
    }
  }

  /**
   * the Ingredients menu to user.
   */
  private void ingredientMenu() {
    int ingVal = 100;
    while (ingVal != 0) {
      ui.ingredient();
      ingVal = ui.intGetter();
      switch (ingVal) {
        case 0:
          break;
        case 1:
          // view ingredients
          ui.ingredientView();
          int choose = ui.intGetter();
          switch (choose) {
            case 1:
              // all ingr
              if (ingredients.isEmpty()) {
                System.out.println("There Is No Ingredients To Show");
                ui.pressToReturn();
              } else {
                viewIngredients();
                ui.pressToReturn();
              }
              break;
            case 2:
              // specieal one
              if (ingredients.isEmpty()) {
                System.out.println("There Is No Ingredients To Show");
                ui.pressToReturn();
              } else {
                ui.standard();
                viewIngredients();
                int ingredientIndex = ui.compare(ingredients.size());
                System.out.println("\n\nThe Chosen Ingredient:\n");
                System.out.println("Name: " + ingredients.get(ingredientIndex).getName());
                System.out.println("Price: " + ingredients.get(ingredientIndex).getPrice());
                System.out.println("Unit: " + ingredients.get(ingredientIndex).getUnit() + "\n\n");
                ui.pressToReturn();
              }
              break;
            default:
              ui.wronger();
          }
          break;
        case 2:
          // add one new
          addIngredient();
          ui.pressToReturn();
          break;
        case 3:
          // edit ingredient
          ingredientEditer();
          break;
        case 4:
          // remove ingredient
          removeIngredient();
          ui.pressToReturn();
          break;
        default:
          ui.wronger();
      }
    }
  }

  /**
   * the Edit Ingredient menu and options.
   */
  private void ingredientEditer() {
    ui.standard();
    viewIngredients();
    int ingIndex = ui.compare(ingredients.size());
    int editVal = 100;
    while (editVal != 0) {
      ui.ingredeientEdit();
      editVal = ui.intGetter();
      switch (editVal) {
        case 0:
          break;
        case 1:
          // name
          System.out.print("\nNew Name Of The (" + ingredients.get(ingIndex).getName() + ") : ");
          ingredients.get(ingIndex).editName(ui.stringGetter());
          System.out.println("\nThe Name have been Edited!\n");
          ui.pressToReturn();
          break;
        case 2:
          // price
          System.out.println("\nPrice Of " + ingredients.get(ingIndex).getName() 
              + " are (" + ingredients.get(ingIndex).getPrice() + ")\n");
          System.out.print("New Price: ");
          double price = ui.doubleGetter();
          while (price <= 0) {
            ui.wronger();
            price = ui.doubleGetter();
          }
          ingredients.get(ingIndex).editPrice(price);
          System.out.println("\nThe Price have been Edited!\n");
          ui.pressToReturn();
          break;
        case 3:
          // unit
          System.out.println("\nUnit Of " + ingredients.get(ingIndex).getName() 
              + " are (" + ingredients.get(ingIndex).getUnit() + ")\n");
          System.out.print("New Unit: ");
          ingredients.get(ingIndex).editUnit(ui.stringGetter());
          System.out.println("\nThe Unit have been Edited!\n");
          ui.pressToReturn();
          break;
        default:
          ui.wronger();
      }
    }
  }

  /**
   * the recip menu to user.
   */
  private void recipMenu() {
    int choose = 100;
    while (choose != 0) {
      ui.recip();
      choose = ui.intGetter();
      switch (choose) {
        case 0:
          break;
        case 1:
          // view recip
          ui.recipView();
          int viewVal = ui.intGetter();
          switch (viewVal) {
            case 1:
              if (recips.isEmpty()) {
                System.out.println("There Is Now Recips Yet!");
                ui.pressToReturn();
              } else {
                viewAllRecips();
                ui.pressToReturn();
              }
              break;
            case 2:
              // specieal recip view
              if (recips.isEmpty()) {
                System.out.println("There Is Now Recips Yet!");
                ui.pressToReturn();
              } else {
                ui.standard();
                viewAllRecips();
                int recipIndex = ui.compare(recips.size());
                System.out.println("\nIngredients:\n" + recips.get(recipIndex).getIngredients() 
                    + "\n\nPortions:\n(" + recips.get(recipIndex).getPortions() 
                    + ")\n\nSteps:\n" + recips.get(recipIndex).viewWayMake()
                    + "\n\nPrice: (" + recips.get(recipIndex).getPrice() + ")\n\n");
                ui.pressToReturn();
              }
              break;
            case 3:
              // Special Portions
              if (recips.isEmpty()) {
                System.out.println("There Is Now Recips Yet!");
                ui.pressToReturn();
              } else {
                ui.standard();
                viewAllRecips();
                int recipIndex = ui.compare(recips.size());
                System.out.println("How many Portions Are U Asking For ");
                int portions = ui.compare(101) + 1;
                recips.get(recipIndex).speciealPortionGetter(portions);
                ui.pressToReturn();
              }
              break;
            default:
              ui.wronger();    
          }
          break;
        case 2:
          addRecip();
          ui.pressToReturn();
          break;
        case 3:
          recipEditer();
          break;
        case 4:
          // delete recip
          ui.standard();
          viewAllRecips();
          int recipIndex = ui.compare(recips.size());
          System.out.println("Are You Sure To Delete Recip? \n" 
              + recips.get(recipIndex).getName() + " (Y For Yes)");
          if (ui.stringGetter().equalsIgnoreCase("Y")) {
            recips.remove(recipIndex);
            System.out.println("Recip Is Now Deleted!\n\n");
          } else {
            System.out.println("Operation Aborted!\n\n");
          }
          ui.pressToReturn();
          break;
        default:
          ui.wronger();
      }  
    }
  }

  /**
   * recip edit options.
   */
  private void recipEditer() {
    ui.standard();
    viewAllRecips();
    int recipIndex = ui.compare(recips.size());
    int editVal = 100;
    while (editVal != 0) {
      ui.recipEdit();
      editVal = ui.intGetter();
      switch (editVal) {
        case 0:
          break;
        case 1:
          // edit recip name
          recips.get(recipIndex).editName();
          ui.pressToReturn();
          break;
        case 2:
          // recip Ingredients editor
          recipIngredientEditor(recipIndex);
          break;
        case 3:
          // recip Steps editor
          recipStepsEditor(recipIndex);
          break;
        default:
          ui.wronger();
      }
    }
  }

  /**
   * option Step edits in recip.
   */
  private void recipStepsEditor(int recipIndex) {

    int editStepVal = 100;
    while (editStepVal != 0) {
      ui.recipEditWay();
      editStepVal = ui.intGetter();
      switch (editStepVal) {
        case 0:
          break;
        case 1:
          recips.get(recipIndex).makingWay();
          ui.pressToReturn();
          break;
        case 2:
          recips.get(recipIndex).addStepAtPlace();
          ui.pressToReturn();
          break;
        case 3:
          recips.get(recipIndex).removeStep();
          ui.pressToReturn();
          break;
        case 4:
          recips.get(recipIndex).editStep();
          ui.pressToReturn();
          break;
        default:
          ui.wronger();
      }
    }
  }

  /**
   * recip Ingredient Editor.
   */
  private void recipIngredientEditor(int recipIndex) {
    // recip ingredients
    int editIngVal = 100;
    int ingIndex;
    while (editIngVal != 0) {
      ui.recipEditIngredient();
      editIngVal = ui.intGetter();
      switch (editIngVal) {
        case 0:
          break;
        case 1:
          // add ingredient to recip
          recips.get(recipIndex).addIngredient(ingredients);
          ui.pressToReturn();
          break;
        case 2:
          // ingredient amount
          ui.standard();
          System.out.println(recips.get(recipIndex).getIngredients());
          ingIndex = ui.compare(recips.get(recipIndex).ingredientsSize());
          ui.newValue();
          recips.get(recipIndex).editIngredientAmount(ingIndex);
          ui.pressToReturn();
          break;
        case 3:
          // ingredient comment
          ui.standard();
          System.out.println(recips.get(recipIndex).getIngredients());
          ingIndex = ui.compare(recips.get(recipIndex).ingredientsSize());
          ui.newValue();
          recips.get(recipIndex).editIngredientComment(ingIndex);
          ui.pressToReturn();
          break; 
        case 4:
          // remove ingredient
          ui.standard();
          System.out.println(recips.get(recipIndex).getIngredients());
          ingIndex = ui.compare(recips.get(recipIndex).ingredientsSize());
          recips.get(recipIndex).removeIngredientFromRecip(ingIndex);
          ui.pressToReturn();
          break;
        default:
          ui.wronger();
      }
    }
  }

  /**
   * the searcher that use search strategy.
   */
  private void searcher() {
    int searchVal = 100;
    while (searchVal != 0) {
      ui.search();
      searchVal = ui.intGetter();
      switch (searchVal) {
        case 0: 
          break;
        case 1:
          sh = new ByPriceSearch();
          sh.search(recips);
          break;
        case 2:
          sh = new ByIngredientsSearch();
          sh.chooseIngrediet(ingredients);
          sh.search(recips);
          break;
        case 3:
          sh = new ByPortionsSearch();
          sh.search(recips);
          break;   
        default:
          ui.wronger(); 
      }
    }
  }

  /**
   * method that runs the program.
   */
  private void run() {
    ingredients = file.ingredientAdder();
    recips = file.recipAdder();
    int choose = 100;
    while (choose != 0) {
      ui.menu();
      choose = ui.intGetter();
      switch (choose) {
        case 0:
          System.out.print("Exiting....");
          file.ingredientWriter(ingredients);
          file.recipWriter(recips);
          System.out.println(" Bye!");
          break;
        case 1:
          ingredientMenu();
          break;
        case 2:
          recipMenu();
          break;  
        case 3:
          searcher();
          break;
        default:
          ui.wronger();
      }
    }
  }

  public static void main(String[] args) {
    RecipApp a = new RecipApp();
    a.run();
  }
}

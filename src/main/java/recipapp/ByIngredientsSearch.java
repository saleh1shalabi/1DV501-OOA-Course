package recipapp;

import java.util.ArrayList;

public class ByIngredientsSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

  private Ingredient theOneIngredient;

  /**
   * searcher for an ingrdeint in recips.
   */
  @Override
  public void search(ArrayList<Recip> recips) {
    StringBuilder x = new StringBuilder();
    int y = 1;
    for (Recip recip : recips) {
      if (recip.haveIngredient(theOneIngredient)) {
        x.append(y + ". " + recip.getName() + "\n");
        y++;
      }
    }
    System.out.println("The Recips With Ingredient (" 
        + theOneIngredient.getName() + ") Are:\n\n" + x.toString());
  }
  
  /**
   * For the user to choose one ingredient.
   */
  @Override
  public Ingredient chooseIngrediet(ArrayList<Ingredient> ingredients) {
    StringBuilder x = new StringBuilder();
    int y = 1;
    System.out.println("Which Ingredient");
    ui.standard();
    for (Ingredient ingredient : ingredients) {
      x.append(y + ". " + ingredient.getName() + "\n");
      y++;
    }
    System.out.println(x.toString());
    int theIngredient = ui.compare(ingredients.size());
    theOneIngredient = ingredients.get(theIngredient);
    return theOneIngredient;
  }
}

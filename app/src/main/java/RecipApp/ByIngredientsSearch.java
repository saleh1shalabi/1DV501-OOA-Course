package RecipApp;

import java.util.ArrayList;

public class ByIngredientsSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

  private String theOneIngredient;

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
    System.out.println("The Recips With Ingredient (" + theOneIngredient + ") Are:\n\n" + x.toString());
  }

  @Override
  public String chooseIngrediet(ArrayList<Ingredient> ingredients) {
    StringBuilder x = new StringBuilder();
    int y = 1;
    System.out.println("Which Ingredient");
    ui.standard();
    for (Ingredient ingredient : ingredients) {
      x.append(y + ". " + ingredient.getName() + "\n");
      y++;
    }
    System.out.println(x.toString());
    int theIngredient = ui.intGetter() - 1;
    while (theIngredient >= ingredients.size() || theIngredient < 0) {
      ui.wronger();
      System.out.println("Please Try To Insert A Right Value");
      theIngredient = ui.intGetter();
    }
    theOneIngredient = ingredients.get(theIngredient).getName();
    return theOneIngredient;
  }
}

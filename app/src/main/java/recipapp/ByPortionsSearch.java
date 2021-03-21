package recipapp;

import java.util.ArrayList;

public class ByPortionsSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

  /**
   * searcher for recips of X portion.
   */
  @Override
  public void search(ArrayList<Recip> recips) {
    System.out.println("What Is The Number Of Portions?");
    int y = 1;
    StringBuilder x = new StringBuilder();
    int portions = ui.intGetter();
    for (Recip recip : recips) {
      if (recip.getPortions() == portions) {
        x.append(y + ". " + recip.getName() + "\n");
        y++;
      }
    }
    System.out.println("Recips Found With The Number Of Portions (" 
        + portions + "):\n\n" + x.toString());
  }

  /**
    * none functional in this implementaion.
   */
  @Override
  public Ingredient chooseIngrediet(ArrayList<Ingredient> ingredients) {
    return null;
  }
}

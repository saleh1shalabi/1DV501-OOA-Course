package recipapp;

import java.util.ArrayList;

/**
 * searcher class for label in recips.
 */
public class ByLabelSearch implements SearchBehaivour {

  private UiConsoleSc ui = new UiConsoleSc();
  
  /**
   * search recips with a specific label.
   */
  @Override
  public void search(ArrayList<Recip> recips) {
    String label = ui.chooseRecipLabel();
    StringBuilder x = new StringBuilder();
    int y = 1;      
    for (Recip recip : recips) {
      if (recip.labelGetter().equals(label)) {
        x.append(y + ". " + recip.getName() + "\n");
        y++;
      }
    }
    System.out.println("The Recipes With The Label (" 
        + label + ") Are:\n\n" + x.toString());
  }

  @Override
  public void chooseIngrediet(ArrayList<Ingredient> ingredients) {
  }
  
}

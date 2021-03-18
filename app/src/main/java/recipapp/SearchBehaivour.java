package recipapp;

import java.util.ArrayList;

public interface SearchBehaivour {

  /**
   * searcher.
   */
  public void search(ArrayList<Recip> recips);

  /**
   * user ingredient choice.
   */
  public String chooseIngrediet(ArrayList<Ingredient> ingredients);
}

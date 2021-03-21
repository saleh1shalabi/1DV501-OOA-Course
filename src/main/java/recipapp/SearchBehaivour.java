package recipapp;

import java.util.ArrayList;

/**
 * searcher interface class.
 */
public interface SearchBehaivour {

  /**
   * searcher.
   */
  public void search(ArrayList<Recip> recips);

  /**
   * user ingredient choice.
   */
  public void chooseIngrediet(ArrayList<Ingredient> ingredients);
}

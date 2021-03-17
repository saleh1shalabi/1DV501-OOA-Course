package recipapp;

import java.util.ArrayList;

public interface SearchBehaivour {

  /**
   * Creates the tiles.
   */
  public void search(ArrayList<Recip> recips);

  /**
   * Creates the tiles.
   */
  public String chooseIngrediet(ArrayList<Ingredient> ingredients);
}

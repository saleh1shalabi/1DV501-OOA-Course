package recipapp;

import java.util.ArrayList;

public class ByPriceSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

  /**
   * search with a price.
   */
  @Override
  public void search(ArrayList<Recip> recips) {
    System.out.println("What Is The Price?\n");
    int price = ui.intGetter();
    int y = 1;
    StringBuilder x = new StringBuilder();
    for (Recip recip : recips) {
      if (recip.getPrice() <= price) {
        x.append(y + ". " + recip.getName() + " (" + recip.getPrice() + ")" + "\n");
        y++;
      }
    }
    System.out.println("Recips Found With The Price " + price + " Or Less:\n\n" + x.toString());
  }

  /**
   * none functional in this implementaion.
   */
  @Override
  public void chooseIngrediet(ArrayList<Ingredient> ingredients) {
  }

}

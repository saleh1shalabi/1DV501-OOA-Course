package RecipApp;

import java.util.ArrayList;

public class ByPriceSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

  @Override
  public void search(ArrayList<Recip> recips) {
    System.out.println("What is the price?\n");
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

  @Override
  public String chooseIngrediet(ArrayList<Ingredient> ingredients) {
    return null;
  }

}

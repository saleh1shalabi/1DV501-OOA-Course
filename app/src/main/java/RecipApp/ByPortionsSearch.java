package RecipApp;

import java.util.ArrayList;

public class ByPortionsSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

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
    System.out.println("Recips Found With The Number Of Portions (" + portions + "):\n\n" + x.toString());
  }

  @Override
  public String chooseIngrediet(ArrayList<Ingredient> ingredients) {
    return null;
  }

}

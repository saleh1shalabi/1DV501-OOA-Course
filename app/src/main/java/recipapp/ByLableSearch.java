package recipapp;

import java.util.ArrayList;

public class ByLableSearch implements SearchBehaivour {

  private UiConsoleSc ui = new UiConsoleSc();
  
  /**
   * search recips with a specific lable.
   */
  @Override
  public void search(ArrayList<Recip> recips) {
    String lable = ui.chooseRecipLable();
    StringBuilder x = new StringBuilder();
    int y = 1;      
    for (Recip recip : recips) {
      if (recip.lableGetter().equals(lable)) {
        x.append(y + ". " + recip.getName() + "\n");
        y++;
      }
    }
    System.out.println("The Recips With The Lable (" 
        + lable + ") Are:\n\n" + x.toString());
  }

  @Override
  public void chooseIngrediet(ArrayList<Ingredient> ingredients) {
  }
  
}

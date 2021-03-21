package recipapp;

import java.util.ArrayList;

/**
 * searcher class grade.
 */
public class ByGradeSearch implements SearchBehaivour {
  private UiConsoleSc ui = new UiConsoleSc();

  /**
   * searcher for grade.
   */
  @Override
  public void search(ArrayList<Recip> recips) {
    System.out.println("What Is The Grade?\n");
    int grade = ui.compare(11) + 1;
    int y = 1;
    StringBuilder x = new StringBuilder();
    for (Recip recip : recips) {
      if (recip.gradeGetter() >= grade) {
        x.append(y + ". " + recip.getName() + " Grade:(" + recip.gradeGetter() + ")" + "\n");
        y++;
      }
    }
    System.out.println("Recips Found With The Grade " + grade + " Or more:\n\n" + x.toString());
  }

  @Override
  public void chooseIngrediet(ArrayList<Ingredient> ingredients) {  
  }

}

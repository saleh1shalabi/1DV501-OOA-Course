package RecipApp;

import java.util.Scanner;

public class UiConsoleSc {
  private String menu = "\nThis is the menu of The Recip App:\n    1. view all availble ingredients\n    2. add ingredient\n    3. edit ingredient\n    4. remove ingredient\n    5. Recip View\n    6. add recip\n    7. edit a recip\n    8. remove recip\n";
  private String recipEdit = "\nChoose what to edit:\n    1. Name\n    2. Ingredients\n    3. The way of making\n    0. to get back\n";
  private String recipEditIngredients = "\nwhat to do with ingredients?\n    1. Add Ingredient\n    2. Edit an Ingredient Amount\n    3. Edit an Ingredient Comment\n    4. Remove an Ingredient\n    0. to get back\n";
  private String chooseIngredient = "\nChoose the Ingredient\n";
  private String ingreientEditMenu = "\nWhat to edit\n    1. Name\n    2. price\n    3. Unit\n";
  private String recipViewer = "\nRecip view:\n    1. View all Recips\n    2. View A recip";
  private Scanner input = new Scanner(System.in);

  public void menu() {
    System.out.println(menu);
  }

  public int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        return nr;
      } catch (Exception e) {
        System.out.println("Wrong input!\nPlease try again with writ value!");
      }
    }
  }

  public double doubleGetter() {
    while (true) {
      try {
        double nr = Double.parseDouble(input.nextLine());
        return nr;
      } catch (Exception e) {
        System.out.println("Wrong input!\nPlease try again with writ value!");
      }
    }
  }

  public String stringGetter() {
    String st = "";
    do {
      st = input.nextLine();
    } while (st.equals(""));
    return st;
  }

  public void recipEditMenu() {
    System.out.println(recipEdit);
  }

  public void recipEditIngredientMenu() {
    System.out.println(recipEditIngredients);
  }

  public void ingredeientChoose() {
    System.out.println(chooseIngredient);
  }

  public void ingredeientEditMenu() {
    System.out.println(ingreientEditMenu);
  }

  public void recipView() {
    System.out.println(recipViewer);
  }

  public void wronger() {
    System.out.println("Wrong Value Please Try to Insert Again!");
  }
}

package RecipApp;

import java.util.Scanner;

public class UiConsoleSc {

  private String standard = "\n\n\nChoose one:\n    ";

  private Scanner input = new Scanner(System.in);

  public int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        return nr;
      } catch (Exception e) {
        wronger();
      }
    }
  }

  public double doubleGetter() {
    while (true) {
      try {
        double nr = Double.parseDouble(input.nextLine());
        return nr;
      } catch (Exception e) {
        wronger();
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

  public void menu() {
    System.out.println(
        "\nThis is the menu of The Recip App:\n    1. Ingredients\n    2. Recip\n    3. Search\n    0. Quit\n");
  }

  public void ingredient() {
    System.out.println(standard
        + "1. View Ingredients\n    2. Add Ingredient\n    3. Edit Ingredient\n    4. Remove Ingredient\n    0. Back to main menu\n");
  }

  public void ingredientView() {
    System.out.println(standard + "1. All Availble Ingredients\n    2. Details about one\n");
  }

  public void ingredeientEdit() {
    System.out.println(standard + "1. Name\n    2. price\n    3. Unit\n    0. Back to Ingredients Menu");
  }

  public void standard() {
    System.out.println(standard);
  }

  public void recip() {
    System.out.println(standard
        + "1. View Recip\n    2. Add Recip\n    3. Edit a Recip\n    4. Remove Recip\n    0. Back to Main Menu\n");
  }

  public void recipView() {
    System.out.println(standard + "1. All Availble Recips\n    2. Details about one\n");
  }

  public void recipEdit() {
    System.out.println(standard + "1. Name\n    2. Ingredients\n    3. The way of making\n    0. Back to Recip Menu\n");
  }

  public void recipEditIngredient() {
    System.out.println(standard
        + "1. Add Ingredient\n    2. Edit an Ingredient Amount\n    3. Edit an Ingredient Comment\n    4. Remove an Ingredient\n    0. Back to Recip Edit Menu\n");
  }

  public void recipEditWay() {
    System.out.println(standard
        + "1. Add Step At End\n    2. Add Step At Specific place\n    3. Remove a Step\n    4. Edit a Step\n    0. Back to Recip Edit Menu\n");
  }

  public void wronger() {
    System.out.println("Wrong Value!");
  }

  public void newValue() {
    System.out.println("Enter the new value!");
  }

  public void search() {
    System.out.println(standard
        + "1. Search by Price\n    2. Search by Ingredients\n    3. Search by Portion number\n    0. Back to Recip Edit Menu\n");
  }
}

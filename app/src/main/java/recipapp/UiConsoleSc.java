package recipapp;

import java.util.Scanner;

public class UiConsoleSc {

  private String standard = "\n\nChoose one:\n    ";

  private Scanner input = new Scanner(System.in);

  /**
   * gets an int input from user.
   */
  public int intGetter() {
    while (true) {
      try {
        int nr = Integer.parseInt(input.nextLine());
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return nr;
      } catch (Exception e) {
        wronger();
      }
    }
  }

  /**
   * gets an double input from user.
   */
  public double doubleGetter() {
    while (true) {
      try {
        double nr = Double.parseDouble(input.nextLine());
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return nr;
      } catch (Exception e) {
        wronger();
      }
    }
  }

  /**
   * gets an string input from user.
   */
  public String stringGetter() {
    String st = "";
    do {
      st = input.nextLine();
    } while (st.equals(""));
    System.out.print("\033[H\033[2J");
    System.out.flush();

    return st = st.substring(0,1).toUpperCase() + st.substring(1);
  }

  /**
   * this method is used
   * when its time for the user to choose a number that will 
   * represent the index of one ingredient or recip
   * with this method the user is not allowed to choose index that 
   * are out of the range.
   */
  public int compare(int comparTo) {
    int number = intGetter() - 1;
    while (number >= comparTo || number < 0) {
      wronger();
      System.out.println("Please Try To Insert A Right Value");
      number = intGetter() - 1;
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }
    return number;
  }

  /**
   * presser.
   */
  public void pressToReturn() {
    System.out.println("Press Enter to Continue!");
    input.nextLine();
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void menu() {
    System.out.println("\nThis is the menu of The Recip App:\n    1. Ingredients\n    2. Recip\n" 
        + "    3. Search\n    0. Quit\n");
  }

  public void ingredient() {
    System.out.println(standard + "1. View Ingredients\n    2. Add Ingredient\n    "
        + "3. Edit Ingredient\n    4. Remove Ingredient\n    0. Back to main menu\n");
  }

  public void ingredientView() {
    System.out.println(standard + "1. All Availble Ingredients\n    2. Details about one\n");
  }

  public void ingredeientEdit() {
    System.out.println(standard + "1. Name\n    2. Price\n    3. Unit\n    4. Lable\n"
        + "    0. Back to Ingredients Menu");
  }

  public void standard() {
    System.out.println(standard);
  }

  public void recip() {
    System.out.println(standard + "1. View Recip\n    2. Add Recip\n"
        + "    3. Edit a Recip\n    4. Remove Recip\n    0. Back to Main Menu\n");
  }

  public void recipView() {
    System.out.println(standard + "1. All Availble Recips\n    2. Details about one\n" 
        + "    3. A Recip With Specieal given Portion Number\n");
  }

  /**
   * Recip Edit menu.
   */
  public void recipEdit() {
    System.out.println(standard + "1. Name\n    2. Ingredients\n"
        + "    3. The way of making\n    4. Edit Lable\n    "
        + "5. Number Of Portions\n    0. Back to Recip Menu\n");
  }

  /**
   * the menu for editing ingrdeints in recips.
   */
  public void recipEditIngredient() {
    System.out.println(standard + "1. Add Ingredient\n    2. Edit an Ingredient Amount\n"
        + "    3. Edit an Ingredient Comment\n    4. Remove an Ingredient\n"
        + "    0. Back to Recip Edit Menu\n");
  }

  public void recipEditWay() {
    System.out.println(standard + "1. Add Step At End\n    2. Add Step At Specific place\n"
        + "    3. Remove a Step\n    4. Edit a Step\n    0. Back to Recip Edit Menu\n");
  }

  public void wronger() {
    System.out.println("Wrong Value!");
  }

  public void newValue() {
    System.out.println("Enter the new value!");
  }

  public void search() {
    System.out.println(standard + "1. Search by Price\n    2. Search by Ingredients\n"
        + "    3. Search by Portion number\n    4. Search by Lable\n    0. Back to Main Menu\n");
  }

  /**
   * method to set lable to a recip.
   */
  public String chooseRecipLable() {
    String[] labels = {"Dessert", "Dinner", "Breakfast" 
        + "Lunch", "BBQ", "Vegetarian", "Vegan", "Dairy Free"};
    int count = 1;  
    standard();
    for (String lable : labels) {
      System.out.println(count + ". " + lable);
      count++;
    }
    int choose = compare(9);
    return labels[choose]; 
  }

  /**
   * method to set lable to a Ingredient.
   */
  public String chooseIngredientLable() {
    
    String[] labels = {"Vegan", "Dairy", "Gluten", "Fish & SeaFood", "meat", "Chicken"};
    int count = 1;
    standard();  
    for (String lable : labels) {
      System.out.println(count + ". " + lable);
      count++;
    }
    int choose = compare(6);
    return labels[choose]; 
  }
}

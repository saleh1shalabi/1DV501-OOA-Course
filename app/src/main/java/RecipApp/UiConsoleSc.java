package RecipApp;

import java.util.Scanner;

public class UiConsoleSc {
  private String menu = "This is the menu of The Recip App:\n    1. view all availble ingredients\n    2. add ingredient\n    3. edit ingredient\n    4.remove ingredient\n    5. view all recips\n    6. add recip\n    7. edit a recip\n    8. remove recip ";
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
    String st = input.nextLine();
    do {
      st = input.nextLine();
    } while (st.equals(""));
    return st;
  }
}

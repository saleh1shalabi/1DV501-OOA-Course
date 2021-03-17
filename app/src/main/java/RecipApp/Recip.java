package RecipApp;

import java.util.ArrayList;

public class Recip {

  private String name;
  private ArrayList<Ingredient> ingredients;
  private ArrayList<Double> meny;
  private ArrayList<String> comments;
  private UiConsoleSc ui = new UiConsoleSc();
  private ArrayList<String> wayToMake;
  private ArrayList<ArrayList<?>> recipt;
  private int portions;

  public Recip(String name) {
    this.name = name;
    ingredients = new ArrayList<>();
    meny = new ArrayList<>();
    comments = new ArrayList<>();
    recipt = new ArrayList<>();
    wayToMake = new ArrayList<>();

  }

  public void makeWayFromFile(String steg) {
    wayToMake.add(steg);
  }

  public void portionSetter(int portions) {
    this.portions = portions;
  }

  public int getPortions() {
    return portions;
  }

  public void makingWay() {
    do {
      System.out.println("The Steps!\n");
      System.out.println(viewWayMake());
      System.out.println("\n\nNew Step To Do When Doing Recip?  (N) When Finish");
      wayToMake.add(ui.stringGetter());
      System.out.println("New Step Have Been Added!");
    } while (!(ui.stringGetter().equalsIgnoreCase("n")));
  }

  public void addIngredient(ArrayList<Ingredient> ingredientz) {
    System.out.println("ADD new ingredient!");
    String more = "";

    while (!(more.equalsIgnoreCase("n"))) {

      int x = 0;
      for (Ingredient c : ingredientz) {
        x++;
        System.out.print(x + ". " + c.getName());
        System.out.println();
      }
      System.out.println("\n\n");

      int theIngredient = ui.compare(ingredientsSize());

      System.out.println("How Much?");
      double much = ui.doubleGetter();

      System.out.println("What Reason");
      String reason = ui.stringGetter();

      comments.add(reason);
      meny.add(much);
      ingredients.add(ingredientz.get(theIngredient));

      recipt.add(ingredients);
      recipt.add(meny);
      recipt.add(comments);

      System.out.println("ADD new ingredient! (N for No)");
      more = ui.stringGetter();
    }
  }

  public String getName() {
    return name;
  }

  public String getIngredients() {
    int y = 1;
    StringBuilder x = new StringBuilder();
    for (int c = 0; c < ingredients.size(); c++) {
      x.append(y);
      x.append(". " + ingredients.get(c).getName() + " : " + meny.get(c) + " (" + ingredients.get(c).getUnit() + ")"
          + " : " + "(Reason) " + comments.get(c) + "\n");
      y++;
    }
    return x.toString();
  }

  public int getPrice() {
    int x = 0;
    for (Ingredient c : ingredients) {
      x += c.getPrice();
    }
    return x;
  }

  public String writeRecip() {
    StringBuilder x = new StringBuilder();
    for (int c = 0; c < ingredients.size(); c++) {
      x.append(ingredients.get(c).getName() + " : " + meny.get(c) + " : " + comments.get(c) + "||");
    }
    x.append(",");
    for (String step : wayToMake) {
      x.append(step + "||");
    }
    x.append(",");
    x.append(getPortions());
    return x.toString();
  }

  public String viewWayMake() {
    int y = 1;
    StringBuilder x = new StringBuilder();
    for (String c : wayToMake) {
      x.append(y + ". ");
      x.append(c + "\n");
      y++;
    }
    return x.toString();
  }

  public void editName() {
    System.out.println("What is the new name of the recip " + getName());
    String newName = ui.stringGetter();
    name = newName;

  }

  public void editIngredientAmount(int index) {
    meny.set(index, ui.doubleGetter());

  }

  public void editIngredientComment(int index) {
    comments.set(index, ui.stringGetter());

  }

  public void removeIngredientFromRecip(int index) {
    System.out.println("Are you sure (y)");
    if (ui.stringGetter().equalsIgnoreCase("y")) {
      ingredients.remove(index);
      meny.remove(index);
      comments.remove(index);
    } else {
      System.out.println("Opretion Aborted");
    }
  }

  public int ingredientsSize() {
    return ingredients.size();
  }

  public void AddStepAtPlace() {
    System.out.println("\nWhere Should It Be Added:\n");
    System.out.println(viewWayMake());
    int place = ui.compare(wayToMake.size());

    System.out.println("What Is The New Step:\n");
    wayToMake.add(place, ui.stringGetter());

  }

  public void removeStep() {
    System.out.println("\nWhere Should It Be Removed:\n");
    System.out.println(viewWayMake());

    int place = ui.compare(wayToMake.size());

    System.out.println("Are you sure (y)");
    if (ui.stringGetter().equalsIgnoreCase("y")) {
      wayToMake.remove(place);
    } else {
      System.out.println("Opretion Aborted");
    }
  }

  public void editStep() {
    System.out.println("\nWhere Should It Be Edited:\n");
    System.out.println(viewWayMake());
    int place = ui.compare(wayToMake.size());

    System.out.println("What Is The New Step:\n");
    wayToMake.set(place, ui.stringGetter());

  }

  public boolean haveIngredient(String ingr) {

    for (Ingredient ingredient : ingredients) {
      if (ingredient.getName().equals(ingr)) {
        return true;
      }
    }
    return false;
  }

  public void addIngredientFromFile(Ingredient ingr, double much, String reason) {
    comments.add(reason);
    meny.add(much);
    ingredients.add(ingr);

    recipt.add(ingredients);
    recipt.add(meny);
    recipt.add(comments);
  }
}
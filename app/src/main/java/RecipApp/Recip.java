package RecipApp;

import java.util.ArrayList;
// import java.util.Scanner;

public class Recip {

  private String name;
  private TheApp a = new TheApp();
  private ArrayList<Ingredient> ingredients;
  private ArrayList<Double> meny;
  private ArrayList<String> comments;
  private UiConsoleSc ui = new UiConsoleSc();
  private ArrayList<String> wayToMake;

  // private Scanner input;
  private ArrayList<ArrayList<?>> recipt;

  public Recip(String name) {
    this.name = name;
    ingredients = new ArrayList<>();
    meny = new ArrayList<>();
    comments = new ArrayList<>();
    recipt = new ArrayList<>();
    wayToMake = new ArrayList<>();

  }

  public void makingWay() {
    do {
      wayToMake.add(ui.stringGetter());
    } while (!(ui.stringGetter().equals("n") || ui.stringGetter().equals("N")));

  }

  public void addIngredient(Ingredient ingredient, double much, String reason) {
    addComment(reason);
    addMuchOfIng(much);
    ingredients.add(ingredient);
    recipt.add(ingredients);
    recipt.add(meny);
    recipt.add(comments);
  }

  public void addMuchOfIng(double mush) {
    meny.add(mush);
  }

  public void addComment(String reason) {
    comments.add(reason);
  }

  public String getName() {
    return name;
  }

  public String getIngredients() {
    String x = "";

    for (Ingredient c : ingredients) {
      x += c.getName() + " ";
    }
    return x;
  }

  public int getPrice() {
    int x = 0;
    for (Ingredient c : ingredients) {
      x += c.getPrice();
    }
    return x;
  }

  public String viewRecip() {
    String x = "";
    for (int c = 0; c < ingredients.size(); c++) {
      x += (ingredients.get(c).getName() + " : " + meny.get(c) + " : " + comments.get(c) + "\n");
    }
    for (String c : wayToMake) {
      x += c + "\n";
    }
    return x;
  }

  public String recipToWrite() {
    String x = "";
    for (int c = 0; c < ingredients.size(); c++) {
      x += (ingredients.get(c).getName() + ":" + meny.get(c) + ":" + comments.get(c) + "||");
    }
    if (wayToMake.isEmpty() == false) {
      x += ",";
      for (String c : wayToMake) {
        x += c + "||";
      }
    }
    return x;
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

  public void removeIngredient(int index) {
    ingredients.remove(index);
    meny.remove(index);
    comments.remove(index);

  }
}
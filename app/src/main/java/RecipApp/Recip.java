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
    StringBuilder x = new StringBuilder();

    for (Ingredient c : ingredients) {
      x.append(c.getName() + " ");
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

  public String viewRecip() {
    StringBuilder x = new StringBuilder();
    for (int c = 0; c < ingredients.size(); c++) {
      x.append(ingredients.get(c).getName() + " : " + meny.get(c) + " : " + comments.get(c) + "||");
    }
    return x.toString();
  }

  public String viewWayMake() {
    StringBuilder x = new StringBuilder();
    for (String c : wayToMake) {
      x.append(c + "||");
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

  public void removeIngredient(int index) {
    ingredients.remove(index);
    meny.remove(index);
    comments.remove(index);
  }
}
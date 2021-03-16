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

  public void makeWayFromFile(String steg) {
    wayToMake.add(steg);
  }

  public void makingWay() {
    System.out.println("How it's Done ?");
    do {
      System.out.println("(N) When Finish");
      wayToMake.add(ui.stringGetter());
    } while (!(ui.stringGetter().equalsIgnoreCase("n")));

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
    int y = 1;
    StringBuilder x = new StringBuilder();

    for (int c = 0; c < ingredients.size(); c++) {
      x.append(y);
      x.append(". " + ingredients.get(c).getName() + " : " + meny.get(c) + " : " + comments.get(c) + "\n");
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

  public void editMakingWay() {
    System.out.println("Here it works");
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
}
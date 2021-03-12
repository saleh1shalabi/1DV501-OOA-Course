package RecipApp;

import java.util.ArrayList;
// import java.util.Scanner;

public class Recip {

  private String name;
  private ArrayList<Ingredient> ingredients;
  private ArrayList<Integer> meny;
  private ArrayList<String> comments;


  // private Scanner input;
  private ArrayList<ArrayList<?>> recipt;

  public Recip(String name) {
    this.name = name;
    ingredients = new ArrayList<>();
    meny = new ArrayList<>();
    comments = new ArrayList<>();
    recipt = new ArrayList<>();
  }

  public void addIngredient(Ingredient ingredient, int much, String reason) {
    addComment(reason);
    addMuchOfIng(much);
    ingredients.add(ingredient);
    recipt.add(ingredients);
    recipt.add(meny);
    recipt.add(comments);
  }
  
  protected void addMuchOfIng(int mush) {
    meny.add(mush);
  }
  
  protected void addComment(String reason) {
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
    for (int c = 0; c < ingredients.size(); c++){
      x += (ingredients.get(c).getName() + " : " + meny.get(c) + " : " + comments.get(c) + "\n");
    }
    return x;
  }

  
}


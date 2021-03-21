package recipapp;

import java.util.ArrayList;

public class Recip {

  private String name;
  private ArrayList<Ingredient> ingredients;
  private ArrayList<Double> many;
  private ArrayList<String> comments;
  private UiConsoleSc ui = new UiConsoleSc();
  private ArrayList<String> wayToMake;
  private ArrayList<ArrayList<?>> recipt;
  private int portions;
  private String label; 

  /**
   * Recip Object.
   */
  public Recip(String name) {
    this.name = name;
    ingredients = new ArrayList<>();
    many = new ArrayList<>();
    comments = new ArrayList<>();
    recipt = new ArrayList<>();
    wayToMake = new ArrayList<>();

  }

  public void labelSetter() {
    label = ui.chooseRecipLabel();
  }

  public void setLabelFromFile(String label) {
    this.label = label;
  }

  public String labelGetter() {
    return label;
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

  /**
   * the method called when the recipe is done
   * and making way is asked.
   */
  public void makingWay() {
    String step = "";
    while (!(step.equalsIgnoreCase("n"))) {
      System.out.println("\nThe Steps!\n");
      System.out.println(viewWayMake());
      System.out.println("\n\nNew Step To Do When Doing Recip?  (N) When Finish");
      step = ui.stringGetter();
      switch (step) {
        case "N":
          break;
        case "n":
          break;
        default:
          wayToMake.add(step);
          System.out.println("New Step Have Been Added!");
      } 
    }
  }

  /**
   * adds ingredient to the recipe from the user.
   */
  public void addIngredient(ArrayList<Ingredient> ingredientz) {
    System.out.println("Add new ingredient!");
    String more = "";
    while (!(more.equalsIgnoreCase("n"))) {
      int x = 0;
      for (Ingredient c : ingredientz) {
        x++;
        System.out.print(x + ". " + c.getName());
        System.out.println();
      }
      System.out.println("\n\n");

      final int theIngredient = ui.compare(ingredientz.size());

      System.out.println("How Much?");
      double much = ui.doubleGetter();
      while (much <= 0) {
        ui.wronger();
        much = ui.doubleGetter();
      }

      System.out.println("What Reason");
      String reason = ui.stringGetter();

      comments.add(reason);
      many.add(much);
      ingredients.add(ingredientz.get(theIngredient));

      recipt.add(ingredients);
      recipt.add(many);
      recipt.add(comments);

      System.out.println("Add new ingredient! (N for No)");
      more = ui.stringGetter();
    }
  }

  public String getName() {
    return name;
  }

  /**
   * gets the ingredients with the the amount
   * and reason as string.
   */
  public String getIngredients() {
    int y = 1;
    StringBuilder x = new StringBuilder();
    for (int c = 0; c < ingredients.size(); c++) {
      x.append(y);
      x.append(". " + ingredients.get(c).getName() + " : " + many.get(c) 
          + " (" + ingredients.get(c).getUnit() + ")"
          + " : " + "(Reason) " + comments.get(c) + "\n");
      y++;
    }
    return x.toString();
  }

  /**
   * get the the price of the recipe.
   */
  public int getPrice() {
    int x = 0;
    for (int c = 0; c < ingredients.size(); c++) {
      x += ingredients.get(c).getPrice() * many.get(c);
    }
    return x;
  }

  /**
   * the method called only from FileManager class
   * to write the recipe to the file.
   */
  public String writeRecip() {
    StringBuilder x = new StringBuilder();
    for (int c = 0; c < ingredients.size(); c++) {
      x.append(ingredients.get(c).getName().substring(0,1).toUpperCase() 
          + ingredients.get(c).getName().substring(1) 
          + " : " + many.get(c) + " : " 
          + comments.get(c).substring(0,1).toUpperCase() + comments.get(c).substring(1) + "||");
    }
    x.append(",");
    for (String step : wayToMake) {
      step = step.substring(0,1).toUpperCase() + step.substring(1);
      x.append(step + "||");
    }
    x.append(",");
    x.append(getPortions());
    return x.toString();
  }

  /**
   * get the steps to make as string.
   */
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
  
  /**
   * edits the recipe name.
   */
  public void editName() {
    System.out.println("What is the new name of the recipe " + getName());
    String newName = ui.stringGetter();
    name = newName;

  }
  
  public void editIngredientAmount(int index) {
    many.set(index, ui.doubleGetter());

  }

  public void editIngredientComment(int index) {
    comments.set(index, ui.stringGetter());

  }

  /**
   * remove an ingredietn from the recipe.
   */
  public void removeIngredientFromRecip(int index) {
    System.out.println("Are you sure (y)");
    if (ui.stringGetter().equalsIgnoreCase("y")) {
      ingredients.remove(index);
      many.remove(index);
      comments.remove(index);
    } else {
      System.out.println("Opretion Aborted");
    }
  }

  public int ingredientsSize() {
    return ingredients.size();
  }

  /**
   * Adds step to the specifid place.
   */ 
  public void addStepAtPlace() {
    if (!(wayToMake.isEmpty())) {
      System.out.println("\nWhere Should It Be Added:\n");
      System.out.println(viewWayMake());
      int place = ui.compare(wayToMake.size());

      System.out.println("What Is The New Step:\n");
      wayToMake.add(place, ui.stringGetter());
    } else {
      makingWay();
    }
  }

  /**
   * removes a step from the recipe.
   */
  public void removeStep() {
    if (!(wayToMake.isEmpty())) {
      System.out.println("\nWhere Should It Be Removed:\n");
      System.out.println(viewWayMake());

      int place = ui.compare(wayToMake.size());

      System.out.println("Are you sure (y)");
      if (ui.stringGetter().equalsIgnoreCase("y")) {
        wayToMake.remove(place);
      } else {
        System.out.println("Opretion Aborted");
      }
    } else {
      System.out.println("There Is no Steps to Remove!");
    }
  }

  /**
   * changes a step in the making way from the recipe.
   */
  public void editStep() {
    if (!(wayToMake.isEmpty())) {
      System.out.println("\nWhere Should It Be Edited:\n");
      System.out.println(viewWayMake());
      int place = ui.compare(wayToMake.size());

      System.out.println("What Is The New Step:\n");
      wayToMake.set(place, ui.stringGetter());
    } else {
      System.out.println("There Is No Steps To Change!");
    }
  }

  /**
   * checks if an ingredient is in this recipe.
   */
  public boolean haveIngredient(Ingredient ingr) {

    for (Ingredient ingredient : ingredients) {
      if (ingredient.equals(ingr)) {
        return true;
      }
    }
    return false;
  }

  /**
   * called from class FileManagar to add ingredietns from file.
   */
  public void addIngredientFromFile(Ingredient ingr, double much, String reason) {
    comments.add(reason);
    many.add(much);
    ingredients.add(ingr);

    recipt.add(ingredients);
    recipt.add(many);
    recipt.add(comments);
  }

  /**
   * called when a recipe with speciell amount of portions is asked.
   */
  public void speciealPortionGetter(int port) {
    ArrayList<Double> ny = new ArrayList<>();
    for (double nr : many) {
      ny.add(nr / getPortions());
    }
    int y = 1;
    StringBuilder x = new StringBuilder();

    for (int c = 0; c < ingredients.size(); c++) {
      x.append(y);
      x.append(". " + ingredients.get(c).getName() + " : " + Math.round(ny.get(c) * port)
          + " (" + ingredients.get(c).getUnit() + ")"
          + " : " + "(Reason) " + comments.get(c) + "\n");
      y++;
    }
    System.out.println(x.toString());
    int prise = 0;
    for (int c = 0; c < ingredients.size(); c++) {
      prise += ingredients.get(c).getPrice() * (ny.get(c) * port);
    }
    System.out.println("\nLabel:" + labelGetter() + "\n\nPrice (" + prise + ")\n" 
        + "\nSteps:\n" + viewWayMake());
  }
}
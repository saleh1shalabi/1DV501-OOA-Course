package recipapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileManager {

  private final String pathToIngredients = "./app/files/ingredients.csv";
  private final String pathToRecips = "./app/files/recips.csv";
  private ArrayList<Ingredient> ingredients = new ArrayList<>();
  private ArrayList<String> recips = new ArrayList<>();

  /**
   * the method that reads the ingrdeients file
   * return the ingredients as arrylist of strings.
   */
  private ArrayList<ArrayList<String>> ingredientReader() {

    try {
      BufferedReader ingReader = new BufferedReader(new FileReader(pathToIngredients));
      String line;
      ArrayList<ArrayList<String>> ingridientz = new ArrayList<>();
      while ((line = ingReader.readLine()) != null) {
        ArrayList<String> oneIngredient = new ArrayList<>();
        for (String c : line.split(",")) {
          oneIngredient.add(c);
        }
        ingridientz.add(new ArrayList<>(oneIngredient));
        oneIngredient.clear();
      }
      ingReader.close();
      return ingridientz;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * the method that adds the ingrdietns into the app.
   */
  public ArrayList<Ingredient> ingredientAdder() {

    ArrayList<ArrayList<String>> ingr = new ArrayList<>(ingredientReader());
    for (ArrayList<String> ings : ingr) {
      Ingredient ing = (new Ingredient(ings.get(0), ings.get(1), 
          Double.parseDouble(ings.get(2)), ings.get(3)));
      ingredients.add(ing);
    }
    return ingredients;
  }

  /**
   * the method that writes the ingrdeients into the file.
   */
  public void ingredientWriter(ArrayList<Ingredient> ingredients) {

    try {
      FileWriter ingWriter = new FileWriter(pathToIngredients);
      for (Ingredient ingredient : ingredients) {
        ingWriter.append(ingredient.getName().substring(0,1).toUpperCase() 
            + ingredient.getName().substring(1) + "," 
            + ingredient.getUnit().substring(0,1).toUpperCase() 
            + ingredient.getUnit().substring(1)  
            + "," + ingredient.getPrice() + ","
            + ingredient.getLable() + "\n");
      }
      ingWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * the method that reads the recip file
   * return the ingredients as arrylist of strings.
   */
  private ArrayList<String> recipReader() {
    try {
      BufferedReader recipReader = new BufferedReader(new FileReader(pathToRecips));
      String line;
      while ((line = recipReader.readLine()) != null) {
        recips.add(line);
      }
      recipReader.close();
      return recips;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * the method that writes the recips into the file.
   */
  public void recipWriter(ArrayList<Recip> recips) {
    try {
      FileWriter recipWriter = new FileWriter(pathToRecips);
      for (Recip recip : recips) {
        recipWriter.append(recip.getName() + "," + recip.writeRecip() 
            + "," + recip.lableGetter() + "\n");
      }
      recipWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * the method that creates the recips.
   */
  public ArrayList<Recip> recipAdder() {
    ArrayList<Recip> recips = new ArrayList<>();
    for (String recp : recipReader()) {
      String[] rec = recp.split(",");

      String name = rec[0];
      Recip recip = new Recip(name);

      String ingrediens = rec[1].replace("||", ",");
      String[] ingrediensFromRecip = ingrediens.split(",");

      String makeWay = rec[2].replace("||", ",");
      String[] makeWayList = makeWay.split(",");

      String numberPortions = rec[3];

      final String lable = rec[4].substring(0,1).toUpperCase() + rec[4].substring(1);

      for (String ing : ingrediensFromRecip) {
        String thisOne = ing.replace(":", ",");
        String[] theOtherOne = thisOne.split(",");
        String theIngredient = theOtherOne[0].replace(" ", "");
        theIngredient = theIngredient.substring(0,1).toUpperCase() + theIngredient.substring(1);

        for (Ingredient ingr : ingredients) {          
          if (theIngredient.equals(ingr.getName())) {
            while (theOtherOne[2].startsWith(" ")) {
              theOtherOne[2] = theOtherOne[2].substring(1, theOtherOne[2].length());
            }
            recip.addIngredientFromFile(ingr, Double.parseDouble(theOtherOne[1].replace(" ", "")),
                  theOtherOne[2]);
            break;
          }
        }
      }
      for (String steg : makeWayList) {
        while (steg.startsWith(" ")) {
          steg = steg.substring(1, steg.length());
        }
        if (!(steg.isEmpty())) {
          recip.makeWayFromFile(steg);
        }
      }
      recip.portionSetter(Integer.parseInt(numberPortions));
      recip.setLableFromFile(lable);
      recips.add(recip);
    }
    return recips;
  }
}

package recipapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * the class that handels readin and writing from.
 */
public class FileManager {

  private String pathToIngredients = "./files/ingredients.csv";
  private String pathToRecips = "./files/recips.csv";
  private ArrayList<Ingredient> ingredients = new ArrayList<>();
  private ArrayList<String> recips = new ArrayList<>();

  /**
   * the method that reads the ingrdeients file
   * return the ingredients as arrylist of strings.
   */
  private ArrayList<ArrayList<String>> ingredientReader() {

    try (InputStream st = new FileInputStream(pathToIngredients)) {
      Reader read = new InputStreamReader(st, StandardCharsets.UTF_8);
      BufferedReader ingReader = new BufferedReader(read);
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
          Integer.parseInt(ings.get(2)), ings.get(3)));
      ingredients.add(ing);
    }
    return ingredients;
  }

  /**
   * the method that writes the ingrdeients into the file.
   */
  public void ingredientWriter(ArrayList<Ingredient> ingredients) {
    FileWriter ingWriter = null;
    try {
      ingWriter = new FileWriter(pathToIngredients, StandardCharsets.UTF_8);
      for (Ingredient ingredient : ingredients) {
        ingWriter.append(ingredient.getName().substring(0, 1).toUpperCase() 
            + ingredient.getName().substring(1) + "," 
            + ingredient.getUnit().substring(0, 1).toUpperCase() 
            + ingredient.getUnit().substring(1)  
            + "," + ingredient.getPrice() + ","
            + ingredient.getLabel() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally { 
      // hole this block of code is becuse the check style and findBugs 
      if (ingWriter != null) {
        try {
          ingWriter.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          ingWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * the method that reads the recip file
   * return the ingredients as arrylist of strings.
   */
  private ArrayList<String> recipReader() {
    try (InputStream st = new FileInputStream(pathToRecips)) {
      Reader read = new InputStreamReader(st, StandardCharsets.UTF_8);
      BufferedReader recipReader = new BufferedReader(read);
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
    FileWriter recipWriter = null;
    try {
      recipWriter = new FileWriter(pathToRecips, StandardCharsets.UTF_8);
      for (Recip recip : recips) {
        recipWriter.append(recip.getName() + "," + recip.writeRecip() 
            + "," + recip.labelGetter() 
            + "," + recip.gradeGetter() + "\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally { 
      // hole this block of code is becuse the check style and findBugs 
      if (recipWriter != null) {
        try {
          recipWriter.flush();
        } catch (IOException e) {
          e.printStackTrace();
        }
        try {
          recipWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
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

      final String label = rec[4].substring(0, 1).toUpperCase() + rec[4].substring(1);

      for (String ing : ingrediensFromRecip) {
        String thisOne = ing.replace(":", ",");
        String[] theOtherOne = thisOne.split(",");
        String theIngredient = theOtherOne[0].replace(" ", "");
        theIngredient = theIngredient.substring(0, 1).toUpperCase() + theIngredient.substring(1);

        for (Ingredient ingr : ingredients) {          
          if (theIngredient.equals(ingr.getName())) {
            while (theOtherOne[2].startsWith(" ")) {
              theOtherOne[2] = theOtherOne[2].substring(1, theOtherOne[2].length());
            }
            double many = Math.round(Double.parseDouble(theOtherOne[1].replace(" ", "")) 
                * 10.0) / 10.0;
            recip.addIngredientFromFile(ingr, many, theOtherOne[2]);
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
      int grade = Integer.parseInt(rec[5]);

      recip.portionSetter(Integer.parseInt(numberPortions));
      recip.setLabelFromFile(label);
      recip.gradeSetter(grade);
      recips.add(recip);
    }
    return recips;
  }
}

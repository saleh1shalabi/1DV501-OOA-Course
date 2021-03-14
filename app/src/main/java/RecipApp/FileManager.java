package RecipApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileManager {

  private String pathToIngredients = "./app/files/ingredientsFile.csv";
  private String pathToRecips = "./app/files/recipView.csv";

  public ArrayList<ArrayList<String>> ingredientReader() {

    try {

      BufferedReader ingReader = new BufferedReader(new FileReader(pathToIngredients));
      String line;
      ArrayList<ArrayList<String>> saker = new ArrayList<>();

      while ((line = ingReader.readLine()) != null) {
        String[] s = line.split(",");
        ArrayList<String> x = new ArrayList<>();
        for (String c : s) {
          x.add(c);
        }
        saker.add(x);
      }
      ingReader.close();
      return saker;

    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public ArrayList<String> recipReader() {
    try {
      BufferedReader recipReader = new BufferedReader(new FileReader(pathToRecips));
      String line;
      ArrayList<String> recips = new ArrayList<>();
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

  public void ingredientWriter(ArrayList<Ingredient> ingredients) {
    try {
      FileWriter ingWriter = new FileWriter("./app/files/ingredientsFile.csv");
      for (Ingredient ingredient : ingredients) {
        ingWriter.append(ingredient.getName() + "," + ingredient.getUnit() + "," + ingredient.getPrice() + "\n");
      }
      ingWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void recipWriter(ArrayList<Recip> recips) {
    try {
      FileWriter recipWriter = new FileWriter("./app/files/recipView.csv");
      for (Recip recip : recips) {
        recipWriter.append(recip.getName() + "," + recip.viewRecip() + "," + recip.viewWayMake() + "\n");
      }
      recipWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

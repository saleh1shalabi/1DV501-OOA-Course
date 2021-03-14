package RecipApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileManager {

  private String pathToIngredients = "./app/files/ingredientsFile.csv";
  private String pathToRecips = "./app/files/recipView.csv";

  public ArrayList<ArrayList> ingredientReader() {

    try {

      BufferedReader ingReader = new BufferedReader(new FileReader(pathToIngredients));
      ingReader.readLine();
      String line;
      ArrayList<ArrayList> saker = new ArrayList<>();

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
      return recips;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void writer(ArrayList<Recip> recips) {
    try {
      FileWriter ingWriter = new FileWriter("./app/files/recipView.csv");
      for (Recip recip : recips) {

        ingWriter.append(recip.getName() + "," + recip.recipToWrite() + "\n");
      }
      ingWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

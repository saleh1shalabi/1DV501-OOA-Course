package RecipApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

public class FileManager {

  private String pathToIngredients = "/home/saleh/Skrivbord/java/assignment-4/app/files/ingredientsFile.csv";
  // private String pathToRecips = "";

  public ArrayList<ArrayList> reader() {

    try {

      // BufferedReader RecipReader = new BufferedReader(new
      // FileReader(pathToRecips));
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

}

package recipapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {

  @Test
  public void createsIngredient() {
    Ingredient ing = new Ingredient("null", "null", 0, "null");
    assertNotNull("app gets name of  Ingredients", ing.getName());
  }

  @Test
  public void createsRecip() {
    Recip recip = new Recip("null");
    assertNotNull("app gets name of  Recip", recip.getName());
  }

  @Test
  public void checkIngredientInRecipe() {
    Recip recip = new Recip("null");
    Ingredient ing = new Ingredient("name", "unit", 0, "label");
    assertEquals("Recipe dont have the Ingredient",recip.haveIngredient(ing), false);
    recip.addIngredientFromFile(ing, 0, "reason");
    assertEquals("Recipe have the Ingredient",recip.haveIngredient(ing), true);
  }
}
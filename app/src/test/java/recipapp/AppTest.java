package recipapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {
  @Test
  public void testAppCreatesIngredient() {
    Ingredient classUnderTest = new Ingredient("null", "null", 0, "null");
    assertNotNull("app gets name of  Ingredients", classUnderTest.getName());

  }
}

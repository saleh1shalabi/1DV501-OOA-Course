package recipapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AppTest {

  @Test
  public void createsIngredient() {
    Ingredient classUnderTest = new Ingredient("null", "null", 0, "null");
    assertNotNull("app gets name of  Ingredients", classUnderTest.getName());

  }

  @Test
  public void createsRecip() {
    Recip classUnderTest = new Recip("null");
    assertNotNull("app gets name of  Recip", classUnderTest.getName());

  }

}
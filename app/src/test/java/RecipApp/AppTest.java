package RecipApp;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAppCreatesIngredient() {
        Ingredient classUnderTest = new Ingredient("null", "null", 0);
        assertNotNull("app gets name of  Ingredients", classUnderTest.getName());

    }

}
    q
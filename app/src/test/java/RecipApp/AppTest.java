package RecipApp;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAppHasAGreeting() {
        Ingredient classUnderTest = new Ingredient("null", "null", 0);
        assertNotNull("app gets name of  Ingredients", classUnderTest.getName());

    }

}

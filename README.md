# Recip App

The code should work porply for all the tasks for passing grade, even for much of the higher grade. the only thing that i didnt hade the time to implement is the point 6 from higher grade requirement (*Advanced recipee search where several search expressions can be combined e.g. (tomatoes && ham) || mozzarella. The design should use the composite pattern.*). I have instead others **`SearchBehaivour`**.

In this program the user is able to add a *double* amount of an ingredient to a recipe. the user is able to insert a number of the type double, and it will be automaticly rounded to a one decimal using the method `doubleGetter` in the **`UiConsole`** class

```java
public double doubleGetter() {
  while (true) {
    try {
      double nr = Double.parseDouble(input.nextLine());
      // clears the console 
      System.out.print("\033[H\033[2J");
      System.out.flush();
      // round to only 1 decimal 
      double te = Math.round(nr * 10.0) / 10.0;
      // check if the value is 0
      while (te == 0) {
        System.out.println("you can not add så smal number");
        nr = Double.parseDouble(input.nextLine());
        te = Math.round(nr * 10.0) / 10.0;
      }
      return te;
    } catch (Exception e) {
      wronger();
    }
  }
}
```
This will effect things such let say that you have an Ingredient name: rice, Unit: Kg
and the user adds 0.02Kg (20 g) rice to a rceip this will be rounde to 0.0 then the usesr will be worned to change the namber. It should at least be 0.05 to be rounde upp to 0.1 then it will be accepeted.


In the same way of rounding, when the user asks about a recipe to be showen in another number of portion then that the recipe have, the ingredients amount will be rounded and presented.
Note: let say we have a recipe with 100 portions and we will use 1 sallad for this recipe,
the program will try to devide 1 to 100 and gets 0.01 then it will be rounded wit one deciemal ==> 0.0, if such a case happens the program will try with to show another decimal it will be 0.01 in this case. In case it will be 0.001 the program will add a decimal and so on.  

The user is not able to write what label an ingredient or a recipe should have but can only choose one of hardcoded labels for them.

The user is not able to add an non existing ingredient to a recipe due when ading ingredients to a recipe the user is able to only choose ingredients from the already existing ones.

When adding a new ingredient the user is able to write name, give it a price (the price should be of the type int), choose a label from the hardcoded ones, and add unit for the ingredient. The unit is of the type String and can be what ever the user chooses it to be. 

## User Options

What the user is able to do in this program:

1. Ingredients.
    1. View Ingredients.
        - View all availble Ingredients.
        - Show details about one Ingredient.
    2. Add new Ingredient.
        - It will have a Name (*String*).
        - It will have a Price (*Integer*).
        - It will have a Unit (*String*).
        - It will have a Label (*The user chooses from existing ones*).
    3. Edit An exsiting one.
        1. Edit The Name.
        2. Edit The Price.
        3. Edit the Unit.
        4. Edit The Label.
        - Notes: Chenges will effect the Recipes  
    4. Remove an Ingredient.
        - When removing an Ingredient the user will be asked to confirm.
        - Note: This will automatically remove the Ingredient from all recipees where the Ingrdeient exists.
2. Recips.
    1. View Recipes.
        - View all availble Recipes.
        - Show the details about one Recipe.
        - Show a Recipe with a given number of Portions.
    2. Add Recipe.
        - It will have a Name (*String*).
        - It will have a Number of Portions (*Integer*).
        - It will have a Grade (*Integer between (1 - 10)*).
        - It will have a Label (*The user chooses from existing ones*).
        - It will have Ingredients (*The user chooses from existing ones and adds how many as wishes*).
            - It will have a Comment (*String*).
            - It will have a Amount (*Integer*).
        - It will have Steps to make (*The user adds how many steps as wishes, String[]*).
    3. Edit A Recipe.
        1. Edit The Name.
        2. Ingredients.
            1. Add Ingredient.
            2. Edit an Ingredient Amount.
            3. Edit an Ingredient Comment.
            4. Remove an Ingredient from Recipe.
        3. Edit The Steps to Make.
            1. Add a Step at The End of Steps.
            2. Add a Step at a Specific Place Between The Steps.
            3. Remove a Step.
            4. Edit a Step.
        4. Edit The Label.
        5. Edit The Number of The Portions.
        6. Edit The Grade.
    4. Remove A Recipe.
        - When removing a Recipe the user will be asked to confirm.
3. Search For Recipes.
    1. Search by Price
        - All Recipes with lower than and equals the given Price will be showen.
    2. Search by Ingredients
        - All Recipes that have the chosen Ingredient will be showen
    3. Search by Portion number.
        - All Recipes with the exact number of Portions as the given one will be shown.
    4. Search by Label
        - All Recipes with same Label as the chosen one will be shown.
    5. Search by Grade
        - All Recipes with higher than and equals the given Grade will be showen.

## Automaticity 

The program loads all Ingredients and Recipes from the files. It also saves all changes for each and every Ingredient and Recipes, even it saves the new added Ingredients and Recipes. 

## Improvements
- Starting of with adding Ingredients, The Unit added by the User can be what ever the User choose it to be, I would insted have all possible Units as (g, hg, kg, ml, dl, l, can, pice, .....) in a hardcoded list such as the label and offer the user to choose one of them.

- The main Class **`RecipApp`** is too larg, some changes can shortcut the code would be nice or dividing it to more Classes would make the code much easier to read, understande and improve.

- Automatically Setted Label for Recipes such as { (vegetarian: based on no meat, fish, chicken), (vegan: based all vegan ingredients), (dairy free: based on no dairy), .... }





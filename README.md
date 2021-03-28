# The Task

## The Recipe App
You are to create an application that handles recipes. In essence this is a digital cooking book with recipes that you can add, delete and view via the terminal. All recipes are to be stored on file and read when the program starts (as well as saved when the program is closed). As it is digital, you should be able to do some additional things as compared to a normal book, for instance change the number of portions or list based on ingredient or max price. Below are the requirements for the application.

### Passing Grade Requirements

- Create at least a class diagram for the application before you start implementation, save in intended.md This should be committed to the repo before the implementation is added. I.e. you should show that you have spent some time designing.
- Create and add an ingredient, it should have a name, and a unit of measure (i.e. grams, litre, piece) and a price. The ingredient name is unique. For example; milk:litre:10.5 or, egg:piece:4.
- List all available ingredients.
- Look at the details of a particular ingredient
- Delete a particular ingredients (note that this may effect recipes)
- Add a recipe with a name, number of portions, ingredients, ingredient amounts and comments, and step by step instructions.

note that you may need the same ingredient several times with different purposes in a recipe, you can use the ingredient comment for this. I.e. Butter 100g in batter, Butter 20g for frying.


- List all available recipes
- Look at a particular recipe

- User should be able to define the number of portions needed and the recipe should be updated accordingly. Note that some ingredients cannot be divided, for example eggs, this should be handled by the application rounding to the nearest even divisor above the desired number of portions. The price of the recipe should be calculated.


- Delete a particular recipe
- Search available recipes based on ingredient name, or the max price

- The search should be designed to use the strategy pattern

- Feel free to add more search types, e.g. recipe name etc.


- The application should load all ingredients and recipes from disk when the program i starting. See File Format
- The application should save all ingredients and recipes to disk when the program is ended. See File Format
- The user interface should be console based and offer a menu with possible sub menus of your choice.
At least one automatic test case for one operation.
- Create an updated class diagram showing the final design after implementation, save in design.md

- Good quality of code (for example naming, standards, duplication)
- An object oriented design and implementation. This includes but is not limited to:

    1. Objects are connected using associations/dependencies and not with keys/ids.
    2. Classes have high cohesion and are not too large or have too much responsibility.
    3. Classes have low coupling and are not too connected to other entities.
    4. Avoid the use of static variables and operations as well as global variables.
    5. Avoid hidden dependencies.
    6. Information should be encapsulated.
    7. Use a natural design, the domain model should inspire the design.


- Simple error handling. The application should not crash but it does not need to be user friendly.
- Add a README.md that explains what is working and what is not, and any usability issues we need to know when trying your application.


### Higher Grade Requirements

- Edit an ingredient (note that this may effect recipes)
- Edit a recipe.
- Add labels to ingredients. For example an ingredient could be labelled as vegan or dairy free, a recipe containing all vegan or dairy free ingredients could itself be marked as vegan/dairy free.
- Add labels to recipes. For example a label a recipe as desert.
- Search using labels.
- Advanced recipe search where several search expressions can be combined e.g. (tomatoes && ham) || mozzarella. The design should use the composite pattern.
- Grading of recipes (with search on grade etc).
- Several automatic test cases for different operations and classes.
- Automatic build pipeline using Gradle and GitLab
- Automatic quality tests with checkStyle and findBugs use CodeQualityTests.java from assignment 3
- Create packages according to roles of the classes, that is, do not put everything in one package but separate them based on what they do.


### Ingredient Label Categories

- vegan (vegan ingredient)
- dairy (i.e milk, cheese, etc)
- gluten (contains the protein gluten, i.e. most grains)
- fish (contains fish or seafood)
- meat (contains meat in some form)
- ...


### Recipe Label Categories

- dessert
- dinner
- breakfast
- lunch
- bbq
- vegetarian (auto label based on no meat, fish)
- vegan (auto label all vegan ingredients)
- dairy free (auto label no dairy)


### File Format
It is up to you to define the file format. Try to make it possible to work with using the method split() in String. One way to see it is that you put one recipe per line in the file and separate the parts with semicolon. There might be useful to add lists of thing (the ingredients for example) and try to separate them in another way. Below could be the beginning of an example:

Gingerbread biscuit; 100, pieces; [1, litre, flour; 2, dl, cream; 1, spoon, cinnamon]; *Mix everything, *Wait one day, *Make figures

The above is by no means covering everything and should not be seen as "the solution", but the beginning of it. Also notice that you might need to use two files, one for the recipes and one for ingredients.

Note requirements regarding loading and saving, it is easier to load everything at startup and save everything at program end.
You are free to use any format you like, if you feel adventurous you may use something like JSON or XML (and add suitable libraries), but you then need to provide easy to follow build instructions. Or, preferably use gradle.

=====================================================================================
# The App Report when it was done 
# Recipe App

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





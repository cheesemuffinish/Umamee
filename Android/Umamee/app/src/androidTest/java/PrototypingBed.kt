import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {

    //Test creating and adding foods
    var expirationDate: Date ?= SimpleDateFormat("dd-mm-yyyy").parse("02-12-2019")

    var testRecipe = Recipe()
    var testPantry = Pantry()

    var testPantryFood = Perishable()
    testPantryFood.add(10.5, "pounds")
    testPantryFood.uniqueName = "TestFood"
    testPantryFood.expirationDate = expirationDate

    testPantry.addFood(testPantryFood)

    //Test creating recipe
    testRecipe.uniqueName = "Brandy Baked Peaches"

    var peaches = Perishable()
    peaches.uniqueName = "Peaches"
    peaches.add(3.0, "Items")
    peaches.expirationDate = SimpleDateFormat("dd-mm-yyyy").parse("22-12-2019")

    var butter = Perishable()
    butter.uniqueName = "Butter"
    butter.add(2.0,"cups")
    butter.expirationDate = SimpleDateFormat("dd-mm-yyyy").parse("15-12-2019")

    testPantry.addFood(peaches)

    println(testPantry.pantryList)
    testPantry.removeFood(butter, 2.0,"teaspoons")
    println(testPantry.pantryList)

    testRecipe.addIngredient("Peaches","3")
    testRecipe.addIngredient("Butter","1/4 Cup")
    testRecipe.addIngredient("Sliced Almonds","1 Tbsp")
    testRecipe.addIngredient("Honey","1/4 Cup")
    testRecipe.addIngredient("Brown Sugar","1/4 Cup")
    testRecipe.addIngredient("Ground Cinnamon","1 1/2 tsp")
    testRecipe.addIngredient("Brandy","2 Tbsp")
    testRecipe.addIngredient("Salt","1 Pinch")
    testRecipe.addIngredient("Vanilla Extract","1 tsp")

    testRecipe.addStep("Preheat oven to 350 degrees F (175 degrees C). Prepare a baking dish with cooking spray.")
    testRecipe.addStep("Arrange peaches cut-side up in the prepared baking dish.")

    //Test removing ingredients
    println("\nBefore Remove")
    testRecipe.printIngredients()
    println("\nAfter Remove")
    testRecipe.printIngredients()
    var step: String = testRecipe.instructions.toString()
    println(step)

    //Test Unit Conversions
    val testFood = Food()
    testFood.uniqueName = "PickledNanners"
    testFood.add(4.0,"cups")
    println(testFood.amount)
    testFood.add(3.0, "pounds")
    testFood.remove(200.0, "milliliters")
    println(testFood.amount)
    testFood.remove(4.0, "cups")
    println(testFood.amount)

    //Test Save and Load
    testPantry.save("Test.json")
    testPantry.load("Test.json")
    testPantry.pantryList2.forEach{println(it)}

    println(testPantry.getFood("PickledNanners"))
    testPantry.addFood(testFood)
    println(testPantry.getFood("PickledNanners"))

}
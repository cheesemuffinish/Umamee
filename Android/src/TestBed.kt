import java.time.LocalDate

fun main(args: Array<String>) {

    var expirationDate = LocalDate.parse("2019-12-22")

    var testRecipe = Recipe()
    var testPantry = Pantry()

    testRecipe.shortName = "Brandy Baked Peaches"


    testPantry.addFood("Peaches",Perishable(),3.0,"Items",LocalDate.parse("2019-12-22"))
    testPantry.addFood("Butter",Perishable(),2.0,"Cups",LocalDate.parse("2019-12-15"))

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

    println("\nBefore Remove")
    testRecipe.printIngredients()
    println("\nAfter Remove")
    testRecipe.printIngredients()
    var step: String = testRecipe.instructions.toString()
    println(step)
}
class Recipe {

    init {
    }
    // data members
    var uniqueName: String ?= null
    var ingredientsList =  mutableListOf<Ingredient>()
    var instructions = mutableListOf<String>()
    var keywords = mutableListOf<String>()

    // private data members


    // member functions
    fun addIngredient(uniqueName: String, amount: String){

        //TODO add an ingredient only input, Maybe

        var ingredient = Ingredient()
        ingredient.uniqueName = uniqueName
        ingredient.amount = amount

        ingredientsList.add(ingredient)
    }

    fun deleteIngredient(ingredient: Ingredient){
        if (ingredientsList.contains(ingredient)){
            ingredientsList.remove(ingredient)
        }else{
            val uniqueName = ingredient.uniqueName
            println("$uniqueName is not on the ingredients list of this recipe")
        }
    }

    fun addStep(step: String){
        instructions.add(step)
    }

    fun deleteStep(stepIdx: Int){
        instructions.removeAt(stepIdx)
    }

    fun insertStep(stepIdx: Int, step: String ){
        instructions.add(stepIdx, step)
    }

    fun printIngredients(){
        ingredientsList.forEach{println(it.uniqueName)}
    }


}
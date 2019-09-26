class Recipe {

    init {
    }
    // data members
    var shortName: String ?= null
    var ingredientsList =  mutableListOf<Ingredient>()
    var instructions = mutableListOf<String>()
    var keywords = mutableListOf<String>()

    // private data members


    // member functions
    fun addIngredient(shortName: String, amount: String){

        //TODO add an ingredient only input, Maybe

        var ingredient = Ingredient()
        ingredient.shortName = shortName
        ingredient.amount = amount

        ingredientsList.add(ingredient)
    }

    fun deleteIngredient(ingredient: Ingredient){
        if (ingredientsList.contains(ingredient)){
            ingredientsList.remove(ingredient)
        }else{
            val shortName = ingredient.shortName
            println("$shortName is not on the ingredients list of this recipe")
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
        ingredientsList.forEach{println(it.shortName)}
    }


}
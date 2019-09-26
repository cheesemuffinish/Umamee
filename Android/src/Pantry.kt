import java.time.LocalDate

class Pantry {

    var pantryList = mutableListOf<Food>()

    // member functions
    fun addFood(shortName: String, foodType: Food, amount: Double, units: String, expirationDate: LocalDate){

        var food = foodType
        food.shortName = shortName
        food.expirationDate = expirationDate
        food.amount = amount
        food.units = units

        pantryList.add(food)
    }

    fun removeFood(food: Food, amount: Float, units: String){
        if (pantryList.contains(food)){
            var foodIdx = pantryList.indexOf(food)
            pantryList[foodIdx].decrement(amount, units)
        }else{
            val shortName = food.shortName
            println("$shortName is not in the Pantry")
        }
    }


}
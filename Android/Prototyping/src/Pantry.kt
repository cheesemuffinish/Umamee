import org.json.JSONObject
import java.io.File
import java.time.LocalDate



class Pantry {

    var pantryList = mutableMapOf<String, Food>()

    // member functions
    fun addFood(pantryFood: Food){

        if (pantryFood.uniqueName != null || pantryFood.amount != null || pantryFood.units != null ) {
            if (pantryList.contains(pantryFood.uniqueName)){
                pantryList[pantryFood.uniqueName]!!.add(pantryFood.amount!!, pantryFood.units!!)
            }
            this.pantryList[pantryFood.uniqueName!!] = pantryFood
        }else{
            println("Food could not be added. It requires full initialization.")
        }
    }

    fun removeFood(pantryFood: Food, amount: Double, units: String){

        if (pantryList.contains(pantryFood.uniqueName)){
            pantryList[pantryFood.uniqueName]!!.remove(amount, units)
        }else{
            println("${pantryFood.uniqueName} is not in the Pantry")
        }

    }

    fun getFood(uniqueName: String): Food?{

        if (pantryList.contains(uniqueName)){
            return pantryList[uniqueName]!!
        }else{
            println("That food is not in the pantry.")
        }

        return null
    }

    fun save(filename: String){

        val saveHolder = JSONObject(this.pantryList as Map<*, *>)
        File(filename).writeText(saveHolder.toString())
    }

    fun load(){

    }

}
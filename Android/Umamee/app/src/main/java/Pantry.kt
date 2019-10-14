import java.io.File
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken



class Pantry {

    var pantryList = mutableMapOf<String, Food>()
    var pantryList2 = mutableMapOf<String, Food>()

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

        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonPantry: String = gson.toJson(this.pantryList)
        File(filename).writeText(jsonPantry)

    }

    fun load(filename: String){

        val jsonPantry: String = File(filename).readText()
        val gson = GsonBuilder().setPrettyPrinting().create()
        this.pantryList2 = gson.fromJson(jsonPantry, object : TypeToken<Map<String, Food>>() {}.type)
    }

}
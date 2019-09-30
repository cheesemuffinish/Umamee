import java.time.LocalDate

open class Food {

    var shortName: String ?= null
    var expirationDate: LocalDate ?= null
    var amount: Double ?= null
    var units: String ?= null

    private val massConversionNames = listOf<String>("grams","kilograms", "ounces", "pounds")

    private val massConversionValues = doubleArrayOf(1000.0, 1.0, 35.274, 2.20462)

    private val volumeConversionNames = listOf<String>("teaspoons", "tablespoons", "fluid ounces", "cups",
        "pints", "quarts", "gallons", "milliliters", "liters")

    private val volumeConversionValues = doubleArrayOf(48.0, 16.0, 8.0, 1.0, 0.5, 0.25, 0.0625, 236.588, 0.236588)


    init{
    }

    fun add(amount: Double, unitsGiven: String){
        if (this.units == null){
            this.units = unitsGiven
            this.amount = amount
        }else{
            val amountAdd: Double ?= this?.convertUnits(amount, unitsGiven, this.units!! ) ?:0.0
            this.amount = this.amount!! + amountAdd!!
        }
    }

    fun remove(amount: Double, unitsGiven: String){

        val amountDec =  this?.convertUnits(amount, unitsGiven, this.units!!) ?:0.0

        if (this.amount == null){
            println("This food has not been initialized.")
        }else if (this.amount!! >= amountDec){
            this.amount = this.amount!! - amountDec
        }else{
            this.amount = 0.0
            println("You are audi 5000 of ${this.shortName}")
        }
    }

    fun convertUnits(amountIn: Double, unitsGiven: String, unitsDesired: String): Double? {

        if (massConversionNames.contains(unitsGiven)){
            if (massConversionNames.contains(unitsDesired)){
                val idxG: Int = massConversionNames.indexOf(unitsGiven)
                val idxD: Int = massConversionNames.indexOf(unitsDesired)
                return amountIn.times(massConversionValues[idxD] / (massConversionValues[idxG]))
            }else{
                println("The units given are incompatible with ${this.units}")
            }

        }else if(volumeConversionNames.contains(unitsGiven)){
            if (volumeConversionNames.contains(unitsDesired)) {
                val idxG: Int = volumeConversionNames.indexOf(unitsGiven)
                val idxD: Int = volumeConversionNames.indexOf(unitsDesired)
                return amountIn.times(volumeConversionValues[idxD] / (volumeConversionValues[idxG]))
            }else{
                println("The units given are incompatible with ${this.units}")
            }
        }else{
            println("Units given are not supported.")
        }

        return null
    }

}
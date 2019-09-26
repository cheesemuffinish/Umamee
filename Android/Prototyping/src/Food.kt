import java.time.LocalDate

open class Food {

    var shortName: String ?= null
    var expirationDate: LocalDate ?= null
    var amount: Double ?= null
    var units: String ?= null

    init{
    }

    fun add(amount: Float, units: String){
        //TODO: Add in a unit checker
    }

    fun decrement(amount: Float, units: String){
        //TODO: Add in a unit checker and make sure that it hasn't been decremented below 0.
    }

}
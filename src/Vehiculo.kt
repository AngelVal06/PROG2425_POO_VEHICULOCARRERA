import kotlin.math.roundToInt

const val KM_POR_LITRO = 10f
const val AHORRO_ELECTRICO = 5f
const val KM_POR_LITRO_MOTO = 20f
const val GASTO_DERRAPE = 7.5f
const val GASTO_DERRAPE_HIBRIDO = 6.25f
const val GASTO_CABALLITO = 6.5f

open class Vehiculo(
    val marca: String,
    val modelo: String,
    val capacidadCombustible: Float,
    var combustibleActual: Float = 0f,
    var kilometrosActuales: Float = 0f
) {

    open fun obtenerInformacion(): String {
        return "Marca: $marca, Modelo: $modelo, Combustible actual: ${"%.2f".format(combustibleActual)} L, " +
                "Kilometraje: ${"%.2f".format(kilometrosActuales)} km, Autonomía: ${"%.2f".format(calcularAutonomia())} km"
    }

    open fun calcularAutonomia(): Float {
        return (combustibleActual * KM_POR_LITRO * 100).roundToInt() / 100f
    }

    open fun realizaViaje(distancia: Float): Float {
        val distanciaPosible = calcularAutonomia()
        if (distanciaPosible >= distancia) {
            combustibleActual -= distancia / KM_POR_LITRO
            kilometrosActuales += distancia
            return 0f
        } else {
            combustibleActual = 0f
            kilometrosActuales += distanciaPosible
            return distancia - distanciaPosible
        }
    }

    open fun repostar(cantidad: Float): Float {
        val combustibleNecesario = capacidadCombustible - combustibleActual
        val repostado = if (cantidad <= 0 || cantidad > combustibleNecesario) combustibleNecesario else cantidad
        combustibleActual += repostado
        return repostado
    }
}
import kotlin.math.roundToInt

class Motocicleta(
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float = 0f,
    kilometrosActuales: Float = 0f,
    val cilindrada: Int
) : Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    init {
        require(cilindrada in 125..1000) { "La cilindrada debe estar entre 125 y 1000 cc." }
    }

    override fun calcularAutonomia(): Float {
        val factorCilindrada = if (cilindrada == 1000) 1f else 1f - (cilindrada / 1000f)
        return (combustibleActual * KM_POR_LITRO_MOTO * factorCilindrada * 100).roundToInt() / 100f
    }

    override fun realizaViaje(distancia: Float): Float {
        val distanciaPosible = calcularAutonomia()
        if (distanciaPosible >= distancia) {
            combustibleActual -= distancia / KM_POR_LITRO_MOTO
            kilometrosActuales += distancia
            return 0f
        } else {
            combustibleActual = 0f
            kilometrosActuales += distanciaPosible
            return distancia - distanciaPosible
        }
    }

    fun realizaCaballito(): Float {
        combustibleActual -= GASTO_CABALLITO / KM_POR_LITRO_MOTO
        return combustibleActual
    }
}
class Automovil(
    marca: String,
    modelo: String,
    capacidadCombustible: Float,
    combustibleActual: Float = 0f,
    kilometrosActuales: Float = 0f,
    val esHibrido: Boolean
) : Vehiculo(marca, modelo, capacidadCombustible, combustibleActual, kilometrosActuales) {

    companion object {
        var condicionBritanica: Boolean = false
        const val GASTO_DERRAPE_HIBRIDO = 6.25f
        const val AHORRO_ELECTRICO = 5f
        const val GASTO_DERRAPE = 7.5f

    }

    fun cambiarCondicionBritanica(nuevaCondicion: Boolean) {
        condicionBritanica = nuevaCondicion
    }

    override fun calcularAutonomia(): Float {
        val autonomiaBase = super.calcularAutonomia()
        return if (esHibrido) autonomiaBase + (AHORRO_ELECTRICO * combustibleActual) else autonomiaBase
    }

    fun realizaDerrape(): Float {
        val gasto = if (esHibrido) GASTO_DERRAPE_HIBRIDO else GASTO_DERRAPE
        combustibleActual -= gasto / KM_POR_LITRO
        return combustibleActual
    }
}
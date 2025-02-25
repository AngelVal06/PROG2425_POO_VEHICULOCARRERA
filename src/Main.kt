fun main() {
    val auto = Automovil("Toyota", "Corolla", 50f, esHibrido = true)
    auto.repostar(50f)
    println(auto.obtenerInformacion())
    println("Autonomía después de repostar: ${auto.calcularAutonomia()} km")
    auto.realizaViaje(100f)
    println(auto.obtenerInformacion())
    auto.realizaDerrape()
    println("Combustible después del derrape: ${"%.2f".format(auto.combustibleActual)} L")

    val moto = Motocicleta("Honda", "CBR", 15f, cilindrada = 500)
    moto.repostar(15f)
    println(moto.obtenerInformacion())
    println("Autonomía después de repostar: ${moto.calcularAutonomia()} km")
    moto.realizaViaje(50f)
    println(moto.obtenerInformacion())
    moto.realizaCaballito()
    println("Combustible después del caballito: ${"%.2f".format(moto.combustibleActual)} L")

}
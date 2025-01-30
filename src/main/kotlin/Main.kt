
import com.github.ajalt.mordant.rendering.TextColors
import models.*
import factories.*
import extensions.*
import repositories.*
import java.time.LocalDateTime

typealias color = TextColors

fun main() {
    val vehiculoFactory = VehiculoFactory
    val v1 = vehiculoFactory.random()
    val v2 = vehiculoFactory.random()
    val v3 = vehiculoFactory.random()
    val v4 = vehiculoFactory.random()
    val v5 = vehiculoFactory.random()
    val v6 = vehiculoFactory.random()
    val v7 = vehiculoFactory.random()
    val v8 = vehiculoFactory.random()
    val v9 = vehiculoFactory.random()
    val v10 = vehiculoFactory.random()

    val vehiculos = VehiculosRepositoryImpl()

    vehiculos.create(v1)
    vehiculos.create(v2)
    vehiculos.create(v3)
    vehiculos.create(v4)
    vehiculos.create(v5)
    vehiculos.create(v6)
    vehiculos.create(v7)
    vehiculos.create(v8)
    vehiculos.create(v9)
    vehiculos.create(v10)

    println(color.brightYellow("Todos los vehículos:"))
    vehiculos.findAll().forEach { println(it) }

    println(color.brightYellow("Vehículo por ID:"))
    println(vehiculos.findById(3))
    println()

    println(color.brightYellow("Vehículo por matrícula:"))
    println(vehiculos.findAll().firstOrNull { it.matricula == "1234ABC" })
    println()

    println(color.brightYellow("Guardar un nuevo vehículo:"))
    val nuevoVehiculo = CocheGasolinaImpl("Peugueot", "5433JJB", 53000)
    vehiculos.create(nuevoVehiculo)
    println(color.yellow("Vehiculo nuevo: $nuevoVehiculo"))
    vehiculos.findAll().forEach { println(it) }
    println()

    println(color.brightYellow("Actualizar un vehículo:"))
    val vehiculoActualizado = CocheHibridoImpl("Peugueot", "5433JJB", 53000)
    println(vehiculos.findById(1))
    vehiculos.update(1, vehiculoActualizado)
    println()

    println(color.brightYellow("Borrar un vehículo:"))
    vehiculos.delete(3)
    vehiculos.findAll().forEach { println(it) }
    println()

    println(color.brightYellow("Todos los coches de gasolina:"))
    vehiculos.filterBy { it is CocheGasolinaImpl }.forEach { println(it) }
    println()

    println(color.brightYellow("Todas las motocicletas:"))
    vehiculos.filterBy { it is MotocicletaImpl }.forEach { println(it) }
    println()

    println(color.brightYellow("Todos los coches eléctricos:"))
    vehiculos.filterBy { it is CocheElectricoImpl }.forEach { println(it) }
    println()

    println(color.brightYellow("Contar vehículos:"))
    println("Total de vehículos: ${vehiculos.countBy { true }}")
    println()


    println(color.brightYellow("Máximo de kilómetros:"))
    println("Máximo de kilómetros: ${vehiculos.maxBy({ it.kilometros }, { true })}")
    println()

    println(color.brightYellow("Mínimo de kilómetros:"))
    println("Mínimo de kilómetros: ${vehiculos.minBy({ it.kilometros }, { true })}")
    println()

    println(color.brightYellow("Media de kilómetros:"))
    println("Media de kilometros: ${vehiculos.averageBy({ it.kilometros }, { true })}")
    println()


    println(color.brightYellow("Ordenar vehículos por ID ascendente:"))
    vehiculos.sortedBy(ModoOrdenamiento.ASCENDENTE) { it.id }.forEach { println(it) }
    println()

    println(color.brightYellow("Ordenar vehículos por ID descendente:"))
    vehiculos.sortedBy(ModoOrdenamiento.DESCENDENTE) { it.id }.forEach { println(it) }
    println()

    println(color.brightYellow("Ordenar vehículos por kilómetros ascendente:"))
    vehiculos.sortedBy(ModoOrdenamiento.ASCENDENTE) { it.kilometros }.forEach { println(it) }
    println()

    println(color.brightYellow("Ordenar vehículos por kilómetros descendente:"))
    vehiculos.sortedBy(ModoOrdenamiento.DESCENDENTE) { it.kilometros }.forEach { println(it) }
    println()

}


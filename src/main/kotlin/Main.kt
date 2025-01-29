package jorgemrj

import jorgemrj.extensions.ModoOrdenamiento
import jorgemrj.factories.VehiculoFactory
import jorgemrj.models.*
import jorgemrj.repositories.VehiculosRepository
import jorgemrj.repositories.VehiculosRepositoryImpl


fun main() {
    val repository: VehiculosRepository = VehiculosRepositoryImpl()


    repeat(20) {
        repository.create(VehiculoFactory.random())
    }
    println("Todos los estudiantes:")
    repository.findAll().forEach {
        println(it)
    }
    println("Todos los vehículos:")
    repository.findAll().forEach { println(it) }

    println("Vehículo por ID:")
    println(repository.findById(3))
    println()

    println("Vehículo por matrícula:")
    println(repository.findAll().firstOrNull { it.matricula == "4545GFG" })
    println()

    println("Guardar un nuevo vehículo:")
    val nuevoVehiculo = CocheGasolinaImpl("BMW", "4545GFG", 20000)
    repository.create(nuevoVehiculo)
    println("Vehiculo nuevo: $nuevoVehiculo")
    repository.findAll().forEach { println(it) }
    println()

    println("Actualizar un vehículo:")
    val vehiculoActualizado = CocheHibridoImpl("BMW", "4545GFG", 100000)
    println(repository.findById(1))
    repository.update(1, vehiculoActualizado)
    println(vehiculoActualizado)
    println()

    println("Borrar un vehículo:")
    repository.delete(3)
    repository.findAll().forEach { println(it) }
    println()

    println("Todos los coches de gasolina:")
    repository.filterBy { it is CocheGasolinaImpl }.forEach { println(it) }
    println()

    println("Todas las motocicletas:")
    repository.filterBy { it is MotoImpl }.forEach { println(it) }
    println()

    println("Todos los coches eléctricos:")
    repository.filterBy { it is CocheElectricoImpl }.forEach { println(it) }
    println()

    println("Contar vehículos:")
    println("Total de vehículos: ${repository.countBy { true }}")
    println()


    println("Máximo de kilómetros:")
    println("Máximo de kilómetros: ${repository.maxBy({ it.kilometros }, { true })}")
    println()

    println("Mínimo de kilómetros:")
    println("Mínimo de kilómetros: ${repository.minBy({ it.kilometros }, { true })}")
    println()

    println("Media de kilómetros:")
    println("Media de kilometros: ${repository.averageBy({ it.kilometros }, { true })}")
    println()


    println("Ordenar vehículos por ID ascendente:")
    repository.sortedBy(ModoOrdenamiento.ASC) { it.id }.forEach { println(it) }
    println()

    println("Ordenar vehículos por ID descendente:")
    repository.sortedBy(ModoOrdenamiento.DESC) { it.id }.forEach { println(it) }
    println()

    println("Ordenar vehículos por kilómetros ascendente:")
    repository.sortedBy(ModoOrdenamiento.ASC) { it.kilometros }.forEach { println(it) }
    println()

    println("Ordenar vehículos por kilómetros descendente:")
    repository.sortedBy(ModoOrdenamiento.DESC) { it.kilometros }.forEach { println(it) }
    println()

}

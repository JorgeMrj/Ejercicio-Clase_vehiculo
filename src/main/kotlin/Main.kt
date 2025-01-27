package jorgemrj

import jorgemrj.factories.VehiculoFactory
import jorgemrj.repositories.VehiculosRepository
import jorgemrj.repositories.VehiculosRepositoryImpl


fun main() {
    val vehiculosRepository = VehiculosRepositoryImpl()

    val c1 = VehiculoFactory.random()
    val c2 = VehiculoFactory.random()
    val c3 = VehiculoFactory.random()
    val c4 = VehiculoFactory.random()
    val c5 = VehiculoFactory.random()
    val c6 = VehiculoFactory.random()

    vehiculosRepository.create(c1)
    vehiculosRepository.create(c2)
    vehiculosRepository.create(c3)
    vehiculosRepository.create(c4)
    vehiculosRepository.create(c5)
    vehiculosRepository.create(c6)

    println(c1)
    println(c2)
    println(c3)
    println(c4)
    println(c5)
    println(c6)


}
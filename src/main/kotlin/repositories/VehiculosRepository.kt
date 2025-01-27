package jorgemrj.repositories

import jorgemrj.extensions.ModoOrdenamiento
import jorgemrj.models.Vehiculo
import javax.sql.rowset.Predicate

interface VehiculosRepository: CrudRepository<Vehiculo, Int> {
    fun filterBy(predicate: (Vehiculo) -> Boolean = { true }): Array<Vehiculo>
    fun averageBy(predicate: (Vehiculo) -> Boolean = { true }): Double
    fun countBy(predicate: (Vehiculo) -> Boolean = { true }): Int
    fun maxBy(selector: (Vehiculo) -> Int = { 0 }, predicate: (Vehiculo) -> Boolean = { true }): Vehiculo?
    fun minBy(selector: (Vehiculo) -> Int = { 0 }, predicate: (Vehiculo) -> Boolean = { true }): Vehiculo?
    fun sortedBy(
        mode: ModoOrdenamiento = ModoOrdenamiento.ASC,
        condition: (Vehiculo) -> Double
    ): Array<Vehiculo>
}
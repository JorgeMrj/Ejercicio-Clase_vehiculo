package jorgemrj.models

class MotocicletaImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros), Motocicleta {
    override fun cilindrada() {
        println("La moto tiene una cilindrada de 1000cc")
    }
    override fun toString(): String {
        return ("Motocicleta=(id=$id, marca=$marca, matricula=$matricula, kilometros=$kilometros)")
    }
}
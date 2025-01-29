package jorgemrj.models

import java.time.LocalDateTime

class MotoImpl(
    marca: String,
    matricula: String,
    kilometros: Int,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now()
): Vehiculo(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt), Moto {
    override fun cilindrada() {
        println("La motocicleta tiene una cilindrada de 600cc")
    }
    override fun toString(): String {
        return ("Motocicleta=(id=$id, marca=$marca, matricula=$matricula, kilometros=$kilometros, createdAt=$createdAt, updatedAt=$updatedAt)")
    }

    override fun copy(): MotoImpl {
        return MotoImpl(marca = marca, matricula = matricula, kilometros = kilometros, createdAt = createdAt, updatedAt = updatedAt)
    }
}
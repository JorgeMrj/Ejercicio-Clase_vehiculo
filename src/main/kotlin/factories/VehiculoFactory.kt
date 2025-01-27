package jorgemrj.factories

import jorgemrj.models.CocheElectricoImpl
import jorgemrj.models.CocheGasolinaImpl
import jorgemrj.models.CocheHibridoImpl
import jorgemrj.models.MotocicletaImpl
import jorgemrj.models.Vehiculo



class VehiculoFactory {
    companion object {
        private val marcas = arrayOf("BMW", "Audi", "Honda", "Nissan", "Lexus", "Masserati", "Porsche")
        private val letra = arrayOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z')

        private fun generarMatricula(): String {
            val numeros = (1000..9999).random().toString()
            var letras = ""
            repeat(3) {
                letras += letra.random()
            }
            return "$numeros$letras"
        }

        fun random(): Vehiculo {
            val kilometros = (0..1000000).random()
            val randomNum = (0..100).random()

            val marca = marcas.random()
            val matricula = generarMatricula()

            return when (randomNum) {
                in 0..25 -> MotocicletaImpl(marca = marca, matricula = matricula, kilometros = kilometros)
                in 26..50 -> CocheGasolinaImpl(marca = marca, matricula = matricula, kilometros = kilometros)
                in 51..75 -> CocheHibridoImpl(marca = marca, matricula = matricula, kilometros = kilometros)
                else -> CocheElectricoImpl(marca = marca, matricula = matricula, kilometros = kilometros)
            }
        }
    }
}


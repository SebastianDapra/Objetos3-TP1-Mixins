package herramientas

import excepciones._
import elementosDelTerreno._
import personajes.PersonajeDelTerreno
import personajes.Personaje

/**
 * @author sebastian
 */
class Herramienta(personaje: PersonajeDelTerreno) {
  var duenio = personaje
}

abstract class Hacha(personaje: PersonajeDelTerreno) extends Herramienta(personaje) with Arma {

  def golpe: Int

  def danioComoArma = 10

  def talar(arbol: Arbol) {
    arbol.quitarResistencia(golpe)
  }
  
  def atacar(personaje: PersonajeDelTerreno){
    realizarAtaque(personaje)
  }
}

class HachaComun(personaje: PersonajeDelTerreno) extends Hacha(personaje) with Desgastable {

  override def golpe = 1

  override def calcularResistencia = 70

  override def resistenciaADescontar = (resistenciaActual * 0.03)

  override def talar(arbol: Arbol): Unit = {
    super.talar(arbol)
    desgastarse
  }

  override def atacar(personaje: PersonajeDelTerreno) {
    super.atacar(personaje)
    desgastarse
  }
}
class HachaReforzada(personaje: PersonajeDelTerreno) extends Hacha(personaje) {
  override def golpe = 2
  
  def golpeAPiedra = 5
  
  def picar(bloque: BloqueDePiedra) {
    bloque.quitarResistencia(golpeAPiedra)
  }
}

abstract class Pala(personaje: Personaje) extends Herramienta(personaje) {
  def cavar(hierba: Hierba)
}

class PalaComun(personaje: Personaje) extends Pala(personaje) with Desgastable {

  override def calcularResistencia = 90

  override def resistenciaADescontar = 3

  override def cavar(hierba: Hierba) {
	  personaje.terreno.quitarElementoDelTerreno(hierba)
    personaje.agregarAlInventario(hierba)
    desgastarse
  }
}

class PalaReforzada(personaje: Personaje) extends Pala(personaje) {
  override def cavar(hierba: Hierba) {
  }

  def cavarArbol(arbolTalado: Arbol) {
    if (arbolTalado.resistencia == 0) {
      personaje.agregarAlInventario(arbolTalado)
    } else {
      throw new Exception("Este arbol aun puede ser talado")
    }
  }
}

abstract class Pico(personaje: PersonajeDelTerreno) extends Herramienta(personaje) with Arma {

  def golpe: Double

  def danioComoArma = 7

  def picar(bloque: BloqueDePiedra) {
    bloque.quitarResistencia(golpe)
  }
  
  def atacar(personaje: PersonajeDelTerreno){
    realizarAtaque(personaje)

  }
}

class PicoDeHierro(personaje: PersonajeDelTerreno) extends Pico(personaje) with Desgastable {

  override def golpe = {6.0 * (resistenciaActual / resistenciaInicial)}

  override def calcularResistencia = 70

  override def resistenciaADescontar = 1

  override def picar(bloque: BloqueDePiedra) {
    super.picar(bloque)
    desgastarse 
  }
  
  override def atacar(personaje: PersonajeDelTerreno) {
    super.atacar(personaje)
    desgastarse
  }
}

class PicoReforzado(personaje: PersonajeDelTerreno) extends Pico(personaje) {
  override def golpe = 10
}
  
  



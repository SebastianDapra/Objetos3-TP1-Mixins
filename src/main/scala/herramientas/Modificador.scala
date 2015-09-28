package herramientas

import excepciones._
import elementosDelTerreno._
import personajes.PersonajeDelTerreno

/**
 * @author sebastian
 */


trait Desgastable {
  this: Herramienta =>
    
  var resistenciaActual = calcularResistencia
  var resistenciaInicial = calcularResistencia
    
  def calcularResistencia: Double
  
  def resistenciaADescontar: Double


  def desgastarse = resistenciaActual -= resistenciaADescontar
  
}

trait Arma {
  this: Herramienta =>
    
  def danioComoArma : Int
    
  def realizarAtaque(personaje: PersonajeDelTerreno) {
    personaje.restarSalud(danioComoArma)
  }

}
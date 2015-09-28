package personajes

import elementosDelTerreno._
import elementosDelTerreno.Baya


/**
 * @author sebastian
 */
abstract class PersonajeDelTerreno(posicionInicial: Posicion, terreno: Terreno, puntosDeSaludInicial: Double) extends ElementoDelTerreno(posicionInicial, terreno) {
  var salud = puntosDeSaludInicial

  def calcularSalud(puntosDeSalud: Int){
    salud -= puntosDeSalud
  }

  def restarSalud(puntosDeSalud: Int) {
    calcularSalud(puntosDeSalud)
  }
  
  def modificadorSegunMetabolismo = {1.00}
  
  def comer(baya: Baya){
    salud += baya.energia * modificadorSegunMetabolismo
  }
}
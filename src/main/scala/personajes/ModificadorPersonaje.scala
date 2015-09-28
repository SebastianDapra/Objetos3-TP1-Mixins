package personajes

import personajes._
import elementosDelTerreno.Baya

/**
 * @author sebastian
 */
trait ModificadorPersonaje {
}

trait SaludMinima {
  this: PersonajeDelTerreno =>

  var saludMinima : Double = _

  override def calcularSalud(puntosDeSaludARestar: Int) {    
    salud = Math.max((salud - puntosDeSaludARestar), saludMinima)
  }
  
   def setSaludMinima(puntosDeSalud : Int){
     saludMinima = puntosDeSalud
   }
   
}

trait Resistencia{
  this: PersonajeDelTerreno =>
    
  override def calcularSalud(puntosDeSaludARestar: Int){
    salud -= (puntosDeSaludARestar * 0.33)
  }
}

trait CausaDanioAlSerAtacado{
  this: PersonajeDelTerreno =>
    
  override def calcularSalud(puntosDeSaludARestar: Int){
    this.calcularSalud(puntosDeSaludARestar)
  }
}

trait MetabolismoSuperEficiente{
  this: PersonajeDelTerreno =>

    
    override def modificadorSegunMetabolismo = {2.00}
}


trait MetabolismoDeficiente{
  this: PersonajeDelTerreno =>
  
  var valorDeDeficiencia : Double = _

  override def modificadorSegunMetabolismo = {valorDeDeficiencia}
}

trait MetabolismoLimitado{
  this: PersonajeDelTerreno =>
    
  var limiteDeEnergia : Double = _
  
  override def comer(baya: Baya){
    salud += Math.min(baya.energia, limiteDeEnergia) 
  }
  
}
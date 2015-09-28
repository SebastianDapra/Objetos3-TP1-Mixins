package dominioTestCase

import excepciones._
import org.scalatest._
import herramientas._
import elementosDelTerreno._
import scala.collection.mutable.ArrayBuffer
import personajes._
import alimentos._


/**
 * @author sebastian
 */
class MetabolismoTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno() 
  
  var bayaMoradaCocida = new BayaMorada(new Posicion(0, 0), 10, terreno) with Cocida
  var bayaMoradaPodrida = new BayaMorada(new Posicion(0, 0), 10, terreno) with Podrida
  
  "un personaje con metabolismo super eficiente " should "aumentar su salud con el doble de la energia que aporta el alimento consumido" in{
    var beto = new Personaje(new Posicion(0, 0), terreno, 100) with MetabolismoSuperEficiente
    beto.comer(bayaMoradaCocida)
    assert(beto.salud == 122)
    
    beto.comer(bayaMoradaPodrida) 
    assert(beto.salud == 128.6)
  }
  
  "un personaje con metabolismo deficiente " should "aumentar su salud con un valor menor configurable al total del alimento consumido" in{
    var beto = new Personaje(new Posicion(0, 0), terreno, 100) with MetabolismoDeficiente{valorDeDeficiencia = 0.5}
    beto.comer(bayaMoradaCocida)
    assert(beto.salud == 105.5)
    
    beto.comer(bayaMoradaPodrida) 
    assert(beto.salud == 107.15)
  } 
  
  "un personaje con metabolismo limitado " should "no aumentar su salud mas que el valor limitado configurable de salud maxima" in{
    var beto = new Personaje(new Posicion(0, 0), terreno, 100) with MetabolismoLimitado{limiteDeEnergia = 10}
    beto.comer(bayaMoradaCocida)
    assert(beto.salud == 110)
    
    beto.comer(bayaMoradaPodrida) 
    assert(beto.salud == 113.3)
  }
  
  
  
}
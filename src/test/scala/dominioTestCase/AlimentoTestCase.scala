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
class AlimentoTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno() 
  
  var beto = new Personaje(new Posicion(0, 0), terreno, 100)
  
  "una baya morada cocida " should "aumentar la salud del consumidor un 10% mas que una baya comun" in{
    var bayaMoradaCocida = new BayaMorada(new Posicion(0, 0), 10, terreno) with Cocida
    var bayaMorada = new BayaMorada(new Posicion(0, 0), 10, terreno)
    beto.comer(bayaMorada)
    assert(beto.salud == 110)
    
    beto.comer(bayaMoradaCocida)
    assert(beto.salud == 121)
  }
  
  "una baya morada podrida " should "aumentar la salud del consumidor una tercera parte del total de una baya comun" in{
    var bayaMoradaPodrida = new BayaMorada(new Posicion(0, 0), 10, terreno) with Podrida
    var bayaMorada = new BayaMorada(new Posicion(0, 0), 10, terreno)
    beto.comer(bayaMorada)
    assert(beto.salud == 131)
    
    beto.comer(bayaMoradaPodrida)
    assert(beto.salud == 134.3)
  }
  
}
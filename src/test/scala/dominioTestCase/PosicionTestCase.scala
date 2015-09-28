package dominioTestCase

import elementosDelTerreno._
import org.scalatest._

/**
 * @author sebastian
 */
class PosicionTestCase extends FlatSpec{
  
  var posicion1 = new Posicion(0,0)
  var posicion2 = new Posicion(100,100)
  
  "una posicion " should "calcular su distancia a otra posicion" in{
    
    assert(posicion1.calcularDistanciaA(posicion2) == 141)
    
  }
  
}
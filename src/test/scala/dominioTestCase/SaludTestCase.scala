package dominioTestCase

import excepciones._
import org.scalatest._
import herramientas._
import elementosDelTerreno._
import scala.collection.mutable.ArrayBuffer
import personajes._

/**
 * @author sebastian
 */
class SaludTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var chancho = new Chancho(new Posicion(0, 0), terreno, 100)
  var picoReforzado = new PicoReforzado(chancho)

  "un personaje  con salud minima" should "recibir ataques y quedar siempre con igual o mas de su energia minima" in {
    var beto = new Personaje(new Posicion(0, 0), terreno, 100) with SaludMinima {saludMinima = 90}
    
    picoReforzado.atacar(beto)
    assert(beto.salud == 93)
    
    picoReforzado.atacar(beto)
    assert(beto.salud == 90)
    
    picoReforzado.atacar(beto)
    assert(beto.salud == 90)
  }
  
  "un personaje con resistencia" should " recibir una tercera parte del danio original" in{
    var beto = new Personaje(new Posicion(0, 0), terreno, 100) with Resistencia
    
    picoReforzado.atacar(beto)
    assert(beto.salud == 97.69)  
  }
  
  "un personaje que causa danio al ser atacado" should " causar danio a su atacante" in{
    var beto = new Personaje(new Posicion(0, 0), terreno, 100) with CausaDanioAlSerAtacado
    picoReforzado.atacar(beto)
    assert(beto.salud == 93)
    assert(picoReforzado.duenio.salud == 96.50)
  }
  
}
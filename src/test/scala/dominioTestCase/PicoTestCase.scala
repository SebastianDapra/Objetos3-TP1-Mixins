package dominioTestCase


import excepciones._
import org.scalatest._
import herramientas._
import elementosDelTerreno._
import personajes.Chancho
import personajes.Personaje

/**
 * @author sebastian
 */
class HerramientaTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var beto = new Personaje(new Posicion(0, 0), terreno, 100)
  var bloqueDePiedras = new BloqueDePiedra(new Posicion(0, 0), terreno, 100)
  var picoDeHierro = new PicoDeHierro(beto)
  var picoReforzado = new PicoReforzado(beto)
  var chancho = new Chancho(new Posicion(0, 0), terreno, 100)
  
  before {}
  after {
    beto.vaciarInventario
  }

  "un pico reforzado " should "restarle 10 de danio a un bloque de piedras" in {
    //beto.equiparHerramienta(pico)
    picoReforzado.picar(bloqueDePiedras)
    assert(bloqueDePiedras.resistencia == 90)
  }

  "un pico de hierro " should "restarle 6 de danio a un bloque de piedras " in {
    //beto.equiparHerramienta(picohierro)
    picoDeHierro.picar(bloqueDePiedras)
   // picoDeHierro.picar(bloqueDePiedras)
    assert(bloqueDePiedras.resistencia == 84)
    assert(picoDeHierro.resistenciaActual ==69)
  }
  
  "un pico reforzado " should "descontar 7 puntos de salud a un personaje cuando es atacado"in{
    //beto.equiparHerramienta(pico)
    picoReforzado.atacar(chancho)
    assert(chancho.salud == 93) 
  }

   "un pico de hierro " should "descontar 7 puntos de salud a un personaje cuando es atacado y desgastarse"in{
    //beto.equiparHerramienta(pico)
    picoDeHierro.atacar(chancho)
    //picoDeHierro.atacar(chancho)
    assert(chancho.salud == 86)
    assert(picoDeHierro.resistenciaActual == 68)
  }
   

}
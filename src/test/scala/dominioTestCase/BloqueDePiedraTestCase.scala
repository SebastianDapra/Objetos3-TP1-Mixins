package dominioTestCase


import org.scalatest._
import herramientas._
import elementosDelTerreno._
import personajes.Personaje
/**
 * @author sebastian
 */
class BloqueDePiedraTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var beto = new Personaje(new Posicion(0, 0), terreno, 100)
  var bloqueDePiedras = new BloqueDePiedra(new Posicion(0, 0), terreno, 10)
  var pico = new PicoReforzado(beto)

  before {}
  after {
    //terreno.vaciarTerreno()
    //beto = new Personaje(new Posicion(0, 0), terreno, 100)
  }

  "un bloque de piedra" should "otorgar entre 3 y 5 piedras y a lo sumo un oro " in {
    //beto.equiparHerramienta(pico)
    assert(terreno.listaDeElementos.length == 2) // beto y el bloque de piedra son los unicos elementos de terreno
    pico.picar(bloqueDePiedras)
    assert((terreno.listaDeElementos.length > 3) && (terreno.listaDeElementos.length <= 7))
  }
}
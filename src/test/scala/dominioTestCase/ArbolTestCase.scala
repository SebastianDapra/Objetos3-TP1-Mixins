package dominioTestCase


import org.scalatest._
import herramientas._
import elementosDelTerreno._
import personajes.Personaje
/**
 * @author sebastian
 */
class ArbolTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var beto = new Personaje(new Posicion(0, 0), terreno, 100)
  var hachaComun = new HachaComun(beto)
  trait resistenciaArbol {
    this: Arbol =>
    override def definirResistencia = {
      1
    }
  }

  before {}
  after {
    terreno.vaciarTerreno()
    beto = new Personaje(new Posicion(0, 0), terreno, 100)
  }

  "un arbol grande" should "otorgar entre 5 y 8 piezas de madera " in {
    var arbol = new ArbolGrande(new Posicion(201, 201), terreno) with resistenciaArbol
    //beto.equiparHerramienta(hacha) 
    assert(terreno.listaDeElementos.length == 2) // beto y arbol son los unicos elementos de terreno
    hachaComun.talar(arbol)
    assert((1 < terreno.listaDeElementos.length) && terreno.listaDeElementos.length <= 9)
  }
  
    "un arbol chico" should "otorgar 3 piezas de madera " in {
    var arbol = new ArbolChico(new Posicion(201, 201), terreno) with resistenciaArbol
    //beto.equiparHerramienta(hacha)
    assert(terreno.listaDeElementos.length == 2) // beto y el arbol son los unicos elementos de terreno
    hachaComun.talar(arbol)
    assert(terreno.listaDeElementos.length==5)
  }
}
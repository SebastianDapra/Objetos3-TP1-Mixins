package dominioTestCase

import dominio._
import org.scalatest._
import scala.collection.mutable.ArrayBuffer

/**
 * @author sebastian
 */
class TerrenoTesCase extends FlatSpec {
  
  var terreno = new Terreno()
  var bayaNegra = new BayaNegra(new Posicion(9,9), 50, terreno)
  var bayaMorada = new BayaMorada(new Posicion(101,101), 20, terreno)
  var arbolito = new Arbol(new Posicion(200,200), terreno)
  var arbol = new Arbol(new Posicion(201,201), terreno)
  var listaDePrueba = new ArrayBuffer[ElementoDelTerreno]()
  listaDePrueba.append(bayaNegra)
  listaDePrueba.append(bayaMorada)
  
  
  
    "un terreno" should "agregra elementos al terreno" in {
      assert(terreno.listaDeElementos.length == 3)
  }
}
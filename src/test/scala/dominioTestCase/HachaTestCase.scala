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
class HachaTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var beto = new Personaje(new Posicion(0, 0), terreno, 100)
  var hachaComun = new HachaComun(beto)
  var hachaReforzada = new HachaReforzada(beto)
  
  trait resistenciaArbol {
    this: Arbol =>
    override def definirResistencia = {
      10
    }
  }

  before {}
  after {
    beto.vaciarInventario
  }

  "un hacha comun " should "descontar resistencia a un arbol cuando lo golpea y debe desgastarse" in {
    var arbol = new ArbolGrande(new Posicion(201, 201), terreno) with resistenciaArbol
    //beto.equiparHerramienta(hacha)
    hachaComun.talar(arbol)
    assert(arbol.resistencia == 9)
    assert(hachaComun.resistenciaActual == 67.9)
  }

  "un hacha reforzada " should "descontar 2 punto de resistencia a un arbol cuando lo golpea" in {
    var arbol = new ArbolGrande(new Posicion(201, 201), terreno) with resistenciaArbol
    var hacha = new HachaReforzada(beto)
    //beto.equiparHerramienta(hacha)
    hachaReforzada.talar(arbol) 
    assert(arbol.resistencia == 8)
  }

  "un hacha comun " should "no descontar resistencia a un arbol talado " in {
    trait arbolSinResistencia {
      this: Arbol =>
      override def definirResistencia = {
        0
      }
    }
    var arbol = new ArbolGrande(new Posicion(201, 201), terreno) with arbolSinResistencia
    var hacha = new HachaComun(beto)
    //beto.equiparHerramienta(hacha)
    hachaComun.talar(arbol)
    assert(arbol.resistencia == 0)
  }
  
  "un hacha reforzada "  should "restarle 5 de danio a un bloque de piedras" in {
    var hacha = new HachaReforzada(beto) 
    var bloqueDePiedras = new BloqueDePiedra(new Posicion(0, 0), terreno, 100)
    //beto.equiparHerramienta(hacha)
    hachaReforzada.picar(bloqueDePiedras)
    assert(bloqueDePiedras.resistencia == 95)
  }
  
    "un hacha reforzada " should "descontar 10 puntos de salud a un personaje cuando es atacado"in{
    var hacha = new HachaReforzada(beto)
    //beto.equiparHerramienta(hacha)
    var chancho = new Chancho(new Posicion(0, 0), terreno, 100)
    hachaReforzada.atacar(chancho)
    assert(chancho.salud == 90) 
  }

   "un hacha comun " should "descontar 10 puntos de salud a un personaje cuando es atacado y desgastarse"in{
    //beto.equiparHerramienta(hacha)
    var chancho = new Chancho(new Posicion(0, 0), terreno, 100)
    hachaComun.atacar(chancho)
    assert(chancho.salud == 90)
    assert(hachaComun.resistenciaActual == 63.88711)
  }
   
  
}
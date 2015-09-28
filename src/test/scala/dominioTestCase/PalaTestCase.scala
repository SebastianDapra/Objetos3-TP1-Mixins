package dominioTestCase


import excepciones._
import org.scalatest._
import herramientas._
import elementosDelTerreno._
import personajes.Personaje

/**
 * @author sebastian
 */
class PalaTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var beto = new Personaje(new Posicion(0, 0), terreno, 100)
  var hacha = new HachaComun(beto)
  var palaComun = new PalaComun(beto)
  var palaReforzada = new PalaReforzada(beto)
  var hierba = new Hierba(new Posicion(201, 201), terreno)
  
//  trait resistenciaArbol {
//    this: Arbol =>
//    override def definirResistencia = {
//      10
//    }
//  }

  before {}
  after {beto.vaciarInventario}

  "una pala comun " should "recoger una hierba del terreno y quitarla del terreno " in {
    //beto.equiparHerramienta(pala)
    palaComun.cavar(hierba)
    assert(beto.cantidadDeElementosEnElInventario() == 1)
  }

  "una pala refrozada " should "recoger un arbol talado" in {
    trait resistenciaArbol {
      this: Arbol =>
      override def definirResistencia = {
        1
      }
    }
    var arbol = new ArbolGrande(new Posicion(201, 201), terreno) with resistenciaArbol
    //beto.equiparHerramienta(hacha)
    hacha.talar(arbol)
    //beto.equiparHerramienta(pala)
    palaReforzada.cavarArbol(arbol)
    assert(beto.cantidadDeElementosEnElInventario() == 1)
  }

  
  "una pala comun " should "desgastarse cuando cava" in{
    //beto.equiparHerramienta(pala)
    palaComun.cavar(hierba)
    assert(palaComun.resistenciaActual == 84)
  }
  
  "una pala reforzada " should "no desplantar un arbol si este no esta talado" in{
    var arbol = new ArbolGrande(new Posicion(201, 201), terreno)
   // beto.equiparHerramienta(pala)
    intercept[Exception]{
    palaReforzada.cavarArbol(arbol)
    }
    assert(beto.cantidadDeElementosEnElInventario() == 0)
  }
  
}
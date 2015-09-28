package dominioTestCase


import excepciones._
import org.scalatest._
import herramientas._
import elementosDelTerreno._
import scala.collection.mutable.ArrayBuffer
import personajes.Personaje
import elementosDelTerreno.BayaNegra
import elementosDelTerreno.BayaMorada

/**
 * @author sebastian
 */
class PersonajeTestCase extends FlatSpec with BeforeAndAfter{

    var terreno = new Terreno()
    var beto = new Personaje(new Posicion(0,0), terreno, 100)
    var bayaNegra = new BayaNegra(new Posicion(10,10), 50, terreno)
    var bayaMorada = new BayaMorada(new Posicion(101,101), 20, terreno)
    var arbolito = new ArbolChico(new Posicion(100,100), terreno)
    var arbol = new ArbolGrande(new Posicion(201,201), terreno)
    var casaDeChanchoCopado = new CasaDeChancho(new Posicion(1,1), new EstadoChanchoBuenHumor, terreno)
    var casaDeChanchoEnojado = new CasaDeChancho(new Posicion(20,20), new EstadoChanchoMalHumor, terreno)
    
    before{}
    after{
      beto.vaciarInventario
    }
  
  "un personaje  " should "inspeccionar el terreno" in{
     assert(beto.inspeccionarTerreno(14).length == 2)
  }
  
  "un personaje  " should "contabilizar energia total del alimento que se encuentra a lo sumo a 100 de distancia" in{
     assert(beto.contabilizarEnergiaTotalDeAlimento() == 5)
  }
  
  "un personaje  " should "contabilizar cantidad de arboles a lo sumo a 200 de distancaia" in{
     assert(beto.contarArboles() == 1)
  }
  
   "un personaje  " should "recoger la comida que se encuentre a los sumo a 100 de distancia" in{
     beto.recogerComida()
     assert(beto.inventario.length == 1)
     assert(terreno.listaDeElementos.length == 6)
  }
   
   "un personaje  " should "reconocer la casa de chancho mejor provisionado" in{
     casaDeChanchoCopado.agregrarElementoAStock(bayaMorada)
     casaDeChanchoEnojado.agregrarElementoAStock(bayaNegra)
     assert(beto.reconocerCasaDeChanchoMejorProvisionada() == casaDeChanchoCopado)
  }
   
   "un personaje  " should "agregar un elemento a su inventario" in{
     beto.agregarAlInventario(bayaNegra)
     assert(beto.inventario.length == 1)
  }
   
   "un personaje  " should "perder salud" in{
     beto.restarSalud(10)
     assert(beto.salud == 90)
  }
   
   "un personaje  " should "crear una hoguera" in{
     beto.inventario = new ArrayBuffer[ElementoDelTerreno]()
     beto.agregarAlInventario(new Piedra(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Piedra(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Hierba(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Hierba(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Hierba(new Posicion(0,0), terreno))
     beto.crearHoguera
     assert(beto.inventario.length == 5)
  }
   
   
   
  
}